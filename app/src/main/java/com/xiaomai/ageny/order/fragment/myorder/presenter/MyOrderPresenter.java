package com.xiaomai.ageny.order.fragment.myorder.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.order.fragment.myorder.contract.MyOrderContract;
import com.xiaomai.ageny.order.fragment.myorder.model.MyOrderModel;

import io.reactivex.functions.Consumer;

public class MyOrderPresenter extends BasePresenter<MyOrderContract.View> implements MyOrderContract.Presenter {
    private MyOrderContract.Model model;
    public MyOrderPresenter() {
        model=new MyOrderModel();
    }

    @Override
    public void getData(String orderid, String sellername, String startTime, String endTime,String page,String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(orderid, sellername, startTime, endTime,page,pagesize).compose(RxScheduler.<MyOrderBean>Flo_io_main())
                .subscribe(new Consumer<MyOrderBean>() {
                    @Override
                    public void accept(MyOrderBean bean) throws Exception {
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

    @Override
    public void getRefrsh(String orderid, String sellername, String startTime, String endTime, String page,String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getRefrsh(orderid, sellername, startTime, endTime,page,pagesize).compose(RxScheduler.<MyOrderBean>Flo_io_main())
                .subscribe(new Consumer<MyOrderBean>() {
                    @Override
                    public void accept(MyOrderBean bean) throws Exception {
                        mView.onFreshSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onFreshError(throwable);
                    }
                });
    }
}
