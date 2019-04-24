package com.xiaomai.ageny.offline.fragment.indirect.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;

import io.reactivex.Flowable;

public interface IndirectContract {
    interface Model {
        Flowable<OffIndirectDeivceBean> getData(String agentname, String agentmobile, String deviceid, String state);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(OffIndirectDeivceBean bean);

        void onSuccess_Fresh(OffIndirectDeivceBean bean);


    }

    interface Presenter {
        void getData(String agentname, String agentmobile, String deviceid, String state);

        void getData_Fresh(String agentname, String agentmobile, String deviceid, String state);
    }
}
