package com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.PowerInfoBean;
import com.xiaomai.ageny.bean.PowerWithDrawInfoBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface PowerWithDrawZxingContract {
    interface Model {
        Flowable<PowerWithDrawInfoBean> getData(String id);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(PowerWithDrawInfoBean bean);

    }

    interface Presenter {
        void getData(String id);
    }
}
