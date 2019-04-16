package com.xiaomai.ageny.fragment.index.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.IndexBean;
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
                        mView.onSuccess(indexBean);
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
