package com.xiaomai.ageny.fragment.mine;

import android.view.View;

import com.uber.autodispose.AutoDisposeConverter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.fragment.mine.contract.MineContract;
import com.xiaomai.ageny.fragment.mine.presenter.MinePresenter;

public class Mine_Fragment extends BaseMvpFragment<MinePresenter> implements MineContract.View {
    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

}
