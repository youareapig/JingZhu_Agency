package com.xiaomai.ageny.xiajishanghu.xiajishanghulist.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.AgencySellerListBean;

import io.reactivex.Flowable;

public interface XiajiSHContract {
    interface Model {
        Flowable<AgencySellerListBean> getData(String id);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(AgencySellerListBean bean);
    }

    interface Presenter {
        void getData(String id);
    }
}
