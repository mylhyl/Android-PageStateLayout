package com.mylhyl.pagestatelayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mylhyl.pagestatelayout.PageStateLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnRefreshListener {

    private Toolbar mToolbar;
    private RefreshLayout mRefreshLayout;
    private PageStateLayout mPageStateLayout;
    private RecyclerView mRecyclerView;
    private BaseQuickAdapter mAdapter;
    private int mType = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mRefreshLayout = findViewById(R.id.smartRefreshLayout);
        mPageStateLayout = findViewById(R.id.pageStateLayout);
        mRecyclerView = findViewById(R.id.recyclerView);

        setSupportActionBar(mToolbar);
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1) {

            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(android.R.id.text1, item);
            }
        };
        mRecyclerView.setAdapter(mAdapter);

        mRefreshLayout.autoRefresh();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        switch (mType) {
            case 1:
                mRefreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishRefresh();
                        mPageStateLayout.showLoadingView();
                    }
                }, 200l);
                break;
            case 2:
                mRefreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishRefresh();
                        mPageStateLayout.showEmptyView();
                    }
                }, 200l);
                mType = 5;
                break;
            case 3:
                mRefreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishRefresh();
                        mPageStateLayout.showErrorView();
                    }
                }, 200l);
                break;
            case 4:
                mRefreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishRefresh();
                        mPageStateLayout.showErrorNetView();
                    }
                }, 200l);
                break;
            case 5:
                mPageStateLayout.showLoadingView();
                mRefreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> listData = new ArrayList<>();
                        for (int i = 0; i < 33; i++) {
                            listData.add("item " + i + 1);
                        }
                        mAdapter.setNewData(listData);
                        mRefreshLayout.finishRefresh();
                        mPageStateLayout.showContentView();
                    }
                }, 2000);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_loading:
                mType = 1;
                break;
            case R.id.menu_empty:
                mType = 2;
                break;
            case R.id.menu_error:
                mType = 3;
                break;
            case R.id.menu_errorNet:
                mType = 4;
                break;
            case R.id.menu_content:
                mType = 5;
                break;
            case R.id.menu_customEmpty:
                startActivity(new Intent(this, CustomEmptyActivity.class));
                break;
        }
        mRefreshLayout.autoRefresh();
        return super.onOptionsItemSelected(item);
    }
}
