package com.wyl.module_mine.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wyl.lib_base.base.ui.BaseFragment;
import com.wyl.lib_base.routerpath.RouterFragmentPath;
import com.wyl.module_mine.R;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：
 */
@Route(path = RouterFragmentPath.Mine.PAGER_MINE)
public class MineFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, container,false);
        return view;
    }
}
