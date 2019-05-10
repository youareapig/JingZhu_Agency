package com.xiaomai.ageny.deposit_list.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.bean.DepositListBean;
import com.xiaomai.ageny.deposit_list.contract.DepositListContract;
import com.xiaomai.ageny.deposit_list.model.DepositListModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DepositListPresenter extends BasePresenter<DepositListContract.View> implements DepositListContract.Presenter {
    private DepositListContract.Model model;

    public DepositListPresenter() {
        model=new DepositListModel();
    }

    @Override
    public void getData(String page, String page_size, String state, String orderid, String price_start, String price_end) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(page, page_size, state, orderid, price_start, price_end).compose(RxScheduler.<DepositListBean>Flo_io_main())
                .as(mView.<DepositListBean>bindAutoDispose())
                .subscribe(new Consumer<DepositListBean>() {
                    @Override
                    public void accept(DepositListBean bean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getData_Fresh(String page, String page_size, String state, String orderid, String price_start, String price_end) {
        if (!isViewAttached()) {
            return;
        }
        model.getData_Fresh(page, page_size, state, orderid, price_start, price_end).compose(RxScheduler.<DepositListBean>Flo_io_main())
                .as(mView.<DepositListBean>bindAutoDispose())
                .subscribe(new Consumer<DepositListBean>() {
                    @Override
                    public void accept(DepositListBean bean) throws Exception {
                        mView.onSuccess_Fresh(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}
