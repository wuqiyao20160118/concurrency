package com.example.demo.cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

// 如果要在应用程序上下文中注册类，我们可以使用@Component注解进行注册
// 如果我们使用注解@Component或其他构造型注解之一标记一个类，则将使用类路径扫描自动检测这些类
// 并为每个这些类创建一个新bean，将其注册到ApplicationContext中
@Component
public class RedisClient {

    // 默认按名称进行装配注入bean，通过name属性进行绑定。可以写在字段上或者setter方法上。
    // SpringBoot通过@Configuration中定义的配置进行查找与装配
    @Resource(name = "redisPool")
    private JedisPool jedisPool;

    public void set(String key, String value) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } finally {
            // 回收关闭资源
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String get(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } finally {
            // 回收关闭资源
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
