package com.wyl.lib_base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.utils
 * 创建时间：1/31/21
 * 备注：网络链接工具类
 */
public class NetworkUtil {

    private NetworkUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 网络链接是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
            for (NetworkInfo networkInfo : networkInfos) {
                NetworkInfo.State state = networkInfo.getState();
                if (state == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
