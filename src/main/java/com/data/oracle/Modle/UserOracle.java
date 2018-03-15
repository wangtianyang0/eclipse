package com.data.oracle.Modle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.*;
import com.data.oracle.util.DB;

public class UserOracle {
	
	public static List<UserOracle> getUsers(CustomerOracle customer){
		if (customer == null) {
			return null;
		} else {
			List<UserOracle> users = new ArrayList<UserOracle>();
			Connection con = DB.getConnection();
			String sql = "SELECT * FROM TF_F_USER_CBSS WHERE CUST_ID = '" + customer.getCustId() + "'";
			//System.out.println(sql);
			PreparedStatement pst = DB.getPreparedStatment(con, sql);
			ResultSet rs = DB.getResultSt(pst);			
			try {
				while (rs.next()) {
					UserOracle user = new UserOracle();
					//System.out.println("����ѭ��");
					user.setCustId(customer.getCustId());
					user.setUserId(rs.getString("USER_ID"));
					user.setOpenDate(rs.getTimestamp("OPEN_DATE"));
					user.setPartitionId(rs.getString("PARTITION_ID"));
					user.setRemoveTag(rs.getString("REMOVE_TAG"));
					user.setSerialNum(rs.getString("SERIAL_NUMBER"));
					user.setTpyeCode(rs.getString("NET_TYPE_CODE"));
					/*String userIdBefore = rs.getString("USER_ID").substring(0,rs.getString("USER_ID").length()-4);
					if (user.getPartitionId().equals("")) {
						user.setPartitionId("0000");
					} else if (user.getPartitionId().length() == 1) {
						user.setPartitionId("000" + customer.getPartitionId());
					} else if (user.getPartitionId().length() == 2) {
						user.setPartitionId("00" + user.getPartitionId());
					} else if (customer.getPartitionId().length() == 3) {
						user.setPartitionId("0" + user.getPartitionId());
					}
					user.setUserId(userIdBefore + user.getPartitionId());*/
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB.close(con);
				DB.close(pst);
				DB.close(rs);
			}
			return users;
		}
	}
	
	public static void deleteUser(String userId) {
		Connection con = DB.getConnection();
		Statement stt = null;
		try {
			stt = con.createStatement();
			stt.executeUpdate("DELETE FROM TF_F_USER_CBSS WHERE USER_ID='" + userId + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con);
			DB.close(stt);
		}
	}
	public static int deleteUserBySERIAL_NUMBER(String SERIAL_NUMBER)
	{
		Connection con = DB.getConnection();
		Statement stt = null;
		try {
			stt = con.createStatement();
			//stt.executeUpdate("DELETE FROM TF_F_USER_CBSS WHERE PSPT_ID='" + PSPT_ID + "'");
			int status =stt.executeUpdate("DELETE FROM TF_F_USER_CBSS WHERE SERIAL_NUMBER='" + SERIAL_NUMBER + "'");
			System.out.println("status:"+status);
			if(status == 0)
				return 0;
			else
				return 1;
			//stt.executeUpdate("DELETE FROM TF_F_USER WHERE USER_ID='" + USER_ID + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con);
			DB.close(stt);
			
		}
		return 65535;
	}
	
	public static void deleteUser(UserOracle user) {
		deleteUser(user.getUserId());
	}
	
	public String getPartitionId() {
		return partitionId;
	}
	public void setPartitionId(String partitionId) {
		this.partitionId = partitionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getTpyeCode() {
		return tpyeCode;
	}
	public void setTpyeCode(String tpyeCode) {
		this.tpyeCode = tpyeCode;
	}
	public Timestamp getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Timestamp openDate) {
		this.openDate = openDate;
	}
	public String getRemoveTag() {
		return removeTag;
	}
	public void setRemoveTag(String removeTag) {
		this.removeTag = removeTag;
	}
	private String partitionId;
	private String userId;
	private String custId;
	private String serialNum;
	private String tpyeCode;
	private Timestamp openDate;
	private String removeTag;

}
