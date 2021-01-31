package com.wyl.lib_base.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.wyl.lib_base.utils.NetworkUtil;
import com.wyl.lib_base.widget.NoNetworkTip;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.receiver
 * 创建时间：1/31/21
 * 备注：网络广播监听
 */
public class NetworkChangeReceiver extends BroadcastReceiver {

    private static final String TAG = "NetworkChangeReceiver";
    private Activity activity;
    private NoNetworkTip noNetworkTip;

    public NetworkChangeReceiver(Activity activity) {
        this.activity = activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: ");
        if (noNetworkTip == null) {
            noNetworkTip = new NoNetworkTip(activity);
        }
        if (NetworkUtil.isNetworkAvailable(context)) {
            if (noNetworkTip != null && noNetworkTip.isShowing()) {
                noNetworkTip.dismiss();
            }
        } else {
            if (noNetworkTip != null && !noNetworkTip.isShowing()) {
                noNetworkTip.show();
            }
        }
    }

    public void onDestroy() {
        if (noNetworkTip != null && noNetworkTip.isShowing()) {
            noNetworkTip.dismiss();
        }
        activity = null;
        noNetworkTip = null;
    }
}
