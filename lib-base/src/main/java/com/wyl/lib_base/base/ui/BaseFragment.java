package com.wyl.lib_base.base.ui;

import androidx.fragment.app.Fragment;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：
 */
//public class BaseFragment <V extends ViewDataBinding, VM extends BaseViewModel> extends RxFragment {
public class BaseFragment extends Fragment {
    public boolean isBackPressed() {
        return false;
    }
}
