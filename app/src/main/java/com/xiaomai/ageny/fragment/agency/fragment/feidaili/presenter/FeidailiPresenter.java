package com.xiaomai.ageny.fragment.agency.fragment.feidaili.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.contract.FeidailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.model.FeidailiModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class FeidailiPresenter extends BasePresenter<FeidailiContract.View> implements FeidailiContract.Presenter {
    private FeidailiContract.Model model;
    public FeidailiPresenter() {
        model=new FeidailiModel();
    }

    @Override
    public void getData(String mobile, String deviceid, String grade, String directly, String isbytime) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(mobile, deviceid, grade, directly, isbytime).compose(RxScheduler.<DailiListBean>Flo_io_main())
                .subscribe(new Consumer<DailiListBean>() {
                    @Override
                    public void accept(DailiListBean bean) throws Exception {
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
    public void getData_Fresh(String mobile, String deviceid, String grade, String directly, String isbytime) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(mobile, deviceid, grade, directly, isbytime).compose(RxScheduler.<DailiListBean>Flo_io_main())
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
}
