package com.xzxj.frame.integration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.xzxj.frame.base.proxy.FragmentProxy;
import com.xzxj.frame.base.proxy.FragmentProxyImpl;
import com.xzxj.frame.base.proxy.IFragment;
import com.xzxj.frame.integration.cache.Cache;
import com.xzxj.frame.integration.cache.IntelligentCache;
import com.xzxj.frame.utils.Preconditions;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/7
 *     email : 524607562@qq.com
 *     desc  : FragmentLifecycleCallbacks 默认实现类
 * </pre>
 */
@Singleton
public class FragmentLifecycle extends FragmentManager.FragmentLifecycleCallbacks {

    @Inject
    public FragmentLifecycle() {
    }

    @Override
    public void onFragmentAttached(FragmentManager fm, Fragment f, Context context) {
        Timber.w(f.toString() + " - onFragmentAttached");
        if (f instanceof IFragment) {
            FragmentProxy fragmentProxy = fetchFragmentProxy(f);
            if (fragmentProxy == null || !fragmentProxy.isAdded()) {
                Cache<String, Object> cache = getCacheFromFragment((IFragment) f);
                fragmentProxy = new FragmentProxyImpl(fm, f);
                //使用 IntelligentCache.KEY_KEEP 作为 key 的前缀, 可以使储存的数据永久存储在内存中
                //否则存储在 LRU 算法的存储空间中, 前提是 Fragment 使用的是 IntelligentCache (框架默认使用)
                cache.put(IntelligentCache.KEY_KEEP + FragmentProxy.FRAGMENT_DELEGATE, fragmentProxy);
            }
            fragmentProxy.onAttach(context);
        }
    }

    @Override
    public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        Timber.w(f.toString() + " - onFragmentCreated");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {
        Timber.w(f.toString() + " - onFragmentViewCreated");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onCreateView(v, savedInstanceState);
        }
    }

    @Override
    public void onFragmentActivityCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
        Timber.w(f.toString() + " - onFragmentActivityCreated");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onActivityCreate(savedInstanceState);
        }
    }

    @Override
    public void onFragmentStarted(FragmentManager fm, Fragment f) {
        Timber.w(f.toString() + " - onFragmentStarted");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onStart();
        }
    }

    @Override
    public void onFragmentResumed(FragmentManager fm, Fragment f) {
        Timber.w(f.toString() + " - onFragmentResumed");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onResume();
        }
    }

    @Override
    public void onFragmentPaused(FragmentManager fm, Fragment f) {
        Timber.w(f.toString() + " - onFragmentPaused");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onPause();
        }
    }

    @Override
    public void onFragmentStopped(FragmentManager fm, Fragment f) {
        Timber.w(f.toString() + " - onFragmentStopped");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onStop();
        }
    }

    @Override
    public void onFragmentSaveInstanceState(FragmentManager fm, Fragment f, Bundle outState) {
        Timber.w(f.toString() + " - onFragmentSaveInstanceState");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {
        Timber.w(f.toString() + " - onFragmentViewDestroyed");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onDestroyView();
        }
    }

    @Override
    public void onFragmentDestroyed(FragmentManager fm, Fragment f) {
        Timber.w(f.toString() + " - onFragmentDestroyed");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onDestroy();
        }
    }

    @Override
    public void onFragmentDetached(FragmentManager fm, Fragment f) {
        Timber.w(f.toString() + " - onFragmentDetached");
        FragmentProxy fragmentDelegate = fetchFragmentProxy(f);
        if (fragmentDelegate != null) {
            fragmentDelegate.onDetach();
        }
    }

    private FragmentProxy fetchFragmentProxy(Fragment fragment) {
        if (fragment instanceof IFragment) {
            Cache<String, Object> cache = getCacheFromFragment((IFragment) fragment);
            return (FragmentProxy) cache.get(IntelligentCache.KEY_KEEP + FragmentProxy.FRAGMENT_DELEGATE);
        }
        return null;
    }

    @NonNull
    private Cache<String, Object> getCacheFromFragment(IFragment fragment) {
        Cache<String, Object> cache = fragment.provideCache();
        Preconditions.checkNotNull(cache, "%s cannot be null on Fragment", Cache.class.getName());
        return cache;
    }

}
