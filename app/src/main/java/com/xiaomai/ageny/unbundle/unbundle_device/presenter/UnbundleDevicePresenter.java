package com.xiaomai.ageny.unbundle.unbundle_device.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.unbundle.unbundle_device.contract.UnbundleDeviceContract;
import com.xiaomai.ageny.unbundle.unbundle_device.model.UnbundleDeviceModel;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class UnbundleDevicePresenter extends BasePresenter<UnbundleDeviceContract.View> implements UnbundleDeviceContract.Presenter {
    private UnbundleDeviceContract.Model model;
    public UnbundleDevicePresenter() {
        model=new UnbundleDeviceModel();
    }


    @Override
    public void getCode(String mobile) {
        if (!isViewAttached()) {
            return;
        }
        model.getCode(mobile).compose(RxScheduler.<VerCodeBean>Flo_io_main())
                .subscribe(new Consumer<VerCodeBean>() {
                    @Override
                    public void accept(VerCodeBean bean) throws Exception {
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getDeviceDelete(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getDeviceDelete(body).compose(RxScheduler.<HintBean>Flo_io_main())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
