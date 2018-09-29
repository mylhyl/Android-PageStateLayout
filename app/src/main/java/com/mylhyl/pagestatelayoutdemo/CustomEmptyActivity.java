package com.mylhyl.pagestatelayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mylhyl.pagestatelayout.PageStateLayout;

public class CustomEmptyActivity extends AppCompatActivity {
    private PageStateLayout mPageStateLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_empty);

        mPageStateLayout = findViewById(R.id.pageStateLayout);
        mPageStateLayout.showEmptyView();
//        TextView emptyMsgView = mPageStateLayout.getEmptyMsgView();
//        if (emptyMsgView != null) {
//            emptyMsgView.setText("自定义的");
//        }
    }
}
