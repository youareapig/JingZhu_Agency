package com.xiaomai.ageny.shop_manage.goshop.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.shop_manage.goshop.contract.GoShopContract;
import com.xiaomai.ageny.shop_manage.goshop.model.GoShopModel;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class GoShopPresenter extends BasePresenter<GoShopContract.View> implements GoShopContract.Presenter {
    private GoShopContract.Model model;

    public GoShopPresenter() {
        model = new GoShopModel();
    }

    @Override
    public void getData(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(body).compose(RxScheduler.<HintBean>Flo_io_main())
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
