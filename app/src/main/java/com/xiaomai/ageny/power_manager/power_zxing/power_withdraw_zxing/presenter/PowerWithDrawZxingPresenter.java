package com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.PowerInfoBean;
import com.xiaomai.ageny.bean.PowerWithDrawInfoBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.contract.PowerWithDrawZxingContract;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.model.PowerWithDrawZxingModel;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class PowerWithDrawZxingPresenter extends BasePresenter<PowerWithDrawZxingContract.View> implements PowerWithDrawZxingContract.Presenter {
    private PowerWithDrawZxingContract.Model model;

    public PowerWithDrawZxingPresenter() {
        model=new PowerWithDrawZxingModel();
    }

    @Override
    public void getData(String id) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(id).compose(RxScheduler.<PowerWithDrawInfoBean>Flo_io_main())
                .as(mView.<PowerWithDrawInfoBean>bindAutoDispose())
                .subscribe(new Consumer<PowerWithDrawInfoBean>() {
                    @Override
                    public void accept(PowerWithDrawInfoBean bean) throws Exception {
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
