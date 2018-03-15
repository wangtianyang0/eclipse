package com.controller.SpringbootController.servlet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.oracle.Modle.CustomerOracle;
import com.data.oracle.Modle.UserOracle;
import com.data.redis.usr.User;
import com.data.redis.util.RedisUtil;

import redis.clients.jedis.Jedis;

@Controller
public class WebDataController {
	
	public WebDataController() {
        super();
        // TODO Auto-generated constructor stub
    }
	@RequestMapping(value ="/updateall",method=RequestMethod.GET)
	public String login(@RequestParam("USER_ID")String USER_ID,@RequestParam("PSPT_ID")String PSPT_ID,@RequestParam("SERIAL_NUMBER")String SERIAL_NUMBER,@RequestParam("PSPT_TYPE_CODE")String PSPT_TYPE_CODE,@RequestParam("CUST_NAME")String CUST_NAME,@RequestParam("STATUS")String STATUS,HttpServletResponse res,HttpServletRequest req){
		req.getSession().setAttribute("USER_ID", USER_ID);
		req.getSession().setAttribute("PSPT_ID", PSPT_ID);
		//.getSession().setAttribute("updateinformation", updateinformation);
		
		/**
		 * 加入查询的语句Oracle的语句
		 */
		Jedis jedis = RedisUtil.getJedis();
        User user = new User();
        Set<String> UserList = new HashSet<String>();
        //Set<String> user_id_value_set = new HashSet<String>();
        
        //根据PSPT_ID查询USER_ID
        String PKPSPT_ID = "";
        PKPSPT_ID = "Index+"+PSPT_ID;
        UserList = user.getUSER_IDbyPSPT_ID(PKPSPT_ID);
        String PKUSER_ID="";
        Iterator<String> it = UserList.iterator();
        while(it.hasNext()){
        	//System.out.println((String)it.next());
        	PKUSER_ID = (String)it.next();
        }	
        //根据USER_ID查询出所有用户信息
        Map<String,String> map = user.getAllUserInformation(USER_ID);
        user.printAllUserInformation(user.getAllUserInformation(USER_ID));
        //更新数据
        //user.updateUserInformationByUseID("1000000000000050", "100040", "23010345666666","1000000", "200", "system", "1");
    	user.updateUserInformationByUseID(PKUSER_ID,USER_ID,PSPT_ID,SERIAL_NUMBER,PSPT_TYPE_CODE,CUST_NAME,STATUS);
        //删除数据
    	user.deleteValue(PKUSER_ID, "USER_ID");
        jedis.save();
        jedis.close();
        
		return "login";
	}
	@RequestMapping(value="/delete1" , method=RequestMethod.GET)
	public String DeleteUSER(@RequestParam("USER_ID")String USER_ID,@RequestParam("PSPT_ID")String PSPT_ID)
	{
		Jedis jedis = RedisUtil.getJedis();
        User user = new User();
        /**
         * 可以修改PKUSER-id的命名
         */
        /**
         * 字符串拼接时可以进行优化
         */
        String PKUSER_ID=""+USER_ID;
        String PKPSPT_ID = "";
        PKPSPT_ID = "Index+"+PSPT_ID;
		user.deleteUser(PKPSPT_ID, PKUSER_ID);
		/**
		 * 判断是否存在用户，不存在返回删除失败。
		 */
		if(user.IsExistKey(PKUSER_ID,"USER_ID")){
			user.deleteValue(PKUSER_ID, "USER_ID");
		}
		else{
			return "deleteFailed";
		}
		if(user.IsExistKey(PKUSER_ID,"PSPT_ID")){
			user.deleteValue(PKUSER_ID, "PSPT_ID");
		}
		else{
			return "deleteFailed";
		}
		
		
		if(user.IsExistKey(PKUSER_ID,"SERIAL_NUMBER")){
			user.deleteValue(PKUSER_ID, "SERIAL_NUMBER");
		}
		if(user.IsExistKey(PKUSER_ID,"PSPT_TYPE_CODE")){
			user.deleteValue(PKUSER_ID, "PSPT_TYPE_CODE");
		}
		if(user.IsExistKey(PKUSER_ID,"CUST_NAME")){
			user.deleteValue(PKUSER_ID, "CUST_NAME");
		}
		if(user.IsExistKey(PKUSER_ID,"STATUS")){
			user.deleteValue(PKUSER_ID, "STATUS");
		}
		System.out.println("delete:"+USER_ID);
		jedis.save();
        jedis.close();
        return "DeleteSuccess";
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String UpdateUserInformation(@RequestParam("USER_ID")String USER_ID,@RequestParam("PSPT_ID")String PSPT_ID,@RequestParam("SERIAL_NUMBER")String SERIAL_NUMBER,@RequestParam("PSPT_TYPE_CODE")String PSPT_TYPE_CODE,@RequestParam("CUST_NAME")String CUST_NAME,@RequestParam("STATUS")String STATUS,HttpServletResponse res,HttpServletRequest req){
		Jedis jedis = RedisUtil.getJedis();
        User user = new User();
//        Set<String> UserList = new HashSet<String>();
//        String PKPSPT_ID = "";
//        PKPSPT_ID = "Index+"+PSPT_ID;
//        UserList = user.getUSER_IDbyPSPT_ID(PKPSPT_ID);
        /**
         * PKUSER_ID应该是一个数组
         */
//        String PKUSER_ID="";
//        Iterator<String> it = UserList.iterator();
//        while(it.hasNext()){
//        	//System.out.println((String)it.next());
//        	PKUSER_ID = (String)it.next();
//        }
        String PKUSER_ID = "";
        /**
         * 若改变程序，需要更改PKUSER_ID的赋值语句
         */
        PKUSER_ID = USER_ID + "";
        /***
         * 这里可以加入判断
         */
//        if("".equals(USER_ID)||"".equals(PSPT_ID)||"".equals(CUST_NAME)||"".equals(PSPT_TYPE_CODE)||"".equals(SERIAL_NUMBER)||"".equals(STATUS)){
//        	if(user.IsExistKey(USER_ID,"USER_ID")){
//        		
//        	}
//        }
//        else{
//        	
//        }
		Boolean status = user.updateUserInformationByUseID(PKUSER_ID,USER_ID,PSPT_ID,SERIAL_NUMBER,PSPT_TYPE_CODE,CUST_NAME,STATUS);
		jedis.save();
        jedis.close();
        if(status == false){
        	return "updateFailed";
        }
        else{
        	return "updateSuccess";
        }
        
	}
	
	@RequestMapping(value="/update_status",method=RequestMethod.GET)
	public String UpdateUserStatusInformation(@RequestParam("USER_ID")String USER_ID,@RequestParam("PSPT_ID")String PSPT_ID,@RequestParam("STATUS")String STATUS,HttpServletResponse res,HttpServletRequest req){
		Jedis jedis = RedisUtil.getJedis();
        User user = new User();
//        Set<String> UserList = new HashSet<String>();
//        String PKPSPT_ID = "";
//        PKPSPT_ID = "Index+"+PSPT_ID;
//        UserList = user.getUSER_IDbyPSPT_ID(PKPSPT_ID);
        /**
         * PKUSER_ID应该是一个数组
         */
//        String PKUSER_ID="";
//        Iterator<String> it = UserList.iterator();
//        while(it.hasNext()){
//        	//System.out.println((String)it.next());
//        	PKUSER_ID = (String)it.next();
//        }
        String PKUSER_ID = "";
        /**
         * 若改变程序，需要更改PKUSER_ID的赋值语句
         */
        PKUSER_ID = USER_ID + "";
        /***
         * 这里可以加入判断
         */
//        if("".equals(USER_ID)||"".equals(PSPT_ID)||"".equals(CUST_NAME)||"".equals(PSPT_TYPE_CODE)||"".equals(SERIAL_NUMBER)||"".equals(STATUS)){
//        	if(user.IsExistKey(USER_ID,"USER_ID")){
//        		
//        	}
//        }
//        else{
//        	
//        }
		Boolean status = user.updateUserStatusbyUseID(PKUSER_ID,PSPT_ID,STATUS);
		jedis.save();
        jedis.close();
        if(status == false){
        	return "updateFailed";
        }
        else{
        	return "updateSuccess";
        }
        
	}
	
	@RequestMapping(value ="/findall1",method=RequestMethod.GET)
	public String getAllUserInformation(@RequestParam String USER_ID){
		String PKUSER_ID = "";
		PKUSER_ID = USER_ID;
		User user = new User();
        user.printAllUserInformation(user.getAllUserInformation(USER_ID));
        return "index";
	}
	@RequestMapping(value ="/finduser1", method=RequestMethod.GET)
	public String getUserIdbyPSPT_ID(@RequestParam String PSPT_ID){
		Jedis jedis = RedisUtil.getJedis();
        User user = new User();
        /**
         * 使用LIst来存放所有的USER_ID
         */
        Set<String> UserList = new HashSet<String>();
        //Set<String> user_id_value_set = new HashSet<String>();
        
        //根据PSPT_ID查询USER_ID
        String PKPSPT_ID = "";
        PKPSPT_ID = "Index+"+PSPT_ID;
        UserList = user.getUSER_IDbyPSPT_ID(PKPSPT_ID);
        /**
         * 
         */
        String PKUSER_ID="";
        Iterator<String> it = UserList.iterator();
        while(it.hasNext()){
        	//System.out.println((String)it.next());
        	PKUSER_ID = (String)it.next();
        	System.out.println("PKUSER_ID:"+PKUSER_ID);
        }
        /**
         * 直接使用打印UserliST也可
         */
        jedis.save();
        jedis.close();
        //System.out.println("PKUSER_ID:"+PKUSER_ID);
        return "index";
	}
	
	@RequestMapping(value="/delete" , method=RequestMethod.GET)
	public String deleteUserBySERIAL_NUMBER(@RequestParam String SERIAL_NUMBER){
		/**
		UserOracle user = new UserOracle();
		CustomerOracle customer = CustomerOracle.getCustomerOracle(PSPT_ID);
		List<UserOracle> users = UserOracle.getUsers(customer);
		if(users == null){
			return "deleteFailed";
		}
		*/
		int Status = UserOracle.deleteUserBySERIAL_NUMBER(SERIAL_NUMBER);
		if(Status == 0)
		{
			return "deleteFailed";
		}
		else if(Status == 1){
			return "DeleteSuccess";
		}
		else{
			return  "deleteFailed";
		}
		
	}

}
