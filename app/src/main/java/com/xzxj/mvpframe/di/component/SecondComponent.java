/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xzxj.mvpframe.di.component;

import com.xzxj.frame.injection.component.AppComponent;
import com.xzxj.frame.injection.scope.FragmentScope;
import com.xzxj.mvpframe.di.module.SecondModule;
import com.xzxj.mvpframe.mvp.second.SecondFragment;

import dagger.Component;

/**
 * <pre>
 *     author: libin
 *     blog  : https://blog.csdn.net/github_33304260
 *     time  : 2018/5/16
 *     email : 524607562@qq.com
 *     desc  : 展示 Component 的用法
 * </pre>
 */
@FragmentScope
@Component(modules = SecondModule.class, dependencies = AppComponent.class)
public interface SecondComponent {
    void inject(SecondFragment fragment);
}
