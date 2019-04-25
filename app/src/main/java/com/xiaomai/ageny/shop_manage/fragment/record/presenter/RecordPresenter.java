package com.xiaomai.ageny.shop_manage.fragment.record.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ShopApplyBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.shop_manage.fragment.record.contract.RecordContract;
import com.xiaomai.ageny.shop_manage.fragment.record.model.RecordModel;

import io.reactivex.functions.Consumer;

public class RecordPresenter extends BasePresenter<RecordContract.View> implements RecordContract.Presenter {
    private RecordContract.Model model;

    public RecordPresenter() {
        model = new RecordModel();
    }

    @Override
    public void getData(String bath, String state,String moble, String page, String page_size) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(bath, state,moble, page, page_size).compose(RxScheduler.<ShopApplyBean>Flo_io_main())
                .subscribe(new Consumer<ShopApplyBean>() {
                    @Override
                    public void accept(ShopApplyBean bean) throws Exception {
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
    public void getDataFresh(String bath, String state,String moble, String page, String page_size) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(bath, state,moble, page, page_size).compose(RxScheduler.<ShopApplyBean>Flo_io_main())
                .subscribe(new Consumer<ShopApplyBean>() {
                    @Override
                    public void accept(ShopApplyBean bean) throws Exception {
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
