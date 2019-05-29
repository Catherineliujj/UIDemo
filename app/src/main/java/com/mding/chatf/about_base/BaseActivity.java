package com.mding.chatf.about_base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mding.chatf.R;
import com.mding.chatf.about_manage.AppManager;
import com.qmuiteam.qmui.arch.QMUIActivity;

/**
 * 项目：UIDemo
 * 文件描述：BaseActivity
 * 作者：ljj
 * 创建时间：2019/5/27
 * 修改人：
 * 更改时间：
 * 修改备注：
 */
public class BaseActivity extends QMUIActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppManager.getAppManager().addActivity(this);

        setContentView(getLayoutView());
        initBaseView();
    }

    protected void initBaseView() {

    }

    protected int getLayoutView() {
        return 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
        if (isTopBack()){
            findViewById(R.id.include_top_lin_newback).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppManager.getAppManager().finishActivity();
                }
            });
        }
    }

    protected boolean isTopBack() {
        return true;
    }
}
