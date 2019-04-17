package com.xiaomai.ageny.details.orderdetails.myorderdetails.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.MyOrderDetailsBean;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.contract.MyOrderDetailsContract;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.model.MyOrderDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class MyOrderDetailsPresenter extends BasePresenter<MyOrderDetailsContract.View> implements MyOrderDetailsContract.Presenter {
    private MyOrderDetailsContract.Model model;

    public MyOrderDetailsPresenter() {
        model=new MyOrderDetailsModel();
    }

    @Override
    public void getData(String orderid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(orderid).compose(RxScheduler.<MyOrderDetailsBean>Flo_io_main())
                .subscribe(new Consumer<MyOrderDetailsBean>() {
                    @Override
                    public void accept(MyOrderDetailsBean bean) throws Exception {
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
