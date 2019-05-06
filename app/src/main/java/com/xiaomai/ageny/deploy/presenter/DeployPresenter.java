package com.xiaomai.ageny.deploy.presenter;

import android.Manifest;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelToNameBean;
import com.xiaomai.ageny.deploy.DeployActivity;
import com.xiaomai.ageny.deploy.contract.DeployContract;
import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.deploy.model.DeployModel;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.utils.ToastUtil;
import com.zhy.m.permission.MPermissions;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class DeployPresenter extends BasePresenter<DeployContract.View> implements DeployContract.Presenter {
    private DeployContract.Model model;
    private AMapLocationClient mLocationClient = null;
    private AMapLocationListener mLocationListener = new MyAMapLocationListener();
    private AMapLocationClientOption mLocationOption = null;

    public DeployPresenter() {
        model = new DeployModel();
    }

    @Override
    public void getData(String mobile) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(mobile).compose(RxScheduler.<TelToNameBean>Flo_io_main())
                .subscribe(new Consumer<TelToNameBean>() {
                    @Override
                    public void accept(TelToNameBean bean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getLocation() {
        getPositioning();
    }

    @Override
    public void getDeploy(RequestBody requestBody) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getDeploy(requestBody).compose(RxScheduler.<HintBean>Flo_io_main())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
                        mView.hideLoading();
                        mView.onDeploy(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void stopLocation() {
        mLocationClient.stopLocation();
    }

    // 高德定位
    public void getPositioning() {
        mLocationClient = new AMapLocationClient(App.context);
        mLocationClient.setLocationListener(mLocationListener);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setOnceLocationLatest(true);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setMockEnable(true);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationClient.startLocation();
    }

    class MyAMapLocationListener implements AMapLocationListener {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            Logger.d("定位" + aMapLocation.getErrorCode());
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    mView.locationSuccess(aMapLocation);
                } else {
                    ToastUtil.showShortToast("获取当前位置失败,请检查是否开启定位权限");
                }

            }
        }
    }
}
