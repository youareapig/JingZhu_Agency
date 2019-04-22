package com.xiaomai.ageny.add_staff.model;

import com.xiaomai.ageny.add_staff.contract.AddStaffContract;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class AddStaffModel implements AddStaffContract.Model {
    @Override
    public Flowable<HintBean> addStaff(RequestBody body) {
        return RetrofitClient.getInstance().getApi().addStaff(body);
    }
}
