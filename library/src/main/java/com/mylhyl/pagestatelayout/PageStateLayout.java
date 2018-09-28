package com.mylhyl.pagestatelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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

        int emptyImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyImgId, NO_ID);
        Drawable emptyImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_emptyImgSrc);
        int errorImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorImgId, NO_ID);
        Drawable errorImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_errorImgSrc);
        int errorNetImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetImgId, NO_ID);
        Drawable errorNetImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_errorNetImgSrc);

        int loadingTipViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_loadingTipViewId, NO_ID);
        int emptyTipViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyTipViewId, NO_ID);
        int errorTipViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorTipViewId, NO_ID);
        int errorNetTipViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetTipViewId, NO_ID);
        if (!isInEditMode()) {
            setRootView(this);
            if (loadingLayout != NO_ID) {
                mPageStateCreater.setLoadingLayout(loadingLayout);
            }
            if (emptyLayout != NO_ID) {
                mPageStateCreater.setEmptyLayout(emptyLayout);
            }
            if (errorLayout != NO_ID) {
                mPageStateCreater.setErrorLayout(errorLayout);
            }
            if (errorNetLayout != NO_ID) {
                mPageStateCreater.setErrorNetLayout(errorNetLayout);
            }
            if (loadingTipViewId != NO_ID) {
                mPageStateCreater.setLoadingTipViewId(loadingTipViewId);
            }
            if (emptyImgId != NO_ID) {
                mPageStateCreater.setEmptyImgId(emptyImgId);
            }
            if (emptyTipViewId != NO_ID) {
                mPageStateCreater.setEmptyTipViewId(emptyTipViewId);
            }
            if (errorImgId != NO_ID) {
                mPageStateCreater.setErrorImgId(errorImgId);
            }
            if (errorTipViewId != NO_ID) {
                mPageStateCreater.setErrorTipViewId(errorTipViewId);
            }
            if (errorNetImgId != NO_ID) {
                mPageStateCreater.setErrorNetImgId(errorNetImgId);
            }
            if (errorNetTipViewId != NO_ID) {
                mPageStateCreater.setErrorNetTipViewId(errorNetTipViewId);
            }
            mPageStateCreater.create();

            if (emptyImgDrawable != null) {
                mPageStateCreater.setEmptyImgDrawable(emptyImgDrawable);
            }
            if (errorImgDrawable != null) {
                mPageStateCreater.setErrorImgDrawable(errorImgDrawable);
            }
            if (errorNetImgDrawable != null) {
                mPageStateCreater.setErrorNetImgDrawable(errorNetImgDrawable);
            }
        }
        ta.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 5) {
            throw new IllegalStateException("PageLoadingView can host only one direct child");
        }
        if (!isInEditMode()) {
            View view = getChildAt(4);
            view.setVisibility(GONE);
            setContentView(view);
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
    public void setLoadingTipViewId(@IdRes int loadingTipViewId) {
        mPageStateCreater.setLoadingTipViewId(loadingTipViewId);
    }

    @Override
    public void setEmptyImgId(int emptyImgId) {
        mPageStateCreater.setEmptyImgId(emptyImgId);
    }

    @Override
    public void setEmptyTipViewId(@IdRes int emptyTipViewId) {
        mPageStateCreater.setEmptyTipViewId(emptyTipViewId);
    }

    @Override
    public void setErrorImgId(int errorImgId) {
        mPageStateCreater.setErrorImgId(errorImgId);
    }

    @Override
    public void setErrorTipViewId(@IdRes int errorTipViewId) {
        mPageStateCreater.setErrorTipViewId(errorTipViewId);
    }

    @Override
    public void setErrorNetImgId(int errorNetImgId) {
        mPageStateCreater.setErrorNetImgId(errorNetImgId);
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
    public void setEmptyImgDrawable(Drawable drawable) {
        mPageStateCreater.setEmptyImgDrawable(drawable);
    }

    @Override
    public void setEmptyTip(@StringRes int resId) {
        mPageStateCreater.setEmptyTip(resId);
    }

    @Override
    public void setErrorImgDrawable(Drawable drawable) {
        mPageStateCreater.setErrorImgDrawable(drawable);
    }

    @Override
    public void setErrorTip(@StringRes int resId) {
        mPageStateCreater.setEmptyTip(resId);
    }

    @Override
    public void setErrorNetImgDrawable(Drawable drawable) {
        mPageStateCreater.setErrorNetImgDrawable(drawable);
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
