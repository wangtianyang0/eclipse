package com.data.oracle.Modle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserOracleDao {
	public Map<String,Map<String,String>> findAllUserNumber(String PSPT_ID){
		CustomerOracle customer = CustomerOracle.getCustomerOracle(PSPT_ID);
		//System.out.println("partitionId:"+customer.getPartitionId());
		//System.out.println("custid:"+customer.getCustId());
		List<UserOracle> users = UserOracle.getUsers(customer);
		/**
		 * 从Oracle数据库中得到号码信息
		 */
		if(users == null)
		{
			return null;
		}
		
		Set<String> serialNum = new HashSet<String>();
		if(!users.isEmpty() && users!=null){
			for(int i=0 ; i<users.size(); i++) {
				String tempserialNum = users.get(i).getSerialNum();
				serialNum.add(tempserialNum);
				System.out.println("SerialNum:"+users.get(i).getSerialNum());
			}
		}
		Map<String,Map<String,String>> userallinformationall = new HashMap<String,Map<String,String>>();
		String user_id="";
		String cust_id="";
		String serialnum="";
		String partitionid="";
		String removetag="";
		String typecode="";
		for(int i=0;i<users.size();i++){
			user_id = users.get(i).getUserId();
			cust_id = users.get(i).getCustId();
			serialnum = users.get(i).getSerialNum();
			partitionid = users.get(i).getPartitionId();
			removetag = users.get(i).getRemoveTag();
			typecode = users.get(i).getTpyeCode();
			
			Map<String,String> usersallinformation = new HashMap<String,String>();
			
			usersallinformation.put("USER_ID", user_id);
			usersallinformation.put("CUST_ID", cust_id);
			usersallinformation.put("SERIAL_NUMBER",serialnum);
			usersallinformation.put("PARTITION_ID", partitionid);
			usersallinformation.put("TYPECODE", typecode);
			usersallinformation.put("REMOVE_TAG", removetag);
			
			//把遍历的信息汇总，加入到集合中，下标用1~5表示
			String string=String.valueOf(i);
			userallinformationall.put(string, usersallinformation);
		}
		return userallinformationall;
		
	}
}
