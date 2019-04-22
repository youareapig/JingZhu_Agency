package com.xiaomai.ageny.addbank.presenter;

import com.xiaomai.ageny.addbank.contract.BankContract;
import com.xiaomai.ageny.addbank.model.BankModel;
import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class BankPresenter extends BasePresenter<BankContract.View> implements BankContract.Presenter {
    private BankContract.Model model;

    public BankPresenter() {
        model=new BankModel();
    }

    @Override
    public void addBank(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.addBank(body).compose(RxScheduler.<HintBean>Flo_io_main())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
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
