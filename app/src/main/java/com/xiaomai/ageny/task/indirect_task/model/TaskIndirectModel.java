package com.xiaomai.ageny.task.indirect_task.model;

import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.task.indirect_task.contract.TaskIndirectContract;

import io.reactivex.Flowable;

public class TaskIndirectModel implements TaskIndirectContract.Model {
    @Override
    public Flowable<OffIndirectDeivceBean> getData(String agentname, String agentmobile, String deviceid, String state) {
        return RetrofitClient.getInstance().getApi().getInDirectListBean(agentname, agentmobile, deviceid,state);
    }
}
