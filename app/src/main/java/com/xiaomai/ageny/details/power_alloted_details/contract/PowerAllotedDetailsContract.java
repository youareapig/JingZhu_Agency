package com.xiaomai.ageny.details.power_alloted_details.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.PowerAllotedBean;
import com.xiaomai.ageny.bean.PowerDetailsBean;

import io.reactivex.Flowable;

public interface PowerAllotedDetailsContract {
    interface Model {
        Flowable<PowerDetailsBean> getData(String id);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(PowerDetailsBean bean);
    }

    interface Presenter {
        void getData(String id);
    }
}
