package com.xiaomai.ageny.order.fragment.lowerorder.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.LowerOrderBean;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.order.fragment.lowerorder.contract.LowerOrderContract;
import com.xiaomai.ageny.order.fragment.lowerorder.model.LowerOrderModel;

import io.reactivex.functions.Consumer;

public class LowerOrderPresenter extends BasePresenter<LowerOrderContract.View> implements LowerOrderContract.Presenter {
    private LowerOrderContract.Model model;
    public LowerOrderPresenter() {
        model=new LowerOrderModel();
    }

    @Override
    public void getData(String orderid, String sellername, String startTime, String endTime,String page,String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(orderid, sellername, startTime, endTime,page,pagesize).compose(RxScheduler.<LowerOrderBean>Flo_io_main())
                .subscribe(new Consumer<LowerOrderBean>() {
                    @Override
                    public void accept(LowerOrderBean bean) throws Exception {
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
    public void getRefrsh(String orderid, String sellername, String startTime, String endTime, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getRefrsh(orderid, sellername, startTime, endTime,page,pagesize).compose(RxScheduler.<LowerOrderBean>Flo_io_main())
                .subscribe(new Consumer<LowerOrderBean>() {
                    @Override
                    public void accept(LowerOrderBean bean) throws Exception {
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
