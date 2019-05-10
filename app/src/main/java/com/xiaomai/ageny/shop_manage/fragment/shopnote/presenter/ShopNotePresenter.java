package com.xiaomai.ageny.shop_manage.fragment.shopnote.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.AgencySellerListBean;
import com.xiaomai.ageny.bean.ShopRecordBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.shop_manage.fragment.shopnote.contract.ShopNoteContract;
import com.xiaomai.ageny.shop_manage.fragment.shopnote.model.ShopNoteModel;

import io.reactivex.functions.Consumer;

public class ShopNotePresenter extends BasePresenter<ShopNoteContract.View> implements ShopNoteContract.Presenter {
    private ShopNoteContract.Model model;

    public ShopNotePresenter() {
        model = new ShopNoteModel();
    }

    @Override
    public void getData(String bath, String mobile, String page, String page_size) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(bath, mobile, page, page_size).compose(RxScheduler.<ShopRecordBean>Flo_io_main())
                .as(mView.<ShopRecordBean>bindAutoDispose())
                .subscribe(new Consumer<ShopRecordBean>() {
                    @Override
                    public void accept(ShopRecordBean bean) throws Exception {
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
    public void getDataFresh(String bath, String mobile, String page, String page_size) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(bath, mobile, page, page_size).compose(RxScheduler.<ShopRecordBean>Flo_io_main())
                .as(mView.<ShopRecordBean>bindAutoDispose())
                .subscribe(new Consumer<ShopRecordBean>() {
                    @Override
                    public void accept(ShopRecordBean bean) throws Exception {
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
