package com.xiaomai.ageny.unbundle.unbundle_record.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.UnbindRecordBean;

import io.reactivex.Flowable;

public interface UnbundleRecordContract {
    interface Model {
        Flowable<UnbindRecordBean> getData(String page, String page_size, String linkman, String linkmobile);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(UnbindRecordBean bean);
    }

    interface Presenter {
        void getData(String page, String page_size, String linkman, String linkmobile);
    }
}
