package com.xiaomai.ageny.unbundle.unbundle_device.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.VerCodeBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface UnbundleDeviceContract {
    interface Model {
        Flowable<VerCodeBean> getCode(String mobile);

        Flowable<HintBean> getDeviceDelete(RequestBody body);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(VerCodeBean bean);

        void onSuccess(HintBean bean);
    }

    interface Presenter {
        void getCode(String mobile);

        void getDeviceDelete(RequestBody body);
    }
}
