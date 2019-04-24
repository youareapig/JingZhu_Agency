package com.xiaomai.ageny.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaomai.ageny.utils.NetWorkUtils;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder unBinder;
    public OtherViewHolder mHolder;
    public boolean isNetWork=true;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(this.getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, view);
        //是否有网络
        isNetWork = NetWorkUtils.isNetworkConnected(getActivity());
        mHolder=new OtherViewHolder(getActivity());
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unBinder.unbind();
    }

    /**
     * 初始化视图
     *
     * @param view
     */
    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    protected void toClass(Context context, Class<? extends BaseMvpActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    //带参数
    protected void toClass(Context context, Class<? extends BaseMvpActivity> clazz, Bundle bundle) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    protected void toClass1(Context context, Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    protected void toClass_Empty(Context context, Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    protected void toClass(Context context, Class<? extends BaseMvpActivity> clazz, Bundle bundle, int reuqestCode) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, reuqestCode);
    }
    protected void toClass1(Context context, Class<? extends BaseActivity> clazz, Bundle bundle, int reuqestCode) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, reuqestCode);
    }
}
