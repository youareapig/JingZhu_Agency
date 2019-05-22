package com.xiaomai.ageny.power_manager.power_allot_next.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.power_manager.power_allot_next.contract.PowerAllotNextContract;
import com.xiaomai.ageny.power_manager.power_allot_next.model.PowerAllotNextModel;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class PowerAllotNextPresenter extends BasePresenter<PowerAllotNextContract.View> implements PowerAllotNextContract.Presenter {
    private PowerAllotNextContract.Model model;

    public PowerAllotNextPresenter() {
        model = new PowerAllotNextModel();
    }

    @Override
    public void sureTel(String tel) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.sureTel(tel).compose(RxScheduler.<TelBean>Flo_io_main())
                .as(mView.<TelBean>bindAutoDispose())
                .subscribe(new Consumer<TelBean>() {
                    @Override
                    public void accept(TelBean bean) throws Exception {
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
    public void getData(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(body).compose(RxScheduler.<HintBean>Flo_io_main())
                .as(mView.<HintBean>bindAutoDispose())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
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
}
