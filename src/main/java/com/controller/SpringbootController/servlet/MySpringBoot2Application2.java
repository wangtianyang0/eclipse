package com.controller.SpringbootController.servlet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;

import com.data.redis.util.RedisUtil;
import com.MySpringBoot2ApplicationTests;

import redis.clients.jedis.Jedis;
import com.data.redis.usr.User;
@SpringBootApplication
	@Configuration
	@EnableAutoConfiguration
	@ComponentScan({"com.controller.SpringbootController.servlet", "WebDataController","controller", "service"})
public class MySpringBoot2Application2 {

	@Autowired
	private static RedisTemplate<String, User> redisTemplate;
	@Test
	public void test() throws Exception {
		// 保存对象
//		User user = new User("超人", 20);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//		user = new User("蝙蝠侠", 30);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//		user = new User("蜘蛛侠", 40);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//		System.out.println("This is the test---------");
//		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
//		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
	}
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MySpringBoot2Application2.class, args);
		//SpringApplication.run(MySpringBoot2ApplicationTests.class);
		System.out.println("-------------------");
		System.out.println("This is spring-boot");
		
		
//		Jedis jedis=new Jedis("10.124.3.1",7101);
//        for (int i = 0; i <1000; i++) {
//            jedis.del("key222"+i);
//            System.out.println("设置key"+i+"的数据到redis");
//            Thread.sleep(2);
//        }
//        //执行保存，会在服务器下生成一个dump.rdb数据库文件
//        jedis.save();
//        jedis.close();
//        System.out.println("写入完成");
        
        Jedis jedis = RedisUtil.getJedis();
        //jedis.set("key11111114","11111111111");
        User user = new User();
//        user.setUser("key11111555", "1257900000");
//        Set<String> list1 = new HashSet<String>();
//        list1 = user.getAllUser("key11111555");
//      
//      
//      Map<String,String> map = user.getAllUserInformation("1000000000000001");
//      
//      user.printAllUserInformation(user.getAllUserInformation("1000000000000001"));
//      user.updateUserInformationByUseID("1000000000000050", "100040", "23010345666666","1000000", "200", "system", "1");
      
      
//      for (String key : map.keySet()) {
//    	  String a = "字段： " + key + " 值为： " + map.get(key);
//        System.out.println(a);
//    }
        
//        String cust_name = jedis.hget("1000000000000001", "CUST_NAME");
//        System.out.println(cust_name);
        
//        Set<String> list2 = new HashSet<String>();
//        Map<String,String> map = new HashMap<String,String>();
//        list2 = jedis.hkeys("1000000000000001");
//        map = jedis.hgetAll("1000000000000001");
//        
//        for (String key : map.keySet()) {
//            System.out.println("key= " + key + " and value= " + map.get(key));
//        }
        User user1 = new User();
        Set<String> list3 = new HashSet<String>();
        
        list3 = user1.getUSER_IDbyPSPT_ID("index+230103000000000001");
        Iterator<String> it = list3.iterator();
        while(it.hasNext()){
        	System.out.println((String)it.next());
        }	
        
        
//        for(String list: list2)
//        {
//        	System.out.println(list);
//        }
        user1.FindAllUserAllInformation("230103000000000001");
        //user.deleteValue("1000000000000050", "USER_ID");
        jedis.save();
        jedis.close();
        
        System.out.println("-------------------");
        
		
		
		
		
		//private RedisTemplate<String, User> redisTemplate;
//		User user = new User("超人", 20);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//		user = new User("蝙蝠侠", 30);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//		user = new User("蜘蛛侠", 40);
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//		System.out.println("This is the test---------");
//		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
//		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
//		//MySpringBoot2Application mysb2 = new MySpringBoot2Application();
		//mysb2.test();
		System.out.println("-------------------");
		System.out.println("This is spring-boot-end");
	}
}
