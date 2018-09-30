package com.mylhyl.pagestatelayout;

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
    public void setLoadingLayout(@LayoutRes int loadingLayoutId) {
        this.mLoadingLayout = loadingLayoutId;
    }

    @Override
    public void setEmptyLayout(@LayoutRes int emptyLayoutId) {
        this.mEmptyLayout = emptyLayoutId;
    }

    @Override
    public void setErrorLayout(@LayoutRes int errorLayoutId) {
        this.mErrorLayout = errorLayoutId;
    }

    @Override
    public void setErrorNetLayout(@LayoutRes int errorNetLayoutId) {
        this.mErrorNetLayout = errorNetLayoutId;
    }

    @Override
    public void setLoadingProgressViewId(int loadingProgressViewId) {
        this.mLoadingProgressViewId = loadingProgressViewId;
    }

    @Override
    public void setLoadingMsgViewId(int loadingMsgViewId) {
        this.mLoadingMsgViewId = loadingMsgViewId;
    }

    @Override
    public void setEmptyImgId(int emptyImgId) {
        this.mEmptyImgId = emptyImgId;
    }

    @Override
    public void setEmptyMsgViewId(@IdRes int emptyMsgViewId) {
        this.mEmptyMsgViewId = emptyMsgViewId;
    }

    @Override
    public void setErrorImgId(int errorImgId) {
        this.mErrorImgId = errorImgId;
    }

    @Override
    public void setErrorMsgViewId(@IdRes int errorMsgViewId) {
        this.mErrorMsgViewId = errorMsgViewId;
    }

    @Override
    public void setErrorNetImgId(int errorNetImgId) {
        this.mErrorNetImgId = errorNetImgId;
    }

    @Override
    public void setErrorNetMsgViewId(@IdRes int errorNetMsgViewId) {
        this.mErrorNetMsgViewId = errorNetMsgViewId;
    }

    @Override
    public void setErrorClickShowLoading(boolean show) {
        this.showErrorClickLoading = show;
    }

    @Override
    public void setRootView(View rootView) {
        this.mRootView = (ViewGroup) rootView;
        this.mContext = rootView.getContext();
    }

    @Override
    public void setContentView(@IdRes int contentId) {
        setContentView(mRootView.findViewById(contentId));
    }

    @Override
    public void setContentView(View contentView) {
        this.mContentView = contentView;
        if (this.mContentView != null)
            this.mContentView.setVisibility(View.GONE);
    }

    @Override
    public void setOnErrorListener(OnErrorClickListener listener) {
        this.mOnErrorClickListener = listener;
    }

    @Override
    public void setOnErrorNetListener(OnErrorNetClickListener listener) {
        this.mOnErrorNetClickListener = listener;
    }

    @Override
    public void showLoadingView() {
        //显示错误页面，其他页面隐藏
        goneAllView();
        if (this.mLoadingView != null) {
            this.mLoadingView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showContentView() {
        //显示数据页面，其他页面隐藏
        goneAllView();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showEmptyView() {
        //显示List空页面，其他页面隐藏
        goneAllView();
        if (this.mEmptyView != null) {
            this.mEmptyView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showErrorView() {
        //显示错误页面，其他页面隐藏
        goneAllView();
        if (mErrorView != null) mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorNetView() {
        //显示错误页面，其他页面隐藏
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

    @Override
    public void create() {
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

        //加载视图
        if (this.mLoadingProgressViewId != NO_ID) {
            this.mLoadingProgressView = mLoadingView.findViewById(mLoadingProgressViewId);
        }
        if (this.mLoadingMsgViewId != NO_ID) {
            this.mLoadingMsgView = mLoadingView.findViewById(mLoadingMsgViewId);
        }

        //空视图
        if (this.mEmptyImgId != NO_ID) {
            this.mEmptyImgView = mEmptyView.findViewById(mEmptyImgId);
        }
        if (this.mEmptyMsgViewId != NO_ID) {
            this.mEmptyMsgView = mEmptyView.findViewById(mEmptyMsgViewId);
        }

        //加载失败视图
        if (this.mOnErrorClickListener != null) {
            this.mErrorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击时显示加载视图
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

        //网络异常视图
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

    private void goneAllView() {
        if (mLoadingView != null) mLoadingView.setVisibility(View.GONE);
        if (mContentView != null) mContentView.setVisibility(View.GONE);
        if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
        if (mErrorView != null) mErrorView.setVisibility(View.GONE);
        if (mErrorNetView != null) mErrorNetView.setVisibility(View.GONE);
    }
}
