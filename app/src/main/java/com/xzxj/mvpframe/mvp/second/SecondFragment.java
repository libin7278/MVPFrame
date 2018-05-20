package com.xzxj.mvpframe.mvp.second;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xzxj.frame.base.BaseFragment;
import com.xzxj.frame.injection.component.AppComponent;
import com.xzxj.mvpframe.R;
import com.xzxj.mvpframe.di.component.DaggerSecondComponent;
import com.xzxj.mvpframe.di.module.SecondModule;

import butterknife.BindView;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/19
 *     email : 524607562@qq.com
 *     desc  : 展示 Fragment 的用法
 * </pre>
 */
public class SecondFragment extends BaseFragment<SecondPresenter> implements SecondContract.View {
    @BindView(R.id.showTextview)
    TextView showTextview;

    public static SecondFragment newInstance() {

        Bundle args = new Bundle();

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerSecondComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .secondModule(new SecondModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.getDate();
    }

    @Override
    public void showData(String version) {
        showTextview.setText(version);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
