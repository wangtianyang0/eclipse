package com.data.redis.usr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.data.redis.util.RedisUtil;

import redis.clients.jedis.Jedis;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 309131457324683839L;
	
	private long  USER_ID;
	private long  SERIAL_NUMBER;
	private long  PSPT_ID;
	private int  PSPT_TYPE_CODE;
	private String CUST_NAME;
	private int STATUS;
	
	private String user_id="USER_ID";
	private String serial_number="SERIAL_NUMBER";
	private String pspt_id="PSPT_ID";
	private String pspt_type_code="PSPT_TYPE_CODE";
	private String cust_name="CUST_NAME";
	private String status="STATUS";
	
	
	Map<String,Long> USER_ID_MAP = new HashMap<String,Long>();
	Map<String,Long> SERIAL_NUMBER_MAP = new HashMap<String,Long>();
	Map<String,Long> PSPT_ID_MAP = new HashMap<String,Long>();
	Map<String,Integer> PSPT_TYPE_CODE_MAP = new HashMap<String,Integer>();
	Map<String,String> CUST_NAME_MAP = new HashMap<String,String>();
	Map<String,Integer> STATUS_MAP = new HashMap<String,Integer>();
	
	List<User> USER_LIST = new ArrayList<User>();
	Set<User> USER_TABLE_SET = new HashSet<User>();
	
	//@Autowired
	Jedis jedis = RedisUtil.getJedis();
	
	public User()
	{
		
	}

	/**
	 * @param uSER_ID
	 * @param sERIAL_NUMBER
	 * @param pSPT_ID
	 * @param pSPT_TYPE_CODE
	 * @param cUST_NAME
	 * @param sTATUS
	 */
	public User(long uSER_ID, long sERIAL_NUMBER, long pSPT_ID, int pSPT_TYPE_CODE, String cUST_NAME, int sTATUS) {
		//super();
		USER_ID = uSER_ID;
		SERIAL_NUMBER = sERIAL_NUMBER;
		PSPT_ID = pSPT_ID;
		PSPT_TYPE_CODE = pSPT_TYPE_CODE;
		CUST_NAME = cUST_NAME;
		STATUS = sTATUS;
	}

	@Override
	public String toString() {
		return "User [USER_ID=" + USER_ID + ", SERIAL_NUMBER=" + SERIAL_NUMBER + ", PSPT_ID=" + PSPT_ID
				+ ", PSPT_TYPE_CODE=" + PSPT_TYPE_CODE + ", CUST_NAME=" + CUST_NAME + ", STATUS=" + STATUS + "]";
	}

	public long getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(long uSER_ID) {
		//USER_ID = uSER_ID;
		USER_ID_MAP.put(user_id, uSER_ID);
	}

	public long getSERIAL_NUMBER() {
		return SERIAL_NUMBER;
	}

	public void setSERIAL_NUMBER(long sERIAL_NUMBER) {
		SERIAL_NUMBER_MAP.put(serial_number, sERIAL_NUMBER);
		//SERIAL_NUMBER = sERIAL_NUMBER;
	}

	public long getPSPT_ID() {
		return PSPT_ID;
	}

	public void setPSPT_ID(long pSPT_ID) {
		//PSPT_ID = pSPT_ID;
		PSPT_ID_MAP.put(pspt_id, pSPT_ID);
	}

	public int getPSPT_TYPE_CODE() {
		return PSPT_TYPE_CODE;
	}

	public void setPSPT_TYPE_CODE(int pSPT_TYPE_CODE) {
		//PSPT_TYPE_CODE = pSPT_TYPE_CODE;
		PSPT_TYPE_CODE_MAP.put(pspt_type_code, pSPT_TYPE_CODE);
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String cUST_NAME) {
		CUST_NAME_MAP.put(cust_name, cUST_NAME);
		//CUST_NAME = cUST_NAME;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS_MAP.put(status, sTATUS);
		//STATUS = sTATUS;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getPspt_id() {
		return pspt_id;
	}

	public void setPspt_id(String pspt_id) {
		this.pspt_id = pspt_id;
	}

	public String getPspt_type_code() {
		return pspt_type_code;
	}

	public void setPspt_type_code(String pspt_type_code) {
		this.pspt_type_code = pspt_type_code;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 配置USER表——set的属性值
	 */
	/**
	 * 
	 * @param user_id
	 * @param user
	 */
	public void setUser(String user_id,String user)
	{
		jedis.sadd(user_id,user);
	}
	public void deleteUser(String user_id,String user)
	{
		jedis.srem(user_id, user);
	}
	
	public Set<String> getAllUser(String key)
	{
		Set<String> allValue = jedis.smembers(key);
		return allValue;
	}
	/***
	 * 以下是配置USER表——Hash的属性值
	 */
	/***
	 * 
	 * @param user_id
	 * @param key
	 * @param value
	 */
	public void setValue(String user_id,String key,String value)
	{
		jedis.hset(user_id, key, value);
	}
	/**
	 * 根据key值得到hash表中的字段
	 * @param user_id
	 * @param key
	 * @return
	 */
	public String getValue(String user_id,String key)
	{
		String getvalue=jedis.hget(user_id, key);
		return getvalue;
	}
	/**
	 * 根据key值删除hash表中的字段
	 * @param user_id
	 * @param key
	 */
	public void deleteValue(String user_id,String key)
	{
		jedis.hdel(user_id, key);
	}
	
	public Map<String,String> getAllKeyValue(String user_id)
	{
		//Map<String, String> getAllvalue = new HashMap<String, String>();
		Map<String, String> getAllkeyvalue = jedis.hgetAll(user_id);
		return getAllkeyvalue;	
	}
	public List<String> getAllValue(String user_id)
	{
		List<String> allvalue = jedis.hvals(user_id);
		return allvalue;
	}
	public Long getLength(String user_id)
	{
		Long len=jedis.hlen(user_id);
		return len;
	}
	public Set<String> getALLKey(String user_id)
	{
		Set<String> allkey = jedis.hkeys(user_id);
		return allkey;
	}
	/**
	 * 通过USER_ID获得PSPT_ID的值
	 * @param PSPT_ID
	 * @return
	 */
	public Set<String> getUSER_IDbyPSPT_ID(String PSPT_ID)
	{
		Set<String> allUser = jedis.smembers(PSPT_ID);//查询set类型的通过PSPT_ID查询到Hash表的key
		//for(String alluser: allUser)
		//{
		//	String getvalue+"1" = jedis.hget(alluser, USER_ID+"");
		//}
		Iterator<String> it = allUser.iterator();
		//String user_id_string = String.valueOf(USER_ID);//转换Long变为String类型
		String user_id_string = "USER_ID";
		
		String user_id_value = "";
		Set<String> user_id_value_set = new HashSet<String>();
		while(it.hasNext())
		{
			String user= it.next();
			//String user_id = jedis.hget(user, USER_ID+"");
			user_id_value = jedis.hget(user, "USER_ID");//user是hash表的key
			//user_id_value = jedis.hget(user, user_id_string);
			System.out.println("--------------------");
			System.out.println("getUSER_IDbyPSPT_ID");
			System.out.println("--------------------");
			System.out.println(user_id_value);
			user_id_value_set.add(user_id_value);
			//jedis.hmset(key, fields);
		}
		jedis.save();
        jedis.close();
		return user_id_value_set;	
	}
	/**
	 * 获得所有用户信息
	 * @param PKUSER_ID
	 * @return
	 */
	public Map<String, String> getAllUserInformation(String PKUSER_ID){
		
		Map<String, String> information = jedis.hgetAll(PKUSER_ID);
		jedis.save();
        jedis.close();
		//jedis.hvals(PKUSER_ID);
		return information;
		
	}
	/**
	 * 打印出用户所有信息
	 * @param information
	 */
	public void printAllUserInformation(Map<String, String> information){
		 for (String key : information.keySet()) {
	    	  String a = "字段： " + key + " 值为： " + information.get(key);
	        System.out.println(a);
	    }
	}
	/**
	 * 更新用户信息
	 * @param PKUSER_ID
	 * @param uSER_ID
	 * @param pSPT_ID
	 * @param sERIAL_NUMBER
	 * @param pSPT_TYPE_CODE
	 * @param cUST_NAME
	 * @param sTATUS
	 */
	public Boolean updateUserInformationByUseID(String PKUSER_ID,String uSER_ID,String pSPT_ID,String sERIAL_NUMBER,String pSPT_TYPE_CODE,String cUST_NAME,String sTATUS){
//		jedis.hdel(PKUSER_ID,"USER_ID");
//		jedis.hdel(PKUSER_ID,"SERIAL_NUMBER");
//		jedis.hdel(PKUSER_ID,"PSPT_TYPE_CODE");
//		jedis.hdel(PKUSER_ID,"CUST_NAME");
		//User user = new User();
		System.out.println("update is running");
		/**
		if(user.IsExistKey(PKUSER_ID,"USER_ID") ==false){
			return false;
		}
		**/
		/**
		 * 查询是否存在这个user
		 */
		Set<String> alluser =jedis.smembers("Index"+pSPT_ID);
		if(alluser == null){
			return false;
		}
		/**
		 * 若存在则进行更新
		 */
		jedis.hdel(PKUSER_ID, "USER_ID");
		jedis.hdel(PKUSER_ID,"SERIAL_NUMBER");
		jedis.hdel(PKUSER_ID,"PSPT_ID");
		jedis.hdel(PKUSER_ID,"PSPT_TYPE_CODE");
		jedis.hdel(PKUSER_ID,"STATUS");
		jedis.hdel(PKUSER_ID,"CUST_NAME");
		
		jedis.hset(PKUSER_ID, "USER_ID", uSER_ID);
		jedis.hset(PKUSER_ID, "PSPT_ID", pSPT_ID);
		jedis.hset(PKUSER_ID, "SERIAL_NUMBER" ,sERIAL_NUMBER);
		jedis.hset(PKUSER_ID, "PSPT_TYPE_CODE", pSPT_TYPE_CODE);
		jedis.hset(PKUSER_ID, "CUST_NAME", cUST_NAME);
		jedis.hset(PKUSER_ID, "STATUS", sTATUS);
		
		jedis.save();
        jedis.close();
		
		System.out.println("update is OK");
		
		return true;
	}
	
	public Boolean updateUserStatusbyUseID(String PKUSER_ID,String pSPT_ID,String sTATUS){
//		jedis.hdel(PKUSER_ID,"USER_ID");
//		jedis.hdel(PKUSER_ID,"SERIAL_NUMBER");
//		jedis.hdel(PKUSER_ID,"PSPT_TYPE_CODE");
//		jedis.hdel(PKUSER_ID,"CUST_NAME");
		//User user = new User();
		System.out.println("update status is running");
		/**
		if(user.IsExistKey(PKUSER_ID,"USER_ID") ==false){
			return false;
		}
		**/
		/**
		 * 查询是否存在这个user
		 */
		Set<String> alluser =jedis.smembers("Index"+pSPT_ID);
		if(alluser == null){
			return false;
		}
		/**
		 * 若存在则进行更新
		 */
//		jedis.hdel(PKUSER_ID, "USER_ID");
//		jedis.hdel(PKUSER_ID,"SERIAL_NUMBER");
//		jedis.hdel(PKUSER_ID,"PSPT_ID");
//		jedis.hdel(PKUSER_ID,"PSPT_TYPE_CODE");
		jedis.hdel(PKUSER_ID,"STATUS");
//		jedis.hdel(PKUSER_ID,"CUST_NAME");
		
//		jedis.hset(PKUSER_ID, "USER_ID", uSER_ID);
//		jedis.hset(PKUSER_ID, "PSPT_ID", pSPT_ID);
//		jedis.hset(PKUSER_ID, "SERIAL_NUMBER" ,sERIAL_NUMBER);
//		jedis.hset(PKUSER_ID, "PSPT_TYPE_CODE", pSPT_TYPE_CODE);
//		jedis.hset(PKUSER_ID, "CUST_NAME", cUST_NAME);
		jedis.hset(PKUSER_ID, "STATUS", sTATUS);
		
		jedis.save();
        jedis.close();
		
		System.out.println("update status is OK");
		
		return true;
	}
	
	public Boolean IsExistKey(String user_id,String key)
	{
		Boolean ok=jedis.hexists(user_id, key);
		jedis.save();
        jedis.close();
		
		return ok;
	}

	public Map<String,Map<String,String>> FindAllUserAllInformation(String m) {

		String x=new String();
		m = "Index+" + m;
		// jedis.smembers(m);
		// jedis.scard(m);
		System.out.println("身份證下共有" + jedis.scard(m) + "個UserID");
		System.out.println("UserID是：\n" + jedis.smembers(m));
		//获得Index下的所有USER_ID
		Set<String> s=new HashSet<String>();
		s=jedis.smembers(m);
//		System.out.println("输出:\n"+s);
     	Iterator<String> it = s.iterator();
     	Map<String,String> allinformation = new HashMap<String,String>();
     	Map<String,Map<String,String>> allUserAllInformation = new HashMap<String,Map<String,String>>();
     	int i=0;
		while(it.hasNext()){
			//通过USER_ID查出所有信息 it是USER-ID,先遍历所有USER_ID
			 x=it.next();
			 String string=String.valueOf(i);
			 System.out.println("UserID:"+x+"对应");
			//通过USER_ID查出所有信息 it是USER-ID
			 allinformation=SearchInf(x);
			 //Map<String,String> a = new HashMap<String,String>();
			 //allinformation = jedis.hgetAll(x);
			 allUserAllInformation.put(string,allinformation);
			 i++;
		}
        jedis.save();
        jedis.close();
		return allUserAllInformation;
	}
	public Map<String,String> SearchInf(String n){
		//System.out.println("用户号码信息:\n" + jedis.hgetAll(n));
		Map<String,String> a = new HashMap<String,String>();
		a = jedis.hgetAll(n);
		//jedis.save();
        ///jedis.close();
		return a;
	}
	
	
	
}
