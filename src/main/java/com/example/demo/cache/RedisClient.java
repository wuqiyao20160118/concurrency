package com.example.demo.cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class RedisClient {

    // 默认按名称进行装配bean，通过name属性进行绑定。可以写在字段上或者setter方法上。
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
