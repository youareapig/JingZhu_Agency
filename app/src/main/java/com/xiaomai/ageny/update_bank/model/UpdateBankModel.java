package com.xiaomai.ageny.update_bank.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.update_bank.contract.UpdateBankContract;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class UpdateBankModel implements UpdateBankContract.Model {
    @Override
    public Flowable<HintBean> updateBank(RequestBody body) {
        return RetrofitClient.getInstance().getApi().updateBank(body);
    }
}
