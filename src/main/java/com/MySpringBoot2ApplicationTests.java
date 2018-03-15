package com;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

//import org.springframework.util.Assert;

/***
@RunWith(SpringRunner.class)
@SpringBootTest
***/
//@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration(Application.class)
@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration(MySpringBoot2Application.class)
//@SpringBootTest
public class MySpringBoot2ApplicationTests {

	@Test
	public void contextLoads() {
	}
//	@Autowired
//	private RedisTemplate<String, User> redisTemplate;
//	@Test
//	public void test() throws Exception {
//		// 保存对象
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
//	}

}
