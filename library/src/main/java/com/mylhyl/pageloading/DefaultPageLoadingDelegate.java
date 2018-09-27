package com.mylhyl.pageloading;

/**
 * Created by hupei on 2018/9/27 10:17.
 */
public class DefaultPageLoadingDelegate extends PageLoadingDelegate {

    @Override
    protected int getProgressLayoutId() {
        return R.layout.page_loading_progress;
    }

    @Override
    protected int getEmptyLayoutId() {
        return R.layout.page_loading_empty;
    }

    @Override
    protected int getErrorLayoutId() {
        return R.layout.page_loading_error;
    }

    @Override
    protected int getErrorNetLayoutId() {
        return R.layout.page_loading_error_net;
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
