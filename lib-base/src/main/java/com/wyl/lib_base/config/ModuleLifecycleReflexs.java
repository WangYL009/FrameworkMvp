package com.wyl.lib_base.config;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：
 */
public class ModuleLifecycleReflexs {
    /**
     * 基础库
     */
    private static final String BaseInit = "com.wyl.lib_base.BaseModuleInit";

    //主业务模块
    private static final String MainInit = "com.wyl.module_main.MainModuleInit";
    //登录验证模块
    private static final String LoginInit = "com.wyl.module_login.LoginModuleInit";
    //首页业务模块
    private static final String HomeInit = "com.wyl.module_home.HomeModuleInit";
    //工作业务模块
    private static final String WorkInit = "com.wyl.module_work.WorkModuleInit";
    //用户业务模块
    private static final String UserInit = "com.wyl.module_mine.MineModuleInit";

    public static String[] initModuleNames = {BaseInit,MainInit,LoginInit,HomeInit,WorkInit,UserInit};
}
