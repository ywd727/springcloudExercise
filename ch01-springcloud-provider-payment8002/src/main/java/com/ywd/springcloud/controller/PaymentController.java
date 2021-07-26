package com.ywd.springcloud.controller;

import com.ywd.springcloud.service.PaymentService;
import com.ywd.springcloud.domain.CommonResult;
import com.ywd.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.controller
 * @ClassName: PaymentController
 * @Author: 简鑫鑫
 * @Description: 交易的控制器
 * @Date: 2021/6/13 16:27
 * @Version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/query/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryPaymentById(id);

        if (payment != null) {
            return new CommonResult(200,"查询成功,对应的端口号是：" + serverPort,payment);
        }else {
            return new CommonResult(404,"此id没有对应的交易流水,对应的端口号是：" + serverPort,null);
        }
    }

    //（单独的进行测试的时候）这个方法的形参里面单独的加入@RequestBody注解就会报400错误，如果不加就不报
    //（使用消费者进行调用的时候）如果不添加@RequestBody注解，那么前端传来的参数就插入不到数据库中
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        Integer num = paymentService.create(payment);

        log.info("插入的结果是======>" + num);

        if (num > 0) {
            return new CommonResult(200,"插入成功,对应的端口号是：" + serverPort,num);
        }else {
            return new CommonResult(404,"插入失败,对应的端口号是：" + serverPort,null);
        }
    }
}
