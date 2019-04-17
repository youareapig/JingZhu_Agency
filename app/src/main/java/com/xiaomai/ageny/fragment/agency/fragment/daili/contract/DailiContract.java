package com.xiaomai.ageny.fragment.agency.fragment.daili.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DailiListBean;

import io.reactivex.Flowable;

public interface DailiContract {
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
    }

    interface Presenter {
        void getData(String mobile, String deviceid, String grade, String directly, String isbytime);
    }
}
