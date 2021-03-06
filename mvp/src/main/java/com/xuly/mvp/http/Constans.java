package com.xuly.mvp.http;

public class Constans {
    public final static String BaseUrl = "http://192.168.1.161:8080/hw/";
    public final static String BaseOriginUrl = "http://192.168.1.161:8080";
//    public final static  String BaseUrl = "http://39.97.209.220/";
//    public final static  String BaseOriginUrl = "http://39.97.209.220";
//    public final static  String BaseUrl = "https://www.dxlinshigong.com/";
//    public final static  String BaseOriginUrl = "https://www.dxlinshigong.com";
    //微信配置
    public static final String WX_APP_ID = "wxe78fde148557cb37";
    public static final String WX_PAY_APP_KEY = "dxlinshigondudududu0311123456789";
    public final static String getLoginToken = "f/api/fw/login";
    public final static String register = "f/api/fw/register";
    public final static String sendMessage = "f/api/px/sendTel";
    public final static String forgetPassword = "f/api/fw/forgetPassword";
    public final static String getAreaList = "f/api/px/getAreaList";//城市列表
    public final static String getTplbList = "f/api/px/getTplbList";//轮播列表
    public final static String getTztgList = "f/api/px/getTztgList";//通告列表
    public final static String getKcOneList = "f/api/px/getKcOneList";//首页课程列表
    public final static String getTztgById = "f/api/px/getTztgById";//通告详情
    public final static String getFwglList = "f/api/px/getFwglList";//服务大类
    public final static String getFwxlList = "f/api/gz/getFwxlList";//服务小类列表
    public final static String getYzfwList = "f/api/gz/getYzfwList";//优质服务
    public final static String getDbthList = "f/api/gz/getDbthList";//打包特惠
    public final static String getYyzqList = "f/api/gz/getYyzqList";//预约专区
    public final static String getQbflList = "f/api/gz/getQbflList";//服务全部类别列表
    public final static String getMyfwList = "f/api/fw/getMyfwList";//上传资质完成查询状态
    public final static String delFuwuById = "f/api/fw/delFuwuById";//删除服务
    public final static String saveFwryzz = "f/api/fw/saveFwryzz";//上传资质
    public final static String getfwxlById = "f/api/gz/getfwxlById";//服务详情
    public final static String getDbthById = "f/api/gz/getDbthById";//打包特惠详情
    public final static String getJsfwByName = "f/api/gz/getJsfwByName";//服务检索
    public final static String getKcByName = "f/api/px/getKcByName";//课程检索
    public final static String getServerType = "f/api/gz/getServerType";//服务小类发布需求时的类别
    public final static String getXqnrByCode = "f/api/gz/getXqnrByCode";//服务小类发布需求时的类别
    public final static String getYgjgByCode = "f/api/gz/getYgjgByCode";//预估价格
    public final static String saveMyAddress = "f/api/gz/saveMyAddress";//新增地址
    public final static String editMyAddress = "f/api/gz/updateMyAddressById";//新增地址
    public final static String deleteMyAddressById = "f/api/gz/deleteMyAddressById";//删除地址
    public final static String updateMrdzById = "f/api/gz/updateMrdzById";//设置默认地址
    public final static String getWddzList = "f/api/gz/getWddzList";//我的地址列表
    public final static String saveLjgm = "f/api/gz/saveLjgm";//提交订单
    public final static String getDingdanList = "f/api/gz/getDingdanList";//查询订单列表
    public final static String getSsDingdanList = "f/api/gz/getSsDingdanList";//查询实时订单列表
    public final static String getYjDingdanList = "f/api/gz/getYjDingdanList";//查询已接订单列表
    public final static String getDingdanById = "f/api/gz/getDingdanById";//查询订单详情
    public final static String getDdxqById = "f/api/gz/getDdxqById";//查询订单详情新
    public final static String getFwDdxqById = "f/api/fw/getFwDdxqById";//查询订单详情新——服务端
    public final static String getDddk = "f/api/gz/getDddk";//查询订单抵扣
    public final static String updaterQxType = "f/api/gz/updaterQxType";//取消订单
    public final static String updaterDingdanStatus = "f/api/gz/updaterDingdanStatus";//更新订单状态
    public final static String saveDingdanServer = "f/api/gz/saveDingdanServer";//更新订单状态（有意向）
    public final static String getFwryByid = "f/api/fw/getFwryByid";//获取个人信息
    public final static String getFwryxxById = "f/api/gz/getFwryxxById";//获取个人信息-新
    public final static String getJfList = "f/api/fw/getJfList";//我的积分
    public final static String getZfbtList = "f/api/fw/getZfbtList";//我的补贴
    public final static String getZdlsList = "f/api/fw/getZdlsList";//我的账单流水
    public final static String updateFwryxx = "f/api/fw/updateFwryxx";//修改个人信息
    public final static String getAbout = "f/api/px/getJzConfig";//关于我们
    public final static String getLevelType = "f/api/gz/getLevelType";//获取VIP等级
    public final static String getDingdanServerList = "f/api/gz/getDingdanServerList";//选择服务人员
    public final static String updaterDingdanServer = "f/api/gz/updaterDingdanServer";//指定接单人员

    public final static String getQbkcList = "f/api/px/getQbkcList";//获取所有分类课程
    public final static String getKcTwoList = "f/api/px/getKcTwoList";//小类课程列表
    public final static String getWdscList = "f/api/px/getWdscList";//收藏课程列表
    public final static String getKcById = "f/api/px/getKcById";//获取课程详情
    public final static String saveKcsc = "f/api/px/saveKcsc";//收藏
    public final static String delKcscByKcId = "f/api/px/delKcscByKcId";//取消收藏
    public final static String getCardList = "f/api/fw/getCardList";//银行卡列表
    public final static String saveCard = "f/api/fw/saveCard";//添加银行卡
    public final static String updateCard = "f/api/fw/updateCard";//编辑银行卡
    public final static String getCardById = "f/api/fw/getCardById";//查询银行卡详情
    public final static String delcardById = "f/api/fw/delCardById";//删除银行卡
    public final static String getBank = "f/api/fw/getBank";//银行卡
    public final static String saveJwd = "f/api/fw/saveJwd";//上传经纬度
    public final static String getJwd = "f/api/gz/getJwd";//获取最新经纬度
    public final static String saveDdzf = "f/api/gz/saveDdzf";//订单支付
    public final static String getSfscwz = "f/api/fw/getSfscwz";//是否需要上传位置
    public final static String upper = "f/api/fw/upper";//上线
    public final static String lower = "f/api/fw/lower";//下线
    public final static String getPjDictList = "f/api/gz/getPjDictList";//评价字典列表
    public final static String saveDdpj = "f/api/gz/saveDdpj";//保存评价
    public final static String alipay = "f/apix/pay/alipay/addSignature";
    public final static String getYhjList = "f/api/gz/getYhjList";//我的优惠券列表
    public final static String getJzPicture = "f/api/fw/getJzPicture";//我的优惠券列表
    public final static String saveTxsq = "f/api/fw/saveTxsq";//提现
    public final static String updateUserSjqx = "f/api/fw/updateUserSjqx";//更新城市
    public final static String updateAppmodel = "f/api/fw/updateAppmodel";//手机型号
    public final static String getGxbbById = "f/api/gj/getGxbbById";//版本升级
    public final static String findTxsqList = "f/api/fw/findTxsqList";//我的提现列表
    public final static String updateUserApptype = "f/api/fw/updateUserApptype";//修改APP类型
    public final static String getUserList = "f/api/fw/getUserList";//查询联系电话列表
    public final static String callPhone = "f/api/fw/callPhone";//查询虚拟号码
    public final static String getChiefStatus = "f/api/fw/getChiefStatus";//查询是否为团长
    public final static String saveNewChiefStatus = "f/api/fw/saveNewChiefStatus";//申请成为团长
    public static final int DEFAULT_TIME=10;
    //人脸识别key
    public static final String APP_ID = "GFXV9cNAcepGBj7FmcXD2U2uPRFXBxty4zZgfYfdXEug";
    public static final String SDK_KEY = "3rqaUvuV15TLGwPvqM45tKd7beFKe4RTkPrae46cRq9g";
    //轨迹服务
    public static final long SERVICE_ID = 176378;
    public static final String TERMINAL_NAME = "test_terminal_name";
}
