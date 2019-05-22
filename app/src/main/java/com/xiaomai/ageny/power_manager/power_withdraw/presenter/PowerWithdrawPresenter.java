package com.xiaomai.ageny.power_manager.power_withdraw.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.power_manager.power_withdraw.contract.PowerWithdrawContract;
import com.xiaomai.ageny.power_manager.power_withdraw.model.PowerWithdrawModel;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class PowerWithdrawPresenter extends BasePresenter<PowerWithdrawContract.View> implements PowerWithdrawContract.Presenter {
    private PowerWithdrawContract.Model model;

    public PowerWithdrawPresenter() {
        model = new PowerWithdrawModel();
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
                        mView.onError(throwable);
                    }
                });
    }
}
