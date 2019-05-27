package com.xiaomai.ageny.task.direct_task.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.LoginBean;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.task.direct_task.contract.TaskDirectContract;
import com.xiaomai.ageny.task.direct_task.model.TaskDirectModel;

import io.reactivex.functions.Consumer;

public class TaskDirectPresenter extends BasePresenter<TaskDirectContract.View> implements TaskDirectContract.Presenter {
    private TaskDirectContract.Model model;
    public TaskDirectPresenter() {
        model=new TaskDirectModel();
    }

    @Override
    public void getData(String sellername, String linkmobile, String deviceid, String state,String page,String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(sellername, linkmobile, deviceid,state,page,pagesize).compose(RxScheduler.<OffDirectDeviceBean>Flo_io_main())
                .as(mView.<OffDirectDeviceBean>bindAutoDispose())
                .subscribe(new Consumer<OffDirectDeviceBean>() {
                    @Override
                    public void accept(OffDirectDeviceBean bean) throws Exception {
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
    public void getDataFresh(String sellername, String linkmobile, String deviceid, String state,String page,String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(sellername, linkmobile, deviceid,state,page,pagesize).compose(RxScheduler.<OffDirectDeviceBean>Flo_io_main())
                .as(mView.<OffDirectDeviceBean>bindAutoDispose())
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

    @Override
    public void getDataLoadMore(String sellername, String linkmobile, String deviceid, String state, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(sellername, linkmobile, deviceid,state,page,pagesize).compose(RxScheduler.<OffDirectDeviceBean>Flo_io_main())
                .as(mView.<OffDirectDeviceBean>bindAutoDispose())
                .subscribe(new Consumer<OffDirectDeviceBean>() {
                    @Override
                    public void accept(OffDirectDeviceBean bean) throws Exception {
                        mView.onSuccessLoadMore(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}
