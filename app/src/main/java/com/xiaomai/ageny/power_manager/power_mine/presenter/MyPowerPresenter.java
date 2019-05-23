package com.xiaomai.ageny.power_manager.power_mine.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.MyPowerListBean;
import com.xiaomai.ageny.bean.PowerManagerBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.power_manager.power_mine.contract.MyPowerContract;
import com.xiaomai.ageny.power_manager.power_mine.model.MyPowerModel;

import io.reactivex.functions.Consumer;

public class MyPowerPresenter extends BasePresenter<MyPowerContract.View> implements MyPowerContract.Presenter {
    private MyPowerContract.Model model;

    public MyPowerPresenter() {
        model = new MyPowerModel();
    }

    @Override
    public void getData(String id, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(id,page,pagesize).compose(RxScheduler.<MyPowerListBean>Flo_io_main())
                .as(mView.<MyPowerListBean>bindAutoDispose())
                .subscribe(new Consumer<MyPowerListBean>() {
                    @Override
                    public void accept(MyPowerListBean bean) throws Exception {
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
    public void getDataFresh(String id, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(id,page,pagesize).compose(RxScheduler.<MyPowerListBean>Flo_io_main())
                .as(mView.<MyPowerListBean>bindAutoDispose())
                .subscribe(new Consumer<MyPowerListBean>() {
                    @Override
                    public void accept(MyPowerListBean bean) throws Exception {
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
    public void getDataLoadMore(String id, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(id,page,pagesize).compose(RxScheduler.<MyPowerListBean>Flo_io_main())
                .as(mView.<MyPowerListBean>bindAutoDispose())
                .subscribe(new Consumer<MyPowerListBean>() {
                    @Override
                    public void accept(MyPowerListBean bean) throws Exception {
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
