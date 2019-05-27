package com.mding.about_base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

/**
 * Created by cgspine on 2018/1/7.
 */

public abstract class BaseFragment extends QMUIFragment {


    public BaseFragment() {
    }

    @Override
    protected int backViewInitOffset() {
        return QMUIDisplayHelper.dp2px(getContext(), 100);
    }

    @Override
    public void onResume() {
        super.onResume();
//        QDUpgradeManager.getInstance(getContext()).runUpgradeTipTaskIfExist(getActivity());

    }

    protected void goToWebExplorer(@NonNull String url, @Nullable String title) {
//        Intent intent = QDMainActivity.createWebExplorerIntent(getContext(), url, title);
//        startActivity(intent);
    }

    protected void injectDocToTopBar(QMUITopBar topBar) {
//        final QDItemDescription description = QDDataManager.getInstance().getDescription(this.getClass());
//        if (description != null) {
//            topBar.addRightTextButton("DOC", QMUIViewHelper.generateViewId())
//                    .setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            goToWebExplorer(description.getDocUrl(), description.getName());
//                        }
//                    });
//        }
    }

    protected void injectDocToTopBar(QMUITopBarLayout topBar){
//        final QDItemDescription description = QDDataManager.getInstance().getDescription(this.getClass());
//        if (description != null) {
//            topBar.addRightTextButton("DOC", QMUIViewHelper.generateViewId())
//                    .setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            goToWebExplorer(description.getDocUrl(), description.getName());
//                        }
//                    });
//        }
    }

}
