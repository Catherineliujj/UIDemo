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

package com.mding.main_code.about_fragment;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mding.R;
import com.mding.about_base.BaseFragment;
import com.mding.main_code.about_fragment.about_home.HomeContactsController;
import com.mding.main_code.about_fragment.about_home.HomeController;
import com.mding.main_code.about_fragment.about_home.HomeDiscoverController;
import com.mding.main_code.about_fragment.about_home.HomeMessageController;
import com.mding.main_code.about_fragment.about_home.HomePersonalController;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author cginechen
 * @date 2016-10-19
 */

public class HomeFragment extends BaseFragment {
    private final static String TAG = HomeFragment.class.getSimpleName();

    @BindView(R.id.pager)
    ViewPager mViewPager;
    @BindView(R.id.tabs)
    QMUITabSegment mTabSegment;
    private HashMap<Pager, HomeController> mPages;
    private PagerAdapter mPagerAdapter = new PagerAdapter() {

        private int mChildCount = 0;

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return mPages.size();
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {
            HomeController page = mPages.get(Pager.getPagerFromPositon(position));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            container.addView(page, params);
            return page;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            if (mChildCount == 0) {
                return POSITION_NONE;
            }
            return super.getItemPosition(object);
        }

        @Override
        public void notifyDataSetChanged() {
            mChildCount = getCount();
            super.notifyDataSetChanged();
        }
    };


    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, layout);
        initTabs();
        initPagers();
        return layout;
    }

    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.qmui_config_color_gray_6);
        int selectColor = getResources().getColor(R.color.app_theme);
        mTabSegment.setDefaultNormalColor(normalColor);
        mTabSegment.setDefaultSelectedColor(selectColor);
//        mTabSegment.setDefaultTabIconPosition(QMUITabSegment.ICON_POSITION_BOTTOM);

//        // 如果你的 icon 显示大小和实际大小不吻合:
//        // 1. 设置icon 的 bounds
//        // 2. Tab 使用拥有5个参数的构造器
//        // 3. 最后一个参数（setIntrinsicSize）设置为false
//        int iconShowSize = QMUIDisplayHelper.dp2px(getContext(), 20);
//        Drawable normalDrawable = ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_component);
//        normalDrawable.setBounds(0, 0, iconShowSize, iconShowSize);
//        Drawable selectDrawable = ContextCompat.getDrawable(getContext(), R.mipmap.icon_tabbar_component_selected);
//
//        selectDrawable.setBounds(0, 0, iconShowSize, iconShowSize);
//
//        QMUITabSegment.Tab component = new QMUITabSegment.Tab(
//                normalDrawable,
//                normalDrawable,
//                "Components", false, false
//        );

        QMUITabSegment.Tab message = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.drawable.home_message_nor),
                ContextCompat.getDrawable(getContext(), R.drawable.home_message),
                "消息", false
        );

        QMUITabSegment.Tab contacts = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.drawable.home_contacts_nor),
                ContextCompat.getDrawable(getContext(), R.drawable.home_contacts),
                "联系人", false
        );
        QMUITabSegment.Tab discover = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.drawable.home_discover_nor),
                ContextCompat.getDrawable(getContext(), R.drawable.home_discover),
                "发现", false
        );
        QMUITabSegment.Tab personal = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.drawable.home_personal_nor),
                ContextCompat.getDrawable(getContext(), R.drawable.home_personal),
                "个人中心", false
        );
        mTabSegment.addTab(message)
                .addTab(contacts)
                .addTab(discover)
                .addTab(personal);
    }

    private void initPagers() {

        HomeController.HomeControlListener listener = new HomeController.HomeControlListener() {
            @Override
            public void startFragment(BaseFragment fragment) {
                HomeFragment.this.startFragment(fragment);
            }
        };

        mPages = new HashMap<>();

        HomeController homeMessageController = new HomeMessageController(getActivity());
        homeMessageController.setHomeControlListener(listener);
        mPages.put(Pager.MESSAGE, homeMessageController);

        HomeController homeContactsController = new HomeContactsController(getActivity());
        homeContactsController.setHomeControlListener(listener);
        mPages.put(Pager.CONTACTS, homeContactsController);

        HomeController homeLabController = new HomeDiscoverController(getActivity());
        homeLabController.setHomeControlListener(listener);
        mPages.put(Pager.DISCOVER, homeLabController);

        HomeController homePersonalController = new HomePersonalController(getActivity());
        homePersonalController.setHomeControlListener(listener);
        mPages.put(Pager.PERSONAL, homePersonalController);

        mViewPager.setAdapter(mPagerAdapter);
        mTabSegment.setupWithViewPager(mViewPager, false);
    }

    enum Pager {
        MESSAGE, CONTACTS, DISCOVER, PERSONAL;

        public static Pager getPagerFromPositon(int position) {
            switch (position) {
                case 0:
                    return MESSAGE;
                case 1:
                    return CONTACTS;
                case 2:
                    return DISCOVER;
                case 3:
                    return PERSONAL;
                default:
                    return MESSAGE;
            }
        }
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }
}