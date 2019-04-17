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
    public void getData(String orderid, String sellername, String startTime, String endTime) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(orderid, sellername, startTime, endTime).compose(RxScheduler.<LowerOrderBean>Flo_io_main())
                .subscribe(new Consumer<LowerOrderBean>() {
                    @Override
                    public void accept(LowerOrderBean bean) throws Exception {
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
