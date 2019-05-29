package com.mding.chatf.main_code.about_activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.mding.chatf.R;
import com.mding.chatf.about_base.BaseActivity;
import com.mding.chatf.about_custom.about_top_bar.ActivityTopBarLayout;
import com.mding.chatf.utils.StrUtils;
import com.mding.chatf.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.search_ac_topbar)
    ActivityTopBarLayout searchAcTopbar;
    @BindView(R.id.seach_ed_input)
    EditText seachEdInput;

    @Override
    protected void initBaseView() {
        super.initBaseView();
        ButterKnife.bind(this);

        initTopBar();
        initView();
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_search;
    }

    private void initTopBar() {
        searchAcTopbar.setTitle("搜索");
    }

    private void initView() {
        listenEnter();
    }

    //    监听软键盘的回车键
    private void listenEnter() {
        seachEdInput.setImeOptions(EditorInfo.IME_ACTION_SEND);
        seachEdInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    //处理事件
                    clickSearch();
                }
                return false;
            }
        });
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        seachEdInput.setFocusable(true);
        seachEdInput.setFocusableInTouchMode(true);
        seachEdInput.requestFocus();
        seachEdInput.findFocus();
    }

    private void clickSearch() {
        String edInput = seachEdInput.getText().toString().trim();
        if (StrUtils.isEmpty(edInput))
        {
            ToastUtil.show("搜索内容不能为空");
            return;
        }
        // TODO  搜索
    }

}
