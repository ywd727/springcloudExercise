package com.ywd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd
 * @ClassName: OrderHystrixFeignMain80
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/7/13 15:13
 * @Version: 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixFeignMain80.class,args);
    }
}
