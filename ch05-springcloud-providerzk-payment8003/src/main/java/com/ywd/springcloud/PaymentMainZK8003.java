package com.ywd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud
 * @ClassName: PaymantMainZK8003
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/18 16:52
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMainZK8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMainZK8003.class,args);
    }
}
