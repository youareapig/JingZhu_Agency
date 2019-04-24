package com.xiaomai.ageny.fragment.index.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.IndexBean;

import io.reactivex.Flowable;

public interface IndexContract {
    interface Model {
        Flowable<IndexBean> getData();

        Flowable<ConfigBean> getConfigBean();

    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(IndexBean bean);

        void onSuccess(ConfigBean bean);

        void onSuccess_Fresh(IndexBean bean);
    }

    interface Presenter {
        void getData();

        void getData_Fresh();

        void getConfigBean();
    }
}
