package com.mylhyl.pagestatelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by hupei on 2018/9/27 13:49.
 */
public class PageStateLayout extends FrameLayout implements PageState {

    private int mContentLayoutId = NO_ID;

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

        CharSequence loadingTip = ta.getText(R.styleable.PageStateLayout_psl_loadingTip);
        CharSequence emptyTip = ta.getText(R.styleable.PageStateLayout_psl_emptyTip);
        CharSequence errorTip = ta.getText(R.styleable.PageStateLayout_psl_errorTip);
        CharSequence errorNetTip = ta.getText(R.styleable.PageStateLayout_psl_errorNetTip);

        mContentLayoutId = ta.getResourceId(R.styleable.PageStateLayout_psl_contentLayoutId, NO_ID);

        if (!isInEditMode()) {
            setRootView(this);
            if (loadingLayout != NO_ID) {
                setLoadingLayout(loadingLayout);
            }
            if (emptyLayout != NO_ID) {
                setEmptyLayout(emptyLayout);
            }
            if (errorLayout != NO_ID) {
                setErrorLayout(errorLayout);
            }
            if (errorNetLayout != NO_ID) {
                setErrorNetLayout(errorNetLayout);
            }
            if (loadingTipViewId != NO_ID) {
                setLoadingTipViewId(loadingTipViewId);
            }
            if (emptyImgId != NO_ID) {
                setEmptyImgId(emptyImgId);
            }
            if (emptyTipViewId != NO_ID) {
                setEmptyTipViewId(emptyTipViewId);
            }
            if (errorImgId != NO_ID) {
                setErrorImgId(errorImgId);
            }
            if (errorTipViewId != NO_ID) {
                setErrorTipViewId(errorTipViewId);
            }
            if (errorNetImgId != NO_ID) {
                setErrorNetImgId(errorNetImgId);
            }
            if (errorNetTipViewId != NO_ID) {
                setErrorNetTipViewId(errorNetTipViewId);
            }
            create();

            if (emptyImgDrawable != null) {
                setEmptyImgDrawable(emptyImgDrawable);
            }
            if (errorImgDrawable != null) {
                setErrorImgDrawable(errorImgDrawable);
            }
            if (errorNetImgDrawable != null) {
                setErrorNetImgDrawable(errorNetImgDrawable);
            }

            if (!TextUtils.isEmpty(loadingTip)) {
                setLoadingTip(loadingTip);
            }

            if (!TextUtils.isEmpty(loadingTip)) {
                setLoadingTip(loadingTip);
            }
            if (!TextUtils.isEmpty(emptyTip)) {
                setEmptyTip(emptyTip);
            }
            if (!TextUtils.isEmpty(errorTip)) {
                setErrorTip(errorTip);
            }
            if (!TextUtils.isEmpty(errorNetTip)) {
                setErrorNetTip(errorNetTip);
            }
        }
        ta.recycle();
    }

    @Override
    public void setLoadingLayout(@LayoutRes int loadingLayoutId) {
        mPageStateCreater.setLoadingLayout(loadingLayoutId);
    }

    @Override
    public void setEmptyLayout(@LayoutRes int emptyLayoutId) {
        mPageStateCreater.setEmptyLayout(emptyLayoutId);
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
    public void setLoadingTip(CharSequence text) {
        mPageStateCreater.setLoadingTip(text);
    }

    @Override
    public TextView getEmptyTipView() {
        return mPageStateCreater.getEmptyTipView();
    }

    @Override
    public void setEmptyTip(CharSequence text) {
        mPageStateCreater.setEmptyTip(text);
    }

    @Override
    public TextView getErrorTip() {
        return mPageStateCreater.getErrorTip();
    }

    @Override
    public void setErrorTip(CharSequence text) {
        mPageStateCreater.setErrorTip(text);
    }

    @Override
    public TextView getErrorNetTip() {
        return mPageStateCreater.getErrorNetTip();
    }

    @Override
    public void setErrorNetTip(CharSequence text) {
        mPageStateCreater.setErrorNetTip(text);
    }

    @Override
    public void create() {
        mPageStateCreater.create();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (mContentLayoutId == NO_ID) {
            if (getChildCount() > 5) {
                throw new IllegalStateException("PageStateLayout can host only one direct child");
            }
            View view = getChildAt(4);
            setContentView(view);
        } else {
            View contentLayout = findViewById(mContentLayoutId);
            setContentView(contentLayout);
        }
    }
}
