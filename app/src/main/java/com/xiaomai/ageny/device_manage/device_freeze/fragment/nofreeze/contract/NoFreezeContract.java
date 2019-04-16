package com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.FreezeBean;

import io.reactivex.Flowable;

public interface NoFreezeContract {
    interface Model {
        Flowable<FreezeBean> getData(String filler_state,String filler_deviceid,String filler_relation);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(FreezeBean bean);
    }

    interface Presenter {
        void getData(String filler_state,String filler_deviceid,String filler_relation);
    }
}
