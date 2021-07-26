package com.ywd.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ywd.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.service.impl
 * @ClassName: PaymentServiceImpl
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/7/13 10:32
 * @Version: 1.0
 */
@Service
@DefaultProperties(defaultFallback = "timeOut_TimeOutHandler_Global")
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String normalMethod(Integer id) {
        return "当前的线程是" + Thread.currentThread().getName() + "来自于ServiceImpl层的normal方法,id = " + id + "调用的状态是：“开心 q(≧▽≦q)”";
    }

    @Override
    @HystrixCommand(fallbackMethod = "timeOut_TimeOutHandler_private", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String timeOut(Integer id) {
        //设置当前线程睡眠的时间
        int seconds = 5;

        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前的线程是" + Thread.currentThread().getName() + "来自于ServiceImpl层的Timout方法,id = " + id + "调用的状态是：“难过 `(*>﹏<*)′”";
    }

    @Override
    @HystrixCommand
    public String timeOut_two(Integer id) {
        int seconds = 5;
        //使当前的线程睡眠三秒钟
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前的线程是" + Thread.currentThread().getName() + "来自于ServiceImpl层的Timout方法,id = " + id + "调用的状态是：“难过 `(*>﹏<*)′”";
    }

    //断路器方法
    @Override
    @HystrixCommand(fallbackMethod = "timeOut_TimeOutHandler_Breaker", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//打开断路器处理机制
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//设置的请求最低标准（当求情达到这个数时，才会进行评测并根据评测结果将断路器打开）
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//设置的处理周期时间
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//当请求出错的百分比达到设置的这个数时将打开断路器
    })
    public String timeOutBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("===id不能为负数===");
        }
        String serialNumber = IdUtil.simpleUUID();//hutool工具包里面的一个方法

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    //降级处理，兜底处理方案
    public String timeOut_TimeOutHandler_private(Integer id){
        return "调用支付接口异常或超时：\t" + "\t当前线程的名字是：" + Thread.currentThread().getName() + "\t私人的";
    }

    //用域全局的兜底处理方法
    public String timeOut_TimeOutHandler_Global(){
        return "调用支付接口异常或超时：\t" + "\t当前线程的名字是：" + Thread.currentThread().getName() + "\t全局的";
    }

    //断路器的兜底方案
    public String timeOut_TimeOutHandler_Breaker(Integer id){
        return "调用支付接口的数值id小于“0”导致出错：\t" + "\t当前线程的名字是：" + Thread.currentThread().getName() + "\t断路器";
    }
}
