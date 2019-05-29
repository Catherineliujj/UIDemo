package com.mding.chatf.main_code.about_fragment.about_home;

import android.content.Context;

/**
 * 项目：UIDemo
 * 文件描述：个人中心Controller
 * 作者：ljj
 * 创建时间：2019/5/23
 * 修改人：
 * 更改时间：
 * 修改备注：
 */
public class HomePersonalController extends HomeController{

    public HomePersonalController(Context context) {
        super(context);
    }

    @Override
    protected String getTitle() {
        return "个人中心";
    }
}
