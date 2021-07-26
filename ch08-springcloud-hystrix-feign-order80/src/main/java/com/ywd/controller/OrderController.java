package com.ywd.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ywd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.controller
 * @ClassName: OrderController
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/7/13 15:14
 * @Version: 1.0
 */
@RestController

public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/consumer/normal/{id}")
    public String normalMethod(@PathVariable("id") Integer id){
        String result = orderService.normalMethod(id);
        return result;
    }

    @GetMapping(value = "/consumer/timeOut/{id}")
    @HystrixCommand(fallbackMethod = "timeOut_timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String timeOut(@PathVariable("id") Integer id){
        String result = orderService.timeOut(id);
        return result;
    }

    @GetMapping(value = "/consumer/timeOutTwo/{id}")
    @HystrixCommand(fallbackMethod = "timeOut_timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String timeOut_two(@PathVariable("id") Integer id){
        String result = orderService.timeOut_two(id);
        return result;
    }

    //用于显示服务降级的处理结果的方法，进行兜底处理的方案
    public String timeOut_timeOutHandler(Integer id){
        return "我是消费者80，我只能等待1.5秒，你超时了还有可能是程序运行出问题了，导致处理失败" + "当前的线程名字是：" + Thread.currentThread().getName();
    }
}
