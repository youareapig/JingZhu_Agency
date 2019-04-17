package com.xiaomai.ageny.details.dailidetails.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.HisSellerBean;
import com.xiaomai.ageny.details.dailidetails.contract.DailiDetailsContract;
import com.xiaomai.ageny.details.dailidetails.model.DailiDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DailiDetailsPresenter extends BasePresenter<DailiDetailsContract.View> implements DailiDetailsContract.Presenter {

    private DailiDetailsContract.Model model;

    public DailiDetailsPresenter() {
        model = new DailiDetailsModel();
    }

    @Override
    public void getData(String agentid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(agentid).compose(RxScheduler.<AgencyDetailsBean>Flo_io_main())
                .subscribe(new Consumer<AgencyDetailsBean>() {
                    @Override
                    public void accept(AgencyDetailsBean bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    @Override
    public void getHisSeller(String agentid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getHisSeller(agentid).compose(RxScheduler.<HisSellerBean>Flo_io_main())
                .subscribe(new Consumer<HisSellerBean>() {
                    @Override
                    public void accept(HisSellerBean bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    @Override
    public void getAgencyUserInfo(String agentid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getAgencyUserInfo(agentid).compose(RxScheduler.<AgencyUserInfoBean>Flo_io_main())
                .subscribe(new Consumer<AgencyUserInfoBean>() {
                    @Override
                    public void accept(AgencyUserInfoBean bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
