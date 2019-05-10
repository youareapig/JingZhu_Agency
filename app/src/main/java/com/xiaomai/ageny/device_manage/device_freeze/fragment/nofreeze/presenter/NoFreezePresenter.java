package com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze.contract.NoFreezeContract;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze.model.NoFreezeModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class NoFreezePresenter extends BasePresenter<NoFreezeContract.View> implements NoFreezeContract.Presenter {
    private NoFreezeContract.Model model;

    public NoFreezePresenter() {
        model = new NoFreezeModel();
    }

    @Override
    public void getData(String filler_state, String filler_deviceid, String filler_relation) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(filler_state,filler_deviceid,filler_relation).compose(RxScheduler.<FreezeBean>Flo_io_main())
                .as(mView.<FreezeBean>bindAutoDispose())
                .subscribe(new Consumer<FreezeBean>() {
                    @Override
                    public void accept(FreezeBean bean) throws Exception {
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
    public void getDataFresh(String filler_state, String filler_deviceid, String filler_relation) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(filler_state,filler_deviceid,filler_relation).compose(RxScheduler.<FreezeBean>Flo_io_main())
                .as(mView.<FreezeBean>bindAutoDispose())
                .subscribe(new Consumer<FreezeBean>() {
                    @Override
                    public void accept(FreezeBean bean) throws Exception {
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
