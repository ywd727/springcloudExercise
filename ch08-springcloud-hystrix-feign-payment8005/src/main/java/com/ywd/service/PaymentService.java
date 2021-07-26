package com.ywd.service;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.service
 * @ClassName: PaymentService
 * @Author: 简鑫鑫
 * @Description: 支付服务的接口
 * @Date: 2021/7/13 10:30
 * @Version: 1.0
 */
public interface PaymentService {
    //正常执行的方法
    String normalMethod(Integer id);
    //超时执行的方法
    String timeOut(Integer id);
    //超时执行的方法，进行全局兜底方法的测试
    String timeOut_two(Integer id);
    //断路器方法
    String timeOutBreaker(Integer id);
}
