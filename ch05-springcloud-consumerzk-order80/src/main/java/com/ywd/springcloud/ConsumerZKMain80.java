package com.ywd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud
 * @ClassName: ConsumerZKMain80
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/18 17:32
 * @Version: 1.0
 */
@SpringBootApplication
public class ConsumerZKMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZKMain80.class,args);
    }
}
