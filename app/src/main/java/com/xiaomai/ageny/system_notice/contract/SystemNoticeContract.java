package com.xiaomai.ageny.system_notice.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.SystemNoticeBean;

import io.reactivex.Flowable;

public interface SystemNoticeContract {
    interface Model {
        Flowable<SystemNoticeBean> getData(String page, String pagesize);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(SystemNoticeBean bean);

        void onSuccessFresh(SystemNoticeBean bean);
    }

    interface Presenter {
        void getData(String page, String pagesize);

        void getDataFresh(String page, String pagesize);
    }
}
