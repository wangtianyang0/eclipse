package com.controller.SpringbootController.servlet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.oracle.Modle.CustomerOracle;
import com.data.oracle.Modle.UserOracle;
import com.data.oracle.Modle.UserOracleDao;
import com.data.redis.usr.User;
import com.data.redis.util.RedisUtil;

import redis.clients.jedis.Jedis;

@RestController
public class WebReturnDataController {
	
	@RequestMapping(value ="/findall",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getAllUserInformation(@RequestParam String USER_ID,HttpServletResponse res,HttpServletRequest req){
		String PKUSER_ID = "";
		PKUSER_ID = USER_ID;
		User user = new User();
		Map<String, String> AllUserInformation = (user.getAllUserInformation(USER_ID));
		//req.setAttribute("AllUserInformation", AllUserInformation);
		if(AllUserInformation==null){
			return null;
		}
		else{
			return AllUserInformation;
		}
	}
	@RequestMapping(value ="/findallinfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Map<String,String>> getAllUserAllInformation(@RequestParam String PSPT_ID,HttpServletResponse res,HttpServletRequest req){
		User user = new User();
		Map<String,Map<String,String>> alluserallinformation = new HashMap<String,Map<String,String>>();
		alluserallinformation = user.FindAllUserAllInformation(PSPT_ID);
		if(alluserallinformation == null){
			return null;
		}
		else{
			return alluserallinformation;
		}
	}
	
	
	@RequestMapping(value ="/finduser", method=RequestMethod.POST)
	@ResponseBody
	public Set<String> getUserIdbyPSPT_ID(@RequestParam String PSPT_ID){
		//Jedis jedis = RedisUtil.getJedis();
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
        if(UserList==null){
        	return null;
        }
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
        
        /**
         * Oracle数据库的查询
         */
        //System.out.println("PKUSER_ID:"+PKUSER_ID);
        return UserList;
	}
	@RequestMapping(value ="/finduserSerialNum", method=RequestMethod.POST)
	public Map<String,Map<String,String>> findUserSerialNum(@RequestParam String PSPT_ID)
	{
		UserOracleDao userOracle = new UserOracleDao();
		Map<String,Map<String,String>> UserOracleinformation = userOracle.findAllUserNumber(PSPT_ID);
		if(UserOracleinformation == null)
		{
			return null;
		}
		else{
			System.out.println("UserOracleinformation.isEmpty(): STATE:"+UserOracleinformation.isEmpty());
			return UserOracleinformation;
		}
		
//	    if(UserNumber.isEmpty() && UserNumber!=null){
//        	return null;
//        }
//		if(UserNumber.isEmpty()){
//			return null;
//		}
//		else{
//			return UserNumber;
//		}
		
		//return UserNumber;	
	}

}
