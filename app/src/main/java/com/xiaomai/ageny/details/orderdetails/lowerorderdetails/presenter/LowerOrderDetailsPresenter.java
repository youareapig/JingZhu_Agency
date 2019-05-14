package com.xiaomai.ageny.details.orderdetails.lowerorderdetails.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.LowerOrderDetailsBean;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.contract.LowerOrderDetailsContract;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.model.LowerOrderDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class LowerOrderDetailsPresenter  extends BasePresenter<LowerOrderDetailsContract.View> implements LowerOrderDetailsContract.Presenter {
    private LowerOrderDetailsContract.Model model;
    public LowerOrderDetailsPresenter() {
        model=new LowerOrderDetailsModel();
    }

    @Override
    public void getData(String orderid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(orderid).compose(RxScheduler.<LowerOrderDetailsBean>Flo_io_main())
                .as(mView.<LowerOrderDetailsBean>bindAutoDispose())
                .subscribe(new Consumer<LowerOrderDetailsBean>() {
                    @Override
                    public void accept(LowerOrderDetailsBean bean) throws Exception {
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
