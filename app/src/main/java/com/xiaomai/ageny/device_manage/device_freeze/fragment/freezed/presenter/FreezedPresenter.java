package com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.contract.FreezedContract;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.model.FreezedModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class FreezedPresenter extends BasePresenter<FreezedContract.View> implements FreezedContract.Presenter {
    private FreezedContract.Model model;
    public FreezedPresenter() {
        model=new FreezedModel();
    }

    @Override
    public void getData(String filler_state, String filler_deviceid, String filler_relation) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(filler_state,filler_deviceid,filler_relation).compose(RxScheduler.<FreezeBean>Flo_io_main())
                .subscribe(new Consumer<FreezeBean>() {
                    @Override
                    public void accept(FreezeBean bean) throws Exception {
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
