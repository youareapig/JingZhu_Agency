package com.xiaomai.ageny.details.devicedetails.indirectdetails.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.contract.IndirectDetailsContract;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.model.IndirectDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class IndirectDetailsPresenter extends BasePresenter<IndirectDetailsContract.View> implements IndirectDetailsContract.Presenter {
    private IndirectDetailsContract.Model model;

    public IndirectDetailsPresenter() {
        model = new IndirectDetailsModel();
    }

    @Override
    public void getData(String deviceid,String msgid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(deviceid,msgid).compose(RxScheduler.<OffIndirectDeivceDetailsBean>Flo_io_main())
                .subscribe(new Consumer<OffIndirectDeivceDetailsBean>() {
                    @Override
                    public void accept(OffIndirectDeivceDetailsBean bean) throws Exception {
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
