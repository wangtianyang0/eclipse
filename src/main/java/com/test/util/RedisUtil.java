package com.test.util;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

	 private static JedisPool jedisPool = null;  
	    /** 
	     * 初始化Redis连接池 
	     */  
	    static {  
	        try {  
	            //加载redis配置文件  
	            ResourceBundle bundle = ResourceBundle.getBundle("redis");    
	            if (bundle == null) {    
	                throw new IllegalArgumentException("[redis.properties] is not found!");    
	            }   
	            int maxActivity = Integer.valueOf(bundle.getString("redis.pool.maxActive"));  
	            int maxIdle = Integer.valueOf(bundle.getString("redis.pool.maxIdle"));  
	            long maxWait = Long.valueOf(bundle.getString("redis.pool.maxWait"));  
	            boolean testOnBorrow = Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow"));  
	            boolean onreturn = Boolean.valueOf(bundle.getString("redis.pool.testOnReturn"));  
	             
	            //创建jedis池配置实例  
	            JedisPoolConfig config = new JedisPoolConfig();  
	            //设置池配置项值  
	            //config.setMaxActive(maxActivity);  
	            config.setMaxIdle(maxIdle);    
	            //config.setMaxWait(maxWait);    
	            config.setTestOnBorrow(testOnBorrow);    
	            config.setTestOnReturn(onreturn);    
	            jedisPool = new JedisPool(config, bundle.getString("redis.ip"), Integer.valueOf(bundle.getString("redis.port")));  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	      
	    /** 
	     * 获取Jedis实例 
	     * @return 
	     */  
	    public synchronized static Jedis getJedis() {  
	        try {  
	            if (jedisPool != null) {  
	                Jedis resource = jedisPool.getResource();  
	                return resource;  
	            } else {  
	                return null;  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	      
	    /** 
	     * 释放jedis资源 
	     * @param jedis 
	     */  
	    public static void returnResource(final Jedis jedis) {  
	        if (jedis != null) {  
	            jedisPool.returnResource(jedis);  
	        }  
	    }  
	  
	    /** 
	     * 查询数据 
	     */  
	    public String  find(String key,String value){  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();    
	            return jedis.get(key);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }finally{    
	            jedisPool.returnResource(jedis);    
	        }  
	    }  
	      
	    /** 
	     * 查询特定字符串 
	     */  
	    public String findSubStr(String key,Integer startOffset,Integer endOffset){  
	        Jedis jedis = null;  
	        try {  
	            jedis = jedisPool.getResource();    
	            return jedis.getrange(key, startOffset, endOffset);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }finally{    
	            jedisPool.returnResource(jedis);
	        }  
	    }  
	     /**  
	     * 向缓存中设置字符串内容 新增数据|修改 
	     * @param key key  
	     * @param value value  
	     * @return  
	     * @throws Exception  
	     */    
	    public static int add(String key,String value) throws Exception{    
	        Jedis jedis = null;    
	        try {    
	            jedis = jedisPool.getResource();    
	            jedis.set(key, value);    
	            return 0;    
	        } catch (Exception e) {    
	            e.printStackTrace();    
	            return -1;    
	        }finally{    
	            jedisPool.returnResource(jedis);    
	        }    
	    }    
	      
	    /**  
	     * 删除缓存中得对象，根据key  
	     * @param key  
	     * @return  
	     */    
	    public static int del(String key){    
	        Jedis jedis = null;    
	        try {    
	            jedis = jedisPool.getResource();    
	            jedis.del(key);    
	            return 0;    
	        } catch (Exception e) {    
	            e.printStackTrace();    
	            return -1;    
	        }finally{    
	            jedisPool.returnResource(jedis);    
	        }    
	    }    
	//System.out.println("----------------");
	
}
