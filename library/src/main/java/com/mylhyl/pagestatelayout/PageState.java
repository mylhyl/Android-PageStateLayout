package com.mylhyl.pagestatelayout;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by hupei on 2018/9/27 10:13.
 */
public interface PageState {

    /**
     * 加载视图的布局 id
     *
     * @param loadingLayoutId
     * @return PageState
     */
    PageState setLoadingLayout(@LayoutRes int loadingLayoutId);

    /**
     * 空视图的布局 id
     *
     * @param emptyLayoutId
     * @return PageState
     */
    PageState setEmptyLayout(@LayoutRes int emptyLayoutId);

    /**
     * 错误视图的布局 id
     *
     * @param errorLayoutId
     * @return PageState
     */
    PageState setErrorLayout(@LayoutRes int errorLayoutId);

    /**
     * 网络视图的布局 id
     *
     * @param errorNetLayoutId
     * @return PageState
     */
    PageState setErrorNetLayout(@LayoutRes int errorNetLayoutId);

    /**
     * 加载视图进度ProgressBar的id
     *
     * @param loadingProgressViewId
     * @return PageState
     */
    PageState setLoadingProgressViewId(@IdRes int loadingProgressViewId);

    /**
     * 加载视图文字描述TextView的id
     *
     * @param loadingMsgViewId
     * @return PageState
     */
    PageState setLoadingMsgViewId(@IdRes int loadingMsgViewId);

    /**
     * 设置空数据视图ImageView的id
     *
     * @param emptyImgId
     * @return PageState
     */
    PageState setEmptyImgId(@IdRes int emptyImgId);

    /**
     * 设置空数据视图文字描述TextView的id
     *
     * @param emptyMsgViewId
     * @return PageState
     */
    PageState setEmptyMsgViewId(@IdRes int emptyMsgViewId);

    /**
     * 错误视图ImageView的id
     *
     * @param errorImgId
     * @return PageState
     */
    PageState setErrorImgId(@IdRes int errorImgId);

    /**
     * 错误视图文字描述TextView的id
     *
     * @param errorMsgViewId
     * @return PageState
     */
    PageState setErrorMsgViewId(@IdRes int errorMsgViewId);

    /**
     * 网络错误视图ImageView的id
     *
     * @param errorNetImgId
     * @return PageState
     */
    PageState setErrorNetImgId(@IdRes int errorNetImgId);

    /**
     * 网络错误视图文字描述TextView的id
     *
     * @param errorNetMsgViewId
     * @return PageState
     */
    PageState setErrorNetMsgViewId(@IdRes int errorNetMsgViewId);

    /**
     * 点击错误视图时是否显示加载视图
     *
     * @param show
     * @return PageState
     */
    PageState setErrorClickShowLoading(boolean show);

    /**
     * 设置根视图
     *
     * @param rootView
     * @return PageState
     */
    PageState setRootView(View rootView);

    /**
     * 内容视图的id
     *
     * @param contentId
     * @return PageState
     */
    PageState setContentView(@IdRes int contentId);

    /**
     * 设置内容视图
     *
     * @param contentView
     * @return PageState
     */
    PageState setContentView(View contentView);

    /**
     * 设置错误视图点击事件
     *
     * @param listener
     * @return PageState
     */
    PageState setOnErrorListener(OnErrorClickListener listener);

    /**
     * 设置网络错误视图点击事件
     *
     * @param listener
     * @return PageState
     */
    PageState setOnErrorNetListener(OnErrorNetClickListener listener);

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

    /**
     * 获取加载视图进度控件
     *
     * @param <T> View
     * @return View
     */
    <T extends View> T getLoadingProgressView();

    /**
     * 获取空视图图片控件
     *
     * @param <T> View
     * @return View
     */
    <T extends View> T getEmptyImgView();

    /**
     * 获取错误视图图片控件
     *
     * @param <T> View
     * @return View
     */
    <T extends View> T getErrorImgView();

    /**
     * 获取网络错误视图图片控件
     *
     * @param <T> View
     * @return View
     */
    <T extends View> T getErrorNetImgView();

}
