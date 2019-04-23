package com.xiaomai.ageny.task.direct_task.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.task.direct_task.contract.TaskDirectContract;
import com.xiaomai.ageny.task.direct_task.model.TaskDirectModel;

import io.reactivex.functions.Consumer;

public class TaskDirectPresenter extends BasePresenter<TaskDirectContract.View> implements TaskDirectContract.Presenter {
    private TaskDirectContract.Model model;
    public TaskDirectPresenter() {
        model=new TaskDirectModel();
    }

    @Override
    public void getData(String sellername, String linkmobile, String deviceid, String state) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(sellername, linkmobile, deviceid,state).compose(RxScheduler.<OffDirectDeviceBean>Flo_io_main())
                .subscribe(new Consumer<OffDirectDeviceBean>() {
                    @Override
                    public void accept(OffDirectDeviceBean bean) throws Exception {
                        mView.onSuccess(bean);
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
