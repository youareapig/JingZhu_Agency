package com.xiaomai.ageny.addagency.add.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.AddAgencyBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface AddAgencyContract {
    interface Model {
        Flowable<AddAgencyBean> getData(RequestBody body);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(AddAgencyBean bean);
    }

    interface Presenter {
        void getData(RequestBody body);
    }
}
