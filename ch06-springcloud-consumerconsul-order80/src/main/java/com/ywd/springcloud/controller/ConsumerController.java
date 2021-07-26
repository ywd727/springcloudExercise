package com.ywd.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.controller
 * @ClassName: ConsumerController
 * @Author: 简鑫鑫
 * @Description:  顾客的控制器
 * @Date: 2021/6/18 17:34
 * @Version:    1.0
 */
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    public static final String URI_PATH = "http://springcloud-consul-provider";

    @GetMapping(value = "/consumer/query")
    public String stringValue(){
        return restTemplate.getForObject(URI_PATH + "/payment/query",String.class);
    }
}
