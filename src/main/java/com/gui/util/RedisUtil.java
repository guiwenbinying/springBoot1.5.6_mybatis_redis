package com.gui.util;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

	//注入redis的控制类
	@Autowired
	private StringRedisTemplate redis;
	private static long redisTime = 60*10;//缓存时间 秒
	private static RedisUtil redisUtil=new RedisUtil();
	
	
	
	
	

	public static RedisUtil getRedisUtil() {
		return redisUtil;
	}

	public static void setRedisUtil(RedisUtil redisUtil) {
		RedisUtil.redisUtil = redisUtil;
	}

	//添加值
	public  void setValue(String key,String value) {
		//TimeUnit.SECONDS秒
		redis.opsForValue().set(key, value, redisTime, TimeUnit.SECONDS);
	}
	
	//获取值
	public String getValue(String key) {
		return redis.opsForValue().get(key);
	}
	
	//获取过期时间  单位秒
	public long getExpire(String key) {
		return redis.getExpire(key,TimeUnit.SECONDS);
	}
	
	//删除缓存
	public void delete(String key) {
		
		 redis.delete(key);
	}
	
	//检查是否存在这个key
	public boolean hasKey(String key) {
		
		return redis.hasKey(key);
	}
	
	
}
