package com.wyl.frameworkmvp;

import com.wyl.lib_base.base.BaseApplication;
import com.wyl.lib_base.config.ModuleLifecycleConfig;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：宿主的应用
 */
public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        //....
        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleAfter(this);
    }
}
