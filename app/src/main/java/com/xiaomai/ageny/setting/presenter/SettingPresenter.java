package com.xiaomai.ageny.setting.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.bean.MyBankBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.setting.contract.SettingContract;
import com.xiaomai.ageny.setting.model.SettingModel;

import io.reactivex.functions.Consumer;

public class SettingPresenter extends BasePresenter<SettingContract.View> implements SettingContract.Presenter {
    private SettingContract.Model model;

    public SettingPresenter() {
        model = new SettingModel();
    }

    @Override
    public void loginOut() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.loginOut().compose(RxScheduler.<LoginOutBean>Flo_io_main())
                .as(mView.<LoginOutBean>bindAutoDispose())
                .subscribe(new Consumer<LoginOutBean>() {
                    @Override
                    public void accept(LoginOutBean bean) throws Exception {
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
}
