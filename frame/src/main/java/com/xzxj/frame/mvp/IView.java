package com.xzxj.frame.mvp;

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
}
