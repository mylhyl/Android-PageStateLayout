package com.mylhyl.pageloadingdemo;

import android.app.Application;

import com.mylhyl.pageloading.PageLoadingCreater;
import com.mylhyl.pageloading.PageLoadingDelegate;

/**
 * Created by hupei on 2018/9/27 19:57.
 */
public class APP extends Application {
    static {
        PageLoadingCreater.setLoadingDelegate(new PageLoadingDelegate() {
            @Override
            protected int getProgressLayout() {
                return R.layout.share_page_progress;
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
