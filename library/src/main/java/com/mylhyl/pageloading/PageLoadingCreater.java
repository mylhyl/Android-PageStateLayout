package com.mylhyl.pageloading;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hupei on 2018/9/27 10:16.
 */
public class PageLoadingCreater implements PageLoading {

    private static PageLoadingDelegate mPageLoadingDelegate = new DefaultPageLoadingDelegate();
    private Context mContext;
    private ViewGroup mRootView;
    private View mContentView, mProgressView, mEmptyView, mErrorView, mErrorNetView;
    private TextView mProgressTipView, mEmptyTipView, mErrorTipView, mErrorNetTipView;
    private OnErrorClickListener mOnErrorClickListener;
    private OnErrorNetClickListener mOnErrorNetClickListener;
    private ViewGroup.LayoutParams mLayoutParams = new ViewGroup.LayoutParams(ViewGroup
            .LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private boolean showErrorClickLoading = true;
    private int mProgressLayout = View.NO_ID, mEmptyLayout = View.NO_ID, mErrorLayout = View.NO_ID, mErrorNetLayout = View.NO_ID;
    private int mProgressTipViewId = View.NO_ID, mEmptyTipViewId = View.NO_ID, mErrorTipViewId = View.NO_ID, mErrorNetTipViewId = View.NO_ID;

    public PageLoadingCreater() {
        setProgressLayout(mPageLoadingDelegate.getProgressLayout());
        setEmptyLayout(mPageLoadingDelegate.getEmptyLayout());
        setErrorLayout(mPageLoadingDelegate.getErrorLayout());
        setErrorNetLayout(mPageLoadingDelegate.getErrorNetLayout());

        setProgressTipViewId(mPageLoadingDelegate.getProgressTipViewId());
        setEmptyTipViewId(mPageLoadingDelegate.getEmptyTipViewId());
        setErrorTipViewId(mPageLoadingDelegate.getErrorTipViewId());
        setErrorNetTipViewId(mPageLoadingDelegate.getErrorNetTipViewId());
    }

    @Override
    public void setProgressLayout(@LayoutRes int progressLayoutId) {
        this.mProgressLayout = progressLayoutId;
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
    public void setProgressTipViewId(@IdRes int progressTipViewId) {
        this.mProgressTipViewId = progressTipViewId;
    }

    @Override
    public void setEmptyTipViewId(@IdRes int emptyTipViewId) {
        this.mEmptyTipViewId = emptyTipViewId;
    }

    @Override
    public void setErrorTipViewId(@IdRes int errorTipViewId) {
        this.mErrorTipViewId = errorTipViewId;
    }

    @Override
    public void setErrorNetTipViewId(@IdRes int errorNetTipViewId) {
        this.mErrorNetTipViewId = errorNetTipViewId;
    }

    @Override
    public void setErrorClickShowProgress(boolean show) {
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
    public void setEmptyTip(@StringRes int resId) {
        if (mEmptyTipView != null) {
            mEmptyTipView.setText(resId);
        }
    }

    @Override
    public void setErrorTip(@StringRes int resId) {
        if (mErrorTipView != null) {
            mErrorTipView.setText(resId);
        }
    }

    @Override
    public void setErrorNetTip(@StringRes int resId) {
        if (mErrorNetTipView != null) {
            mErrorNetTipView.setText(resId);
        }
    }

    @Override
    public void showProgressView(@StringRes int resId) {
        showProgressView();
        setProgressTip(resId);
    }

    @Override
    public void showProgressView() {
        //显示错误页面，其他页面隐藏
        goneAllView();
        if (mProgressView != null) mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContentView() {
        //显示数据页面，其他页面隐藏
        goneAllView();
        if (mContentView != null) mContentView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyView() {
        //显示List空页面，其他页面隐藏
        goneAllView();
        if (mEmptyView != null) mEmptyView.setVisibility(View.VISIBLE);
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
        if (mErrorNetView != null) mErrorNetView.setVisibility(View.VISIBLE);
    }

    @Override
    public View getEmptyView() {
        return mEmptyView;
    }

    @Override
    public View getErrorView() {
        return mErrorView;
    }

    @Override
    public View getErrorNetView() {
        return mErrorNetView;
    }

    @Override
    public TextView getProgressTipView() {
        return mProgressTipView;
    }

    @Override
    public void setProgressTip(@StringRes int resId) {
        if (mProgressTipView != null) {
            mProgressTipView.setText(resId);
        }
    }

    @Override
    public TextView getEmptyTipView() {
        return mEmptyTipView;
    }

    @Override
    public void setEmptyTip(String text) {
        if (mEmptyTipView != null) {
            mEmptyTipView.setText(text);
        }
    }

    @Override
    public TextView getErrorTip() {
        return mErrorTipView;
    }

    @Override
    public void setErrorTip(String text) {
        if (mErrorTipView != null) {
            mErrorTipView.setText(text);
        }
    }

    @Override
    public TextView getErrorNetTip() {
        return mErrorNetTipView;
    }

    @Override
    public void setErrorNetTip(String text) {
        if (mErrorNetTipView != null) {
            mErrorNetTipView.setText(text);
        }
    }

    @Override
    public void create() {

        mProgressView = inflate(mProgressLayout);
        mEmptyView = inflate(mEmptyLayout);
        mErrorView = inflate(mErrorLayout);
        mErrorNetView = inflate(mErrorNetLayout);

        if (mProgressView != null) {
            mRootView.addView(mProgressView, mLayoutParams);
            mProgressTipView = (TextView) mProgressView.findViewById(mProgressTipViewId);
        }

        if (mEmptyView != null) {
            mRootView.addView(mEmptyView, mLayoutParams);
            mEmptyTipView = (TextView) mEmptyView.findViewById(mEmptyTipViewId);
        }

        if (mErrorView != null) {
            mRootView.addView(mErrorView, mLayoutParams);
            mErrorTipView = (TextView) mErrorView.findViewById(mErrorTipViewId);
            mErrorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnErrorClickListener != null) {
                        //点击时显示加载视图
                        if (showErrorClickLoading)
                            showProgressView();
                        else
                            goneAllView();
                        mOnErrorClickListener.onErrorClick();
                    }
                }
            });
        }

        if (mErrorNetView != null) {
            mRootView.addView(mErrorNetView, mLayoutParams);
            mErrorNetTipView = (TextView) mErrorNetView.findViewById(mErrorNetTipViewId);
            mErrorNetView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnErrorNetClickListener != null) {
                        if (showErrorClickLoading)
                            showProgressView();
                        else
                            goneAllView();
                        mOnErrorNetClickListener.onErrorNetClick();
                    }
                }
            });
        }
        goneAllView();
    }

    protected View inflate(int layoutId) {
        return LayoutInflater.from(mContext).inflate(layoutId, mRootView, false);
    }

    private void goneAllView() {
        if (mProgressView != null) mProgressView.setVisibility(View.GONE);
        if (mContentView != null) mContentView.setVisibility(View.GONE);
        if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
        if (mErrorView != null) mErrorView.setVisibility(View.GONE);
        if (mErrorNetView != null) mErrorNetView.setVisibility(View.GONE);
    }

    public static void setLoadingDelegate(PageLoadingDelegate pageLoadingDelegate) {
        mPageLoadingDelegate = pageLoadingDelegate;
    }
}
