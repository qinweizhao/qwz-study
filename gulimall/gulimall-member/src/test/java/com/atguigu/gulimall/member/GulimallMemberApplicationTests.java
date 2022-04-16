package com.atguigu.gulimall.member;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class GulimallMemberApplicationTests {

    @Test
    public void contextLoads() {

        //e10adc3949ba59abbe56e057f20f883e
        //抗修改性:  彩虹表。123456->xxxx   234567->dddd
//        String s = DigestUtils.md5Hex("123456");

        //MD5不能直接进行密码的加密存储;
        //"123456"+System.currentTimeMillis();

        //盐值加密；随机值 加盐：$1$+8位字符
        //$1$Q4jfb2Xz$jbIxdBvSdYXUQRNjyITL11
        //$1$qqqqqqqq$AZofg3QwurbxV3KEOzwuI1
        //$1$qqqqqqqq$AZofg3QwurbxV3KEOzwuI1 123456
        //验证： 123456进行盐值（去数据库查）加密
//        String s1 = Md5Crypt.md5Crypt("123456".getBytes(),"$1$qqqqqqqq");
//        System.out.println(s1);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //$2a$10$4IP4F/2iFO2gbSvQKyJzGuI3RhU5Qdtr519KsyoXGAy.b7WT4P1RW
        //$2a$10$iv6H6nqQ/NWOMkzgZSJdPeMOBGbn0ayhZ9WAewOk0ssWScSHOgsAW
        String encode = passwordEncoder.encode("123456");

        boolean matches = passwordEncoder.matches("123456", "$2a$10$4IP4F/2iFO2gbSvQKyJzGuI3RhU5Qdtr519KsyoXGAy.b7WT4P1RW");


        System.out.println(encode+"=>"+matches);
    }

}
