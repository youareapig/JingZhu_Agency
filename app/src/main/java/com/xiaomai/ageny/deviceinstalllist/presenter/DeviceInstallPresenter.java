package com.xiaomai.ageny.deviceinstalllist.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.deviceinstalllist.contract.DeviceInstallContract;
import com.xiaomai.ageny.deviceinstalllist.model.DeviceInstallModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceInstallPresenter extends BasePresenter<DeviceInstallContract.View> implements DeviceInstallContract.Presenter {
    private DeviceInstallContract.Model model;

    public DeviceInstallPresenter() {
        model=new DeviceInstallModel();
    }

    @Override
    public void getDeviceInstallListData(String chiyou, String anzhuang, String time) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getDeviceInstallListData(chiyou,anzhuang,time).compose(RxScheduler.<DeviceInstallListBean>Flo_io_main())
                .subscribe(new Consumer<DeviceInstallListBean>() {
                    @Override
                    public void accept(DeviceInstallListBean bean) throws Exception {
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
    public void getDeviceInstallListBean_Refresh( String chiyou, String anzhuang, String time) {
        if (!isViewAttached()) {
            return;
        }
        model.getDeviceInstallListBean_Refresh(chiyou, anzhuang, time).compose(RxScheduler.<DeviceInstallListBean>Flo_io_main())
                .subscribe(new Consumer<DeviceInstallListBean>() {
                    @Override
                    public void accept(DeviceInstallListBean bean) throws Exception {
                        mView.onSuccess_Refresh(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void loginOut() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.loginOut().compose(RxScheduler.<LoginOutBean>Flo_io_main())
                .subscribe(new Consumer<LoginOutBean>() {
                    @Override
                    public void accept(LoginOutBean bean) throws Exception {
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
    public void getConfigBean() {
        if (!isViewAttached()) {
            return;
        }
        model.getConfigBean().compose(RxScheduler.<ConfigBean>Flo_io_main())
                .subscribe(new Consumer<ConfigBean>() {
                    @Override
                    public void accept(ConfigBean bean) throws Exception {
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }
}
