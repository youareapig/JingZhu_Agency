package com.xiaomai.ageny.fragment.index.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.UpdateBean;
import com.xiaomai.ageny.fragment.index.contract.IndexContract;
import com.xiaomai.ageny.fragment.index.model.IndexModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class IndexPresenter extends BasePresenter<IndexContract.View> implements IndexContract.Presenter {
    private IndexContract.Model model;

    public IndexPresenter() {
        model = new IndexModel();
    }

    @Override
    public void getData() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<IndexBean>Flo_io_main())
                .subscribe(new Consumer<IndexBean>() {
                    @Override
                    public void accept(IndexBean indexBean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(indexBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getData_Fresh() {
        if (!isViewAttached()) {
            return;
        }
        model.getData().compose(RxScheduler.<IndexBean>Flo_io_main())
                .subscribe(new Consumer<IndexBean>() {
                    @Override
                    public void accept(IndexBean indexBean) throws Exception {
                        mView.onSuccess_Fresh(indexBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getConfigBean() {
        if (!isViewAttached()) {
            return;
        }
        model.getConfigBean().compose(RxScheduler.<ConfigBean>Flo_io_main())
                .subscribe(new Consumer<ConfigBean>() {
                    @Override
                    public void accept(ConfigBean bean) throws Exception {
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }

    @Override
    public void getUpdate() {
        if (!isViewAttached()) {
            return;
        }
        model.getUpdate().compose(RxScheduler.<UpdateBean>Flo_io_main())
                .subscribe(new Consumer<UpdateBean>() {
                    @Override
                    public void accept(UpdateBean bean) throws Exception {
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }
}
