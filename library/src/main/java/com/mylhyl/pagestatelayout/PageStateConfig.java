package com.mylhyl.pagestatelayout;

import android.view.View;

/**
 * Created by hupei on 2018/9/27 10:17.
 */
public abstract class PageStateConfig {

    /**
     * 获取加载数据视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getLoadingLayout();

    /**
     * 获取空数据视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getEmptyLayout();

    /**
     * 获取错误视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getErrorLayout();

    /**
     * 获取网络错误视图控件ID，子类实现
     *
     * @return
     */
    protected abstract int getErrorNetLayout();

    /**
     * 获取加载数据视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected int getLoadingMsgViewId() {
        return View.NO_ID;
    }

    protected int getEmptyImgId() {
        return View.NO_ID;
    }

    /**
     * 获取空数据视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected int getEmptyMsgViewId() {
        return View.NO_ID;
    }

    protected int getErrorImgId() {
        return View.NO_ID;
    }

    /**
     * 获取错误视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected int getErrorMsgViewId() {
        return View.NO_ID;
    }

    protected int getErrorNetImgId() {
        return View.NO_ID;
    }

    /**
     * 获取网络错误视图文字描述控件ID，子类实现
     *
     * @return
     */
    protected int getErrorNetMsgViewId() {
        return View.NO_ID;
    }
}
