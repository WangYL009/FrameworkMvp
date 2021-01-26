package com.wyl.lib_base.base.proxy;

import com.wyl.lib_base.base.presenter.IBasePresenter;
import com.wyl.lib_base.base.presenter.InjectPresenter;
import com.wyl.lib_base.base.ui.IBaseView;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：YL Wang
 * 包名：com.wyl.lib_base.base.proxy
 * 创建时间：1/26/21
 * 备注：
 */
public class PresenterProxyImpl implements IPresenterProxy{


    private Map<String, IBasePresenter> mPresenters;

    private IBaseView baseView;

    public PresenterProxyImpl(IBaseView baseView) {
        this.baseView = baseView;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void bindPresenter() {
        Field[] fields = baseView.getClass().getDeclaredFields();
        if (fields.length == 0) {
            return;
        }
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(InjectPresenter.class);
            if (annotation != null) {
                try {
                    field.setAccessible(true);
                    IBasePresenter<IBaseView> presenter = getPresenter((Class<? extends IBasePresenter<IBaseView>>) field.getType());
                    presenter.attachView(baseView);
                    field.set(baseView, presenter);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void unbindPresenter() {
        if (mPresenters != null && !mPresenters.isEmpty()) {
            for (IBasePresenter presenter : mPresenters.values()) {
                if (presenter != null) {
                    presenter.detachView();
                }
            }
            mPresenters.clear();
        }
        mPresenters = null;
    }

    @SuppressWarnings("unchecked")
    private <P extends IBasePresenter> P getPresenter(Class<P> clazz) {
        if (!IBasePresenter.class.isAssignableFrom(clazz)) {
            throw new RuntimeException(clazz.getSimpleName() + " 必须是 " + IBasePresenter.class.getName() + " 的实现类或子类");
        }
        IBasePresenter presenter = null;
        if (mPresenters == null) {
            mPresenters = new HashMap<>();
        } else {
            presenter = mPresenters.get(clazz.getName());
            if (presenter != null) {
                return (P) presenter;
            }
        }
        try {
            presenter = clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        if (presenter == null) {
            throw new RuntimeException("没有找到合适的构造方法");
        }
        mPresenters.put(clazz.getName(), presenter);
        return (P) presenter;
    }


}
