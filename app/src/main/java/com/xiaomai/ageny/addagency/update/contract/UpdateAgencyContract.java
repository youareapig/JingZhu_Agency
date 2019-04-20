package com.xiaomai.ageny.addagency.update.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface UpdateAgencyContract {
    interface Model {
        Flowable<HintBean> getData(RequestBody requestBody);
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
        void getData(RequestBody requestBody);
    }
}
