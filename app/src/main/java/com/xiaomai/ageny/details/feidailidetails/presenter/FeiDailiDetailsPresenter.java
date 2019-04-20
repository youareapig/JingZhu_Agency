package com.xiaomai.ageny.details.feidailidetails.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.HisSellerBean;
import com.xiaomai.ageny.details.feidailidetails.contract.FeiDailiDetailsContract;
import com.xiaomai.ageny.details.feidailidetails.model.FeiDailiDetailsModel;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.contract.FeidailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.model.FeidailiModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class FeiDailiDetailsPresenter extends BasePresenter<FeiDailiDetailsContract.View> implements FeiDailiDetailsContract.Presenter {
    private FeiDailiDetailsContract.Model model;

    public FeiDailiDetailsPresenter() {
        model = new FeiDailiDetailsModel();
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
    public void getHisSeller(String agentid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getHisSeller(agentid).compose(RxScheduler.<HisSellerBean>Flo_io_main())
                .subscribe(new Consumer<HisSellerBean>() {
                    @Override
                    public void accept(HisSellerBean bean) throws Exception {
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
    public void getAgencyUserInfo(String agentid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getAgencyUserInfo(agentid).compose(RxScheduler.<AgencyUserInfoBean>Flo_io_main())
                .subscribe(new Consumer<AgencyUserInfoBean>() {
                    @Override
                    public void accept(AgencyUserInfoBean bean) throws Exception {
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
}
