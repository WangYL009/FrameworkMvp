package com.wyl.lib_base.base.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wyl.lib_base.base.proxy.IPresenterProxy;
import com.wyl.lib_base.base.proxy.PresenterProxyImpl;
import com.wyl.lib_base.utils.PermissionUtils;
import com.wyl.lib_base.widget.LoadingDialog;

/**
 * @create : wyl
 * @date : 2021/1/23
 * @备注：
 */
public class BaseActivity extends AppCompatActivity implements IBaseView, IDelegate, PermissionUtils.PermissionCallbacks{


    private LoadingDialog loadingDialog;

    private IPresenterProxy mPresenterProxy;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenterProxy = new PresenterProxyImpl(this);
        mPresenterProxy.bindPresenter();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initContentView();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initContentView();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initContentView();
    }

    /**
     * 在调用setContentView之后执行
     */
    protected void initContentView(){

    }

    @Override
    public void showLoading(String msg) {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        if (!TextUtils.isEmpty(msg)) {
            loadingDialog.setMessage(msg);
        }
        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void hideEmpty() {

    }

    @Override
    public void showShortToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLongToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Activity> T getActivity() {
        return (T) this;
    }

    @Override
    public final void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, String[] perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, String[] perms) {

    }

    @Override
    protected void onDestroy() {
        mPresenterProxy.unbindPresenter();
        super.onDestroy();
    }

}
