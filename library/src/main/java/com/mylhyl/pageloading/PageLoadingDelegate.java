package com.mylhyl.pageloading;

/**
 * Created by hupei on 2018/9/27 10:17.
 */
public abstract class PageLoadingDelegate {

    /**
     * 获取加载数据视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getProgressLayoutId();

    /**
     * 获取空数据视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getEmptyLayoutId();

    /**
     * 获取错误视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getErrorLayoutId();

    /**
     * 获取网络错误视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getErrorNetLayoutId();

    /**
     * 获取加载数据视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected abstract int getProgressTipViewId();

    /**
     * 获取空数据视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected abstract int getEmptyTipViewId();

    /**
     * 获取错误视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected abstract int getErrorTipViewId();

    /**
     * 获取网络错误视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected abstract int getErrorNetTipViewId();
}
