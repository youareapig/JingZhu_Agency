package com.xiaomai.ageny.task_earn.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DeviceEarnListBean;
import com.xiaomai.ageny.bean.SystemNoticeBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.task_earn.contract.EarnTaskContract;
import com.xiaomai.ageny.task_earn.model.EarnTaskModel;

import io.reactivex.functions.Consumer;

public class EarnTaskPresenter extends BasePresenter<EarnTaskContract.View> implements EarnTaskContract.Presenter {
    private EarnTaskContract.Model model;

    public EarnTaskPresenter() {
        model=new EarnTaskModel();
    }

    @Override
    public void getData(String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(page, pagesize).compose(RxScheduler.<DeviceEarnListBean>Flo_io_main())
                .as(mView.<DeviceEarnListBean>bindAutoDispose())
                .subscribe(new Consumer<DeviceEarnListBean>() {
                    @Override
                    public void accept(DeviceEarnListBean bean) throws Exception {
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
    public void getDataFresh(String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(page, pagesize).compose(RxScheduler.<DeviceEarnListBean>Flo_io_main())
                .as(mView.<DeviceEarnListBean>bindAutoDispose())
                .subscribe(new Consumer<DeviceEarnListBean>() {
                    @Override
                    public void accept(DeviceEarnListBean bean) throws Exception {
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
    public void getDataLoadMore(String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(page, pagesize).compose(RxScheduler.<DeviceEarnListBean>Flo_io_main())
                .as(mView.<DeviceEarnListBean>bindAutoDispose())
                .subscribe(new Consumer<DeviceEarnListBean>() {
                    @Override
                    public void accept(DeviceEarnListBean bean) throws Exception {
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
