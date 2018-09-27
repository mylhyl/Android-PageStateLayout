package com.mylhyl.pageloadingdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mylhyl.pageloading.PageLoadingView;

public class CustomEmptyActivity extends AppCompatActivity {
    private PageLoadingView mPageLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_empty);

        mPageLoadingView = findViewById(R.id.pageLoadingView);
        mPageLoadingView.showEmptyView();
//        mPageLoadingView.setEmptyTip("自定义的");
    }
}
