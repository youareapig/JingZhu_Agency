package com.xiaomai.ageny.mybankcard.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.MyBankBean;
import com.xiaomai.ageny.mybankcard.contract.MyBankCardContract;
import com.xiaomai.ageny.mybankcard.model.MyBankCardModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class MyBankCardPresenter extends BasePresenter<MyBankCardContract.View> implements MyBankCardContract.Presenter {
    private MyBankCardContract.Model model;

    public MyBankCardPresenter() {
        model = new MyBankCardModel();
    }

    @Override
    public void getData() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<MyBankBean>Flo_io_main())
                .as(mView.<MyBankBean>bindAutoDispose())
                .subscribe(new Consumer<MyBankBean>() {
                    @Override
                    public void accept(MyBankBean bean) throws Exception {
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
}
