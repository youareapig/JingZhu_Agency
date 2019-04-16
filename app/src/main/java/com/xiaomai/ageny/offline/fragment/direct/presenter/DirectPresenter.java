package com.xiaomai.ageny.offline.fragment.direct.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.OffDeviceBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.offline.fragment.direct.contract.DirectContract;
import com.xiaomai.ageny.offline.fragment.direct.model.DirectModel;

import io.reactivex.functions.Consumer;

public class DirectPresenter extends BasePresenter<DirectContract.View> implements DirectContract.Presenter {
    private DirectContract.Model model;
    public DirectPresenter() {
        model=new DirectModel();
    }

    @Override
    public void getData(String sellername, String linkmobile, String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(sellername, linkmobile, deviceid).compose(RxScheduler.<OffDeviceBean>Flo_io_main())
                .subscribe(new Consumer<OffDeviceBean>() {
                    @Override
                    public void accept(OffDeviceBean bean) throws Exception {
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
