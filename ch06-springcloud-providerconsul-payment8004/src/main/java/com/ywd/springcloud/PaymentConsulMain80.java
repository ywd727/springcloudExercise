package com.ywd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud
 * @ClassName: PaymentConsulMain80
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/18 18:22
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain80.class,args);
    }
}
