package com.xiaomai.ageny.details.shanghudevicedetails.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.bean.HintBean;

import io.reactivex.Flowable;

public interface ShangHuDeviceDetailsContract {
    interface Model {
        Flowable<ContactDeviceDetailsBean> getData(String id, String msgid);

        Flowable<HintBean> updatePrice(String id, String price);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ContactDeviceDetailsBean bean);

        void showProcess();

        void hideProcess();

        void onErrorProcess(Throwable throwable);

        void onSuccess(HintBean bean);
    }

    interface Presenter {
        void getData(String id, String msgid);

        void updatePrice(String id, String price);
    }
}
