package com.ywd.springcloud;

import com.ywd.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud
 * @ClassName: OrderMain80
 * @Author: 简鑫鑫
 * @Description: 主启动类
 * @Date: 2021/6/15 17:04
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CH01-SPRINGCLOUD-PROVIDER-PAYMENT" ,configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
