package com.xiaomai.ageny.system_notice.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.SystemNoticeBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.system_notice.contract.SystemNoticeContract;
import com.xiaomai.ageny.system_notice.model.SystemNoticeModel;

import io.reactivex.functions.Consumer;

public class SystemNoticePresenter extends BasePresenter<SystemNoticeContract.View> implements SystemNoticeContract.Presenter {
    private SystemNoticeContract.Model model;

    public SystemNoticePresenter() {
        model = new SystemNoticeModel();
    }

    @Override
    public void getData(String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(page, pagesize).compose(RxScheduler.<SystemNoticeBean>Flo_io_main())
                .subscribe(new Consumer<SystemNoticeBean>() {
                    @Override
                    public void accept(SystemNoticeBean bean) throws Exception {
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

    @Override
    public void getDataFresh(String page, String pagesize) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(page, pagesize).compose(RxScheduler.<SystemNoticeBean>Flo_io_main())
                .subscribe(new Consumer<SystemNoticeBean>() {
                    @Override
                    public void accept(SystemNoticeBean bean) throws Exception {
                        mView.onSuccessFresh(bean);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}