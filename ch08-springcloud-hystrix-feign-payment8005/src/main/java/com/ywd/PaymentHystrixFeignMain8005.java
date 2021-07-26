package com.ywd;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd
 * @ClassName: PaymentHystrixFeignMain8005
 * @Author: 简鑫鑫
 * @Description: 主启动类
 * @Date: 2021/7/13 10:27
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//打开熔断器
public class PaymentHystrixFeignMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixFeignMain8005.class,args);
    }
}
