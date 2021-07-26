package com.ywd.controller;

import com.ywd.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.controller
 * @ClassName: PaymentController
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/7/13 10:41
 * @Version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/normal/{id}")
    public String normalMethod(@PathVariable("id") Integer id){
        String result = paymentService.normalMethod(id);
        log.info("===result===" + result);
        return result;
    }

    @GetMapping(value = "/payment/timeOut/{id}")
    public String timeOut(@PathVariable("id") Integer id){
        String result = paymentService.timeOut(id);
        log.info("===result===" + result);
        return result;
    }

    @GetMapping(value = "/payment/timeOutTwo/{id}")
    public String timeOut_two(@PathVariable("id") Integer id){
        String result = paymentService.timeOut_two(id);
        log.info("===result===" + result);
        return result;
    }

    @GetMapping(value = "/payment/breaker/{id}")
    public String breaker(@PathVariable("id") Integer id){
        String result = paymentService.timeOutBreaker(id);
        log.info("===result===" + result);
        return result;
    }
}
