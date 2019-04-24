package com.xiaomai.ageny.fragment.agency.fragment.feidaili.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DailiListBean;

import io.reactivex.Flowable;

public interface FeidailiContract {
    interface Model {
        Flowable<DailiListBean> getData(String mobile, String deviceid, String grade, String directly, String isbytime);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(DailiListBean bean);

        void onSuccess_Fresh(DailiListBean bean);
    }

    interface Presenter {
        void getData(String mobile, String deviceid, String grade, String directly, String isbytime);

        void getData_Fresh(String mobile, String deviceid, String grade, String directly, String isbytime);
    }
}
