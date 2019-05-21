package com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.PowerInfoBean;
import com.xiaomai.ageny.bean.PowerManagerBean;

import io.reactivex.Flowable;

public interface PowerAlloteZxingContract {
    interface Model {
        Flowable<PowerInfoBean> getData(String powerid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(PowerInfoBean bean);
    }

    interface Presenter {
        void getData(String powerid);
    }
}
