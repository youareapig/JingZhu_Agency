package com.xiaomai.ageny.offline.fragment.indirect.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;

import io.reactivex.Flowable;

public interface IndirectContract {
    interface Model {
        Flowable<OffIndirectDeivceBean> getData(String agentname,String agentmobile,String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(OffIndirectDeivceBean bean);
    }

    interface Presenter {
        void getData(String agentname,String agentmobile,String deviceid);
    }
}
