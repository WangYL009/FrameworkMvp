package com.wyl.lib_base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wyl.lib_base.BuildConfig;
import com.wyl.lib_base.module.IModuleInit;
import com.wyl.lib_base.utils.KLog;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：
 */
public class BaseModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        //开启打印日志
        KLog.init(true);
        //初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
        KLog.e("基础层初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitAfter(Application application) {
        KLog.e("基础层初始化 -- onInitAfter");
        return false;
    }
}
