package com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelBean;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.contract.DeviceAllotAgencyContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.model.DeviceAllotAgencyModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class DeviceAllotAgencyPresenter extends BasePresenter<DeviceAllotAgencyContract.View> implements DeviceAllotAgencyContract.Presenter {
    private DeviceAllotAgencyContract.Model model;

    public DeviceAllotAgencyPresenter() {
        model = new DeviceAllotAgencyModel();
    }

    @Override
    public void sureTel(String tel) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.sureTel(tel).compose(RxScheduler.<TelBean>Flo_io_main())
                .subscribe(new Consumer<TelBean>() {
                    @Override
                    public void accept(TelBean bean) throws Exception {
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

    @Override
    public void getData(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(body).compose(RxScheduler.<HintBean>Flo_io_main())
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
