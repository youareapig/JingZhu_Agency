package com.xiaomai.ageny.details.devcie_freeze_details.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.bean.FreezeDetailsBean;

import io.reactivex.Flowable;

public interface DeviceFreezeDetailsContract {
    interface Model {
        Flowable<FreezeDetailsBean> getData(String deviceid);

        Flowable<FreezeBean> getData(String filler_state, String deviceid, String filler_relation);


    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(FreezeDetailsBean bean);

        void onSuccess(FreezeBean bean);
    }

    interface Presenter {
        void getData(String deviceid);

        void getData(String filler_state, String deviceid, String filler_relation);
    }
}
