package com.van.cache;


import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存类
 */
public class RedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private static JedisConnectionFactory jedisConnectionFactory;


    private String id;

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }
        this.id = id;
    }

    public RedisCache() {

    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            connection.set(serializer.serialize(key), serializer.serialize(value));
            connection.lPush(serializer.serialize(id),serializer.serialize(key));
            System.out.println("写入缓存：" + key + "," + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Object getObject(Object key) {
        Object res = null;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            res = serializer.deserialize(connection.get(serializer.serialize(key)));
            if (res != null) {
                System.out.println("获取缓存数据：" + res.toString());
            } else {
                System.out.println("当前没有缓存:" + key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return res;
    }

    @Override
    public Object removeObject(Object key) {
        Object res = null;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            res = connection.expire(serializer.serialize(key), 0);
            connection.lRem(serializer.serialize(id),0,serializer.serialize(key));
            System.out.println("删除缓存：" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return res;
    }

    @Override
    public void clear() {
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
//            connection.flushDb();
//            connection.flushAll();
            Long length = connection.lLen(serializer.serialize(id));
            if (0 == length) {
                return;
            }
            List<byte[]> keys = connection.lRange(serializer.serialize(id),0,length-1);
            for (byte[] key :keys) {
                connection.expireAt(key,0);
                System.out.println("删除缓存:"+serializer.deserialize(key).toString());
            }
            connection.expireAt(serializer.serialize(id),0);
            keys.clear();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public int getSize() {
        int result = 0;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

}
