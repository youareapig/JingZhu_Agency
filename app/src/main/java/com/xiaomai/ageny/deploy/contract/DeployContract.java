package com.xiaomai.ageny.deploy.contract;

import com.amap.api.location.AMapLocation;
import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelToNameBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface DeployContract {
    interface Model {
        Flowable<TelToNameBean> getData(String mobile);

        Flowable<HintBean> getDeploy(RequestBody requestBody);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(TelToNameBean bean);

        void locationSuccess(AMapLocation aMapLocation);

        void onDeploy(HintBean bean);
    }

    interface Presenter {
        void getData(String mobile);

        void getLocation();

        void getDeploy(RequestBody requestBody);

        void stopLocation();
    }
}
