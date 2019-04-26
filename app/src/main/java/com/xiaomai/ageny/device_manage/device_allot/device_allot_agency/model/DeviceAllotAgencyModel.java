package com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelBean;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.contract.DeviceAllotAgencyContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class DeviceAllotAgencyModel implements DeviceAllotAgencyContract.Model {
    @Override
    public Flowable<TelBean> sureTel(String tel) {
        return RetrofitClient.getInstance().getApi().sureTel(tel);
    }

    @Override
    public Flowable<HintBean> getData(RequestBody body) {
        return RetrofitClient.getInstance().getApi().allotSubmit(body);
    }
}
