package com.wyl.module_work;

import android.app.Application;

import com.wyl.lib_base.module.IModuleInit;
import com.wyl.lib_base.utils.KLog;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：工作组件初始化
 */
public class WorkModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("工作模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitAfter(Application application) {
        KLog.e("工作模块初始化 -- onInitAfter");
        return false;
    }
}
