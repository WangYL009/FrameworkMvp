package com.wyl.lib_base.module;

import android.app.Application;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：动态配置组件Application,有需要初始化的组件实现该接口,统一在宿主app 的Application进行初始化
 * 一般先执行实现类，通过接口可以先进行在application中初始化，然进行baseapplication中的初始化，这样初始化就出现了先后顺序
 */
public interface IModuleInit {

    /**
     * 需要优先初始化的
     */
    boolean onInitAhead(Application application);

    /**
     * 可以后初始化的
     */
    boolean onInitAfter(Application application);
}
