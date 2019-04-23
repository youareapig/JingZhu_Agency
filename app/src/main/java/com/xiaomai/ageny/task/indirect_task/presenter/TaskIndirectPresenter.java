package com.xiaomai.ageny.task.indirect_task.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.task.indirect_task.contract.TaskIndirectContract;
import com.xiaomai.ageny.task.indirect_task.model.TaskIndirectModel;

import io.reactivex.functions.Consumer;

public class TaskIndirectPresenter extends BasePresenter<TaskIndirectContract.View> implements TaskIndirectContract.Presenter {
    private TaskIndirectContract.Model model;
    public TaskIndirectPresenter() {
        model=new TaskIndirectModel();
    }

    @Override
    public void getData(String agentname, String agentmobile, String deviceid, String state) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(agentname, agentmobile, deviceid,state).compose(RxScheduler.<OffIndirectDeivceBean>Flo_io_main())
                .subscribe(new Consumer<OffIndirectDeivceBean>() {
                    @Override
                    public void accept(OffIndirectDeivceBean bean) throws Exception {
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
