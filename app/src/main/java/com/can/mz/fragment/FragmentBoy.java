package com.can.mz.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.can.mz.R;
import com.can.mz.adapter.PhotoAdapter;
import com.can.mz.base.BaseFragment;
import com.can.mz.utils.PermissionManager;
import com.can.mz.view.MultiDividerItemDecoration;
import com.dmcc.image_preview.ImagePreviewActivity;
import com.tech.aile.permission.Permission;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class FragmentBoy extends BaseFragment implements View.OnClickListener {

    private View mRootView;
    private SwipeRefreshLayout mSwipeLayout;
    private RecyclerView mRecyclerView;
    private PhotoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.layout_fragment_mm, container, false);
            initView(mRootView);
            loadData();
        }
        return mRootView;
    }

    private void initView(View rootView) {
        initPullToFresh(rootView);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.main_recyler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //添加竖向分割线
        mRecyclerView.addItemDecoration(new MultiDividerItemDecoration(getContext(),MultiDividerItemDecoration.VERTICAL));
        //添加横向分割线
        mRecyclerView.addItemDecoration(new MultiDividerItemDecoration(getContext(),MultiDividerItemDecoration.HORIZONTAL));
        adapter = new PhotoAdapter(new PhotoAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                if (PermissionManager.isHasPermission(getActivity(), Permission.Group.STORAGE)) {
                    ImagePreviewActivity.startActivity(getActivity(), getData().get(position), getData());
                } else {
                    PermissionManager.requestPermission(getActivity(), Permission.Group.STORAGE);
                }
            }
        });
        mRecyclerView.setAdapter(adapter);

    }

    private ArrayList<String> getData() {
        return getFromAssets("boy.txt");
    }

    public ArrayList<String> getFromAssets(String fileName) {
        ArrayList<String> urls = new ArrayList<>();
        try {
            InputStream in = getActivity().getAssets().open(fileName);
            InputStreamReader inputReader = new InputStreamReader(in, "UTF-8");
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            while ((line = bufReader.readLine()) != null)
                if (!TextUtils.isEmpty(line.trim())) {
                    urls.add(line.trim());
                }

        } catch (Exception e) {
            e.printStackTrace();
            return urls;
        }

        return urls;
    }

    private void initPullToFresh(View rootView) {
        mSwipeLayout = rootView.findViewById(R.id.swipe_ly);
        mSwipeLayout.setColorSchemeResources(R.color.theme_color);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.replaceAll(getData());
                hideProgressDialog();
            }
        });
        mHandler.sendEmptyMessage(REFRESH_LIST);
    }

    private void loadData() {
        showProgressDialog();
        adapter.replaceAll(getData());
        hideProgressDialog();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void showProgressDialog() {
        if (mSwipeLayout != null) {
            mSwipeLayout.setRefreshing(true);
        }
    }

    private void hideProgressDialog() {
        if (mSwipeLayout != null && mSwipeLayout.isRefreshing()) {
            mSwipeLayout.setRefreshing(false);
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_LIST:
                    if (mSwipeLayout.isRefreshing()) {
                        mSwipeLayout.setRefreshing(false);
                    }
                    break;
            }
        }

        ;
    };

}
