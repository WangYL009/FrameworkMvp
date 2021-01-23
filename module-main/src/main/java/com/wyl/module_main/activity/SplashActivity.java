package com.wyl.module_main.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wyl.lib_base.routerpath.RouterActivityPath;
import com.wyl.module_main.R;
import com.wyl.module_main.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.wangyuwei.particleview.ParticleView;

/**
 * @create : wyl
 * @date : 2021/1/8
 * @备注：
 */
public class SplashActivity extends AppCompatActivity {


    @BindView(R2.id.particleview)
    ParticleView particleview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_splash);
        ButterKnife.bind(this);
        particleview.startAnim();
        particleview.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
            }
        });
    }
}
