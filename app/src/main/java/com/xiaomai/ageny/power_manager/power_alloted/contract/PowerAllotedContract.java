package com.xiaomai.ageny.power_manager.power_alloted.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.PowerAllotedBean;
import com.xiaomai.ageny.bean.PowerManagerBean;

import io.reactivex.Flowable;

public interface PowerAllotedContract {
    interface Model {
        Flowable<PowerAllotedBean> getData(String id, String startTime, String endTime);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(PowerAllotedBean bean);

        void onSuccessFresh(PowerAllotedBean bean);
    }

    interface Presenter {
        void getData(String id, String startTime, String endTime);

        void getDataFresh(String id, String startTime, String endTime);
    }
}
