package com.ywd.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.service
 * @ClassName: OrderService
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/7/13 15:15
 * @Version: 1.0
 */
@Component
@FeignClient(value = "CH08-SPRINGCLOUD-HYSTRIX-FEIGN-PAYMENT8005", fallback = OrderServiceFallback.class)
public interface OrderService {
    //使用openFeign进行服务的调用，所以这里提供的“方法头”必须和“服务提供方”的controller层的方法头一模一样
    @GetMapping(value = "/payment/normal/{id}")
    String normalMethod(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/timeOut/{id}")
    String timeOut(@PathVariable("id") Integer id);

    //进行测试全局的超时兜底方案
    @GetMapping(value = "/payment/timeOutTwo/{id}")
    public String timeOut_two(@PathVariable("id") Integer id);
}
