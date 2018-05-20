package com.xzxj.frame.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.xzxj.frame.base.proxy.AppLifecycles;
import com.xzxj.frame.base.proxy.AppProxy;
import com.xzxj.frame.injection.component.AppComponent;
import com.xzxj.frame.utils.FrameUtils;
import com.xzxj.frame.utils.Preconditions;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/7
 *     email : 524607562@qq.com
 *     desc  : 基类
 * </pre>
 */
public class App extends Application implements BaseApplication {
    private AppLifecycles mAppProxy;

    /**
     * 这里会在 {@link App#onCreate} 之前被调用,可以做一些较早的初始化
     * 常用于 MultiDex 以及插件化框架的初始化
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (mAppProxy == null)
            this.mAppProxy = new AppProxy(base);
        this.mAppProxy.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mAppProxy != null)
            this.mAppProxy.onCreate(this);
    }

    /**
     * 在模拟环境中程序终止时会被调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppProxy != null)
            this.mAppProxy.onTerminate(this);
    }

    /**
     * 将 {@link AppComponent} 返回出去, 供其它地方使用, {@link AppComponent} 接口中声明的方法所返回的实例, 在 {@link #getAppComponent()} 拿到对象后都可以直接使用
     *
     * @see FrameUtils#obtainAppComponentFromContext(Context) 可直接获取 {@link AppComponent}
     * @return AppComponent
     */
    @NonNull
    @Override
    public AppComponent getAppComponent() {
        Preconditions.checkNotNull(mAppProxy, "%s cannot be null", AppProxy.class.getName());
        Preconditions.checkState(mAppProxy instanceof BaseApplication, "%s must be implements %s", AppProxy.class.getName(), BaseApplication.class.getName());
        return ((BaseApplication) mAppProxy).getAppComponent();
    }

}
