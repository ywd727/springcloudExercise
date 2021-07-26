package com.ywd.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: cloudParentProject
 * @Package: com.ywd.springcloud.config
 * @ClassName: ApplicationConfig
 * @Author: 简鑫鑫
 * @Description:
 * @Date: 2021/6/18 17:34
 * @Version: 1.0
 */
@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
