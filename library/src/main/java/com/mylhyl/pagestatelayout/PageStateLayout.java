package com.mylhyl.pagestatelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

        int loadingMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_loadingMsgViewId, NO_ID);
        int emptyMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyMsgViewId, NO_ID);
        int errorMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorMsgViewId, NO_ID);
        int errorNetMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetMsgViewId, NO_ID);

        CharSequence loadingMsg = ta.getText(R.styleable.PageStateLayout_psl_loadingMsg);
        CharSequence emptyMsg = ta.getText(R.styleable.PageStateLayout_psl_emptyMsg);
        CharSequence errorMsg = ta.getText(R.styleable.PageStateLayout_psl_errorMsg);
        CharSequence errorNetMsg = ta.getText(R.styleable.PageStateLayout_psl_errorNetMsg);

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
            if (loadingMsgViewId != NO_ID) {
                setLoadingMsgViewId(loadingMsgViewId);
            }
            if (emptyImgId != NO_ID) {
                setEmptyImgId(emptyImgId);
            }
            if (emptyMsgViewId != NO_ID) {
                setEmptyMsgViewId(emptyMsgViewId);
            }
            if (errorImgId != NO_ID) {
                setErrorImgId(errorImgId);
            }
            if (errorMsgViewId != NO_ID) {
                setErrorMsgViewId(errorMsgViewId);
            }
            if (errorNetImgId != NO_ID) {
                setErrorNetImgId(errorNetImgId);
            }
            if (errorNetMsgViewId != NO_ID) {
                setErrorNetMsgViewId(errorNetMsgViewId);
            }
            create();

            if (emptyImgDrawable != null && getEmptyImgView() != null
                    && getEmptyImgView() instanceof ImageView) {
                getEmptyImgView().setVisibility(VISIBLE);
                ((ImageView) getEmptyImgView()).setImageDrawable(emptyImgDrawable);
            }
            if (errorImgDrawable != null && getErrorImgView() != null
                    && getErrorImgView() instanceof ImageView) {
                getErrorImgView().setVisibility(VISIBLE);
                ((ImageView) getErrorImgView()).setImageDrawable(errorImgDrawable);
            }
            if (errorNetImgDrawable != null && getErrorNetImgView() != null
                    && getErrorNetImgView() instanceof ImageView) {
                getErrorNetImgView().setVisibility(VISIBLE);
                ((ImageView) getErrorNetImgView()).setImageDrawable(errorNetImgDrawable);
            }

            if (!TextUtils.isEmpty(loadingMsg) && getLoadingMsgView() != null
                    && getLoadingMsgView() instanceof TextView) {
                ((TextView) getLoadingMsgView()).setText(loadingMsg);
            }
            if (!TextUtils.isEmpty(emptyMsg) && getEmptyMsgView() != null
                    && getEmptyMsgView() instanceof TextView) {
                ((TextView) getEmptyMsgView()).setText(emptyMsg);
            }
            if (!TextUtils.isEmpty(errorMsg) && getErrorMsgView() != null
                    && getErrorMsgView() instanceof TextView) {
                ((TextView) getErrorMsgView()).setText(errorMsg);
            }
            if (!TextUtils.isEmpty(errorNetMsg) && getErrorNetMsgView() != null
                    && getErrorNetMsgView() instanceof TextView) {
                ((TextView) getErrorNetMsgView()).setText(errorNetMsg);
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
    public void setLoadingMsgViewId(@IdRes int loadingMsgViewId) {
        mPageStateCreater.setLoadingMsgViewId(loadingMsgViewId);
    }

    @Override
    public void setEmptyImgId(int emptyImgId) {
        mPageStateCreater.setEmptyImgId(emptyImgId);
    }

    @Override
    public void setEmptyMsgViewId(@IdRes int emptyMsgViewId) {
        mPageStateCreater.setEmptyMsgViewId(emptyMsgViewId);
    }

    @Override
    public void setErrorImgId(int errorImgId) {
        mPageStateCreater.setErrorImgId(errorImgId);
    }

    @Override
    public void setErrorMsgViewId(@IdRes int errorMsgViewId) {
        mPageStateCreater.setErrorMsgViewId(errorMsgViewId);
    }

    @Override
    public void setErrorNetImgId(int errorNetImgId) {
        mPageStateCreater.setErrorNetImgId(errorNetImgId);
    }

    @Override
    public void setErrorNetMsgViewId(@IdRes int errorNetMsgViewId) {
        mPageStateCreater.setErrorNetMsgViewId(errorNetMsgViewId);
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
    public View getLoadingMsgView() {
        return mPageStateCreater.getLoadingMsgView();
    }

    @Override
    public View getEmptyMsgView() {
        return mPageStateCreater.getEmptyMsgView();
    }

    @Override
    public View getErrorMsgView() {
        return mPageStateCreater.getErrorMsgView();
    }

    @Override
    public View getErrorNetMsgView() {
        return mPageStateCreater.getErrorNetMsgView();
    }

    @Override
    public View getEmptyImgView() {
        return mPageStateCreater.getEmptyImgView();
    }

    @Override
    public View getErrorImgView() {
        return mPageStateCreater.getErrorImgView();
    }

    @Override
    public View getErrorNetImgView() {
        return mPageStateCreater.getErrorNetImgView();
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
