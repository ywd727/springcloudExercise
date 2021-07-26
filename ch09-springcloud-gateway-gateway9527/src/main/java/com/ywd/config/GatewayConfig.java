package com.ywd.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.config
 * @ClassName: GatewayConfig
 * @Author: 简鑫鑫
 * @Description: 创建的gateway配置类
 * @Date: 2021/7/18 14:28
 * @Version: 1.0
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder)
    {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_atguigu",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();

    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder)
    {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu2",
                r -> r.path("/mil").uri("http://news.baidu.com/mil")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator3(RouteLocatorBuilder builder)
    {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu3",
                r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
