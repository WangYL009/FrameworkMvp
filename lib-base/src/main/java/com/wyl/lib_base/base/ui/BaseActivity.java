package com.wyl.lib_base.base.ui;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.wyl.lib_base.event.BindEventBus;
import com.wyl.lib_base.event.EventBusHelper;
import com.wyl.lib_base.receiver.NetworkChangeReceiver;
import com.wyl.lib_base.utils.StatusBarUtil;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.base.ui
 * 创建时间：1/31/21
 * 备注：处理状态栏，网络等公共资源
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    private NetworkChangeReceiver receiver;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        mContext = this;
        setStatusBarColor();
        // 基类中注册 eventbus
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBusHelper.register(this);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//黑色
        }
//        StatusBarUtil.setLightMode(this);

        registerNetworkChangeReceiver();
        initView();
        initData();
    }

    public void setStatusBarColor() {
        StatusBarUtil.setColor(this, getResources().getColor(android.R.color.white), 0);
    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected void initData() {

    }

    /**
     * 注册网络监听广播
     */
    private void registerNetworkChangeReceiver() {
        receiver = new NetworkChangeReceiver(this);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver.onDestroy();
            receiver = null;
        }
        // 取消注册
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBusHelper.unregister(this);
        }
    }

    public void setStatusBarTextColor(Window window, boolean lightStatusBar) {
        // 设置状态栏字体颜色 白色与深色
        View decor = window.getDecorView();
        int ui = decor.getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (lightStatusBar) {
                ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
        }
        decor.setSystemUiVisibility(ui);
    }


}
