package com.xiaomai.ageny.staff_manage.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.StaffBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.staff_manage.contract.StaffManageContract;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class StaffManageModel implements StaffManageContract.Model {

    @Override
    public Flowable<StaffBean> getStaffListBean(String page, String page_size) {
        return RetrofitClient.getInstance().getApi().getStaffListBean(page, page_size);
    }

    @Override
    public Flowable<HintBean> staffDelete(RequestBody body) {
        return RetrofitClient.getInstance().getApi().deleteStaff(body);
    }
}
