package com.xiaomai.ageny.mybill.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.mybill.contract.MyBillContract;
import com.xiaomai.ageny.mybill.model.MyBillModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class MyBillPresenter extends BasePresenter<MyBillContract.View> implements MyBillContract.Presenter {
    private MyBillContract.Model model;
    public MyBillPresenter() {
        model=new MyBillModel();
    }

    @Override
    public void getData() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<BillListBean>Flo_io_main())
                .subscribe(new Consumer<BillListBean>() {
                    @Override
                    public void accept(BillListBean bean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        mView.onError(throwable);

                    }
                });
    }
}
