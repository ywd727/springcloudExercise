package com.ywd.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: ch02-springcloud-consumerzk-order80
 * @Package: com.ywd.myrule
 * @ClassName: MySelfRule
 * @Author: 简鑫鑫
 * @Description: 创建自己的规则类
 * @Date: 2021/6/21 18:48
 * @Version: 1.0
 */
@Configuration
public class MySelfRule {
    @Bean//作用：将自定义的servlet注册到容器中，相当于xml配置文件中的<bean></bean>标签对
    public IRule returnRule(){
        return new RandomRule();//定义为随机的调用的规则
    }
}
