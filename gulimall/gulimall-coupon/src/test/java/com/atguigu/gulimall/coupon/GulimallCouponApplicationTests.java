package com.atguigu.gulimall.coupon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class GulimallCouponApplicationTests {

    @Test
    public void contextLoads() {

        //2020-02-21 00:00:00   2020-02-23 23:59:59
//        LocalDate now = LocalDate.now();
//        LocalDate plus = now.plusDays(1);
//        LocalDate plus2 = now.plusDays(2);
//
//        System.out.println(now);
//        System.out.println(plus);
//        System.out.println(plus2);
//
//
//        LocalTime min = LocalTime.MIN;
//        LocalTime max = LocalTime.MAX;
//        System.out.println(min);
//        System.out.println(max);
//
//        LocalDateTime start = LocalDateTime.of(now, min);
//        LocalDateTime end = LocalDateTime.of(plus2, max);
//        System.out.println(start);
//        System.out.println(end);

        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(2);
        LocalDateTime of = LocalDateTime.of(localDate, LocalTime.MAX);
        String format = of.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);


    }

}
