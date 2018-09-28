package com.mylhyl.pagestatelayoutdemo;

import android.app.Application;

import com.mylhyl.pagestatelayout.PageStateConfig;
import com.mylhyl.pagestatelayout.PageStateLayoutCreater;

/**
 * Created by hupei on 2018/9/27 19:57.
 */
public class APP extends Application {
    static {

//        //只自定义加载视图
//        PageStateLayoutCreater.setPageStateConfig(new DefaultPageStateConfig(){
//            @Override
//            protected int getLoadingLayout() {
//                return R.layout.xxxxxx;
//            }
//        });

        PageStateLayoutCreater.setPageStateConfig(new PageStateConfig() {
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
