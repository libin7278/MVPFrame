package com.xzxj.frame.base.proxy;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/7
 *     email : 524607562@qq.com
 *     desc  : 用于代理 {@link Application} 的生命周期
 * </pre>
 */
public interface AppLifecycles {
    void attachBaseContext(@NonNull Context base);

    void onCreate(@NonNull Application application);

    void onTerminate(@NonNull Application application);
}
