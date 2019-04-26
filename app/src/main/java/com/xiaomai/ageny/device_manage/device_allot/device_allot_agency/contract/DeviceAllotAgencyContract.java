package com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface DeviceAllotAgencyContract {
    interface Model {
        Flowable<TelBean> sureTel(String tel);

        Flowable<HintBean> getData(RequestBody body);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(TelBean bean);

        void onSuccess(HintBean bean);
    }

    interface Presenter {
        void sureTel(String tel);

        void getData(RequestBody body);
    }
}
