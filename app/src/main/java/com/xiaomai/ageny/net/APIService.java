package com.xiaomai.ageny.net;


import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.DepositListBean;
import com.xiaomai.ageny.bean.DeviceAllotListBean;
import com.xiaomai.ageny.bean.DeviceManageBean;
import com.xiaomai.ageny.bean.DeviceWithDrawListBean;
import com.xiaomai.ageny.bean.FreezeDetailsBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencySellerListBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.ContactDetailsBean;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.bean.ContactListBean;
import com.xiaomai.ageny.bean.ContactUserInfoBean;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.bean.HisSellerBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.LoginBean;
import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.bean.LowerOrderBean;
import com.xiaomai.ageny.bean.LowerOrderDetailsBean;
import com.xiaomai.ageny.bean.MyBankBean;
import com.xiaomai.ageny.bean.MyOrderDetailsBean;
import com.xiaomai.ageny.bean.NoAllotDeviceBean;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;
import com.xiaomai.ageny.bean.ShopApplyBean;
import com.xiaomai.ageny.bean.ShopBean;
import com.xiaomai.ageny.bean.ShopRecordBean;
import com.xiaomai.ageny.bean.ShowHoleBean;
import com.xiaomai.ageny.bean.StaffBean;
import com.xiaomai.ageny.bean.TelBean;
import com.xiaomai.ageny.bean.TelToNameBean;
import com.xiaomai.ageny.bean.UnbindRecordBean;
import com.xiaomai.ageny.bean.UpdateBean;
import com.xiaomai.ageny.bean.UserInfoBean;
import com.xiaomai.ageny.bean.VerCodeBean;
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

    //获取验证码
    @GET(urlhead + "agentCenter/account/captcha")
    Flowable<VerCodeBean> getVercode(
            @Query("mobile") String mobile);

    //获取解绑验证码
    @GET(urlhead + "agentCenter/account/captcha/seller")
    Flowable<VerCodeBean> getVercodeUnbundle(
            @Query("mobile") String mobile);

    //系统配置
    @GET(urlhead + "agentCenter/user/system/config")
    Flowable<ConfigBean> getConfig();

    //用户登录
    @POST(urlhead + "agentCenter/account/loginAPP")
    Flowable<LoginBean> loginBean(@Body RequestBody requestBody);

    //退出登录
    @POST(urlhead + "agentCenter/account/logout")
    Flowable<LoginOutBean> loginOutBean();

    //首页
    @GET(urlhead + "agentCenter/homepage")
    Flowable<IndexBean> getIndexBean();

    //离线设备列表（直属设备）
    @GET(urlhead + "agentCenter/directlyequipment")
    Flowable<OffDirectDeviceBean> getDirectListBean(
            @Query("sellername") String sellername,
            @Query("linkmobile") String linkmobile,
            @Query("deviceid") String deviceid,
            @Query("state") String state);

    //离线设备列表（非直属设备）
    @GET(urlhead + "agentCenter/nodirecte/quipment")
    Flowable<OffIndirectDeivceBean> getInDirectListBean(
            @Query("agentname") String agentname,
            @Query("agentmobile") String agentmobile,
            @Query("deviceid") String deviceid,
            @Query("state") String state);

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
    Flowable<HintBean> contactUpdateUserInfo(@Body RequestBody requestBody);

    //添加商户
    @POST(urlhead + "agentCenter/seller/add")
    Flowable<HintBean> addContanct(@Body RequestBody requestBody);

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
    Flowable<HintBean> AgencyUpdate(@Body RequestBody requestBody);

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
    Flowable<HintBean> AddAgency(@Body RequestBody requestBody);

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

    //冻结设备情况 冻结设备详情
    @GET(urlhead + "agentCenter/user/device/freeze")
    Flowable<FreezeBean> getFreezeListData(
            @Query("filler_state") String filler_state,
            @Query("filler_deviceid") String filler_deviceid,
            @Query("filler_relation") String filler_relation);


    //冻结设备代理关系列表
    @GET(urlhead + "agentCenter/user/device/details")
    Flowable<FreezeDetailsBean> getFreezeDetailsBean(@Query("deviceid") String deviceid);

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

    //部署设备
    @POST(urlhead + "agentCenter/homepage/install")
    Flowable<HintBean> deployDevice(@Body RequestBody requestBody);

    //申请提现
    @POST(urlhead + "admin/withdrow")
    Flowable<HintBean> dePosit(@Body RequestBody requestBody);

    //解绑商户
    @POST(urlhead + "agentCenter/device/deleteSeller")
    Flowable<HintBean> getUnbundleContanctBean(@Body RequestBody requestBody);

    //解绑设备
    @POST(urlhead + "agentCenter/device/delete")
    Flowable<HintBean> deviceDelete(@Body RequestBody requestBody);

    //提现记录
    @GET(urlhead + "agentCenter/user/withdraw/list")
    Flowable<DepositListBean> getDepositListBean(@Query("page") String page,
                                                 @Query("page_size") String page_size,
                                                 @Query("state") String state,
                                                 @Query("orderid") String orderid,
                                                 @Query("price_start") String price_start,
                                                 @Query("price_end") String price_end);

    //我的银行卡
    @GET(urlhead + "agentCenter/user/creditCard")
    Flowable<MyBankBean> getMyBankBean();

    //添加银行卡
    @POST(urlhead + "agentCenter/user/creditCard/add")
    Flowable<HintBean> addBank(@Body RequestBody requestBody);

    //修改银行卡信息
    @POST(urlhead + "agentCenter/user/creditCard/save")
    Flowable<HintBean> updateBank(@Body RequestBody requestBody);

    //获取员工列表
    @GET(urlhead + "agentCenter/user/agent/list")
    Flowable<StaffBean> getStaffListBean(@Query("page") String page, @Query("page_size") String page_size);

    //删除员工
    @POST(urlhead + "agentCenter/user/agent/delete")
    Flowable<HintBean> deleteStaff(@Body RequestBody requestBody);

    //添加员工
    @POST(urlhead + "agentCenter/user/agent/add")
    Flowable<HintBean> addStaff(@Body RequestBody requestBody);

    //获取商户解绑记录
    @GET(urlhead + "agentCenter/user/seller/unbindcord")
    Flowable<UnbindRecordBean> getUnbindRecordBean(@Query("page") String page,
                                                   @Query("page_size") String page_size,
                                                   @Query("linkman") String linkman,
                                                   @Query("linkmobile") String linkmobile);

    //采购单列表
    @GET(urlhead + "agentCenter/user/application/list")
    Flowable<ShopRecordBean> getShopRecordListBean(@Query("bath") String bath,
                                                   @Query("mobile") String mobile,
                                                   @Query("page") String page,
                                                   @Query("page_size") String page_size);

    //申请记录列表
    @GET(urlhead + "agentCenter/user/records/list")
    Flowable<ShopApplyBean> getShopApplyBean(@Query("bath") String bath,
                                             @Query("state") String state,
                                             @Query("mobile") String mobile,
                                             @Query("page") String page,
                                             @Query("page_size") String page_size);

    //申请记录和采购单详情
    @GET(urlhead + "agentCenter/user/records/details")
    Flowable<ShopBean> getShopDetails(@Query("receiptId") String receiptId);

    //提交采购单
    @POST(urlhead + "agentCenter/user/purchase/order")
    Flowable<HintBean> goShop(@Body RequestBody requestBody);

    //设备管理首页
    @GET(urlhead + "agentCenter/user/device/management")
    Flowable<DeviceManageBean> getDeviceManageBean();

    //未分配设备
    @GET(urlhead + "agentCenter/user/undis/device")
    Flowable<NoAllotDeviceBean> getNoAllotDeviceBean(@Query("deviceid") String deviceid);

    //已分配设备
    @GET(urlhead + "agentCenter/user/undis/device/allocated")
    Flowable<AllotDeviceBean> getAllotDeviceBean(@Query("deviceid") String deviceid, @Query("mobile") String mobile);

    //显示充电宝孔数
    @GET(urlhead + "agentCenter/user/modal/Popup/details")
    Flowable<ShowHoleBean> showHole(@Query("deviceid") String deviceid);

    //弹出充电宝
    @GET(urlhead + "agentCenter/user/modal/Popup")
    Flowable<HintBean> popDevice(@Query("deviceid") String deviceid, @Query("slot") String slot);

    //设备撤回列表
    @GET(urlhead + "agentCenter/user/devicerecall/info")
    Flowable<DeviceWithDrawListBean> withDrawDeviceListBean(@Query("deviceid") String deviceid);

    //设备撤回
    @GET(urlhead + "agentCenter/user/recall")
    Flowable<HintBean> withDrawDeviceBean(@Query("deviceid") String deviceid);

    //设备分配列表
    @GET(urlhead + "agentCenter/user/deviced/bution/getsao")
    Flowable<DeviceAllotListBean> allotDeviceListBean(@Query("deviceid") String deviceid);

    //设备分配验证手机号
    @GET(urlhead + "agentCenter/user/mobile/getRealname")
    Flowable<TelBean> sureTel(@Query("mobile") String mobile);

    //设备分配提交
    @POST(urlhead + "agentCenter/user/deviced/bution")
    Flowable<HintBean> allotSubmit(@Body RequestBody requestBody);

    //app版本更新
    @GET(urlhead + "agentCenter/account/version/update")
    Flowable<UpdateBean> getUpdate();
}

