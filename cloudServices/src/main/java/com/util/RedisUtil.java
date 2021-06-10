package com.util;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 向Redis中存值，永久有效
     */
    public  void  set (String key,String value){
        try {
        value = StringUtils.isEmpty(value) ? "" : value;
        @Cleanup Jedis jedis = jedisPool.getResource();
          jedis.set(key,value);
            log.info("Set key success");
        } catch (Exception e) {
            log.error("Set key error : "+e);
        }
    }

    /**
     * 设置 过期时间
     * @param key
     * @param seconds 以秒为单位
     * @param value
     */
    public void setString(String key ,int seconds,String value){
        try {
            value = StringUtils.isEmpty(value) ? "" : value;
            @Cleanup Jedis jedis = jedisPool.getResource();
            jedis.setex(key, seconds, value);
            log.info("Setex key success");
        } catch (Exception e) {
            log.error("Set keyex error : "+e);
        }
    }

    /**
     * 获取String值
     * @param key
     * @return value
     */
    public String getString(String key){
        String bKey = key;
        @Cleanup Jedis jedis = jedisPool.getResource();
        if(jedis == null || !jedis.exists(bKey)){
            return null;
        }
        return jedis.get(bKey);
    }

    /**
     * 校验Key值是否存在
     */
    public Boolean exists(String key) {
        @Cleanup Jedis jedis = jedisPool.getResource();
        try {
            return jedis.exists(key);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 删除指定Key-Value
     */
    public Long del(String key) {
        @Cleanup Jedis jedis = jedisPool.getResource();
        try {
            return jedis.del(key);
        } catch (Exception e) {
            return 0L;
        }
    }



}
