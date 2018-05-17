package com.xzxj.mvpframe.mvp.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.xzxj.frame.base.BaseActivity;
import com.xzxj.frame.injection.component.AppComponent;
import com.xzxj.frame.widget.Snacker;
import com.xzxj.frame.widget.Toaster;
import com.xzxj.mvpframe.R;
import com.xzxj.mvpframe.di.component.DaggerMainComponent;
import com.xzxj.mvpframe.module.MainModule;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/17
 *     email : 524607562@qq.com
 *     desc  : 展示 Activity 的用法
 * </pre>
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Snacker.with(MainActivity.this).setMessage("警告").warning().show();

        Toaster.with(MainActivity.this).setMessage("上传成功").show();
    }

}
