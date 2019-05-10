package com.xiaomai.ageny.details.record_details.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.ShopBean;
import com.xiaomai.ageny.details.record_details.contract.RecordDetailsContract;
import com.xiaomai.ageny.details.record_details.model.RecordDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class RecordDetailsPresenter extends BasePresenter<RecordDetailsContract.View> implements RecordDetailsContract.Presenter {
    private RecordDetailsContract.Model model;

    public RecordDetailsPresenter() {
        model=new RecordDetailsModel();
    }

    @Override
    public void getData(String receiptId) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(receiptId).compose(RxScheduler.<ShopBean>Flo_io_main())
                .as(mView.<ShopBean>bindAutoDispose())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean bean) throws Exception {
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
}
