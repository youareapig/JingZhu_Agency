package com.xiaomai.ageny.power_manager.power_index.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.PowerManagerBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.power_manager.power_index.contract.PowerIndexContract;
import com.xiaomai.ageny.power_manager.power_index.model.PowerIndexModel;

import io.reactivex.functions.Consumer;

public class PowerIndexPresenter extends BasePresenter<PowerIndexContract.View> implements PowerIndexContract.Presenter {
    private PowerIndexContract.Model model;

    public PowerIndexPresenter() {
        model = new PowerIndexModel();
    }

    @Override
    public void getData() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<PowerManagerBean>Flo_io_main())
                .as(mView.<PowerManagerBean>bindAutoDispose())
                .subscribe(new Consumer<PowerManagerBean>() {
                    @Override
                    public void accept(PowerManagerBean bean) throws Exception {
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
