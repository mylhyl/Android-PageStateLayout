package com.mylhyl.pageloading;

/**
 * Created by hupei on 2018/9/27 10:17.
 */
public class DefaultPageLoadingDelegate extends PageLoadingDelegate {

    @Override
    protected int getProgressLayout() {
        return R.layout.library_pl_progress;
    }

    @Override
    protected int getEmptyLayout() {
        return R.layout.library_pl_empty;
    }

    @Override
    protected int getErrorLayout() {
        return R.layout.library_pl_error;
    }

    @Override
    protected int getErrorNetLayout() {
        return R.layout.library_pl_error_net;
    }

    @Override
    protected int getProgressTipViewId() {
        return R.id.page_loading_tv;
    }

    @Override
    protected int getEmptyTipViewId() {
        return R.id.page_loading_tv_empty;
    }

    @Override
    protected int getErrorTipViewId() {
        return R.id.page_loading_tv_error;
    }

    @Override
    protected int getErrorNetTipViewId() {
        return R.id.page_loading_tv_error_net;
    }
}
