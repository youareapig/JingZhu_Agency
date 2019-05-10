package com.xiaomai.ageny.unbundle.unbundle_record.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.UnbindRecordBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.unbundle.unbundle_record.contract.UnbundleRecordContract;
import com.xiaomai.ageny.unbundle.unbundle_record.model.UnbundleRecordModel;

import io.reactivex.functions.Consumer;

public class UnbundleRecordPresenter extends BasePresenter<UnbundleRecordContract.View> implements UnbundleRecordContract.Presenter {
    private UnbundleRecordContract.Model model;

    public UnbundleRecordPresenter() {
        model = new UnbundleRecordModel();
    }

    @Override
    public void getData(String page, String page_size, String linkman, String linkmobile) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(page, page_size, linkman, linkmobile).compose(RxScheduler.<UnbindRecordBean>Flo_io_main())
                .as(mView.<UnbindRecordBean>bindAutoDispose())
                .subscribe(new Consumer<UnbindRecordBean>() {
                    @Override
                    public void accept(UnbindRecordBean bean) throws Exception {
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
    public void getDataFresh(String page, String page_size, String linkman, String linkmobile) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(page, page_size, linkman, linkmobile).compose(RxScheduler.<UnbindRecordBean>Flo_io_main())
                .as(mView.<UnbindRecordBean>bindAutoDispose())
                .subscribe(new Consumer<UnbindRecordBean>() {
                    @Override
                    public void accept(UnbindRecordBean bean) throws Exception {
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
