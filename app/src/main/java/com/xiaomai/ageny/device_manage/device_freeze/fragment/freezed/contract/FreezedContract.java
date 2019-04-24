package com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.FreezeBean;

import io.reactivex.Flowable;

public interface FreezedContract {
    interface Model {
        Flowable<FreezeBean> getData(String filler_state, String filler_deviceid, String filler_relation);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(FreezeBean bean);
        void onSuccessFresh(FreezeBean bean);
    }

    interface Presenter {
        void getData(String filler_state,String filler_deviceid,String filler_relation);
        void getDataFresh(String filler_state,String filler_deviceid,String filler_relation);
    }
}
