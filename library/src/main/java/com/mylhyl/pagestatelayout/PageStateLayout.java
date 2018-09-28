package com.mylhyl.pagestatelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by hupei on 2018/9/27 13:49.
 */
public class PageStateLayout extends FrameLayout implements PageState {

    private PageStateLayoutCreater mPageStateCreater = new PageStateLayoutCreater();

    public PageStateLayout(@NonNull Context context) {
        this(context, null);
    }

    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.PageStateLayout);
        int loadingLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_loadingLayout, NO_ID);
        int emptyLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyLayout, NO_ID);
        int errorLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_errorLayout, NO_ID);
        int errorNetLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetLayout, NO_ID);

        int progressTipViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_progressTipViewId, NO_ID);
        int emptyTipViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyTipViewId, NO_ID);
        int errorTipViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorTipViewId, NO_ID);
        int errorNetTipViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetTipViewId, NO_ID);
        if (!isInEditMode()) {
            if (loadingLayout != NO_ID)
                mPageStateCreater.setLoadingLayout(loadingLayout);
            if (emptyLayout != NO_ID)
                mPageStateCreater.setEmptyLayout(emptyLayout);
            if (errorLayout != NO_ID)
                mPageStateCreater.setErrorLayout(errorLayout);
            if (errorNetLayout != NO_ID)
                mPageStateCreater.setErrorNetLayout(errorNetLayout);

            if (progressTipViewId != NO_ID)
                mPageStateCreater.setProgressTipViewId(progressTipViewId);
            if (emptyTipViewId != NO_ID)
                mPageStateCreater.setEmptyTipViewId(emptyTipViewId);
            if (errorTipViewId != NO_ID)
                mPageStateCreater.setErrorTipViewId(errorTipViewId);
            if (errorNetTipViewId != NO_ID)
                mPageStateCreater.setErrorNetTipViewId(errorNetTipViewId);
        }
        ta.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 1) {
            throw new IllegalStateException("PageLoadingView can host only one direct child");
        }
        if (!isInEditMode()) {
            setRootView(this);
            View view = getChildAt(0);
            setContentView(view);
            mPageStateCreater.create();
        }
    }

    @Override
    public void setLoadingLayout(@LayoutRes int loadingLayoutId) {
        mPageStateCreater.setLoadingLayout(loadingLayoutId);
    }

    @Override
    public void setEmptyLayout(@LayoutRes int emptyLayoutId) {
        mPageStateCreater.setErrorLayout(emptyLayoutId);
    }

    @Override
    public void setErrorLayout(@LayoutRes int errorLayoutId) {
        mPageStateCreater.setErrorLayout(errorLayoutId);
    }

    @Override
    public void setErrorNetLayout(@LayoutRes int errorNetLayoutId) {
        mPageStateCreater.setErrorNetLayout(errorNetLayoutId);
    }

    @Override
    public void setProgressTipViewId(@IdRes int progressTipViewId) {
        mPageStateCreater.setProgressTipViewId(progressTipViewId);
    }

    @Override
    public void setEmptyTipViewId(@IdRes int emptyTipViewId) {
        mPageStateCreater.setEmptyTipViewId(emptyTipViewId);
    }

    @Override
    public void setErrorTipViewId(@IdRes int errorTipViewId) {
        mPageStateCreater.setErrorTipViewId(errorTipViewId);
    }

    @Override
    public void setErrorNetTipViewId(@IdRes int errorNetTipViewId) {
        mPageStateCreater.setErrorNetTipViewId(errorNetTipViewId);
    }

    @Override
    public void setErrorClickShowLoading(boolean show) {
        mPageStateCreater.setErrorClickShowLoading(show);
    }

    @Override
    public void setRootView(View rootView) {
        mPageStateCreater.setRootView(rootView);
    }

    @Override
    public void setContentView(@IdRes int contentId) {
        mPageStateCreater.setContentView(contentId);
    }

    @Override
    public void setContentView(View contentView) {
        mPageStateCreater.setContentView(contentView);
    }

    @Override
    public void setOnErrorListener(OnErrorClickListener listener) {
        mPageStateCreater.setOnErrorListener(listener);
    }

    @Override
    public void setOnErrorNetListener(OnErrorNetClickListener listener) {
        mPageStateCreater.setOnErrorNetListener(listener);
    }

    @Override
    public void setEmptyTip(@StringRes int resId) {
        mPageStateCreater.setEmptyTip(resId);
    }

    @Override
    public void setErrorTip(@StringRes int resId) {
        mPageStateCreater.setEmptyTip(resId);
    }

    @Override
    public void setErrorNetTip(@StringRes int resId) {
        mPageStateCreater.setErrorNetTip(resId);
    }

    @Override
    public void showLoadingView(@StringRes int resId) {
        mPageStateCreater.showLoadingView(resId);
    }

    @Override
    public void showLoadingView() {
        mPageStateCreater.showLoadingView();
    }

    @Override
    public void showContentView() {
        mPageStateCreater.showContentView();
    }

    @Override
    public void showEmptyView() {
        mPageStateCreater.showEmptyView();
    }

    @Override
    public void showErrorView() {
        mPageStateCreater.showErrorView();
    }

    @Override
    public void showErrorNetView() {
        mPageStateCreater.showErrorNetView();
    }

    @Override
    public View getEmptyView() {
        return mPageStateCreater.getEmptyView();
    }

    @Override
    public View getErrorView() {
        return mPageStateCreater.getErrorView();
    }

    @Override
    public View getErrorNetView() {
        return mPageStateCreater.getErrorNetView();
    }

    @Override
    public TextView getLoadingTipView() {
        return mPageStateCreater.getLoadingTipView();
    }

    @Override
    public void setLoadingTip(@StringRes int resId) {
        mPageStateCreater.setLoadingTip(resId);
    }

    @Override
    public TextView getEmptyTipView() {
        return mPageStateCreater.getEmptyTipView();
    }

    @Override
    public void setEmptyTip(String text) {
        mPageStateCreater.setEmptyTip(text);
    }

    @Override
    public TextView getErrorTip() {
        return mPageStateCreater.getErrorTip();
    }

    @Override
    public void setErrorTip(String text) {
        mPageStateCreater.setErrorTip(text);
    }

    @Override
    public TextView getErrorNetTip() {
        return mPageStateCreater.getErrorNetTip();
    }

    @Override
    public void setErrorNetTip(String text) {
        mPageStateCreater.setErrorNetTip(text);
    }

    @Override
    public void create() {
        mPageStateCreater.create();
    }
}
