package com.xiaomai.ageny.device_manage.device_withdraw.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DeviceWithDrawListBean;
import com.xiaomai.ageny.bean.HintBean;

import io.reactivex.Flowable;

public interface DeviceWithDrawListContract {
    interface Model {
        Flowable<HintBean> getData(String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(HintBean bean);

    }

    interface Presenter {
        void getData(String deviceid);
    }
}
