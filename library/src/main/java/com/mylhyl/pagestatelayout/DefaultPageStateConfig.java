package com.mylhyl.pagestatelayout;

/**
 * Created by hupei on 2018/9/27 10:17.
 */
public class DefaultPageStateConfig extends PageStateConfig {

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
    protected int getLoadingMsgViewId() {
        return R.id.library_psl_loadingMsg;
    }

    @Override
    protected int getEmptyImgId() {
        return R.id.library_psl_emptyImg;
    }

    @Override
    protected int getEmptyMsgViewId() {
        return R.id.library_psl_emptyMsg;
    }

    @Override
    protected int getErrorImgId() {
        return R.id.library_psl_errorImg;
    }

    @Override
    protected int getErrorMsgViewId() {
        return R.id.library_psl_errorMsg;
    }

    @Override
    protected int getErrorNetImgId() {
        return R.id.library_psl_errorNetImg;
    }

    @Override
    protected int getErrorNetMsgViewId() {
        return R.id.library_psl_errorNetMsg;
    }
}
