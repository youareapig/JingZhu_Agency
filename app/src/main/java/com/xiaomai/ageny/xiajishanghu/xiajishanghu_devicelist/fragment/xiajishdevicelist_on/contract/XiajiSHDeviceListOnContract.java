package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.XiajiListBean;

import io.reactivex.Flowable;

public interface XiajiSHDeviceListOnContract {
    interface Model {
        Flowable<XiajiListBean> getData(String id, String deviceid, String dentails, String state);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(XiajiListBean bean);

        void onSuccessFresh(XiajiListBean bean);

    }

    interface Presenter {
        void getData(String id, String deviceid, String dentails, String state);

        void getDataFresh(String id, String deviceid, String dentails, String state);
    }
}
