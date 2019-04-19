package com.xiaomai.ageny.deposit.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DepositBean;
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
                .subscribe(new Consumer<IndexBean>() {
                    @Override
                    public void accept(IndexBean indexBean) throws Exception {
                        mView.onSuccess(indexBean);
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

    @Override
    public void getDepositBean(RequestBody requestBody) {
        if (!isViewAttached()) {
            return;
        }
        model.getDepositBean(requestBody).compose(RxScheduler.<DepositBean>Flo_io_main())
                .subscribe(new Consumer<DepositBean>() {
                    @Override
                    public void accept(DepositBean indexBean) throws Exception {
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
