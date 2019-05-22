package com.xiaomai.ageny.order.order_list.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.bean.OrderListBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.order.order_list.contract.OrderListContract;
import com.xiaomai.ageny.order.order_list.model.OrderListModel;

import io.reactivex.functions.Consumer;

public class OrderListPresenter extends BasePresenter<OrderListContract.View> implements OrderListContract.Presenter {
    private OrderListContract.Model model;

    public OrderListPresenter() {
        model = new OrderListModel();
    }

    @Override
    public void getData(String agentid, String page, String pagesize,String orderid,String sellername,String startTime,String endTime,String state) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(agentid, page, pagesize, orderid, sellername, startTime, endTime,state).compose(RxScheduler.<OrderListBean>Flo_io_main())
                .as(mView.<OrderListBean>bindAutoDispose())
                .subscribe(new Consumer<OrderListBean>() {
                    @Override
                    public void accept(OrderListBean bean) throws Exception {
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
    public void getLoadMore(String agentid, String page, String pagesize,String orderid,String sellername,String startTime,String endTime,String state) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(agentid, page, pagesize, orderid, sellername, startTime, endTime,state).compose(RxScheduler.<OrderListBean>Flo_io_main())
                .as(mView.<OrderListBean>bindAutoDispose())
                .subscribe(new Consumer<OrderListBean>() {
                    @Override
                    public void accept(OrderListBean bean) throws Exception {
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
    public void getRefrshFresh(String agentid, String page, String pagesize,String orderid,String sellername,String startTime,String endTime,String state) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(agentid, page, pagesize, orderid, sellername, startTime, endTime,state).compose(RxScheduler.<OrderListBean>Flo_io_main())
                .as(mView.<OrderListBean>bindAutoDispose())
                .subscribe(new Consumer<OrderListBean>() {
                    @Override
                    public void accept(OrderListBean bean) throws Exception {
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
