package com.xiaomai.ageny.addbank.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface BankContract {
    interface Model {
        Flowable<HintBean> addBank(RequestBody body);
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
        void addBank(RequestBody body);
    }
}
