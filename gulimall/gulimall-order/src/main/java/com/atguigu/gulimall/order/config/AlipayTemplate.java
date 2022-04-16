package com.atguigu.gulimall.order.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.atguigu.gulimall.order.vo.PayVo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private   String app_id = "2016092200568607";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private  String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDD8TcACeOuLpXaG3EupnxffW+TjJqYVWVSEmqEaTCwNLa3i1o4qXYShcq0uzU0AxjOAgub5kzlVb+9F213/Qg0VCJp5alT5mIf2EI7X2ChJndoC+pEC3Lo+/3Uos4Cd6LpoYbQPQyJFWPX5spzBK4qP/+5r8vEkdFurl6YDlIallcxpQ2DbQLNyb2yjs3kryvGYjGuYtd09ah/ZoFQis/ha7d4K/E9twgPQaxBHB55DqZUkPJk+03rwKW2HZZDe4+6kYtEygpCC6JlnnbRMGcjXWbF0XCX9AkbG4oS37FahMiG5jrsX79kbs3RJ138QvTnYqmWil3Mry6bFoMSQiYdAgMBAAECggEASckA5CPVOBdU2MAyu9V3ymGq7Y4p/SlTMTe8IsaVzhTbpXx1ahbuXoVBUxOYMlDkO1dr1bZAyK+kt2kmEOQY/dOc7fHM9Moxszo1nrQI6EZa+rRZ8Gu7Rt71s+fm2ekBUSdBZBNJMCn84iWHoQ5nI4PcIamAezJKAnrpJitmYZoHx3mMIZHL7UPpev/gIZmWgaONe2jIdLzjwTJIo9rdvwqCpC8DXwuPd7Y6MF3z71HZIRoU0xkF2+QtX4nd6xxU6qPIEvOSW4ExcrwraV72bHDUdoR+dYq6tnvV2z5rQ14A/dy2jhkVDSRIek47u5Syr/ykWR/BmM/P+V42V0pwgQKBgQD7YtylMjbA3AQLrfwXFqbcWOomE/hPObK56gxaxPonq/mJ813L0xf0JtrPn2Z9qTNtv78ukC8sx7T3BvyfC41QgS48zzejhQ8mzuX6gueqJ4nceh17YZB3Thetw7+exTVnbIgZ0wkbzVPETr82+H3hP+8Fwh9DtgocDB/SFglNfQKBgQDHidl/CIcZ4ex2b2clM6ayioYMQdDixg/BgtCajrlAYmvnwyGHzjxhxCPqDw1EpK9zrYwBihyq2IdGtMeYjY8KoeP9KC5hOrF5hnWeUwKrYE8OCBnv3AlXQ0DfRmYI1axHI+oB6KPbAwurA45bQYxP17b6r9oOdEeE1olnBOgdIQKBgGCKBtIqBnzqAWO63STAvjPAsasN4D4MmmZrS3NQUgEKOjqQC2VLG9fXVBCH1oRLhkSPbowjMvqvdv+m3zz04sAX2/neWi+h2b+9lPQvcWgW5wqUmt3XCfPHObCxi9UdRvUA6QOB1+2lXJX259fkdfMa6l/7vKX0Ms2ymkXD0K7BAoGBAMPpisx5OPymn56hPqp+DhuaeoaqUEd3o5yhreMyYpzehYemRNOsIAj1pTV31dUhxMpVCPOyAPeVZSx87sPPqTQNQ2YZ/3+jOwFQjUcHxcUx6Cyks6KXbexpsdYGrsPZ1y56CpYZLlgoo1ojQbBDqVnzOErmQbiTXm0Enx+w551BAoGAHg1FfHnEsibV8b6IY1j0FgZxWhaj9vFeJhloo9xW7KOBm5tEsV3SsBUHIibHYl3djwWeeThULKpwZV2ONgonN8hXloeltayfA1L39aZbFbCP+Iq12PcTG2KL1z+gFYjqBxk+HFVjJBzX9qJMUdoZ4iMpKQjYxJbAWqfBWym69Ho=";;
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyQQceVUChTJGtF/a8SXufhSxDTKporieTq9NO7yDZSpDlAX1zVPT/nf0KWAlxq1TYappWMIYtyrOABhJyn6flNP6vuSBiM5lYsepHvYrtRHqlFiJruEkiaCgEZBKL5aCfBHYj0oqgQn9MpNV/PEH4cBYAVaiI4+VX8CBUQfeEGjgN6OkpLULZ3X0JUkmSnVvCNJ1m3PD68IIlbOfEZXJUKCqmZhzprGR5VWswjxA+g87cMwvijL4gdkSy/daG62Bz5vApcmmMkuX1k1fMWP4ajZCASVw8HD+MSLRhd8We9F97gd8CW0TavzbdR+mTS5H4yEgO8F9HRAsbkhV9yu0yQIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private  String notify_url = "http://497n86m7k7.52http.net/payed/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private  String return_url = "http://member.gulimall.com/memberOrder.html";

    // 签名方式
    private  String sign_type = "RSA2";

    // 字符编码格式
    private  String charset = "utf-8";

    private String timeout = "30m";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public  String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+timeout+"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        System.out.println("支付宝的响应："+result);

        return result;

    }
}
