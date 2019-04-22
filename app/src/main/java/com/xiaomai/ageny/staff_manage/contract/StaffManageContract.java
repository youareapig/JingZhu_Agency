package com.xiaomai.ageny.staff_manage.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.StaffBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface StaffManageContract {
    interface Model {
        Flowable<StaffBean> getStaffListBean(String page, String page_size);

        Flowable<HintBean> staffDelete(RequestBody body);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(StaffBean bean);

        void onSuccess(HintBean bean);
    }

    interface Presenter {
        void getStaffListBean(String page, String page_size);

        void staffDelete(RequestBody body);
    }
}
