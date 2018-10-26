package com.mylhyl.pagestate;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.view.View.NO_ID;

/**
 * Created by hupei on 2018/9/27 10:16.
 */
class PageStateLayoutCreater implements PageState {

    private Context mContext;
    private ViewGroup mRootView;
    private View mContentView, mLoadingView, mEmptyView, mErrorView, mErrorNetView;
    private View mLoadingProgressView, mEmptyImgView, mErrorImgView, mErrorNetImgView;
    private View mLoadingMsgView, mEmptyMsgView, mErrorMsgView, mErrorNetMsgView;
    private OnErrorClickListener mOnErrorClickListener;
    private OnErrorNetClickListener mOnErrorNetClickListener;
    private boolean showErrorClickLoading = true;
    private int mLoadingLayout = NO_ID, mEmptyLayout = NO_ID, mErrorLayout = NO_ID, mErrorNetLayout = NO_ID;
    private int mLoadingProgressViewId = NO_ID, mEmptyImgId = NO_ID, mErrorImgId = NO_ID, mErrorNetImgId = NO_ID;
    private int mLoadingMsgViewId = NO_ID, mEmptyMsgViewId = NO_ID, mErrorMsgViewId = NO_ID, mErrorNetMsgViewId = NO_ID;

    @Override
    public PageState setLoadingLayout(@LayoutRes int loadingLayoutId) {
        this.mLoadingLayout = loadingLayoutId;
        return this;
    }

    @Override
    public PageState setEmptyLayout(@LayoutRes int emptyLayoutId) {
        this.mEmptyLayout = emptyLayoutId;
        return this;
    }

    @Override
    public PageState setErrorLayout(@LayoutRes int errorLayoutId) {
        this.mErrorLayout = errorLayoutId;
        return this;
    }

    @Override
    public PageState setErrorNetLayout(@LayoutRes int errorNetLayoutId) {
        this.mErrorNetLayout = errorNetLayoutId;
        return this;
    }

    @Override
    public PageState setLoadingProgressViewId(int loadingProgressViewId) {
        this.mLoadingProgressViewId = loadingProgressViewId;
        return this;
    }

    @Override
    public PageState setLoadingMsgViewId(int loadingMsgViewId) {
        this.mLoadingMsgViewId = loadingMsgViewId;
        return this;
    }

    @Override
    public PageState setEmptyImgId(int emptyImgId) {
        this.mEmptyImgId = emptyImgId;
        return this;
    }

    @Override
    public PageState setEmptyMsgViewId(@IdRes int emptyMsgViewId) {
        this.mEmptyMsgViewId = emptyMsgViewId;
        return this;
    }

    @Override
    public PageState setErrorImgId(int errorImgId) {
        this.mErrorImgId = errorImgId;
        return this;
    }

    @Override
    public PageState setErrorMsgViewId(@IdRes int errorMsgViewId) {
        this.mErrorMsgViewId = errorMsgViewId;
        return this;
    }

    @Override
    public PageState setErrorNetImgId(int errorNetImgId) {
        this.mErrorNetImgId = errorNetImgId;
        return this;
    }

    @Override
    public PageState setErrorNetMsgViewId(@IdRes int errorNetMsgViewId) {
        this.mErrorNetMsgViewId = errorNetMsgViewId;
        return this;
    }

    @Override
    public PageState setErrorClickShowLoading(boolean show) {
        this.showErrorClickLoading = show;
        return this;
    }

    @Override
    public PageState setRootView(View rootView) {
        this.mRootView = (ViewGroup) rootView;
        this.mContext = rootView.getContext();
        return this;
    }

    @Override
    public PageState setContentView(@IdRes int contentId) {
        setContentView(mRootView.findViewById(contentId));
        return this;
    }

    @Override
    public PageState setContentView(View contentView) {
        this.mContentView = contentView;
        if (this.mContentView != null) {
            this.mContentView.setVisibility(View.GONE);
        }
        return this;
    }

    @Override
    public PageState setOnErrorListener(OnErrorClickListener listener) {
        this.mOnErrorClickListener = listener;
        return this;
    }

    @Override
    public PageState setOnErrorNetListener(OnErrorNetClickListener listener) {
        this.mOnErrorNetClickListener = listener;
        return this;
    }

    @Override
    public void showLoadingView() {
        goneAllView();
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showContentView() {
        goneAllView();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showEmptyView() {
        goneAllView();
        if (this.mEmptyView != null) {
            this.mEmptyView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showErrorView() {
        goneAllView();
        if (mErrorView != null) mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorNetView() {
        goneAllView();
        if (this.mErrorNetView != null) {
            this.mErrorNetView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public View getEmptyView() {
        return this.mEmptyView;
    }

    @Override
    public View getErrorView() {
        return this.mErrorView;
    }

    @Override
    public View getErrorNetView() {
        return this.mErrorNetView;
    }

    @Override
    public View getLoadingMsgView() {
        return this.mLoadingMsgView;
    }

    @Override
    public View getEmptyMsgView() {
        return this.mEmptyMsgView;
    }

    @Override
    public View getErrorMsgView() {
        return this.mErrorMsgView;
    }

    @Override
    public View getErrorNetMsgView() {
        return this.mErrorNetMsgView;
    }

    @Override
    public View getLoadingProgressView() {
        return this.mLoadingProgressView;
    }

    @Override
    public View getEmptyImgView() {
        return this.mEmptyImgView;
    }

    @Override
    public View getErrorImgView() {
        return this.mErrorImgView;
    }

    @Override
    public View getErrorNetImgView() {
        return this.mErrorNetImgView;
    }

    private void goneAllView() {
        if (mLoadingView != null) mLoadingView.setVisibility(View.GONE);
        if (mContentView != null) mContentView.setVisibility(View.GONE);
        if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
        if (mErrorView != null) mErrorView.setVisibility(View.GONE);
        if (mErrorNetView != null) mErrorNetView.setVisibility(View.GONE);
    }

    void create() {
        checkParams();
        this.mLoadingView = inflate(mLoadingLayout);
        this.mEmptyView = inflate(mEmptyLayout);
        this.mErrorView = inflate(mErrorLayout);
        this.mErrorNetView = inflate(mErrorNetLayout);

        final ViewGroup.LayoutParams LayoutParams = new ViewGroup.LayoutParams(ViewGroup
                .LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.mRootView.addView(mLoadingView, LayoutParams);
        this.mRootView.addView(mEmptyView, LayoutParams);
        this.mRootView.addView(mErrorView, LayoutParams);
        this.mRootView.addView(mErrorNetView, LayoutParams);

        if (this.mLoadingProgressViewId != NO_ID) {
            this.mLoadingProgressView = mLoadingView.findViewById(mLoadingProgressViewId);
        }
        if (this.mLoadingMsgViewId != NO_ID) {
            this.mLoadingMsgView = mLoadingView.findViewById(mLoadingMsgViewId);
        }

        if (this.mEmptyImgId != NO_ID) {
            this.mEmptyImgView = mEmptyView.findViewById(mEmptyImgId);
        }
        if (this.mEmptyMsgViewId != NO_ID) {
            this.mEmptyMsgView = mEmptyView.findViewById(mEmptyMsgViewId);
        }

        if (this.mOnErrorClickListener != null) {
            this.mErrorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (showErrorClickLoading) {
                        showLoadingView();
                    } else {
                        goneAllView();
                    }
                    mOnErrorClickListener.onErrorClick();
                }
            });
        }
        if (this.mErrorImgId != NO_ID) {
            this.mErrorImgView = mErrorView.findViewById(mErrorImgId);
        }
        if (this.mErrorMsgViewId != NO_ID) {
            this.mErrorMsgView = mErrorView.findViewById(mErrorMsgViewId);
        }

        if (this.mOnErrorNetClickListener != null) {
            this.mErrorNetView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (showErrorClickLoading) {
                        showLoadingView();
                    } else {
                        goneAllView();
                    }
                    mOnErrorNetClickListener.onErrorNetClick();
                }
            });
        }
        if (this.mErrorNetImgId != NO_ID) {
            this.mErrorNetImgView = mErrorNetView.findViewById(mErrorNetImgId);
        }
        if (this.mErrorNetMsgViewId != NO_ID) {
            this.mErrorNetMsgView = mErrorNetView.findViewById(mErrorNetMsgViewId);
        }
        goneAllView();
    }

    private void checkParams() {
        if (this.mRootView == null) {
            throw new NullPointerException("mRootView cannot be null. Please use use setRootView");
        }
        if (this.mLoadingLayout == NO_ID) {
            throw new IllegalArgumentException("mLoadingLayout cannot be null. Please use use " +
                    "psl_loadingLayout or extends PageStateDelegate#getLoadingLayout");
        }
        if (this.mEmptyLayout == NO_ID) {
            throw new IllegalArgumentException("mEmptyLayout cannot be null. Please use use " +
                    "psl_loadingLayout or extends PageStateDelegate#getEmptyLayout");
        }
        if (this.mErrorLayout == NO_ID) {
            throw new IllegalArgumentException("mErrorLayout cannot be null. Please use use " +
                    "psl_loadingLayout or extends PageStateDelegate#getErrorLayout");
        }
        if (this.mErrorNetLayout == NO_ID) {
            throw new IllegalArgumentException("mErrorNetLayout cannot be null. Please use use " +
                    "psl_loadingLayout or extends PageStateDelegate#getErrorNetLayout");
        }
    }

    private View inflate(int layoutId) {
        return LayoutInflater.from(this.mContext).inflate(layoutId, this.mRootView, false);
    }
}
