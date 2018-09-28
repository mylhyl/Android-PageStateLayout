package com.mylhyl.pagestatelayout;

/**
 * Created by hupei on 2018/9/27 10:17.
 */
public class DefaultPageStateDelegate extends PageStateDelegate {

    @Override
    protected int getLoadingLayout() {
        return R.layout.library_psl_loading;
    }

    @Override
    protected int getEmptyLayout() {
        return R.layout.library_psl_empty;
    }

    @Override
    protected int getErrorLayout() {
        return R.layout.library_psl_error;
    }

    @Override
    protected int getErrorNetLayout() {
        return R.layout.library_psl_error_net;
    }

    @Override
    protected int getLoadingTipViewId() {
        return R.id.library_psl_tipLoading;
    }

    @Override
    protected int getEmptyTipViewId() {
        return R.id.library_psl_tipEmpty;
    }

    @Override
    protected int getErrorTipViewId() {
        return R.id.library_psl_tipError;
    }

    @Override
    protected int getErrorNetTipViewId() {
        return R.id.library_psl_tipErrorNet;
    }
}
