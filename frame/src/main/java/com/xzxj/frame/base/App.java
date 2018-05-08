package com.xzxj.frame.base;

import android.app.Application;
import android.support.annotation.NonNull;

import com.xzxj.frame.di.component.AppComponent;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/7
 *     email : 524607562@qq.com
 *     desc  : 框架要求框架中的每个 {@link Application} 都需要实现此类,以满足规范
 * </pre>
 *
 * @see BaseApplication
 */
public interface App {
    @NonNull
    AppComponent getAppComponent();
}
