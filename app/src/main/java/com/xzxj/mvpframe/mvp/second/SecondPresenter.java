package com.xzxj.mvpframe.mvp.second;

import android.app.Application;

import com.xzxj.frame.integration.AppManager;
import com.xzxj.frame.mvp.BasePresenter;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/17
 *     email : 524607562@qq.com
 *     desc  : 展示presenter用法
 * </pre>
 */
public class SecondPresenter extends BasePresenter<SecondContract.Model, SecondContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    AppManager mAppManager;
    @Inject
    Application mApplication;

    @Inject
    public SecondPresenter(SecondContract.Model model, SecondContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mApplication = null;
    }

    public void getDate(){
        mView.showData(mModel.getDate());
    }
}
