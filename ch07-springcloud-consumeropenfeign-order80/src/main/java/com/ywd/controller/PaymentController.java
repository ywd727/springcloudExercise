package com.ywd.controller;

import com.ywd.service.PaymentService;
import com.ywd.springcloud.domain.CommonResult;
import com.ywd.springcloud.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.controller
 * @ClassName: PaymentController
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/21 19:15
 * @Version: 1.0
 */
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/query/{id}")
    CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id){
        return paymentService.queryPaymentById(id);
    };

    @GetMapping(value = "/timeout")
    public String paymentFeignTimout(){
        return paymentService.paymentFeignTimout();
    };
}
