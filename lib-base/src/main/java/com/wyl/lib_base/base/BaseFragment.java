package com.wyl.lib_base.base;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.trello.rxlifecycle4.components.support.RxFragment;

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
