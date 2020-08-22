package com.example.demo.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

// @Configuration标注表示此为配置类
@Configuration
public class RedisConfig {

    @Bean(name = "redisPool")
    public JedisPool jedisPool(@Value("${jedis.host}") String host, @Value("${jedis.port}") int port) {
        // @Value只能给普通变量注入值，不能给静态变量注入值
        // 给静态变量注入值可以使用set()方法，其中需要在类上加入@Component注解
        // 需要使用${}才能取到application.properties文件中的配置值
        return new JedisPool(host, port);
    }
}
