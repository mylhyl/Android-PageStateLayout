package com.mylhyl.pagestatelayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.NO_ID;

/**
 * Created by hupei on 2018/9/27 10:16.
 */
public class PageStateLayoutCreater implements PageState {

    private static PageStateConfig mPageStateConfig = new DefaultPageStateConfig();
    private Context mContext;
    private ViewGroup mRootView;
    private View mContentView, mLoadingView, mEmptyView, mErrorView, mErrorNetView;
    private ImageView mEmptyImg, mErrorImg, mErrorNetImg;
    private TextView mLoadingTipView, mEmptyTipView, mErrorTipView, mErrorNetTipView;
    private OnErrorClickListener mOnErrorClickListener;
    private OnErrorNetClickListener mOnErrorNetClickListener;
    private boolean showErrorClickLoading = true;
    private int mLoadingLayout = NO_ID, mEmptyLayout = NO_ID, mErrorLayout = NO_ID, mErrorNetLayout = NO_ID;
    private int mEmptyImgId = NO_ID, mErrorImgId = NO_ID, mErrorNetImgId = NO_ID;
    private int mLoadingTipViewId = NO_ID, mEmptyTipViewId = NO_ID, mErrorTipViewId = NO_ID, mErrorNetTipViewId = NO_ID;

    public PageStateLayoutCreater() {
        setLoadingLayout(mPageStateConfig.getLoadingLayout());
        setEmptyLayout(mPageStateConfig.getEmptyLayout());
        setErrorLayout(mPageStateConfig.getErrorLayout());
        setErrorNetLayout(mPageStateConfig.getErrorNetLayout());

        setEmptyImgId(mPageStateConfig.getEmptyImgId());
        setErrorImgId(mPageStateConfig.getErrorImgId());
        setErrorNetImgId(mPageStateConfig.getErrorNetImgId());

        setLoadingTipViewId(mPageStateConfig.getLoadingTipViewId());
        setEmptyTipViewId(mPageStateConfig.getEmptyTipViewId());
        setErrorTipViewId(mPageStateConfig.getErrorTipViewId());
        setErrorNetTipViewId(mPageStateConfig.getErrorNetTipViewId());
    }

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
    public void setLoadingTipViewId(@IdRes int loadingTipViewId) {
        this.mLoadingTipViewId = loadingTipViewId;
    }

    @Override
    public void setEmptyImgId(int emptyImgId) {
        this.mEmptyImgId = emptyImgId;
    }

    @Override
    public void setEmptyTipViewId(@IdRes int emptyTipViewId) {
        this.mEmptyTipViewId = emptyTipViewId;
    }

    @Override
    public void setErrorImgId(int errorImgId) {
        this.mErrorImgId = errorImgId;
    }

    @Override
    public void setErrorTipViewId(@IdRes int errorTipViewId) {
        this.mErrorTipViewId = errorTipViewId;
    }

    @Override
    public void setErrorNetImgId(int errorNetImgId) {
        this.mErrorNetImgId = errorNetImgId;
    }

    @Override
    public void setErrorNetTipViewId(@IdRes int errorNetTipViewId) {
        this.mErrorNetTipViewId = errorNetTipViewId;
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
    public void setEmptyImgDrawable(Drawable drawable) {
        if (this.mEmptyImg != null) {
            this.mEmptyImg.setImageDrawable(drawable);
            this.mEmptyImg.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setEmptyTip(@StringRes int resId) {
        if (this.mEmptyTipView != null) {
            this.mEmptyTipView.setText(resId);
        }
    }

    @Override
    public void setErrorImgDrawable(Drawable drawable) {
        if (this.mErrorImg != null) {
            this.mErrorImg.setImageDrawable(drawable);
            this.mErrorImg.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setErrorTip(@StringRes int resId) {
        if (this.mErrorTipView != null) {
            this.mErrorTipView.setText(resId);
        }
    }

    @Override
    public void setErrorNetImgDrawable(Drawable drawable) {
        if (this.mErrorNetImg != null) {
            this.mErrorNetImg.setImageDrawable(drawable);
            this.mErrorNetImg.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setErrorNetTip(@StringRes int resId) {
        if (this.mErrorNetTipView != null) {
            this.mErrorNetTipView.setText(resId);
        }
    }

    @Override
    public void showLoadingView(@StringRes int resId) {
        showLoadingView();
        setLoadingTip(resId);
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
    public TextView getLoadingTipView() {
        return this.mLoadingTipView;
    }

    @Override
    public void setLoadingTip(@StringRes int resId) {
        setLoadingTip(mContext.getString(resId));
    }

    @Override
    public void setLoadingTip(CharSequence text) {
        if (this.mLoadingTipView != null) {
            this.mLoadingTipView.setText(text);
        }
    }

    @Override
    public TextView getEmptyTipView() {
        return this.mEmptyTipView;
    }

    @Override
    public void setEmptyTip(CharSequence text) {
        if (this.mEmptyTipView != null) {
            this.mEmptyTipView.setText(text);
        }
    }

    @Override
    public TextView getErrorTip() {
        return this.mErrorTipView;
    }

    @Override
    public void setErrorTip(CharSequence text) {
        if (this.mErrorTipView != null) {
            this.mErrorTipView.setText(text);
        }
    }

    @Override
    public TextView getErrorNetTip() {
        return this.mErrorNetTipView;
    }

    @Override
    public void setErrorNetTip(CharSequence text) {
        if (this.mErrorNetTipView != null) {
            this.mErrorNetTipView.setText(text);
        }
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
        if (this.mLoadingTipViewId != NO_ID) {
            this.mLoadingTipView = mLoadingView.findViewById(mLoadingTipViewId);
        }

        //空视图
        if (this.mEmptyImgId != NO_ID) {
            this.mEmptyImg = mEmptyView.findViewById(mEmptyImgId);
        }
        if (this.mEmptyTipViewId != NO_ID) {
            this.mEmptyTipView = mEmptyView.findViewById(mEmptyTipViewId);
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
            this.mErrorImg = mErrorView.findViewById(mErrorImgId);
        }
        if (this.mErrorTipViewId != NO_ID) {
            this.mErrorTipView = mErrorView.findViewById(mErrorTipViewId);
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
            this.mErrorNetImg = mErrorNetView.findViewById(mErrorNetImgId);
        }
        if (this.mErrorNetTipViewId != NO_ID) {
            this.mErrorNetTipView = mErrorNetView.findViewById(mErrorNetTipViewId);
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

    public static void setPageStateConfig(PageStateConfig pageStateConfig) {
        mPageStateConfig = pageStateConfig;
    }
}
