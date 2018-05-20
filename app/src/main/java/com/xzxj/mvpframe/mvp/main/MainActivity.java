package com.xzxj.mvpframe.mvp.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xzxj.frame.base.BaseActivity;
import com.xzxj.frame.injection.component.AppComponent;
import com.xzxj.frame.widget.Snacker;
import com.xzxj.frame.widget.Toaster;
import com.xzxj.mvpframe.R;
import com.xzxj.mvpframe.di.component.DaggerMainComponent;
import com.xzxj.mvpframe.di.module.MainModule;
import com.xzxj.mvpframe.mvp.second.SecondFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/17
 *     email : 524607562@qq.com
 *     desc  : 展示 Activity 的用法
 * </pre>
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.moveNextButton)
    Button moveNextButton;

    SecondFragment mSecondFragment;

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
        mPresenter.getVersion();

        mSecondFragment = new SecondFragment();

        Snacker.with(MainActivity.this).setMessage("警告").warning().show();

        Toaster.with(MainActivity.this).setMessage("上传成功").show();
    }

    @Override
    public void showVersion(String version) {
        textView.setText("测试数据：" + version);
    }

    @OnClick({R.id.moveNextButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.moveNextButton:
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.FrameLayout, mSecondFragment);
                fragmentTransaction.commit();
                break;
        }
    }
}
