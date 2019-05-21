package com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.PowerInfoBean;
import com.xiaomai.ageny.bean.PowerManagerBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.contract.PowerAlloteZxingContract;
import com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.model.PowerAlloteZxingModel;

import io.reactivex.functions.Consumer;

public class PowerAlloteZxingPresenter extends BasePresenter<PowerAlloteZxingContract.View> implements PowerAlloteZxingContract.Presenter {
    private PowerAlloteZxingContract.Model model;

    public PowerAlloteZxingPresenter() {
        model = new PowerAlloteZxingModel();
    }

    @Override
    public void getData(String powerid) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(powerid).compose(RxScheduler.<PowerInfoBean>Flo_io_main())
                .as(mView.<PowerInfoBean>bindAutoDispose())
                .subscribe(new Consumer<PowerInfoBean>() {
                    @Override
                    public void accept(PowerInfoBean bean) throws Exception {
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}
