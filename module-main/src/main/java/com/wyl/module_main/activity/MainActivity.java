package com.wyl.module_main.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.wyl.lib_base.routerpath.RouterActivityPath;
import com.wyl.lib_base.routerpath.RouterFragmentPath;

import com.wyl.lib_base.widget.NoScrollViewPager;
import com.wyl.module_main.R;
import com.wyl.module_main.adapter.VpAdapterMain;
import com.wyl.module_main.impl.TabPagerListener;


@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends AppCompatActivity implements TabPagerListener, BubbleNavigationChangeListener {

    NoScrollViewPager noScrollViewPager;
    BubbleNavigationConstraintView bubbleNavigationLinearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noScrollViewPager = (NoScrollViewPager) findViewById(R.id.vp_noScroll);
        bubbleNavigationLinearView = (BubbleNavigationConstraintView) findViewById(R.id.bottom_navigation_constraint);

        initTab();

        initNav();
    }

    private void initNav() {

        bubbleNavigationLinearView.setTypeface(Typeface.createFromAsset(getAssets(), "rubik.ttf"));

        bubbleNavigationLinearView.setBadgeValue(0, null);
        bubbleNavigationLinearView.setBadgeValue(1, null); //invisible badge
        bubbleNavigationLinearView.setBadgeValue(2, null);//empty badge
        bubbleNavigationLinearView.setNavigationChangeListener(this);
    }

    private void initTab() {

        VpAdapterMain adapterMain = new VpAdapterMain(getSupportFragmentManager());
        adapterMain.setListener(this);
        noScrollViewPager.setOffscreenPageLimit(3);
        noScrollViewPager.setScrollable(false);
        noScrollViewPager.setAdapter(adapterMain);
    }


    @Override
    public void onNavigationChanged(View view, int position) {
        noScrollViewPager.setCurrentItem(position, false);
    }

    //用户按返回按钮不关闭页面，而是返回到系统桌面。相当于按home键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public Fragment getFragment(int position) {
        if (position == 0) {
            return (Fragment) ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation();
        } else if (position == 1) {
            return (Fragment) ARouter.getInstance().build(RouterFragmentPath.Work.PAGER_WROK).navigation();

        } else if (position == 2) {
            return (Fragment) ARouter.getInstance().build(RouterFragmentPath.Mine.PAGER_MINE).navigation();
        }
        return null;
    }

    @Override
    public int count() {
        return 3;
    }

}