package com.ywd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud
 * @ClassName: PaymentMain8002
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/17 18:02
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
