package com.mylhyl.pagestatelayoutdemo;

import android.app.Application;

import com.mylhyl.pagestatelayout.PageStateLayoutCreater;
import com.mylhyl.pagestatelayout.PageStateDelegate;

/**
 * Created by hupei on 2018/9/27 19:57.
 */
public class APP extends Application {
    static {
        PageStateLayoutCreater.setLoadingDelegate(new PageStateDelegate() {
            @Override
            protected int getLoadingLayout() {
                return R.layout.share_page_loading;
            }

            @Override
            protected int getEmptyLayout() {
                return R.layout.share_page_empty;
            }

            @Override
            protected int getErrorLayout() {
                return R.layout.share_page_error;
            }

            @Override
            protected int getErrorNetLayout() {
                return R.layout.share_page_error_net;
            }
        });
    }
}
