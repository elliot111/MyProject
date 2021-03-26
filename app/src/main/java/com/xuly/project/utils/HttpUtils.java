package com.xuly.project.utils;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils {
    static OkHttpClient client;

    //我的关注
    public static String folowFollows = "https://api.qc1318.com/query/follow_follows/";
    //我的粉丝
    public static String folowFans = "https://api.qc1318.com/query/follow_fans/";

    //版本更新地址
    public static String UPDATE_URL = "https://img.qc1318.com/app/update.json";

    //获取用户token
    public static String Login_wanandroid_URL = "https://www.wanandroid.com/user/login";

    //获取用户token
    public static String Login_URL = "https://api.qc1318.com/api/bind/wx_open_id";
    //微信登录
    public static String WX_Login_URL = "https://api.qc1318.com/api/app/login/wechat";
    //微信登录绑定
    public static String WX_Login_Bind_URL = "https://api.qc1318.com/api/app/bind/wechat";
    //获取用户信息
    public static String UserInfo_URL = "https://api.qc1318.com/user/login_user_info";

    //保存用户信息
    public static String Save_UserInfo_URL = "https://api.qc1318.com/account/change-userinfo";
    //分享
    public static String Share_URL = "https://api.qc1318.com/share/add_share_num";

    //搜索教练接口
    public static String SearchCoach = "https://api.qc1318.com/search/personal?jobCode=0304";
    //查询个人信息接口
    public static String CoachInfo = "https://api.qc1318.com/detail/up/";
    public static String QueryIsguanzhu = "https://api.qc1318.com/user/is_follow";
    //查询可预约时间接口
    public static String BuyPay = "https://api.qc1318.com/order/confirm-user/";
    public static String AlreadyOrderCount="https://api.qc1318.com/order/status-count/complete/";

    //获取验证码接口
    public static String VerificationCode = "https://api.qc1318.com/api/sms/send_vcode_sms";
    //手机注册接口
    public static String Register_URL = "https://api.qc1318.com/api/signup/personal";
    //手机注册验证接口
    public static String Verification_Register_URL = "https://api.qc1318.com/signup/personal/validation";

    //激活手机号接口
    public static String Activation_URL = "https://api.qc1318.com/signup/personal/activation";

    //邀请获得金币接口
    public static String Yaoqing_URL = "https://api.qc1318.com/share/yaoqing_add_money";

    //获取用户所有预约时间
    public static String All_yuyue_URL = "https://api.qc1318.com/time/query/self";

    //获取当前用户某一天预约时间
    public static String Currentdate_Yuyue_URL = "https://api.qc1318.com/time/query/date/self";

    //获取下单用户预约时间
    public static String Order_Yuyue_URL = "https://api.qc1318.com/order/confirm-user";

    //查询我下的订单
    public static String Get_Order_URL = "https://api.qc1318.com/order/user/self";
    //查询我接的订单
    public static String Get_Coach_Order_URL = "https://api.qc1318.com/goods/user/self";

    //新增发布预约时间
    public static String Add_yuyue_URL = "https://api.qc1318.com/time/submit";

    //获取需求
    public static String Get_Demand = "https://api.qc1318.com/search/demand";

    //修改头像接口
    public static String Upload_Avatar_URL = "https://api.qc1318.com/api/user/upload/avatar";

    //上传日志接口
    public static String Upload_Log_URL = "https://api.qc1318.com/api/upload/applog";

    //实名认证接口
    public static String Upload_Renzheng_URL = "https://api.qc1318.com/audit/upload-realname";

    //查询余额接口
    public static String Query_Balance_URL = "https://api.qc1318.com/wallet/balance/self";

    //查询交易记录接口
    public static String Query_Balance_Detail_URL = "https://api.qc1318.com/wallet/detail/self";

    //下单接口
    public static String Post_Order_URL = "https://api.qc1318.com/order/place";

    //首页教练推荐
    //public static String CoachRecommend = "https://qc.luocat.com/search/personal?jobCode=0304&orderScore=DESC";

    //查询行业接口
    public static String Query_Industry_URL = "https://api.qc1318.com/industry/query/child";

    //查询区域接口
    public static String Query_Region_URL = "https://api.qc1318.com/region/query/child";

    //发布团队接口
    public static String Fabu_Team_URL = "https://api.qc1318.com/group/submit-or-update";

    //查询我所在团队接口
    public static String Query_My_AllTeam_URL = "https://api.qc1318.com/group/joined/self";

    //查询单个团队信息接口
    public static String Query_One_Team_URL = "https://api.qc1318.com/group/detail";

    //查询团队队员接口
    public static String Query_Team_people_URL = "https://api.qc1318.com/group/personnel";

    //邀请其他队员接口
    public static String Yaoqing_Team_people_URL = "https://api.qc1318.com/group/personnel/invite";

    //添加关注post
    public static String Guan_Zhu_Post = "https://api.qc1318.com/add_follow";

    //取消关注post
    public static String Cancel_Guan_Zhu_Post = "https://api.qc1318.com/cancel_follow";

    //获取资历
    public static String Zi_Zhi_GET = "https://api.qc1318.com/center/aptitude/self";

    //删除资质
    public static String Delete_Zi_Zhi_POSR = "https://api.qc1318.com/center/aptitude/delete";




    public static String post(String url, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                //.header("Content-Type","application/x-www-form-urlencoded")
                .post(body)
                .build();
        OkHttpClient client = getInstance();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
//                .header("AppKeyAuthorization", "hopen")
//                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();
        OkHttpClient client = getInstance();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String get(String url, int pageNum, int pageSize, String code) throws IOException {
        Request request = new Request.Builder()
                .url(url + "?pageNum=" + pageNum + "&pageSize=" + pageSize + "&jobCode=" + code)
                .build();

        OkHttpClient client = getInstance();
        try (Response response = client.newCall(request).execute()) {
            //Log.d("%%%%%%%%%",request);
            return response.body().string();
        }
    }


    public static String get(String url, String token, String keepCode, String userId) throws IOException {
        String URL;
        if (url.equals(HttpUtils.QueryIsguanzhu)) {
            URL = url + "?&tokenKey=" + token + "&KeepCode=" + keepCode + "&userId=" + userId;
        } else {
            URL = url + userId + "?&tokenKey=" + token + "&KeepCode=" + keepCode;
        }

        Request request = new Request.Builder()
                .url(URL)
                .build();
        OkHttpClient client = getInstance();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }



    public static synchronized OkHttpClient getInstance() {

        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }

    //by xuly 20180915
    public static String get_userinfo(String tokenkey, String keepcode) {
        String str_response = "";

        try {
            String response = HttpUtils.get(HttpUtils.UserInfo_URL + "?tokenKey=" + tokenkey + "&keepCode=" + keepcode);
//            parseJSONWithGSON(response);

            str_response = response;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str_response;
    }

    //查询一些只需要token和keepcode的接口
    public static String getQueryData(String url, String tokenkey, String keepcode) {
        String str_response = "";

        try {
            String response = HttpUtils.get(url + "?tokenKey=" + tokenkey + "&keepCode=" + keepcode);
            str_response = response;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str_response;
    }

    //by xuly 20180915
    public static String add_share_num(int userid, String yaoqingma) {
        String str_response = "";
        try {
            String response = HttpUtils.get(HttpUtils.Share_URL + "?user_id=" + userid + "&yaoqingma=" + yaoqingma);
            str_response = response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str_response;
    }

    public static String get_post_response(TreeMap<String, String> treeMap, String url) {
        String str_response = "";

        FormBody.Builder builder = new FormBody.Builder();
        // Add Params to Builder
        for (TreeMap.Entry<String, String> entry : treeMap.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }

        RequestBody formBody = builder.build();

        try {
            String response = HttpUtils.post(url, formBody);
            str_response = response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str_response;
    }

    //文件上传
    public static String uploadFile(String url,File file, String tokenkey, String keepcode) {
        String str_response = "";

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("tokenKey", tokenkey);
        treeMap.put("keepCode", keepcode);

        //sLogger.i("data: " + data);
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        FormBody.Builder builder = new FormBody.Builder();
        for (TreeMap.Entry<String, String> entry : treeMap.entrySet()) {
            requestBody.addFormDataPart(entry.getKey(), entry.getValue());
        }
        requestBody.addFormDataPart("avatarFile", file.getName(),
                RequestBody.create(MediaType.parse("application/octet-stream"), file));
        // Create RequestBody
        try {
            String response = HttpUtils.post(url, requestBody.build());
            str_response = response;
            //sLogger.i("upload res model:%d, source:%d, resp:%s", model, source, response);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return str_response;
    }


    //实名认证上传
    public static String uploadRenzhengFile(File file_zheng, String file_canshu, String fullId, String name, String idcard, String tokenkey, String keepcode) {
        String str_response = "";

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("realName", name);
        treeMap.put("identity", idcard);
        treeMap.put("keepCode", keepcode);
        treeMap.put("tokenKey", tokenkey);
        if (!fullId.equals("")) {
            treeMap.put("fullId", fullId);
        }

        //sLogger.i("data: " + data);
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        FormBody.Builder builder = new FormBody.Builder();
        for (TreeMap.Entry<String, String> entry : treeMap.entrySet()) {
            requestBody.addFormDataPart(entry.getKey(), entry.getValue());
        }
        requestBody.addFormDataPart(file_canshu, file_zheng.getName(),
                RequestBody.create(MediaType.parse("application/octet-stream"), file_zheng));
//        requestBody.addFormDataPart("image_bFile", file_fan.getName(),
//                RequestBody.create(MediaType.parse("application/octet-stream"), file_fan));
//        requestBody.addFormDataPart("image_cFile", file_shouchi.getName(),
//                RequestBody.create(MediaType.parse("application/octet-stream"), file_shouchi));
        // Create RequestBody
        try {
            String response = HttpUtils.post(Upload_Renzheng_URL, requestBody.build());
            str_response = response;
            //sLogger.i("upload res model:%d, source:%d, resp:%s", model, source, response);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return str_response;
    }

    //发布团队
    public static String fabuTeam(File file, String tokenkey, String keepcode, String groupname, String quantity, String introduce, String personnelcost, String personnelexplain
            , String toolcost, String toolexplain, String address, String regioncode, String industrycode) {
        String str_response = "";

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("tokenKey", tokenkey.trim());
        treeMap.put("keepCode", keepcode.trim());
        treeMap.put("groupName", groupname.trim());
        treeMap.put("quantity", quantity.trim());
        treeMap.put("introduce", introduce.trim());
        treeMap.put("personnelCost", personnelcost.trim());
        treeMap.put("personnelExplain", personnelexplain.trim());
        treeMap.put("toolCost", toolcost.trim());
        treeMap.put("toolExplain", toolexplain.trim());
        treeMap.put("address", address.trim());
        treeMap.put("region.regionCode", regioncode.trim());
        treeMap.put("industry.industryCode", industrycode.trim());

        //sLogger.i("data: " + data);
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        FormBody.Builder builder = new FormBody.Builder();
        for (TreeMap.Entry<String, String> entry : treeMap.entrySet()) {
            requestBody.addFormDataPart(entry.getKey(), entry.getValue());
        }
        requestBody.addFormDataPart("coverFile", file.getName(),
                RequestBody.create(MediaType.parse("application/octet-stream"), file));
        // Create RequestBody
        try {
            String response = HttpUtils.post(Fabu_Team_URL, requestBody.build());
            str_response = response;
            //sLogger.i("upload res model:%d, source:%d, resp:%s", model, source, response);


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return str_response;
    }


    //修改团队
    public static String update_fabuTeam(File file, String tokenkey, String keepcode, String groupname, String quantity, String introduce, String personnelcost, String personnelexplain
            , String toolcost, String toolexplain, String address, String regioncode, String industrycode, String picName, String mgroupid) {
        String str_response = "";

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("tokenKey", tokenkey.trim());
        treeMap.put("keepCode", keepcode.trim());
        treeMap.put("groupName", groupname.trim());
        treeMap.put("quantity", quantity.trim());
        treeMap.put("introduce", introduce.trim());
        treeMap.put("personnelCost", personnelcost.trim());
        treeMap.put("personnelExplain", personnelexplain.trim());
        treeMap.put("toolCost", toolcost.trim());
        treeMap.put("toolExplain", toolexplain.trim());
        treeMap.put("address", address.trim());
        treeMap.put("region.regionCode", regioncode.trim());
        treeMap.put("industry.industryCode", industrycode.trim());

        treeMap.put("picture.name", picName.trim());
        treeMap.put("id", mgroupid);

        //sLogger.i("data: " + data);
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        FormBody.Builder builder = new FormBody.Builder();
        for (TreeMap.Entry<String, String> entry : treeMap.entrySet()) {
            requestBody.addFormDataPart(entry.getKey(), entry.getValue());
        }
        requestBody.addFormDataPart("coverFile", file.getName(),
                RequestBody.create(MediaType.parse("application/octet-stream"), file));
        // Create RequestBody
        try {
            String response = HttpUtils.post(Fabu_Team_URL, requestBody.build());
            str_response = response;
            //sLogger.i("upload res model:%d, source:%d, resp:%s", model, source, response);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return str_response;
    }




    public static String getUserInfoTeam(String s, String userid) {
        String userinfoteam = "";
        try {
            userinfoteam = HttpUtils.get(s + "?userId=" + userid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userinfoteam;
    }
}