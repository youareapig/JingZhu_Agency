package com.xiaomai.ageny.xiajishanghu.xiajishanghulist.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.AgencySellerListBean;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.contract.XiajiSHContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.model.XiajiSHModel;

import io.reactivex.functions.Consumer;

public class XiajiSHPresenter extends BasePresenter<XiajiSHContract.View> implements XiajiSHContract.Presenter {
    private XiajiSHContract.Model model;

    public XiajiSHPresenter() {
        model = new XiajiSHModel();
    }

    @Override
    public void getData(String id) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(id).compose(RxScheduler.<AgencySellerListBean>Flo_io_main())
                .subscribe(new Consumer<AgencySellerListBean>() {
                    @Override
                    public void accept(AgencySellerListBean bean) throws Exception {
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
