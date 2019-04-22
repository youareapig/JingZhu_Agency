package com.xiaomai.ageny.add_staff.presenter;

import com.xiaomai.ageny.add_staff.contract.AddStaffContract;
import com.xiaomai.ageny.add_staff.model.AddStaffModel;
import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class AddStaffPresenter extends BasePresenter<AddStaffContract.View> implements AddStaffContract.Presenter {
    private AddStaffContract.Model model;

    public AddStaffPresenter() {
        model = new AddStaffModel();
    }

    @Override
    public void addStaff(RequestBody body) {
        if (!isViewAttached()) {
            return;
        }
        model.addStaff(body).compose(RxScheduler.<HintBean>Flo_io_main())
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
