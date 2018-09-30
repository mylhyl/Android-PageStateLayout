package com.mylhyl.pagestatelayoutdemo;

import android.app.Application;

import com.mylhyl.pagestatelayout.PageStateConfig;
import com.mylhyl.pagestatelayout.PageStateLayout;

/**
 * Created by hupei on 2018/9/27 19:57.
 */
public class APP extends Application {
    static {

//        //只自定义加载视图
//        PageStateLayout.setPageStateConfig(new DefaultPageStateConfig(){
//            @Override
//            protected int getLoadingLayout() {
//                return R.layout.xxxxxx;
//            }
//        });

        //全局替换所有
        PageStateLayout.setPageStateConfig(new PageStateConfig() {
            @Override
            protected int getLoadingLayout() {
                return R.layout.share_psl_loading;
            }

            @Override
            protected int getLoadingMsgViewId() {
                return R.id.share_psl_loadingMsg;
            }

            @Override
            protected int getEmptyLayout() {
                return R.layout.share_psl_empty;
            }

            @Override
            protected int getEmptyMsgViewId() {
                return R.id.share_psl_emptyMsg;
            }

            @Override
            protected int getErrorLayout() {
                return R.layout.share_psl_error;
            }

            @Override
            protected int getErrorMsgViewId() {
                return R.id.share_psl_errorMsg;
            }

            @Override
            protected int getErrorNetLayout() {
                return R.layout.share_psl_error_net;
            }

            @Override
            protected int getErrorNetMsgViewId() {
                return R.id.share_psl_errorNetMsg;
            }
        });
    }
}
