package com.wyl.lib_base.base.presenter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.base.presenter
 * 创建时间：1/26/21
 * 备注：
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPresenter {
}
