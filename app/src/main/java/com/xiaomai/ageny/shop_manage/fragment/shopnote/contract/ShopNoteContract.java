package com.xiaomai.ageny.shop_manage.fragment.shopnote.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ShopRecordBean;

import io.reactivex.Flowable;

public interface ShopNoteContract {
    interface Model {
        Flowable<ShopRecordBean> getData(String bath, String mobile, String page, String page_size);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ShopRecordBean bean);

        void onSuccessFresh(ShopRecordBean bean);
    }

    interface Presenter {
        void getData(String bath, String mobile, String page, String page_size);

        void getDataFresh(String bath, String mobile, String page, String page_size);
    }
}
