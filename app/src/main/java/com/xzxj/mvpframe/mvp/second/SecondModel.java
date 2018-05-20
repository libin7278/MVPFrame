package com.xzxj.mvpframe.mvp.second;

import com.xzxj.frame.injection.scope.FragmentScope;
import com.xzxj.frame.integration.IRepositoryManager;
import com.xzxj.frame.mvp.BaseModel;

import javax.inject.Inject;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/17
 *     email : 524607562@qq.com
 *     desc  : 展示 medel 的用法
 * </pre>
 */
@FragmentScope
public class SecondModel extends BaseModel implements SecondContract.Model {

    @Inject
    public SecondModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public String getDate() {
        return "模拟返回version ： 100";
    }
}
