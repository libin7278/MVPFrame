package com.xzxj.mvpframe.mvp.second;

import com.xzxj.frame.mvp.IModel;
import com.xzxj.frame.mvp.IView;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/17
 *     email : 524607562@qq.com
 *     desc  : 展示 Contract 的用法
 * </pre>
 */
public interface SecondContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条等
    interface View extends IView {
        void showData(String version);
    }
    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
    interface Model extends IModel {
        String getDate();
    }
}
