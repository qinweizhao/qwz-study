package com.atguigu.gulimall.auth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.atguigu.common.utils.HttpUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.auth.feign.MemberFeignService;
import com.atguigu.common.vo.MemberRespVo;
import com.atguigu.gulimall.auth.vo.SocialUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理社交登录请求
 */
@Slf4j
@Controller
public class OAuth2Controller {

    @Autowired
    MemberFeignService memberFeignService;

    /**
     * 社交登录成功回调
     * @param code
     * @return
     * @throws Exception
     */
    @GetMapping("/oauth2.0/weibo/success")
    public String weibo(@RequestParam("code") String code, HttpSession session, HttpServletResponse servletResponse, HttpServletRequest request) throws Exception {
        Map<String,String> header = new HashMap<>();
        Map<String,String> query = new HashMap<>();



        Map<String,String> map = new HashMap<>();
        map.put("client_id","2636917288");
        map.put("client_secret","6a263e9284c6c1a74a62eadacc11b6e2");
        map.put("grant_type","authorization_code");
        map.put("redirect_uri","http://auth.gulimall.com/oauth2.0/weibo/success");
        map.put("code",code);
        //1、根据code换取accessToken；
        HttpResponse response = HttpUtils.doPost("https://api.weibo.com", "/oauth2/access_token", "post", header, query, map);

        //2、处理
        if(response.getStatusLine().getStatusCode()==200){
            //获取到了 accessToken
            String json = EntityUtils.toString(response.getEntity());
            SocialUser socialUser = JSON.parseObject(json, SocialUser.class);

            //知道当前是哪个社交用户
            //1）、当前用户如果是第一次进网站，自动注册进来(为当前社交用户生成一个会员信息账号，以后这个社交账号就对应指定的会员)
            //登录或者注册这个社交用户
            R oauthlogin = memberFeignService.oauthlogin(socialUser);
            if(oauthlogin.getCode() == 0){
                MemberRespVo data = oauthlogin.getData("data", new TypeReference<MemberRespVo>() {
                });
                log.info("登录成功：用户：{}",data.toString());
                //1、第一次使用session；命令浏览器保存卡号。JSESSIONID这个cookie；
                //以后浏览器访问哪个网站就会带上这个网站的cookie；
                //子域之间； gulimall.com  auth.gulimall.com  order.gulimall.com
                //发卡的时候(指定域名为父域名)，即使是子域系统发的卡，也能让父域直接使用。
                //TODO 1、默认发的令牌。session=dsajkdjl。作用域：当前域；（解决子域session共享问题）
                //TODO 2、使用JSON的序列化方式来序列化对象数据到redis中
                session.setAttribute("loginUser",data);
//                new Cookie("JSESSIONID","dadaa").setDomain("");
//                servletResponse.addCookie();
                //2、登录成功就跳回首页
                return "redirect:http://gulimall.com";

            }else {
                return "redirect:http://auth.gulimall.com/login.html";
            }

        }else {
            return "redirect:http://auth.gulimall.com/login.html";
        }
    }
}
