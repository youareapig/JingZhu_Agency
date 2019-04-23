package com.xiaomai.ageny.shop_manage.goshop.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface GoShopContract {
    interface Model {
        Flowable<HintBean> getData(RequestBody body);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(HintBean bean);
    }

    interface Presenter {
        void getData(RequestBody body);
    }
}
