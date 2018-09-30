package com.mylhyl.pagestatelayout;

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

    private static PageStateConfig mPageStateConfig = new DefaultPageStateConfig();
    private int mContentLayoutId = NO_ID;
    private PageStateLayoutCreater mPageStateCreater = new PageStateLayoutCreater();

    public PageStateLayout(@NonNull Context context) {
        this(context, null);
    }

    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.PageStateLayout);
        int loadingLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_loadingLayout, NO_ID);
        int emptyLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyLayout, NO_ID);
        int errorLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_errorLayout, NO_ID);
        int errorNetLayout = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetLayout, NO_ID);

        int emptyImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyImgId, NO_ID);
        Drawable emptyImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_emptyImgSrc);
        int errorImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorImgId, NO_ID);
        Drawable errorImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_errorImgSrc);
        int errorNetImgId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetImgId, NO_ID);
        Drawable errorNetImgDrawable = ta.getDrawable(R.styleable.PageStateLayout_psl_errorNetImgSrc);

        int loadingMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_loadingMsgViewId, NO_ID);
        int emptyMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_emptyMsgViewId, NO_ID);
        int errorMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorMsgViewId, NO_ID);
        int errorNetMsgViewId = ta.getResourceId(R.styleable.PageStateLayout_psl_errorNetMsgViewId, NO_ID);

        CharSequence loadingMsg = ta.getText(R.styleable.PageStateLayout_psl_loadingMsg);
        CharSequence emptyMsg = ta.getText(R.styleable.PageStateLayout_psl_emptyMsg);
        CharSequence errorMsg = ta.getText(R.styleable.PageStateLayout_psl_errorMsg);
        CharSequence errorNetMsg = ta.getText(R.styleable.PageStateLayout_psl_errorNetMsg);

        mContentLayoutId = ta.getResourceId(R.styleable.PageStateLayout_psl_contentLayoutId, NO_ID);

        if (!isInEditMode()) {

            setLoadingLayout(mPageStateConfig.getLoadingLayout());
            setEmptyLayout(mPageStateConfig.getEmptyLayout());
            setErrorLayout(mPageStateConfig.getErrorLayout());
            setErrorNetLayout(mPageStateConfig.getErrorNetLayout());

            setLoadingProgressViewId(mPageStateConfig.getLoadingProgressId());
            setEmptyImgId(mPageStateConfig.getEmptyImgId());
            setErrorImgId(mPageStateConfig.getErrorImgId());
            setErrorNetImgId(mPageStateConfig.getErrorNetImgId());

            setLoadingMsgViewId(mPageStateConfig.getLoadingMsgViewId());
            setEmptyMsgViewId(mPageStateConfig.getEmptyMsgViewId());
            setErrorMsgViewId(mPageStateConfig.getErrorMsgViewId());
            setErrorNetMsgViewId(mPageStateConfig.getErrorNetMsgViewId());

            setRootView(this);
            if (loadingLayout != NO_ID) {
                setLoadingLayout(loadingLayout);
            }
            if (emptyLayout != NO_ID) {
                setEmptyLayout(emptyLayout);
            }
            if (errorLayout != NO_ID) {
                setErrorLayout(errorLayout);
            }
            if (errorNetLayout != NO_ID) {
                setErrorNetLayout(errorNetLayout);
            }
            if (loadingMsgViewId != NO_ID) {
                setLoadingMsgViewId(loadingMsgViewId);
            }
            if (emptyImgId != NO_ID) {
                setEmptyImgId(emptyImgId);
            }
            if (emptyMsgViewId != NO_ID) {
                setEmptyMsgViewId(emptyMsgViewId);
            }
            if (errorImgId != NO_ID) {
                setErrorImgId(errorImgId);
            }
            if (errorMsgViewId != NO_ID) {
                setErrorMsgViewId(errorMsgViewId);
            }
            if (errorNetImgId != NO_ID) {
                setErrorNetImgId(errorNetImgId);
            }
            if (errorNetMsgViewId != NO_ID) {
                setErrorNetMsgViewId(errorNetMsgViewId);
            }
            create();

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
        }
        ta.recycle();
    }

    @Override
    public void setLoadingLayout(@LayoutRes int loadingLayoutId) {
        mPageStateCreater.setLoadingLayout(loadingLayoutId);
    }

    @Override
    public void setEmptyLayout(@LayoutRes int emptyLayoutId) {
        mPageStateCreater.setEmptyLayout(emptyLayoutId);
    }

    @Override
    public void setErrorLayout(@LayoutRes int errorLayoutId) {
        mPageStateCreater.setErrorLayout(errorLayoutId);
    }

    @Override
    public void setErrorNetLayout(@LayoutRes int errorNetLayoutId) {
        mPageStateCreater.setErrorNetLayout(errorNetLayoutId);
    }

    @Override
    public void setLoadingProgressViewId(int loadingProgressViewId) {
        mPageStateCreater.setLoadingProgressViewId(loadingProgressViewId);
    }

    @Override
    public void setLoadingMsgViewId(@IdRes int loadingMsgViewId) {
        mPageStateCreater.setLoadingMsgViewId(loadingMsgViewId);
    }

    @Override
    public void setEmptyImgId(int emptyImgId) {
        mPageStateCreater.setEmptyImgId(emptyImgId);
    }

    @Override
    public void setEmptyMsgViewId(@IdRes int emptyMsgViewId) {
        mPageStateCreater.setEmptyMsgViewId(emptyMsgViewId);
    }

    @Override
    public void setErrorImgId(int errorImgId) {
        mPageStateCreater.setErrorImgId(errorImgId);
    }

    @Override
    public void setErrorMsgViewId(@IdRes int errorMsgViewId) {
        mPageStateCreater.setErrorMsgViewId(errorMsgViewId);
    }

    @Override
    public void setErrorNetImgId(int errorNetImgId) {
        mPageStateCreater.setErrorNetImgId(errorNetImgId);
    }

    @Override
    public void setErrorNetMsgViewId(@IdRes int errorNetMsgViewId) {
        mPageStateCreater.setErrorNetMsgViewId(errorNetMsgViewId);
    }

    @Override
    public void setErrorClickShowLoading(boolean show) {
        mPageStateCreater.setErrorClickShowLoading(show);
    }

    @Override
    public void setRootView(View rootView) {
        mPageStateCreater.setRootView(rootView);
    }

    @Override
    public void setContentView(@IdRes int contentId) {
        mPageStateCreater.setContentView(contentId);
    }

    @Override
    public void setContentView(View contentView) {
        mPageStateCreater.setContentView(contentView);
    }

    @Override
    public void setOnErrorListener(OnErrorClickListener listener) {
        mPageStateCreater.setOnErrorListener(listener);
    }

    @Override
    public void setOnErrorNetListener(OnErrorNetClickListener listener) {
        mPageStateCreater.setOnErrorNetListener(listener);
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

    @Override
    public void create() {
        mPageStateCreater.create();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PageStateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public static void setPageStateConfig(PageStateConfig pageStateConfig) {
        mPageStateConfig = pageStateConfig;
    }

    public static PageState wrap(Activity activity, @IdRes int contentId) {
        ViewGroup actContent = activity.findViewById(android.R.id.content);
        ViewGroup rootLayout = (ViewGroup) (actContent).getChildAt(0);
        return wrap(rootLayout, contentId);
    }

    public static PageState wrap(View rootLayout, @IdRes int contentId) {
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
        pageStateLayout.setContentView(contentLayout);

        parent.addView(pageStateLayout, contentViewIndex, lp);
        return pageStateLayout;
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
        if (mContentLayoutId == NO_ID) {
            if (getChildCount() > 5) {
                throw new IllegalStateException("PageStateLayout can host only one direct child");
            }
            View view = getChildAt(4);
            setContentView(view);
        } else {
            View contentLayout = findViewById(mContentLayoutId);
            setContentView(contentLayout);
        }
    }
}
