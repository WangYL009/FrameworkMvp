package com.wyl.lib_base.base;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：
 */
public interface IModel {
    /**
     * ViewModel销毁时清除Model，与ViewModel共消亡。Model层同样不能持有长生命周期对象
     */
    void onCleared();
}
