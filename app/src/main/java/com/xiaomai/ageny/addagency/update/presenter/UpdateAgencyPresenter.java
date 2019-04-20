package com.xiaomai.ageny.addagency.update.presenter;

import com.xiaomai.ageny.addagency.update.contract.UpdateAgencyContract;
import com.xiaomai.ageny.addagency.update.model.UpdateAgencyModel;
import com.xiaomai.ageny.base.BasePresenter;
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
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
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
