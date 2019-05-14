package com.xiaomai.ageny.order.fragment.myorder.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.order.fragment.myorder.contract.MyOrderContract;
import com.xiaomai.ageny.order.fragment.myorder.model.MyOrderModel;

import io.reactivex.functions.Consumer;

public class MyOrderPresenter extends BasePresenter<MyOrderContract.View> implements MyOrderContract.Presenter {
    private MyOrderContract.Model model;

    public MyOrderPresenter() {
        model = new MyOrderModel();
    }

    @Override
    public void getData(String orderid, String sellername, String startTime, String endTime, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(orderid, sellername, startTime, endTime, page, pagesize).compose(RxScheduler.<MyOrderBean>Flo_io_main())
                .as(mView.<MyOrderBean>bindAutoDispose())
                .subscribe(new Consumer<MyOrderBean>() {
                    @Override
                    public void accept(MyOrderBean bean) throws Exception {
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
    public void getLoadMore(String orderid, String sellername, String startTime, String endTime, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(orderid, sellername, startTime, endTime, page, pagesize).compose(RxScheduler.<MyOrderBean>Flo_io_main())
                .as(mView.<MyOrderBean>bindAutoDispose())
                .subscribe(new Consumer<MyOrderBean>() {
                    @Override
                    public void accept(MyOrderBean bean) throws Exception {
                        mView.onSuccessLoadMore(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getRefrshFresh(String orderid, String sellername, String startTime, String endTime, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(orderid, sellername, startTime, endTime, page, pagesize).compose(RxScheduler.<MyOrderBean>Flo_io_main())
                .as(mView.<MyOrderBean>bindAutoDispose())
                .subscribe(new Consumer<MyOrderBean>() {
                    @Override
                    public void accept(MyOrderBean bean) throws Exception {
                        mView.onSuccessFresh(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }


}
