package com.ywd.service;

import com.ywd.springcloud.domain.CommonResult;
import com.ywd.springcloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.service
 * @ClassName: PaymentService
 * @Author: 简鑫鑫
 * @Description: openfeign的调用接口
 * @Date: 2021/6/21 19:16
 * @Version: 1.0
 */
@Component//将这个加载到容器中
@FeignClient(value = "CH01-SPRINGCLOUD-PROVIDER-PAYMENT")//证明是feign的调用端,value中的值是调用哪个微服务下提供的服务
public interface PaymentService {
    //注意：这里的openFeign调用服务接口中的方法需要和服务提供方（暴露的服务）中的方法头相同
    @GetMapping(value = "/payment/query/{id}")
    CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/timeout")
    String paymentFeignTimout();
}
