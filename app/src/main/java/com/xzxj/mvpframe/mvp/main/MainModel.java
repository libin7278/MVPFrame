package com.xzxj.mvpframe.mvp.main;

import com.xzxj.frame.injection.scope.ActivityScope;
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
@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
