package com.data.redis.dao;

import java.util.ArrayList;
import java.util.List;

import com.data.redis.usr.User;
import com.data.redis.util.SerializeUtil;

import redis.clients.jedis.Jedis;

public class UserDao {
	private List<User> users;
	
	public UserDao(){
		load();
	}
	public void save(){
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.set("usrs".getBytes(), SerializeUtil.serialize(users));
		jedis.bgsave();
		jedis.close();
	}
	
	/**
	 * 注意这里的返回值，设置成users这个值
	 **
	 *
	 */
	
	/**
	 * 注意这里的返回值，设置成users这个值
	 *	 
	 */
	public void load(){
		Jedis jedis = new Jedis("127.0.0.1",6379);
		byte[] byties = jedis.get("user".getBytes());
		if(byties !=null && byties.length>0)
		{
			users = (List<User>)SerializeUtil.deSerialize(byties, User.class);
		}
		else{
			users = new ArrayList<User>();
		}
		jedis.close();
	}
	/**
	 * 添加表
	 */
	public void add(User car)
	{
		this.users.add(car);
		save();
	}
	
	public User getUserByUSER_ID(long userid)
	{
		for(User user: users)
		{
			if(user.getUSER_ID() == userid)
				return user;
		}
		
		return null;
		
	}
	
	public void removeByUSER_ID(long userid)
	{
		users.remove(getUserByUSER_ID(userid));
	}
	
	public User getUserBySERIAL_NUMBER(long serial_number)
	{
		for(User user: users)
		{
			if(user.getSERIAL_NUMBER() == serial_number)
				return user;
		}
		
		return null;
		
	}
	
	public void removeBySERIAL_NUMBER(long serial_number)
	{
		users.remove(getUserBySERIAL_NUMBER(serial_number));
	}
	
	public User getUserByPSPT_ID(long pspt_id)
	{
		for(User user: users)
		{
			if(user.getPSPT_ID() == pspt_id)
				return user;
		}
		
		return null;
		
	}
	
	public void removeByPSPT_ID(long pspt_id)
	{
		users.remove(getUserByPSPT_ID(pspt_id));
	}
	
	public User getUserByPSPT_TYPE_CODE(int pspt_type_code)
	{
		for(User user: users)
		{
			if(user.getPSPT_TYPE_CODE() == pspt_type_code)
				return user;
		}
		
		return null;
		
	}
	
	public void removeByPSPT_TYPE_CODE(int pspt_type_code)
	{
		users.remove(getUserByPSPT_TYPE_CODE(pspt_type_code));
	}
	
	public User getUserByCUST_NAME(String custname)
	{
		for(User user: users)
		{
			if(user.getCUST_NAME().equals(custname))
				return user;
		}
		
		return null;
		
	}
	
	public void removeByCUST_NAME(String custname)
	{
		users.remove(getUserByCUST_NAME(custname));
	}
	
	public User getUserBySTATUS(int status)
	{
		for(User user: users)
		{
			if(user.getSTATUS()==(status))
				return user;
		}
		
		return null;
		
	}
	
	public void removeBySTATUS(int status)
	{
		users.remove(getUserBySTATUS(status));
	}
	
	//public long 
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public void setUsers(List<User> users)
	{
		this.users = users;
		save();
	}
	
	
	
}
 