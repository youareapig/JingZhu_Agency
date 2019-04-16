package com.xiaomai.ageny.fragment.mine.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.UserInfoBean;
import com.xiaomai.ageny.fragment.mine.contract.MineContract;
import com.xiaomai.ageny.fragment.mine.model.MineModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class MinePresenter extends BasePresenter<MineContract.View> implements MineContract.Presenter {
    private MineContract.Model model;
    public MinePresenter() {
        model=new MineModel();
    }

    @Override
    public void getData() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<UserInfoBean>Flo_io_main())
                .subscribe(new Consumer<UserInfoBean>() {
                    @Override
                    public void accept(UserInfoBean bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
