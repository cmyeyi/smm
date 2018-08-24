package com.can.mz;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.can.mz.base.BaseActivity;
import com.can.mz.fragment.FragmentMain;
import com.can.mz.fragment.FragmentOne;
import com.can.mz.fragment.FragmentThree;
import com.can.mz.fragment.FragmentTwo;
import com.can.mz.view.FragmentTabHost;

import java.lang.ref.WeakReference;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";
    private static String[] TAB_TAG;
    public static final int TAB_GIRL = 0;
    public static final int TAB_BOY = 1;
    public static final int TAB_SCENERY = 2;
    public static final int TAB_MINE = 3;
    private FragmentTabHost mFragmentTabHost;
    private boolean hasRedSpot = false;

    public static void launch(Context context) {
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        FragmentManager manager = getSupportFragmentManager();
        int tab = handleIntent(intent);
        Fragment fragment = manager.findFragmentByTag(TAB_TAG[tab]);
    }


    private void initView() {
        initToolBar();
        mFragmentTabHost = findViewById(android.R.id.tabhost);
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fl_real_content);
        int index = handleIntent(getIntent());
        initTabFragment();
        mFragmentTabHost.setCurrentTab(index);
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp(getString(R.string.app_name), false);
    }

    private int handleIntent(Intent intent) {
        int tab = mFragmentTabHost.getCurrentTab();
        if (tab < 0) {
            tab = 0;
        }
        if (intent != null && intent.getData() != null) {
            Uri uri = intent.getData();
            String path = uri.getPath();
            if (path.contains("tab_scenery")) {
                tab = TAB_SCENERY;
            } else if (path.contains("tab_girl")) {
                tab = TAB_GIRL;
            } else if (path.contains("tab_boy")) {
                tab = TAB_BOY;
            } else {
                tab = TAB_MINE;
            }
        }
        return tab;
    }


    private void initTabFragment() {
        TAB_TAG = getResources().getStringArray(R.array.main_tab_tags);
        int[] tabLayouts = {R.layout.tab_item_main, R.layout.tab_item_girl, R.layout.tab_item_boy, R.layout.tab_item_scenery};
        Class[] fragmentClasses = {FragmentMain.class, FragmentOne.class, FragmentTwo.class, FragmentThree.class};
        Bundle[] bundles = {new Bundle(), new Bundle(), new Bundle(), new Bundle()};
        if (TAB_TAG.length != fragmentClasses.length || TAB_TAG.length != tabLayouts.length) {
            throw new IllegalStateException(getString(R.string.tab_num_error));
        }
        LayoutInflater inflater = LayoutInflater.from(this);
        TabWidget tabWidget = mFragmentTabHost.getTabWidget();
        for (int i = 0; i < TAB_TAG.length; i++) {
            mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(TAB_TAG[i]).setIndicator(inflater.inflate(tabLayouts[i], tabWidget, false)), fragmentClasses[i], bundles[i]);
        }
        int tabWidgetChildCount = tabWidget.getChildCount();
        for (int i = 0; i < tabWidgetChildCount; i++) {
            View view = tabWidget.getChildAt(i);
            if (null != view) {
                view.setTag(R.id.tabs_item_id, TAB_TAG[i]);
                view.setOnClickListener(new TabClickListener(mFragmentTabHost));
            }
        }

        mFragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                updateRedSpotVisibility(hasRedSpot);

            }
        });

    }

    private int getIndexOfTabs(String tabId) {
        if (TAB_TAG != null && TAB_TAG.length > 0) {
            for (int i = 0; i < TAB_TAG.length; i++) {
                if (tabId.equals(TAB_TAG[i])) {
                    return i;
                }
            }
        }
        return 0;
    }

    private void updateRedSpotVisibility(boolean visible) {
        if (mFragmentTabHost.getCurrentTab() == 2) {
            visible = false;
        }
        hasRedSpot = visible;
        View view = findViewById(R.id.notice_new);
        if (view != null) {
            view.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }


    @Override
    public void onClick(View v) {
    }

    /**
     * 底部item的点击事件
     */
    static class TabClickListener implements View.OnClickListener {
        private WeakReference<FragmentTabHost> reference;
        private AnimatorSet animSet;

        public TabClickListener(FragmentTabHost fragmentTabHost) {
            this.reference = new WeakReference<>(fragmentTabHost);
        }

        @Override
        public void onClick(View v) {
            String tag = (String) v.getTag(R.id.tabs_item_id);
            FragmentTabHost fragmentTabHost = reference.get();
            if (!TextUtils.isEmpty(tag) && fragmentTabHost != null && ViewCompat.isAttachedToWindow(fragmentTabHost)) {
                if (!fragmentTabHost.getCurrentTabTag().equals(tag)) {
                    fragmentTabHost.setCurrentTabByTag(tag);
                } else {
                    //TODO
                }
            }
        }

    }

}
