package com.xiaomai.ageny.details.shop_note_details.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ShopBean;

import io.reactivex.Flowable;

public interface ShopNoteDetailsContract {
    interface Model {
        Flowable<ShopBean> getData(String receiptId);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ShopBean bean);
    }

    interface Presenter {
        void getData(String receiptId);
    }
}
