package com.xiaomai.ageny.device_manage.device_withdraw.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DeviceWithDrawListBean;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.device_manage.device_withdraw.contract.DeviceWithDrawListContract;
import com.xiaomai.ageny.device_manage.device_withdraw.model.DeviceWithDrawListModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceWithDrawListPresenter extends BasePresenter<DeviceWithDrawListContract.View> implements DeviceWithDrawListContract.Presenter {
    private DeviceWithDrawListContract.Model model;

    public DeviceWithDrawListPresenter() {
        model = new DeviceWithDrawListModel();
    }

    @Override
    public void getData(String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(deviceid).compose(RxScheduler.<HintBean>Flo_io_main())
                .as(mView.<HintBean>bindAutoDispose())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
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
