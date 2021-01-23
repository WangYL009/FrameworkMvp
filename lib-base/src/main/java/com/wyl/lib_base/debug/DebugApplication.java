package com.wyl.lib_base.debug;

import com.wyl.lib_base.base.BaseApplication;
import com.wyl.lib_base.config.ModuleLifecycleConfig;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：debug包下的代码不参与编译，仅作为独立模块运行时初始化数据
 */
public class DebugApplication extends BaseApplication {
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
