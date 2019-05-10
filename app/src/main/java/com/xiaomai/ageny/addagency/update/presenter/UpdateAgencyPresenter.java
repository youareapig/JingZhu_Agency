package com.xiaomai.ageny.addagency.update.presenter;

import com.xiaomai.ageny.addagency.update.contract.UpdateAgencyContract;
import com.xiaomai.ageny.addagency.update.model.UpdateAgencyModel;
import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class UpdateAgencyPresenter extends BasePresenter<UpdateAgencyContract.View> implements UpdateAgencyContract.Presenter {
    private UpdateAgencyContract.Model model;
    public UpdateAgencyPresenter() {
        model=new UpdateAgencyModel();
    }

    @Override
    public void getData(RequestBody requestBody) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(requestBody).compose(RxScheduler.<HintBean>Flo_io_main())
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
