package com.xiaomai.ageny.net;


import com.xiaomai.ageny.bean.AddAgencyBean;
import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencySellerListBean;
import com.xiaomai.ageny.bean.AgencyUpdateBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.ContactDetailsBean;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.bean.ContactListBean;
import com.xiaomai.ageny.bean.ContactUpdateUserInfoBean;
import com.xiaomai.ageny.bean.ContactUserInfoBean;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.bean.HisSellerBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.LowerOrderBean;
import com.xiaomai.ageny.bean.LowerOrderDetailsBean;
import com.xiaomai.ageny.bean.MyOrderDetailsBean;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;
import com.xiaomai.ageny.bean.TelToNameBean;
import com.xiaomai.ageny.bean.UserInfoBean;
import com.xiaomai.ageny.bean.XiajiListBean;

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

    //离线设备列表（直属设备）
    @GET(urlhead + "agentCenter/directlyequipment")
    Flowable<OffDirectDeviceBean> getDirectListBean(
            @Query("sellername") String sellername,
            @Query("linkmobile") String linkmobile,
            @Query("deviceid") String deviceid);

    //离线设备列表（非直属设备）
    @GET(urlhead + "agentCenter/nodirecte/quipment")
    Flowable<OffIndirectDeivceBean> getInDirectListBean(
            @Query("agentname") String agentname,
            @Query("agentmobile") String agentmobile,
            @Query("deviceid") String deviceid);

    //离线设备详情（非直属设备）
    @GET(urlhead + "agentCenter/nodirecte/quipment/details ")
    Flowable<OffIndirectDeivceDetailsBean> getInDirectDetailsBean(
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

    //添加商户
    @POST(urlhead + "agentCenter/seller/add")
    Flowable<ContactUpdateUserInfoBean> addContanct(@Body RequestBody requestBody);

    //代理列表 1、直属  0、非直属
    @GET(urlhead + "agentCenter/agent/list")
    Flowable<DailiListBean> getDailiListBean(
            @Query("mobile") String mobile,
            @Query("deviceid") String deviceid,
            @Query("grade") String grade,
            @Query("directly") String directly,
            @Query("isbytime") String isbytime);

    //代理详情
    @GET(urlhead + "agentCenter/agent/details")
    Flowable<AgencyDetailsBean> getAgencyDetials(
            @Query("agentid") String agentid);

    //他的商户
    @GET(urlhead + "agentCenter/agent/seller/HisSeller")
    Flowable<HisSellerBean> getHisSellerBean(
            @Query("agentid") String agentid);

    //代理个人资料
    @GET(urlhead + "agentCenter/agent/info")
    Flowable<AgencyUserInfoBean> getAgencyUserInfo(
            @Query("agentid") String agentid);

    //代理修改资料
    @POST(urlhead + "agentCenter/agent/save")
    Flowable<AgencyUpdateBean> AgencyUpdate(@Body RequestBody requestBody);

    //此代理的商户列表
    @GET(urlhead + "agentCenter/agent/seller/list ")
    Flowable<AgencySellerListBean> getAgencySellerListBean(
            @Query("id") String id);

    //越级查看此商户的设备情况 1，在线  2，离线
    @GET(urlhead + "agentCenter/agent/seller/device/list")
    Flowable<XiajiListBean> getXiajiListBean(
            @Query("id") String id,
            @Query("deviceid") String deviceid,
            @Query("dentails") String dentails,
            @Query("state") String state);

    //添加代理
    @POST(urlhead + "agentCenter/agent/add")
    Flowable<AddAgencyBean> AddAgency(@Body RequestBody requestBody);

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

    //我的订单列表
    @GET(urlhead + "agentCenter/agent/Order")
    Flowable<MyOrderBean> getMyOrderListBean(@Query("orderid") String orderid,
                                             @Query("sellername") String sellername,
                                             @Query("startTime") String startTime,
                                             @Query("endTime") String endTime,
                                             @Query("page") String page,
                                             @Query("page_size") String pagesize);


    //下级订单列表
    @GET(urlhead + "agentCenter/agent/lowerorders")
    Flowable<LowerOrderBean> getLowerOrderListBean(@Query("orderid") String orderid,
                                                   @Query("sellername") String sellername,
                                                   @Query("startTime") String startTime,
                                                   @Query("endTime") String endTime,
                                                   @Query("page") String page,
                                                   @Query("page_size") String pagesize);

    //我的订单详情
    @GET(urlhead + "agentCenter/agent/Orderdetails")
    Flowable<MyOrderDetailsBean> getMyOrderDetailsBean(@Query("orderid") String orderid);

    //下级订单详情
    @GET(urlhead + "agentCenter/agent/lowerordersDetails")
    Flowable<LowerOrderDetailsBean> getLowerOrderDetailsBean(@Query("orderid") String orderid);

    //手机号显示姓名
    @GET(urlhead + "agentCenter/seller/info")
    Flowable<TelToNameBean> getTelName(@Query("mobile") String mobile);
}

