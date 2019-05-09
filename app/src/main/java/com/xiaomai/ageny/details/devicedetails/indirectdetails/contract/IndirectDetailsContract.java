package com.xiaomai.ageny.details.devicedetails.indirectdetails.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;

import io.reactivex.Flowable;

public interface IndirectDetailsContract {
    interface Model {
        Flowable<OffIndirectDeivceDetailsBean> getData(String deviceid,String msgid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(OffIndirectDeivceDetailsBean bean);
    }

    interface Presenter {
        void getData(String deviceid,String msgid);
    }
}
