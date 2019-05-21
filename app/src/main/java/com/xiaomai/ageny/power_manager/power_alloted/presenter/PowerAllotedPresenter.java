package com.xiaomai.ageny.power_manager.power_alloted.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.PowerAllotedBean;
import com.xiaomai.ageny.bean.PowerManagerBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.power_manager.power_alloted.contract.PowerAllotedContract;
import com.xiaomai.ageny.power_manager.power_alloted.model.PowerAllotedModel;

import io.reactivex.functions.Consumer;

public class PowerAllotedPresenter extends BasePresenter<PowerAllotedContract.View> implements PowerAllotedContract.Presenter {
    private PowerAllotedContract.Model model;

    public PowerAllotedPresenter() {
        model = new PowerAllotedModel();
    }

    @Override
    public void getData(String id, String startTime, String endTime) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(id, startTime, endTime).compose(RxScheduler.<PowerAllotedBean>Flo_io_main())
                .as(mView.<PowerAllotedBean>bindAutoDispose())
                .subscribe(new Consumer<PowerAllotedBean>() {
                    @Override
                    public void accept(PowerAllotedBean bean) throws Exception {
                        mView.hideLoading();
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
    public void getDataFresh(String id, String startTime, String endTime) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(id, startTime, endTime).compose(RxScheduler.<PowerAllotedBean>Flo_io_main())
                .as(mView.<PowerAllotedBean>bindAutoDispose())
                .subscribe(new Consumer<PowerAllotedBean>() {
                    @Override
                    public void accept(PowerAllotedBean bean) throws Exception {
                        mView.onSuccessFresh(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);

                    }
                });
    }
}
