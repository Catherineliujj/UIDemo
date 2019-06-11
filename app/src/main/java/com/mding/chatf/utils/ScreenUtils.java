package com.mding.chatf.utils;

import android.content.Context;

import java.lang.reflect.Field;

/**
 * 项目：UIDemo
 * 文件描述：屏幕工具类
 * 作者：ljj
 * 创建时间：2019/5/29
 * 修改人：
 * 更改时间：
 * 修改备注：
 */
public class ScreenUtils {


    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0;
        int statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
            return statusBarHeight;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

}
