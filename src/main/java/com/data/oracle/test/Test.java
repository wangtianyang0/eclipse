package com.data.oracle.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.data.oracle.Modle.CustomerOracle;
import com.data.oracle.Modle.UserOracle;
import com.data.oracle.Modle.UserOracleDao;

public class Test {

	public static void main(String[] args) {
		CustomerOracle c = CustomerOracle.getCustomerOracle("230103198709230700");
		//CustomerOracle c = CustomerOracle.getCustomerOracle("110103198401170323");
		System.out.println("partitionId:"+c.getPartitionId());
		System.out.println("custid:"+c.getCustId());
		List<UserOracle> users = UserOracle.getUsers(c);
		for(int i=0 ; i<users.size(); i++) {
			System.out.println("SerialNum:"+users.get(i).getSerialNum());
		}
		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		UserOracleDao a = new UserOracleDao();
		Map<String,Map<String,String>> information = a.findAllUserNumber("230103198709230700");
		System.out.println("----------------------------------");
		if(information == null)
		{
			System.out.println("There IS no USERNumber");
		}
		else{
		for (Map.Entry<String,Map<String,String>> entry : information.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
		}
		//UserOracle.deleteUserBySERIAL_NUMBER("18518770599");
		//UserOracle.deleteUser(users.get(0));
	}

}
