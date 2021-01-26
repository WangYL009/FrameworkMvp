package com.wyl.lib_base.base.ui;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.base.ui
 * 创建时间：1/26/21
 * 备注：定义view事件的接口
 */
public interface IBaseView {

    /**
     * 显示正在加载中
     */
    void showLoading(String msg);

    /**
     * 隐藏正在加载中
     */
    void hideLoading();

    /**
     * 显示错误信息
     */
    void showError();

    /**
     * 隐藏错误信息
     */
    void hideError();

    /**
     * 显示空页面
     */
    void showEmpty();

    /**
     * 隐藏空页面元素
     */
    void hideEmpty();

    void showShortToast(String msg);

    void showLongToast(String msg);

}
