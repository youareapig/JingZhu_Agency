package com.xiaomai.ageny.unbundle.unbundle_shanghu.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.VerCodeBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface UnbundleShanghuContract {
    interface Model {
        Flowable<VerCodeBean> getCode(String mobile);

        Flowable<HintBean> unbundleContanctBean(RequestBody body);
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

        void unbundleContanctBean(RequestBody body);
    }
}
