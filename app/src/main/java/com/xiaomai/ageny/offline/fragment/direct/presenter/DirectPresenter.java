package com.xiaomai.ageny.offline.fragment.direct.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.offline.fragment.direct.contract.DirectContract;
import com.xiaomai.ageny.offline.fragment.direct.model.DirectModel;

import io.reactivex.functions.Consumer;

public class DirectPresenter extends BasePresenter<DirectContract.View> implements DirectContract.Presenter {
    private DirectContract.Model model;
    public DirectPresenter() {
        model=new DirectModel();
    }

    @Override
    public void getData(String sellername, String linkmobile, String deviceid,String state) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(sellername, linkmobile, deviceid,state).compose(RxScheduler.<OffDirectDeviceBean>Flo_io_main())
                .subscribe(new Consumer<OffDirectDeviceBean>() {
                    @Override
                    public void accept(OffDirectDeviceBean bean) throws Exception {
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
    public void getDataFresh(String sellername, String linkmobile, String deviceid, String state) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(sellername, linkmobile, deviceid,state).compose(RxScheduler.<OffDirectDeviceBean>Flo_io_main())
                .subscribe(new Consumer<OffDirectDeviceBean>() {
                    @Override
                    public void accept(OffDirectDeviceBean bean) throws Exception {
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
