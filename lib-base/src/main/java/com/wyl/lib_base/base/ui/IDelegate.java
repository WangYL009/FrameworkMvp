package com.wyl.lib_base.base.ui;

import android.app.Activity;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.base.ui
 * 创建时间：1/26/21
 * 备注：
 *  这是Activity和Fragment需要实现的基类接口，
 *  里面只是实现了一个获取Activity的方法，主要在Presenter中需要使用Context对象时调用，
 *  不直接在Presenter中创建Context对象，最大程度的防止内存泄漏
 */
public interface IDelegate {

    <T extends Activity> T getActivity();

}
