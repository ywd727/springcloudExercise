package com.ywd.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.controller
 * @ClassName: PaymentController
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/18 18:23
 * @Version: 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serviceName;

    @GetMapping(value = "/payment/query")
    public String stringData(){
        return "查询到的微服务的名称：" + serviceName + "\t" + "查询到的微服务的端口号是:" + serverPort + "\t" + "生成的流水号是:" + UUID.randomUUID().toString();
    }
}
