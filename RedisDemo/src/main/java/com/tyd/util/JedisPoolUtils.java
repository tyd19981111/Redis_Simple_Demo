package com.tyd.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPoolUtils
 * 记载配置文件，配置连接池参数，提供获取连接的方法
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        // 读取jedis.properties配置文件
        InputStream inputStream = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        // 创建Properties对象
        Properties properties = new Properties();
        // 关联配置文件
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取数据并设置到JedisPoolConfig中
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 在此处设置JedisPool的配置信息 START
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        // .........
        // 在此处设置JedisPool的配置信息 END

        // 初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }

    /**
     * 获取连接
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}

