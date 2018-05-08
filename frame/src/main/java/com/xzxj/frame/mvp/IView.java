package com.xzxj.frame.mvp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.xzxj.frame.utils.ArmsUtils;
import com.xzxj.frame.utils.Preconditions;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/7
 *     email : 524607562@qq.com
 *     desc  : 框架要求框架中的每个 View 都需要实现此类, 以满足规范
 * </pre>
 */
public interface IView {

    /**
     * 显示加载
     */
    default void showLoading() {
    }

    /**
     * 隐藏加载
     */
    default void hideLoading() {
    }

    /**
     * 显示信息
     *
     * @param message 消息内容, 不能为 {@code null}
     */
    void showMessage(@NonNull String message);

    /**
     * 跳转 {@link Activity}
     *
     * @param intent {@code intent} 不能为 {@code null}
     */
    default void launchActivity(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    /**
     * 杀死自己
     */
    default void killMyself() {

    }
}
