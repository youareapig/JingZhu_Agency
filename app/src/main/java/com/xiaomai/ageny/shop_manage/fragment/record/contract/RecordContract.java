package com.xiaomai.ageny.shop_manage.fragment.record.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ShopApplyBean;

import io.reactivex.Flowable;

public interface RecordContract {
    interface Model {
        Flowable<ShopApplyBean> getData(String bath, String state, String page, String page_size);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ShopApplyBean bean);

        void onSuccessFresh(ShopApplyBean bean);
    }

    interface Presenter {
        void getData(String bath, String state, String page, String page_size);

        void getDataFresh(String bath, String state, String page, String page_size);
    }
}
