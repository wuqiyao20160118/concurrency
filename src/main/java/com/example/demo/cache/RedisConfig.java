package com.example.demo.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

// @Configuration标注表示此为配置类
// 功能类似于在applicationContext.xml文件手动注册Bean。此时在各级Bean中需要添加setter或者构造方法。
@Configuration
public class RedisConfig {

    // 注解@Bean用于显式声明单个bean，而不是像我们使用@Controller那样让Spring自动执行检测
    // 它使Bean的声明与类定义完全脱钩，使我们可以完全按照自己的选择创建和配置Bean
    // 注解@Bean用于将方法返回的bean注册为IOC Container中的spring配置bean
    // @Bean注解指示方法产生应由Spring容器管理的bean，要声明一个bean，只需使用@Bean对方法进行注解
    // 当Spring检测到该注解方法时，它将执行该方法并将返回值注册为ApplicationContext中的Bean
    // 默认情况下，bean名称与方法名称相同
    @Bean(name = "redisPool")
    public JedisPool jedisPool(@Value("${jedis.host}") String host, @Value("${jedis.port}") int port) {
        // @Value只能给普通变量注入值，不能给静态变量注入值
        // 给静态变量注入值可以使用set()方法，其中需要在类上加入@Component注解
        // 需要使用${}才能取到application.properties文件中的配置值
        return new JedisPool(host, port);
    }
}
