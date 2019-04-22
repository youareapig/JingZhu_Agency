package com.xiaomai.ageny.update_bank.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.update_bank.contract.UpdateBankContract;
import com.xiaomai.ageny.update_bank.model.UpdateBankModel;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class UpdateBankPresenter extends BasePresenter<UpdateBankContract.View> implements UpdateBankContract.Presenter {
    private UpdateBankContract.Model model;

    public UpdateBankPresenter() {
        model = new UpdateBankModel();
    }

    @Override
    public void updateBank(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        model.updateBank(body).compose(RxScheduler.<HintBean>Flo_io_main())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
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
