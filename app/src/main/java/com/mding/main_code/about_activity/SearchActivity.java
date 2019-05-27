package com.mding.main_code.about_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mding.R;
import com.mding.about_base.BaseFragmentActivity;
import com.mding.about_manage.AppManager;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseFragmentActivity {

    @BindView(R.id.topbar)
    QMUITopBarLayout mTopbar;

    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initTopBar();
    }

    private void initTopBar() {
        mTopbar.setTitle("搜索");
        mTopbar.setBackgroundColor(getResources().getColor(R.color.app_theme));
        mTopbar.addLeftImageButton(R.drawable.to_left, R.id.qmui_topbar_item_left_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManager.getAppManager().finishActivity();
            }
        });

    }
}
