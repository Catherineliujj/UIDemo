package com.mding.chatf.main_code;

import android.os.Bundle;

import com.mding.chatf.R;
import com.mding.chatf.about_base.BaseFragment;
import com.mding.chatf.about_base.BaseFragmentActivity;
import com.mding.chatf.main_code.about_fragment.HomeFragment;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected int getContextViewId() {
        return R.id.uidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            BaseFragment fragment = getFirstFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(getContextViewId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commit();
        }

    }

    private BaseFragment getFirstFragment() {

        return new HomeFragment();
    }

}
