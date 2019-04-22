package com.xiaomai.ageny.add_staff.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface AddStaffContract {
    interface Model {
        Flowable<HintBean> addStaff(RequestBody body);
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
        void addStaff(RequestBody body);
    }
}
