package com.ywd.springcloud.controller;

import com.ywd.springcloud.domain.CommonResult;
import com.ywd.springcloud.domain.Payment;
import com.ywd.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private DiscoveryClient discoveryClient;


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

    @GetMapping(value = "/discovery")
    public Object discovery(){
        //获取这个为服务名称下注册的所有微服务
        List<String> dList = discoveryClient.getServices();
        for (String service : dList) {
            log.info("注册的服务名称====>" + service);
        }

        List<ServiceInstance> sl = discoveryClient.getInstances("CH01-SPRINGCLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance s : sl) {
            log.info("服务的id（当前微服务的总名称）" + s.getServiceId() + "\t" + "服务的端口号：" + s.getPort() + "\t" + "主机名称：" + s.getHost() + "\t"
                    + "服务的uri地址：" + s.getUri() + "\t");
        }
        return discoveryClient;
    }

    @GetMapping(value = "/timeout")
    public String paymentFeignTimout(){
        try {
            //沉睡三秒后再进行响应
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前的服务端口号是===>" + serverPort;
    }

}
