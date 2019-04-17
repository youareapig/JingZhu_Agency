package com.xiaomai.ageny.details.dailidetails.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.HisSellerBean;

import io.reactivex.Flowable;

public interface DailiDetailsContract {
    interface Model {
        Flowable<AgencyDetailsBean> getData(String agentid);

        Flowable<HisSellerBean> getHisSeller(String agentid);

        Flowable<AgencyUserInfoBean> getAgencyUserInfo(String agentid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(AgencyDetailsBean bean);

        void onSuccess(HisSellerBean bean);

        void onSuccess(AgencyUserInfoBean bean);
    }

    interface Presenter {
        void getData(String agentid);

        void getHisSeller(String agentid);

        void getAgencyUserInfo(String agentid);
    }
}
