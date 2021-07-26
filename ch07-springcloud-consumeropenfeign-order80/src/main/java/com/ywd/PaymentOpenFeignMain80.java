package com.ywd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd
 * @ClassName: PaymentOpenFeignMain80
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/21 19:14
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//用于开启openfeign的注解
public class PaymentOpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentOpenFeignMain80.class,args);
    }
}
