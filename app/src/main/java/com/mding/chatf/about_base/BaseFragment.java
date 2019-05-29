package com.mding.chatf.about_base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qmuiteam.qmui.arch.QMUIFragment;

/**
 * Created by cgspine on 2018/1/7.
 */

public abstract class BaseFragment extends QMUIFragment {

    public BaseFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
