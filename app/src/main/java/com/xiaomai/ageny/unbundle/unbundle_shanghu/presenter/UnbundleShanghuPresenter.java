package com.xiaomai.ageny.unbundle.unbundle_shanghu.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.unbundle.unbundle_shanghu.contract.UnbundleShanghuContract;
import com.xiaomai.ageny.unbundle.unbundle_shanghu.model.UnbundleShanghuModel;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class UnbundleShanghuPresenter extends BasePresenter<UnbundleShanghuContract.View> implements UnbundleShanghuContract.Presenter {
    private UnbundleShanghuContract.Model model;

    public UnbundleShanghuPresenter() {
        model = new UnbundleShanghuModel();
    }

    @Override
    public void getCode(String mobile) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getCode(mobile).compose(RxScheduler.<VerCodeBean>Flo_io_main())
                .subscribe(new Consumer<VerCodeBean>() {
                    @Override
                    public void accept(VerCodeBean bean) throws Exception {
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

    @Override
    public void unbundleContanctBean(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.unbundleContanctBean(body).compose(RxScheduler.<HintBean>Flo_io_main())
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
