package com.wyl.lib_base.event;

import org.greenrobot.eventbus.EventBus;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.event
 * 创建时间：1/31/21
 * 备注：evenbus帮助类
 */
public class EventBusHelper {

    private EventBusHelper() {
        throw new UnsupportedOperationException("can't be init");
    }

    public static void register(Object object) {
        EventBus.getDefault().register(object);
    }

    public static void unregister(Object object) {
        EventBus.getDefault().unregister(object);
    }

    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void postSticky(Object object) {
        EventBus.getDefault().postSticky(object);
    }

}
