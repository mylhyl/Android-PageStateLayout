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
    private PageStateLayoutCreater mPageStateCreater = new PageStateLayoutCreater();

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
            mPageStateCreater.setRootView(this);

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

            mPageStateCreater.create();

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
        return mPageStateCreater.setLoadingLayout(loadingLayoutId);
    }

    @Override
    public PageState setEmptyLayout(@LayoutRes int emptyLayoutId) {
        return mPageStateCreater.setEmptyLayout(emptyLayoutId);
    }

    @Override
    public PageState setErrorLayout(@LayoutRes int errorLayoutId) {
        return mPageStateCreater.setErrorLayout(errorLayoutId);
    }

    @Override
    public PageState setErrorNetLayout(@LayoutRes int errorNetLayoutId) {
        return mPageStateCreater.setErrorNetLayout(errorNetLayoutId);
    }

    @Override
    public PageState setLoadingProgressViewId(int loadingProgressViewId) {
        return mPageStateCreater.setLoadingProgressViewId(loadingProgressViewId);
    }

    @Override
    public PageState setLoadingMsgViewId(@IdRes int loadingMsgViewId) {
        return mPageStateCreater.setLoadingMsgViewId(loadingMsgViewId);
    }

    @Override
    public PageState setEmptyImgId(int emptyImgId) {
        return mPageStateCreater.setEmptyImgId(emptyImgId);
    }

    @Override
    public PageState setEmptyMsgViewId(@IdRes int emptyMsgViewId) {
        return mPageStateCreater.setEmptyMsgViewId(emptyMsgViewId);
    }

    @Override
    public PageState setErrorImgId(int errorImgId) {
        return mPageStateCreater.setErrorImgId(errorImgId);
    }

    @Override
    public PageState setErrorMsgViewId(@IdRes int errorMsgViewId) {
        return mPageStateCreater.setErrorMsgViewId(errorMsgViewId);
    }

    @Override
    public PageState setErrorNetImgId(int errorNetImgId) {
        return mPageStateCreater.setErrorNetImgId(errorNetImgId);
    }

    @Override
    public PageState setErrorNetMsgViewId(@IdRes int errorNetMsgViewId) {
        return mPageStateCreater.setErrorNetMsgViewId(errorNetMsgViewId);
    }

    @Override
    public PageState setClickShowLoadView(boolean show) {
        return mPageStateCreater.setClickShowLoadView(show);
    }

    @Override
    public PageState setOnErrorListener(OnErrorClickListener listener) {
        return mPageStateCreater.setOnErrorListener(listener);
    }

    @Override
    public PageState setOnErrorNetListener(OnErrorNetClickListener listener) {
        return mPageStateCreater.setOnErrorNetListener(listener);
    }

    @Override
    public void showLoadingView() {
        mPageStateCreater.showLoadingView();
    }

    @Override
    public void showContentView() {
        mPageStateCreater.showContentView();
    }

    @Override
    public void showEmptyView() {
        mPageStateCreater.showEmptyView();
    }

    @Override
    public void showErrorView() {
        mPageStateCreater.showErrorView();
    }

    @Override
    public void showErrorNetView() {
        mPageStateCreater.showErrorNetView();
    }

    @Override
    public <T extends View> T getEmptyView() {
        return (T) mPageStateCreater.getEmptyView();
    }

    @Override
    public <T extends View> T getErrorView() {
        return (T) mPageStateCreater.getErrorView();
    }

    @Override
    public <T extends View> T getErrorNetView() {
        return (T) mPageStateCreater.getErrorNetView();
    }

    @Override
    public <T extends View> T getLoadingMsgView() {
        return (T) mPageStateCreater.getLoadingMsgView();
    }

    @Override
    public <T extends View> T getEmptyMsgView() {
        return (T) mPageStateCreater.getEmptyMsgView();
    }

    @Override
    public <T extends View> T getErrorMsgView() {
        return (T) mPageStateCreater.getErrorMsgView();
    }

    @Override
    public <T extends View> T getErrorNetMsgView() {
        return (T) mPageStateCreater.getErrorNetMsgView();
    }

    @Override
    public <T extends View> T getLoadingProgressView() {
        return (T) mPageStateCreater.getLoadingProgressView();
    }

    @Override
    public <T extends View> T getEmptyImgView() {
        return (T) mPageStateCreater.getEmptyImgView();
    }

    @Override
    public <T extends View> T getErrorImgView() {
        return (T) mPageStateCreater.getErrorImgView();
    }

    @Override
    public <T extends View> T getErrorNetImgView() {
        return (T) mPageStateCreater.getErrorNetImgView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs
            , int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

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
        pageStateLayout.mPageStateCreater.setContentView(contentLayout);

        parent.addView(pageStateLayout, contentViewIndex, lp);
        return pageStateLayout;
    }

    public static PageState wrap(Activity activity, @IdRes int contentParentId
            , @IdRes int contentId) {
        return wrap(activity.findViewById(contentParentId), contentId);
    }

    public static PageState wrap(Fragment fragment, @IdRes int contentId) {
        return wrap(fragment.getView(), contentId);
    }

    public static PageState wrap(android.app.Fragment fragment, @IdRes int contentId) {
        return wrap(fragment.getView(), contentId);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (mContentLayoutId != NO_ID) {
            mPageStateCreater.setContentView(mContentLayoutId);
        } else {
            if (getChildCount() > 5) {
                throw new IllegalStateException("PageStateLayout can host only one direct child");
            }
            View view = getChildAt(4);
            mPageStateCreater.setContentView(view);
        }
    }
}
