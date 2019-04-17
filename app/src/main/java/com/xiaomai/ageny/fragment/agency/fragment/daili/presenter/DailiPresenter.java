package com.xiaomai.ageny.fragment.agency.fragment.daili.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.fragment.agency.fragment.daili.contract.DailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.daili.model.DailiModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DailiPresenter extends BasePresenter<DailiContract.View> implements DailiContract.Presenter {
    private DailiContract.Model model;

    public DailiPresenter() {
        model = new DailiModel();
    }

    @Override
    public void getData(String mobile, String deviceid, String grade, String directly, String isbytime) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(mobile, deviceid, grade, directly, isbytime).compose(RxScheduler.<DailiListBean>Flo_io_main())
                .subscribe(new Consumer<DailiListBean>() {
                    @Override
                    public void accept(DailiListBean bean) throws Exception {
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
