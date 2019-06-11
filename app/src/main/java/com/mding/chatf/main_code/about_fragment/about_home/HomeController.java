/*
 * Tencent is pleased to support the open source community by making QMUI_Android available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the MIT License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mding.chatf.main_code.about_fragment.about_home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.mding.chatf.R;
import com.mding.chatf.about_base.BaseFragment;
import com.mding.chatf.about_custom.about_top_bar.FragmentTopBarLayout;
import com.mding.chatf.main_code.about_activity.SearchActivity;
import com.mding.chatf.utils.ToastUtil;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIWindowInsetLayout;
import com.qmuiteam.qmui.widget.popup.QMUIListPopup;
import com.qmuiteam.qmui.widget.popup.QMUIPopup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mding.chatf.utils.IntentUtils.JumpTo;

/**
 * @author cginechen
 * @date 2016-10-20
 */

public abstract class HomeController extends QMUIWindowInsetLayout {

    @BindView(R.id.topbar)
    FragmentTopBarLayout mTopBar;

    private HomeControlListener mHomeControlListener;
    private QMUIListPopup mListPopup;
    public HomeController(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_home, this);
        ButterKnife.bind(this);
        initTopBar();
        initRightClick();
        initLeftClick();
    }

    protected void startFragment(BaseFragment fragment) {
        if (mHomeControlListener != null) {
            mHomeControlListener.startFragment(fragment);
        }
    }

    public void setHomeControlListener(HomeControlListener homeControlListener) {
        mHomeControlListener = homeControlListener;
    }

    protected abstract String getTitle();

    private void initTopBar() {
        mTopBar.setTitle(getTitle());

        mTopBar.setBackgroundColor(getResources().getColor(R.color.app_theme));

//        mTopBar.addRightImageButton(R.drawable.top_bar_add, R.id.topbar_right_about_button).setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "click", Toast.LENGTH_LONG).show();
//            }
//        });
//        mTopBar.addLeftImageButton(R.drawable.top_bar_search, R.id.qmui_topbar_item_left_back).setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "back", Toast.LENGTH_LONG).show();
//            }
//        });

    }

    public interface HomeControlListener {
        void startFragment(BaseFragment fragment);
    }

    private void initRightClick() {
        mTopBar.setOnRightClick(new OnClickListener() {
            @Override
            public void onClick(View v) {
                initListPopupIfNeed();
//                mListPopup.setAnimStyle(QMUIPopup.ANIM_GROW_FROM_CENTER);
                mListPopup.setPreferredDirection(QMUIPopup.DIRECTION_TOP);
                mListPopup.show(v);
            }
        });
    }

    private void initLeftClick() {
        mTopBar.setOnSearchClick(new OnClickListener() {
            @Override
            public void onClick(View v) {
                JumpTo(getContext(), SearchActivity.class);
//                Intent intent = new Intent(getContext(), SearchActivity.class);
//                getContext().startActivity(intent);

//                JumpTo(SearchActivity.class);
            }
        });
    }

    private void initListPopupIfNeed() {
        if (mListPopup == null) {

            String[] listItems = new String[]{
                    "创建群聊",
                    "添加好友、群",
                    "扫一扫",
            };
            List<String> data = new ArrayList<>();

            Collections.addAll(data, listItems);

            ArrayAdapter adapter = new ArrayAdapter<>(getContext(), R.layout.simple_list_item, data);

            mListPopup = new QMUIListPopup(getContext(), QMUIPopup.DIRECTION_NONE, adapter);
            mListPopup.create(QMUIDisplayHelper.dp2px(getContext(), 130), QMUIDisplayHelper.dp2px(getContext(), 200), new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    switch (i){
                        case 0:

                            ToastUtil.isDebugShow("创建群聊");
                            mListPopup.dismiss();
                            break;
                        case 1:

                            ToastUtil.isDebugShow("添加好友/群");
                            mListPopup.dismiss();
                            break;
                        case 2:

                            ToastUtil.isDebugShow("扫一扫");
                            mListPopup.dismiss();
                            break;
                    }
                }
            });
        }
    }
}
