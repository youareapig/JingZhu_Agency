package com.xiaomai.ageny.offline.fragment.indirect.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.offline.fragment.indirect.contract.IndirectContract;
import com.xiaomai.ageny.offline.fragment.indirect.model.IndirectModel;

import io.reactivex.functions.Consumer;

public class IndirectPresenter extends BasePresenter<IndirectContract.View> implements IndirectContract.Presenter {
    private IndirectContract.Model model;

    public IndirectPresenter() {
        model = new IndirectModel();
    }

    @Override
    public void getData(String agentname, String agentmobile, String deviceid, String state) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(agentname, agentmobile, deviceid, state).compose(RxScheduler.<OffIndirectDeivceBean>Flo_io_main())
                .subscribe(new Consumer<OffIndirectDeivceBean>() {
                    @Override
                    public void accept(OffIndirectDeivceBean bean) throws Exception {
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
    public void getData_Fresh(String agentname, String agentmobile, String deviceid, String state) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(agentname, agentmobile, deviceid, state).compose(RxScheduler.<OffIndirectDeivceBean>Flo_io_main())
                .subscribe(new Consumer<OffIndirectDeivceBean>() {
                    @Override
                    public void accept(OffIndirectDeivceBean bean) throws Exception {
                        mView.onSuccess_Fresh(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}
