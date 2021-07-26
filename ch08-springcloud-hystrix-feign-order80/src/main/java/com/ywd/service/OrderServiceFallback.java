package com.ywd.service;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.service
 * @ClassName: OrderServiceFallback
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/7/16 10:31
 * @Version: 1.0
 */
@Component//将这个实现类加载到容器中
public class OrderServiceFallback implements OrderService {
    @Override
    public String normalMethod(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
    }

    @Override
    public String timeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
    }

    @Override
    public String timeOut_two(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
    }
}
