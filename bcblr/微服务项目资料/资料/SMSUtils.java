package com.baizhi.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSUtils {

    private static final Logger log = LoggerFactory.getLogger(SMSUtils.class);

    private static String ACCESSKEYID = "LTAI5tGF2kkoJbB9ftdH2DwT";
    private static String SECRET = "YYc2CShh6RVZmMuhQzifAXS5WimvUI";

    /**
     * 发送短信验证码
     * @param phone  手机号码
     * @param code   验证码
     * @return  返回验证码
     */
    public static void sendMsg(String phone,String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESSKEYID, SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "青橙小店");
        request.putQueryParameter("TemplateCode", "SMS_217145407");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info("阿里云短信响应信息: "+response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
            throw  new RuntimeException("提示: 阿里云服务异常!");
        } catch (ClientException e) {
            e.printStackTrace();
            throw  new RuntimeException("提示: 短信发送失败!");
        }
    }

    public static void main(String[] args) {
        SMSUtils.sendMsg("13260426185","4324");
    }
}
