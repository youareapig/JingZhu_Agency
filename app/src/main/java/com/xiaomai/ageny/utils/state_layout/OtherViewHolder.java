package com.xiaomai.ageny.utils.state_layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.xiaomai.ageny.R;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
public class OtherViewHolder extends OtherHolder {
    private Context mContext;
    private RetryBtnListener mListener;
    public OtherViewHolder(Context context) {
        super(context);
        mContext = context;
    }
    public void setOnListener(RetryBtnListener listener){
        mListener = listener;
    }

    @Override
    public View setEmpty(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.base_empty, null);
    }

    @Override
    public View setRetry(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.base_retry, null);
        view.findViewById(R.id.m_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    mListener.onListener();
                }
            }
        });
        return view;
    }

    @Override
    public View setLoading(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.base_loading, null);
    }

    public interface RetryBtnListener{
        void onListener();
    }
}
