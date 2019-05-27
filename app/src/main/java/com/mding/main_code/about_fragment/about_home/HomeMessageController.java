package com.mding.main_code.about_fragment.about_home;

import android.content.Context;
import android.view.LayoutInflater;

import com.mding.R;

import butterknife.ButterKnife;

/**
 * 项目：UIDemo
 * 文件描述：消息页Controller
 * 作者：ljj
 * 创建时间：2019/5/23
 * 修改人：
 * 更改时间：
 * 修改备注：
 */
public class HomeMessageController extends HomeController{

    public HomeMessageController(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.fragment_message, this);
        ButterKnife.bind(this);
    }

    @Override
    protected String getTitle() {
        return "消息";
    }
}
