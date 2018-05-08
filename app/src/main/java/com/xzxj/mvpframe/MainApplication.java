package com.xzxj.mvpframe;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.xzxj.frame.base.BaseApplication;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/8
 *     email : 524607562@qq.com
 *     desc  : MainApplication
 * </pre>
 */
public class MainApplication  extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}