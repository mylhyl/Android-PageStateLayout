package com.mylhyl.pagestatelayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.mylhyl.pagestate.PageStateLayout;

public class CustomEmptyActivity extends AppCompatActivity {
    private PageStateLayout mPageStateLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_empty);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        DoubleBounce doubleBounce = new DoubleBounce();
        doubleBounce.setColor(Color.parseColor("#1AAF5D"));
        progressBar.setIndeterminateDrawable(doubleBounce);

        mPageStateLayout = findViewById(R.id.pageStateLayout);
        mPageStateLayout.showEmptyView();
//        TextView emptyMsgView = mPageStateLayout.getEmptyMsgView();
//        if (emptyMsgView != null) {
//            emptyMsgView.setText("自定义的");
//        }
    }
}
