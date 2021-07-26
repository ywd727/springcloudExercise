package com.ywd.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.config
 * @ClassName: FeignConfigLoggingLevel
 * @Author: 简鑫鑫
 * @Description: 设置Feign打印日志的级别
 * @Date: 2021/6/21 19:52
 * @Version: 1.0
 */
@Configuration
public class FeignConfigLogLevel {
    @Bean
    Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
