package com.mylhyl.pagestate;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hupei on 2018/9/27 13:49.
 */
public class PageStateLayout extends FrameLayout implements PageState {

    private int mContentLayoutId = NO_ID;
    private PageStateLayoutCreator mPageStateCreator = new PageStateLayoutCreator();

    public PageStateLayout(@NonNull Context context) {
        this(context, null);
    }

    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs
            , int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.PageStateLayout);
        int loadingLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_loadingLayout
                , R.layout.library_psl_loading);
        int emptyLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyLayout
                , R.layout.library_psl_empty);
        int errorLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_errorLayout
                , R.layout.library_psl_error);
        int errorNetLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetLayout
                , R.layout.library_psl_error_net);

        int loadingProgressId = ta.getResourceId(R.styleable.PageStateLayout_psl_loadingProgressViewId
                , R.id.library_psl_loadingProgress);
        int emptyImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyImgId
                , R.id.library_psl_emptyImg);
        int errorImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorImgId
                , R.id.library_psl_errorImg);
        int errorNetImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetImgId
                , R.id.library_psl_errorNetImg);

        Drawable emptyImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_emptyImgSrc);
        Drawable errorImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_errorImgSrc);
        Drawable errorNetImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_errorNetImgSrc);

        int loadingMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_loadingMsgViewId
                , R.id.library_psl_loadingMsg);
        int emptyMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyMsgViewId
                , R.id.library_psl_emptyMsg);
        int errorMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorMsgViewId
                , R.id.library_psl_errorMsg);
        int errorNetMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetMsgViewId
                , R.id.library_psl_errorNetMsg);

        CharSequence loadingMsg = ta.getText(R.styleable.PageStateLayout_psl_loadingMsg);
        CharSequence emptyMsg = ta.getText(R.styleable.PageStateLayout_psl_emptyMsg);
        CharSequence errorMsg = ta.getText(R.styleable.PageStateLayout_psl_errorMsg);
        CharSequence errorNetMsg = ta.getText(R.styleable.PageStateLayout_psl_errorNetMsg);

        mContentLayoutId = ta.getResourceId(R.styleable.PageStateLayout_psl_contentLayoutId, NO_ID);
        boolean clickShowLoadView = ta.getBoolean(R.styleable.PageStateLayout_psl_clickShowLoadView
                , true);

        if (!isInEditMode()) {
            mPageStateCreator.setRootView(this);

            setLoadingLayout(loadingLayout);
            setEmptyLayout(emptyLayout);
            setErrorLayout(errorLayout);
            setErrorNetLayout(errorNetLayout);

            setLoadingProgressViewId(loadingProgressId);
            setEmptyImgId(emptyImgId);
            setErrorImgId(errorImgId);
            setErrorNetImgId(errorNetImgId);

            setLoadingMsgViewId(loadingMsgViewId);
            setEmptyMsgViewId(emptyMsgViewId);
            setErrorMsgViewId(errorMsgViewId);
            setErrorNetMsgViewId(errorNetMsgViewId);

            mPageStateCreator.create();

            if (emptyImgDrawable != null && getEmptyImgView() != null
                    && getEmptyImgView() instanceof ImageView) {
                ((ImageView) getEmptyImgView()).setImageDrawable(emptyImgDrawable);
            }
            if (errorImgDrawable != null && getErrorImgView() != null
                    && getErrorImgView() instanceof ImageView) {
                ((ImageView) getErrorImgView()).setImageDrawable(errorImgDrawable);
            }
            if (errorNetImgDrawable != null && getErrorNetImgView() != null
                    && getErrorNetImgView() instanceof ImageView) {
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

            setClickShowLoadView(clickShowLoadView);
        }
        ta.recycle();
    }

    @Override
    public PageState setLoadingLayout(@LayoutRes int loadingLayoutId) {
        return mPageStateCreator.setLoadingLayout(loadingLayoutId);
    }

    @Override
    public PageState setEmptyLayout(@LayoutRes int emptyLayoutId) {
        return mPageStateCreator.setEmptyLayout(emptyLayoutId);
    }

    @Override
    public PageState setErrorLayout(@LayoutRes int errorLayoutId) {
        return mPageStateCreator.setErrorLayout(errorLayoutId);
    }

    @Override
    public PageState setErrorNetLayout(@LayoutRes int errorNetLayoutId) {
        return mPageStateCreator.setErrorNetLayout(errorNetLayoutId);
    }

    @Override
    public PageState setLoadingProgressViewId(int loadingProgressViewId) {
        return mPageStateCreator.setLoadingProgressViewId(loadingProgressViewId);
    }

    @Override
    public PageState setLoadingMsgViewId(@IdRes int loadingMsgViewId) {
        return mPageStateCreator.setLoadingMsgViewId(loadingMsgViewId);
    }

    @Override
    public PageState setEmptyImgId(int emptyImgId) {
        return mPageStateCreator.setEmptyImgId(emptyImgId);
    }

    @Override
    public PageState setEmptyMsgViewId(@IdRes int emptyMsgViewId) {
        return mPageStateCreator.setEmptyMsgViewId(emptyMsgViewId);
    }

    @Override
    public PageState setErrorImgId(int errorImgId) {
        return mPageStateCreator.setErrorImgId(errorImgId);
    }

    @Override
    public PageState setErrorMsgViewId(@IdRes int errorMsgViewId) {
        return mPageStateCreator.setErrorMsgViewId(errorMsgViewId);
    }

    @Override
    public PageState setErrorNetImgId(int errorNetImgId) {
        return mPageStateCreator.setErrorNetImgId(errorNetImgId);
    }

    @Override
    public PageState setErrorNetMsgViewId(@IdRes int errorNetMsgViewId) {
        return mPageStateCreator.setErrorNetMsgViewId(errorNetMsgViewId);
    }

    @Override
    public PageState setClickShowLoadView(boolean show) {
        return mPageStateCreator.setClickShowLoadView(show);
    }

    @Override
    public PageState setOnErrorListener(OnErrorClickListener listener) {
        return mPageStateCreator.setOnErrorListener(listener);
    }

    @Override
    public PageState setOnErrorNetListener(OnErrorNetClickListener listener) {
        return mPageStateCreator.setOnErrorNetListener(listener);
    }

    @Override
    public void showLoadingView() {
        mPageStateCreator.showLoadingView();
    }

    @Override
    public void showContentView() {
        mPageStateCreator.showContentView();
    }

    @Override
    public void showEmptyView() {
        mPageStateCreator.showEmptyView();
    }

    @Override
    public void showErrorView() {
        mPageStateCreator.showErrorView();
    }

    @Override
    public void showErrorNetView() {
        mPageStateCreator.showErrorNetView();
    }

    @Override
    public <T extends View> T getEmptyView() {
        return (T) mPageStateCreator.getEmptyView();
    }

    @Override
    public <T extends View> T getErrorView() {
        return (T) mPageStateCreator.getErrorView();
    }

    @Override
    public <T extends View> T getErrorNetView() {
        return (T) mPageStateCreator.getErrorNetView();
    }

    @Override
    public <T extends View> T getLoadingMsgView() {
        return (T) mPageStateCreator.getLoadingMsgView();
    }

    @Override
    public <T extends View> T getEmptyMsgView() {
        return (T) mPageStateCreator.getEmptyMsgView();
    }

    @Override
    public <T extends View> T getErrorMsgView() {
        return (T) mPageStateCreator.getErrorMsgView();
    }

    @Override
    public <T extends View> T getErrorNetMsgView() {
        return (T) mPageStateCreator.getErrorNetMsgView();
    }

    @Override
    public <T extends View> T getLoadingProgressView() {
        return (T) mPageStateCreator.getLoadingProgressView();
    }

    @Override
    public <T extends View> T getEmptyImgView() {
        return (T) mPageStateCreator.getEmptyImgView();
    }

    @Override
    public <T extends View> T getErrorImgView() {
        return (T) mPageStateCreator.getErrorImgView();
    }

    @Override
    public <T extends View> T getErrorNetImgView() {
        return (T) mPageStateCreator.getErrorNetImgView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs
            , int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    /**
     * Activity中使用
     *
     * @param activity  activity
     * @param contentId 内容视图的layoutId
     * @return PageState
     */
    public static PageState wrap(Activity activity, @IdRes int contentId) {
        ViewGroup actContent = activity.findViewById(android.R.id.content);
        ViewGroup rootLayout = (ViewGroup) (actContent).getChildAt(0);
        return wrap(rootLayout, contentId);
    }

    private static PageState wrap(View rootLayout, @IdRes int contentId) {
        View contentLayout = rootLayout.findViewById(contentId);
        if (contentLayout == null) {
            throw new RuntimeException("contentLayout can not be null");
        }
        ViewGroup.LayoutParams lp = contentLayout.getLayoutParams();

        ViewGroup parent = (ViewGroup) contentLayout.getParent();
        if (parent == null) {
            throw new RuntimeException("parent of the contentLayout can not be null");
        }
        int contentViewIndex = parent.indexOfChild(contentLayout);

        parent.removeView(contentLayout);
        PageStateLayout pageStateLayout = new PageStateLayout(parent.getContext());
        pageStateLayout.addView(contentLayout);
        pageStateLayout.mPageStateCreator.setContentView(contentLayout);

        parent.addView(pageStateLayout, contentViewIndex, lp);
        return pageStateLayout;
    }

    /**
     * Activity中使用
     *
     * @param activity
     * @param contentParentId 内容视图的父视图layoutId
     * @param contentId       内容视图layoutId
     * @return PageState
     */
    public static PageState wrap(Activity activity, @IdRes int contentParentId
            , @IdRes int contentId) {
        return wrap(activity.findViewById(contentParentId), contentId);
    }

    /**
     * v4.Fragment使用
     *
     * @param fragment  v4.Fragment
     * @param contentId 内容视图layoutId
     * @return PageState
     */
    public static PageState wrap(Fragment fragment, @IdRes int contentId) {
        return wrap(fragment.getView(), contentId);
    }

    /**
     * app.Fragment使用
     *
     * @param fragment  app.Fragment
     * @param contentId 内容视图layoutId
     * @return PageState
     */
    public static PageState wrap(android.app.Fragment fragment, @IdRes int contentId) {
        return wrap(fragment.getView(), contentId);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (mContentLayoutId != NO_ID) {
            mPageStateCreator.setContentView(mContentLayoutId);
        } else {
            if (getChildCount() > 5) {
                throw new IllegalStateException("PageStateLayout can host only one direct child");
            }
            View view = getChildAt(4);
            mPageStateCreator.setContentView(view);
        }
    }
}
