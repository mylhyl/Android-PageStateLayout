package com.mylhyl.pageloading;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hupei on 2018/9/27 10:13.
 */
public interface PageLoading {

    void setProgressLayout(@LayoutRes int progressLayoutId);

    void setEmptyLayout(@LayoutRes int emptyLayoutId);

    void setErrorLayout(@LayoutRes int errorLayoutId);

    void setErrorNetLayout(@LayoutRes int errorNetLayoutId);

    void setProgressTipViewId(@IdRes int progressTipViewId);

    void setEmptyTipViewId(@IdRes int emptyTipViewId);

    void setErrorTipViewId(@IdRes int errorTipViewId);

    void setErrorNetTipViewId(@IdRes int errorNetTipViewId);

    /**
     * 点击错误视图时是否显示加载视图
     *
     * @param show
     */
    void setErrorClickShowProgress(boolean show);

    /**
     * 设置根视图
     *
     * @param rootView
     */
    void setRootView(View rootView);

    void setContentView(@IdRes int contentId);

    /**
     * 设置内容视图
     *
     * @param contentView
     */
    void setContentView(View contentView);

    /**
     * 设置错误视图点击事件
     *
     * @param listener
     */
    void setOnErrorListener(OnErrorClickListener listener);

    /**
     * 设置网络错误视图点击事件
     *
     * @param listener
     */
    void setOnErrorNetListener(OnErrorNetClickListener listener);

    /**
     * 设置空数据视图的文字描述
     *
     * @param resId
     */
    void setEmptyTip(@StringRes int resId);

    /**
     * 设置错误视图的文字描述
     *
     * @param resId
     */
    void setErrorTip(@StringRes int resId);

    /**
     * 设置错误视图的文字描述
     *
     * @param resId
     */
    void setErrorNetTip(@StringRes int resId);

    /**
     * 显示加载数据视图
     *
     * @param resId 视图文字描述id
     */
    void showProgressView(@StringRes int resId);

    /**
     * 显示加载数据视图
     */
    void showProgressView();

    /**
     * 显示数据视图
     */
    void showContentView();

    /**
     * 显示空数据视图
     */
    void showEmptyView();

    /**
     * 显示错误视图
     */
    void showErrorView();

    /**
     * 显示网络错误视图
     */
    void showErrorNetView();

    /**
     * 获取空数据视图
     *
     * @return
     */
    View getEmptyView();

    /**
     * 获取错误视图
     *
     * @return
     */
    View getErrorView();

    /**
     * 获取网络错误视图
     *
     * @return
     */
    View getErrorNetView();

    /**
     * 获取加载数据文字描述控件
     *
     * @return
     */
    TextView getProgressTipView();

    /**
     * 设置加载数据视图的文字描述
     *
     * @param resId
     */
    void setProgressTip(@StringRes int resId);

    /**
     * 获取空数据文字描述控件
     *
     * @return
     */
    TextView getEmptyTipView();

    void setEmptyTip(String text);

    /**
     * 获取错误提示文字描述控件
     *
     * @return
     */
    TextView getErrorTip();

    /**
     * 设置错误视图的文字描述
     *
     * @param text
     */
    void setErrorTip(String text);

    /**
     * 获取网络错误提示文字描述控件
     *
     * @return
     */
    TextView getErrorNetTip();

    /**
     * 设置错误视图的文字描述
     *
     * @param text
     */
    void setErrorNetTip(String text);

    /**
     * 创建
     */
    void create();
}
