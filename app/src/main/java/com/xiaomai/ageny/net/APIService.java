package com.xiaomai.ageny.net;


import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.ContactDetailsBean;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.bean.ContactListBean;
import com.xiaomai.ageny.bean.ContactUpdateUserInfoBean;
import com.xiaomai.ageny.bean.ContactUserInfoBean;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.OffDeviceBean;
import com.xiaomai.ageny.bean.UserInfoBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public interface APIService {
    //    public String urlhead = "chargeAgent-0.0.1-SNAPSHOT/";
    public String urlhead = "";

    //首页
    @GET(urlhead + "agentCenter/homepage")
    Flowable<IndexBean> getIndexBean();

    //离线设备（直属设备）
    @GET(urlhead + "agentCenter/directlyequipment")
    Flowable<OffDeviceBean> getDirectListBean(
            @Query("sellername") String sellername,
            @Query("linkmobile") String linkmobile,
            @Query("deviceid") String deviceid);

    //商户列表
    @GET(urlhead + "agentCenter/seller/list")
    Flowable<ContactListBean> getContactList(
            @Query("mobile") String mobile,
            @Query("sellerId") String linkmobile,
            @Query("isbyearn") String isbyearn);

    //商户详情
    @GET(urlhead + "agentCenter/seller/details")
    Flowable<ContactDetailsBean> getContactDetailsBean(
            @Query("sellerid") String sellerid);

    //商户详情用户资料
    @GET(urlhead + "agentCenter/seller/info")
    Flowable<ContactUserInfoBean> getContactUserInfoBean(
            @Query("sellerid") String sellerid,
            @Query("mobile") String mobile);

    //商户设备列表详情 在线设备 离线设备
    @GET(urlhead + "agentCenter/seller/device/list")
    Flowable<ContactDeviceListBean> getContactDeviceListBean(
            @Query("sellerid") String sellerid,
            @Query("state") String state,
            @Query("deviceid") String deviceid,
            @Query("device_type") String device_type);

    //商户设备详情
    @GET(urlhead + "agentCenter/device/info")
    Flowable<ContactDeviceDetailsBean> getContactDeviceDetailsBean(
            @Query("deviceid") String deviceid);

    //修改商户资料
    @POST(urlhead + "agentCenter/seller/save")
    Flowable<ContactUpdateUserInfoBean> contactUpdateUserInfo(@Body RequestBody requestBody);

    //添加商户资料
    @POST(urlhead + "agentCenter/seller/add")
    Flowable<ContactUpdateUserInfoBean> addContanct(@Body RequestBody requestBody);

    //设备部署列表
    @GET(urlhead + "agentCenter/homepage/install/list")
    Flowable<DeviceInstallListBean> getDeviceInstallListBean(
            @Query("seller_mobile") String chiyou,
            @Query("install_mobile") String anzhuang,
            @Query("filler_time") String time);

    //设备部署列表加载更多
    @GET(urlhead + "agentCenter/homepage/install/list")
    Flowable<DeviceInstallListBean> getDeviceInstallListBean_Refresh(
            @Query("page") int page,
            @Query("seller_mobile") String chiyou,
            @Query("install_mobile") String anzhuang,
            @Query("filler_time") String time);

    //个人中心，用户资料
    @GET(urlhead + "agentCenter/user/info")
    Flowable<UserInfoBean> getUserInfo();

    //账单列表
    @GET(urlhead + "agentCenter/user/bill/list")
    Flowable<BillListBean> getBillList();

    //冻结设备情况
    @GET(urlhead + "agentCenter/user/device/freeze")
    Flowable<FreezeBean> getFreezeListData(
            @Query("filler_state") String filler_state,
            @Query("filler_deviceid") String filler_deviceid,
            @Query("filler_relation") String filler_relation);

}

