package com.xiaomai.ageny.login.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.LoginBean;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.login.contract.LoginContract;
import com.xiaomai.ageny.login.model.LoginModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private LoginContract.Model model;

    public LoginPresenter() {
        model = new LoginModel();
    }

    @Override
    public void login(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(body).compose(RxScheduler.<LoginBean>Flo_io_main())
                .as(mView.<LoginBean>bindAutoDispose())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean bean) throws Exception {
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
    public void getCode(String mobile) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getCode(mobile).compose(RxScheduler.<VerCodeBean>Flo_io_main())
                .as(mView.<VerCodeBean>bindAutoDispose())
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
}
