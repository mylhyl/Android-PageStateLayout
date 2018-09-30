package com.mylhyl.pagestatelayout;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by hupei on 2018/9/27 10:13.
 */
public interface PageState {

    void setLoadingLayout(@LayoutRes int loadingLayoutId);

    void setEmptyLayout(@LayoutRes int emptyLayoutId);

    void setErrorLayout(@LayoutRes int errorLayoutId);

    void setErrorNetLayout(@LayoutRes int errorNetLayoutId);

    void setLoadingProgressViewId(@IdRes int loadingProgressViewId);

    void setLoadingMsgViewId(@IdRes int loadingMsgViewId);

    /**
     * 设置空数据视图ImageView的id
     *
     * @param emptyImgId
     */
    void setEmptyImgId(@IdRes int emptyImgId);

    /**
     * 设置空数据视图TextView的id
     *
     * @param emptyMsgViewId
     */
    void setEmptyMsgViewId(@IdRes int emptyMsgViewId);

    void setErrorImgId(@IdRes int errorImgId);

    void setErrorMsgViewId(@IdRes int errorMsgViewId);

    void setErrorNetImgId(@IdRes int errorNetImgId);

    void setErrorNetMsgViewId(@IdRes int errorNetMsgViewId);

    /**
     * 点击错误视图时是否显示加载视图
     *
     * @param show
     */
    void setErrorClickShowLoading(boolean show);

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
     * 显示加载数据视图
     */
    void showLoadingView();

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
     * @return View
     */
    <T extends View> T getEmptyView();

    /**
     * 获取错误视图
     *
     * @return View
     */
    <T extends View> T getErrorView();

    /**
     * 获取网络错误视图
     *
     * @return View
     */
    <T extends View> T getErrorNetView();

    /**
     * 获取加载数据文字描述控件
     *
     * @return View
     */
    <T extends View> T getLoadingMsgView();

    /**
     * 获取空数据文字描述控件
     *
     * @return View
     */
    <T extends View> T getEmptyMsgView();

    /**
     * 获取错误提示文字描述控件
     *
     * @return View
     */
    <T extends View> T getErrorMsgView();

    /**
     * 获取网络错误提示文字描述控件
     *
     * @return View
     */
    <T extends View> T getErrorNetMsgView();

    <T extends View> T getLoadingProgressView();

    <T extends View> T getEmptyImgView();

    <T extends View> T getErrorImgView();

    <T extends View> T getErrorNetImgView();

    /**
     * 创建
     */
    void create();
}
