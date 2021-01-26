package com.wyl.lib_base.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.wyl.lib_base.R;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.widget
 * 创建时间：1/26/21
 * 备注：一个显示加载的组件
 */
public class LoadingDialog extends Dialog {

    private CharSequence message;//内容

    private TextView contentTv;


    public LoadingDialog(@NonNull Context context) {
        this(context, 0);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public void setMessage(CharSequence message) {
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        setCancelable(false);
        contentTv = findViewById(R.id.content_tv);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (message != null) {
            contentTv.setText(message);
        }
    }
}
