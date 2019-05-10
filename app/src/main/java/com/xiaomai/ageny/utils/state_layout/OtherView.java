package com.xiaomai.ageny.utils.state_layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class OtherView extends LinearLayout {
    private final int KEY_NORMAL= 0, KEY_LOADING = 1, KEY_EMPTY= 2, KEY_RETRY = 3;
    private int mViewType = KEY_NORMAL;
    private OtherHolder mHolder;

    public OtherView(Context context) {
        super(context);
    }

    public OtherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setHolder(OtherHolder holder){
        mHolder = holder;
        initView();
    }

    private void initView() {
        addView(mHolder.mLoadingView,0);
        addView(mHolder.mEmptyView,0);
        addView(mHolder.mRetryView,0);
        setShowOrHide();
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mHolder.mLoadingView.setLayoutParams(ll);
        mHolder.mEmptyView.setLayoutParams(ll);
        mHolder.mRetryView.setLayoutParams(ll);

    }
    public void showLoadingView(){
        if (mViewType == KEY_LOADING) return;
        mViewType = KEY_LOADING;
        setShowOrHide();
    }
    public void showEmptyView(){
        if (mViewType == KEY_EMPTY) return;
        mViewType = KEY_EMPTY;
        setShowOrHide();
    }
    public void showRetryView(){
        if (mViewType == KEY_RETRY) return;
        mViewType = KEY_RETRY;
        setShowOrHide();
    }
    public void showContentView(){
        if (mViewType == KEY_NORMAL) return;
        mViewType = KEY_NORMAL;
        setShowOrHide();
    }
    private void setShowOrHide(){
        if (mHolder == null){
            throw new RuntimeException("OtherView::请先设置OtherHolder");
        }
        if (mHolder.mEmptyView!=null){
            mHolder.mEmptyView.setVisibility(mViewType == KEY_EMPTY ? VISIBLE : GONE);
        }
        if (mHolder.mLoadingView!=null){
            mHolder.mLoadingView.setVisibility(mViewType == KEY_LOADING ? VISIBLE : GONE);
        }
        if (mHolder.mRetryView!=null){
            mHolder.mRetryView.setVisibility(mViewType == KEY_RETRY ? VISIBLE : GONE);
        }


    }


}
