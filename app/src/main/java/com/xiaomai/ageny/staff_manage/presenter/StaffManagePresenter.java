package com.xiaomai.ageny.staff_manage.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.StaffBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.staff_manage.contract.StaffManageContract;
import com.xiaomai.ageny.staff_manage.model.StaffManageModel;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class StaffManagePresenter extends BasePresenter<StaffManageContract.View> implements StaffManageContract.Presenter {
    private StaffManageContract.Model model;

    public StaffManagePresenter() {
        model = new StaffManageModel();
    }

    @Override
    public void getStaffListBean(String page, String page_size) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getStaffListBean(page, page_size).compose(RxScheduler.<StaffBean>Flo_io_main())
                .subscribe(new Consumer<StaffBean>() {
                    @Override
                    public void accept(StaffBean bean) throws Exception {
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
    public void getStaffListBeanFresh(String page, String page_size) {
        if (!isViewAttached()) {
            return;
        }
        model.getStaffListBean(page, page_size).compose(RxScheduler.<StaffBean>Flo_io_main())
                .subscribe(new Consumer<StaffBean>() {
                    @Override
                    public void accept(StaffBean bean) throws Exception {
                        mView.onSuccessFresh(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void staffDelete(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        model.staffDelete(body).compose(RxScheduler.<HintBean>Flo_io_main())
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
