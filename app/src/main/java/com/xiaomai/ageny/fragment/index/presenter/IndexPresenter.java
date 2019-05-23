package com.xiaomai.ageny.fragment.index.presenter;

import android.app.Activity;
import android.content.Context;

import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.ContactListBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.UpdateBean;
import com.xiaomai.ageny.bean.UserInfoBean;
import com.xiaomai.ageny.fragment.index.contract.IndexContract;
import com.xiaomai.ageny.fragment.index.model.IndexModel;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.utils.update.UpdateAppHttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.functions.Consumer;

public class IndexPresenter extends BasePresenter<IndexContract.View> implements IndexContract.Presenter {
    private IndexContract.Model model;

    public IndexPresenter() {
        model = new IndexModel();
    }

    @Override
    public void getData() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<IndexBean>Flo_io_main())
                .as(mView.<IndexBean>bindAutoDispose())
                .subscribe(new Consumer<IndexBean>() {
                    @Override
                    public void accept(IndexBean indexBean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(indexBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getData_Fresh() {
        if (!isViewAttached()) {
            return;
        }
        model.getData().compose(RxScheduler.<IndexBean>Flo_io_main())
                .as(mView.<IndexBean>bindAutoDispose())
                .subscribe(new Consumer<IndexBean>() {
                    @Override
                    public void accept(IndexBean indexBean) throws Exception {
                        mView.onSuccess_Fresh(indexBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getConfigBean() {
        if (!isViewAttached()) {
            return;
        }
        model.getConfigBean().compose(RxScheduler.<ConfigBean>Flo_io_main())
                .as(mView.<ConfigBean>bindAutoDispose())
                .subscribe(new Consumer<ConfigBean>() {
                    @Override
                    public void accept(ConfigBean bean) throws Exception {
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }

    @Override
    public void getUpdate(String type) {
        if (!isViewAttached()) {
            return;
        }
        model.getUpdate(type).compose(RxScheduler.<UpdateBean>Flo_io_main())
                .as(mView.<UpdateBean>bindAutoDispose())
                .subscribe(new Consumer<UpdateBean>() {
                    @Override
                    public void accept(UpdateBean bean) throws Exception {
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }

    @Override
    public void updateMethod(Activity activity) {
        new UpdateAppManager.Builder()
                .setActivity(activity)
                .setUpdateUrl("https://www.jzcdsc.com/chargeAgent-0.0.1-SNAPSHOT/agentCenter/account/version/update?type=1")
                .setHttpManager(new UpdateAppHttpUtil())
                .setTopPic(R.mipmap.top_8)
                .build()
                .checkNewApp(new UpdateCallback() {
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        UpdateAppBean updateAppBean = new UpdateAppBean();
                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            updateAppBean
                                    //（必须）是否更新Yes,No
                                    .setUpdate(jsonObject.optString("udate"))
                                    //（必须）新版本号，
                                    .setNewVersion(jsonObject.optString("newVersion"))
                                    //（必须）下载地址
                                    .setApkFileUrl(jsonObject.optString("apkFileUrl"))
                                    //（必须）更新内容
                                    .setUpdateLog(jsonObject.optString("updateLog"))
                                    //大小，不设置不显示大小，可以不设置
                                    .setTargetSize(jsonObject.optString("targetSize"))
                                    //是否强制更新，可以不设置constraint  true是强制  false是非强制
                                    .setConstraint(jsonObject.optBoolean("cons"))
                                    //设置md5，可以不设置
                                    .setNewMd5(jsonObject.optString("newMd5"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return updateAppBean;
                    }

                });

    }

    @Override
    public void getAlias() {
        if (!isViewAttached()) {
            return;
        }
        model.getAlias().compose(RxScheduler.<UserInfoBean>Flo_io_main())
                .as(mView.<UserInfoBean>bindAutoDispose())
                .subscribe(new Consumer<UserInfoBean>() {
                    @Override
                    public void accept(UserInfoBean bean) throws Exception {
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
