package com.ywd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud
 * @ClassName: EurekaMain7001
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/17 18:13
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
