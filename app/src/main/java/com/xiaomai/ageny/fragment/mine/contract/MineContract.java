package com.xiaomai.ageny.fragment.mine.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.UserInfoBean;

import io.reactivex.Flowable;

public interface MineContract {
    interface Model {
        Flowable<UserInfoBean> getData();
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(UserInfoBean bean);
    }

    interface Presenter {
        void getData();
    }
}
