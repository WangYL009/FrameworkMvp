package com.wyl.module_login;

import android.app.Application;

import com.wyl.lib_base.module.IModuleInit;
import com.wyl.lib_base.utils.KLog;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：登录组件初始化
 */
public class LoginModuleInit implements IModuleInit {

    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("登录模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitAfter(Application application) {
        KLog.e("登录模块初始化 -- onInitAfter");
        return false;
    }
}
