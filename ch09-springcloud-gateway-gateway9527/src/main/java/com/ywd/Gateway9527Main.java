package com.ywd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd
 * @ClassName: Gateway9527Main
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/7/18 14:14
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527Main {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9527Main.class,args);
    }
}
