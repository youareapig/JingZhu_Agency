package com.xiaomai.ageny.fragment.agency.fragment.daili.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.fragment.agency.fragment.daili.contract.DailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.daili.model.DailiModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DailiPresenter extends BasePresenter<DailiContract.View> implements DailiContract.Presenter {
    private DailiContract.Model model;

    public DailiPresenter() {
        model = new DailiModel();
    }

    @Override
    public void getData(String mobile, String deviceid, String grade, String directly, String isbytime,String page,String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(mobile, deviceid, grade, directly, isbytime,page,pagesize).compose(RxScheduler.<DailiListBean>Flo_io_main())
                .as(mView.<DailiListBean>bindAutoDispose())
                .subscribe(new Consumer<DailiListBean>() {
                    @Override
                    public void accept(DailiListBean bean) throws Exception {
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
    public void getData_Fresh(String mobile, String deviceid, String grade, String directly, String isbytime,String page,String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(mobile, deviceid, grade, directly, isbytime,page,pagesize).compose(RxScheduler.<DailiListBean>Flo_io_main())
                .as(mView.<DailiListBean>bindAutoDispose())
                .subscribe(new Consumer<DailiListBean>() {
                    @Override
                    public void accept(DailiListBean bean) throws Exception {
                        mView.onSuccess_Fresh(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getData_LoadMore(String mobile, String deviceid, String grade, String directly, String isbytime, String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(mobile, deviceid, grade, directly, isbytime,page,pagesize).compose(RxScheduler.<DailiListBean>Flo_io_main())
                .as(mView.<DailiListBean>bindAutoDispose())
                .subscribe(new Consumer<DailiListBean>() {
                    @Override
                    public void accept(DailiListBean bean) throws Exception {
                        mView.onSuccess_LoadMore(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}
