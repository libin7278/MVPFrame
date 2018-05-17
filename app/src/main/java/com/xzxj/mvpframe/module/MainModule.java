package com.xzxj.mvpframe.module;

import com.xzxj.frame.injection.scope.ActivityScope;
import com.xzxj.mvpframe.mvp.main.MainContract;
import com.xzxj.mvpframe.mvp.main.MainModel;

import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/16
 *     email : 524607562@qq.com
 *     desc  : 展示 Module 的用法
 * </pre>
 */
@Module
public class MainModule {
    private MainContract.View view;

    /**
     * 构建 MainModule 时,将 View 的实现类传进来,这样就可以提供 View 的实现类给 Presenter
     *
     * @param view
     */
    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainContract.View provideUserView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainContract.Model provideUserModel(MainModel model) {
        return model;
    }
}
