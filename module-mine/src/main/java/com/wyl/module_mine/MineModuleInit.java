package com.wyl.module_mine;

import android.app.Application;

import com.wyl.lib_base.module.IModuleInit;
import com.wyl.lib_base.utils.KLog;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：我的组件初始化
 */
public class MineModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("我的模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitAfter(Application application) {
        KLog.e("我的模块初始化 -- onInitAfter");
        return false;
    }
}
