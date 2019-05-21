package com.xiaomai.ageny.power_manager.power_index.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.PowerManagerBean;

import io.reactivex.Flowable;

public interface PowerIndexContract {
    interface Model {
        Flowable<PowerManagerBean> getData();
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(PowerManagerBean bean);
    }

    interface Presenter {
        void getData();
    }
}
