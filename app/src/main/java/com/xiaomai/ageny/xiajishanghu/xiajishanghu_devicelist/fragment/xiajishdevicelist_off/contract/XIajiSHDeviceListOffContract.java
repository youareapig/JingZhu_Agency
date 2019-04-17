package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.XiajiListBean;

import io.reactivex.Flowable;

public interface XIajiSHDeviceListOffContract {
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
    }

    interface Presenter {
        void getData(String id, String deviceid, String dentails, String state);
    }
}
