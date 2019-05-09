package com.xiaomai.ageny.fragment.index.contract;

import android.app.Activity;
import android.content.Context;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.UpdateBean;
import com.xiaomai.ageny.bean.UserInfoBean;

import io.reactivex.Flowable;

public interface IndexContract {
    interface Model {
        Flowable<IndexBean> getData();

        Flowable<ConfigBean> getConfigBean();

        Flowable<UpdateBean> getUpdate();

        Flowable<UserInfoBean> getAlias();

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

        void onSuccess(UpdateBean bean);

        void onSuccess(UserInfoBean bean);

    }

    interface Presenter {
        void getData();

        void getData_Fresh();

        void getConfigBean();

        void getUpdate();

        void updateMethod(Activity activity);

        void getAlias();
    }
}
