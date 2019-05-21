package com.xiaomai.ageny.details.power_alloted_details.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.PowerAllotedBean;
import com.xiaomai.ageny.bean.PowerDetailsBean;
import com.xiaomai.ageny.details.power_alloted_details.contract.PowerAllotedDetailsContract;
import com.xiaomai.ageny.details.power_alloted_details.model.PowerAllotedDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class PowerAllotedDetailsPresenter extends BasePresenter<PowerAllotedDetailsContract.View> implements PowerAllotedDetailsContract.Presenter {
    private PowerAllotedDetailsContract.Model model;

    public PowerAllotedDetailsPresenter() {
        model=new PowerAllotedDetailsModel();
    }

    @Override
    public void getData(String id) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(id).compose(RxScheduler.<PowerDetailsBean>Flo_io_main())
                .as(mView.<PowerDetailsBean>bindAutoDispose())
                .subscribe(new Consumer<PowerDetailsBean>() {
                    @Override
                    public void accept(PowerDetailsBean bean) throws Exception {
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
