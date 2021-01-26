package com.wyl.lib_base.base.presenter;

import com.wyl.lib_base.base.ui.IBaseView;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.base.presenter
 * 创建时间：1/26/21
 * 备注：所有Presenter的基类接口
 */
public interface IBasePresenter <V extends IBaseView> {

    /**
     * 判断 presenter 是否与 view 建立联系，防止出现内存泄露状况
     *
     * @return {@code true}: 联系已建立 {@code false}: 联系已断开
     */
    boolean isViewAttach();

    /**
     * presenter 与 view 建立关联
     *
     * @param view UI
     */
    void attachView(V view);

    /**
     * 断开 presenter 与 view 直接的联系
     */
    void detachView();

}
