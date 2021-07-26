package com.ywd.springcloud.controller;

import com.ywd.springcloud.domain.CommonResult;
import com.ywd.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.controller
 * @ClassName: OrderController
 * @Author: 简鑫鑫
 * @Description: 消费者调用器
 * @Date: 2021/6/15 17:07
 * @Version: 1.0
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    //定义一个常量用来固定访问地址
    //注册中心中对外暴露的微服务名称
    public static final String PAYMENT_URL = "http://CH01-SPRINGCLOUD-PROVIDER-PAYMENT";

    @GetMapping(value = "/consumer/query/{id}")
    public CommonResult queryPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/query/"+id,CommonResult.class);
    }

    //这里使用@getMapping注解的原因：这是针对于用户的控制器，用户的输入一定是get请求
    @GetMapping(value = "/consumer/create")
    public CommonResult create(Payment payment){
        log.info("牛逼666");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
}
