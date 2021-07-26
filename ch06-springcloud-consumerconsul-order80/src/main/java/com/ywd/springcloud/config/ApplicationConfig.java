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
 * @Description: 配置
 * @Date: 2021/6/15 17:08
 * @Version: 1.0
 */
@Configuration
public class ApplicationConfig {
    //被 @Bean 注解标注的方法会创建一个 bean 的实例，放在 spring IoC 容器中。
    // 等需要使用这个 bean 的时候，在类里用 @Autowired，@Resource 注入这个对象就行了。
    @Bean
    @LoadBalanced//使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
