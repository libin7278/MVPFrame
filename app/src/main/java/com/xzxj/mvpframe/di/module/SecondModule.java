package com.xzxj.mvpframe.di.module;

import com.xzxj.frame.injection.scope.FragmentScope;
import com.xzxj.mvpframe.mvp.second.SecondContract;
import com.xzxj.mvpframe.mvp.second.SecondModel;

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
public class SecondModule {
    private SecondContract.View view;

    /**
     * 构建 MainModule 时,将 View 的实现类传进来,这样就可以提供 View 的实现类给 Presenter
     *
     * @param view
     */
    public SecondModule(SecondContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    SecondContract.View provideSecondView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    SecondContract.Model provideSecondModel(SecondModel model) {
        return model;
    }
}
