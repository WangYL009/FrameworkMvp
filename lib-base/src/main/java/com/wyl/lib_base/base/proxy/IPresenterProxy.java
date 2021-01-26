package com.wyl.lib_base.base.proxy;

import com.wyl.lib_base.base.presenter.IBasePresenter;
import com.wyl.lib_base.base.presenter.InjectPresenter;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.base.proxy
 * 创建时间：1/26/21
 * 备注：
 */
public interface IPresenterProxy {

    /**
     * 为所有Presenter注入实例，Presenter必须是{@link IBasePresenter}的子类或实现类
     * 并建立Presenter与View层绑定关系
     *
     * @see InjectPresenter
     */
    void bindPresenter();

    /**
     * 解除View与Presenter的绑定关系
     */
    void unbindPresenter();

}
