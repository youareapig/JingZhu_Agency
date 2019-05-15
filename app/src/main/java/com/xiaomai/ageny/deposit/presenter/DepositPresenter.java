package com.xiaomai.ageny.deposit.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.deposit.contract.DepositContract;
import com.xiaomai.ageny.deposit.model.DepositModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class DepositPresenter extends BasePresenter<DepositContract.View> implements DepositContract.Presenter {
    private DepositContract.Model model;

    public DepositPresenter() {
        model = new DepositModel();
    }

    @Override
    public void getData() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<IndexBean>Flo_io_main())
                .as(mView.<IndexBean>bindAutoDispose())
                .subscribe(new Consumer<IndexBean>() {
                    @Override
                    public void accept(IndexBean indexBean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(indexBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getDepositBean(RequestBody requestBody) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getDepositBean(requestBody).compose(RxScheduler.<HintBean>Flo_io_main())
                .as(mView.<HintBean>bindAutoDispose())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean indexBean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccessDeposit(indexBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}
