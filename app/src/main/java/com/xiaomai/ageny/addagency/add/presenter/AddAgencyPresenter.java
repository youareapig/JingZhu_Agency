package com.xiaomai.ageny.addagency.add.presenter;

import com.xiaomai.ageny.addagency.add.contract.AddAgencyContract;
import com.xiaomai.ageny.addagency.add.model.AddAgencyModel;
import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class AddAgencyPresenter extends BasePresenter<AddAgencyContract.View> implements AddAgencyContract.Presenter {
    private AddAgencyContract.Model model;

    public AddAgencyPresenter() {
        model = new AddAgencyModel();
    }

    @Override
    public void getData(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(body).compose(RxScheduler.<HintBean>Flo_io_main())
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
