package com.xiaomai.ageny.details.shop_note_details.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.bean.ShopBean;
import com.xiaomai.ageny.details.shop_note_details.contract.ShopNoteDetailsContract;
import com.xiaomai.ageny.details.shop_note_details.model.ShopNoteDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class ShopNoteDetailsPresenter extends BasePresenter<ShopNoteDetailsContract.View> implements ShopNoteDetailsContract.Presenter {
    private ShopNoteDetailsContract.Model model;

    public ShopNoteDetailsPresenter() {
        model = new ShopNoteDetailsModel();
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
