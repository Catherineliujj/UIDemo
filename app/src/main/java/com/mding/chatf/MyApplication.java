package com.mding.chatf;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.mding.chatf.about_manage.AppManager;
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

/**
 * 项目：UIDemo
 * 文件描述：MyApplication
 * 作者：ljj
 * 创建时间：2019/5/27
 * 修改人：
 * 更改时间：2019/6/11  15:30
 * 修改备注：
 */
public class MyApplication extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        QMUISwipeBackActivityManager.init(this);
        AppManager.getAppManager().addActivity((AppCompatActivity) getContext());
    }

}
