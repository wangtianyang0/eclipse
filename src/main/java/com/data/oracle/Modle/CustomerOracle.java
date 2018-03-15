package com.data.oracle.Modle;

import java.sql.*;

import com.data.oracle.util.DB;

public class CustomerOracle {
	
	private String partitionId;
	private String custId;
	private String psptId;
	private String custName;
	private String psptTypeCode;
	private String removeTag;
	
	public static CustomerOracle getCustomerOracle(String psptId) {
		Connection con = DB.getConnection();
		String sql = "SELECT * FROM TF_F_CUSTOMER_CBSS WHERE PSPT_ID = '" + psptId + "'";
		PreparedStatement pst = DB.getPreparedStatment(con, sql);
		ResultSet rs = DB.getResultSt(pst);
		CustomerOracle customer = new CustomerOracle();
		try {
			while(rs.next()) {
				customer.setCustId(rs.getString("CUST_ID"));
				customer.setPsptId(rs.getString("PSPT_ID"));
				customer.setPartitionId(rs.getString("PARTITION_ID"));
				/*String custIdBefore = rs.getString("CUST_ID").substring(0,rs.getString("CUST_ID").length()-4);
				if (customer.getPartitionId().equals("")) {
					customer.setPartitionId("0000");
				} else if (customer.getPartitionId().length() == 1) {
					customer.setPartitionId("000" + customer.getPartitionId());
				} else if (customer.getPartitionId().length() == 2) {
					customer.setPartitionId("00" + customer.getPartitionId());
				} else if (customer.getPartitionId().length() == 3) {
					customer.setPartitionId("0" + customer.getPartitionId());
				}
				customer.setCustId(custIdBefore + customer.getPartitionId());*/
				customer.setCustName(rs.getString("CUST_NAME"));
				customer.setPsptTypeCode(rs.getString("PSPT_TYPE_CODE"));
				customer.setRemoveTag(rs.getString("REMOVE_TAG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con);
			DB.close(pst);
			DB.close(rs);
		}
		if (customer.getCustId() == null ) {
			return null;
		} else {
			return customer;
		}
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getPartitionId() {
		return partitionId;
	}
	public void setPartitionId(String partitionId) {
		this.partitionId = partitionId;
	}
	public String getPsptId() {
		return psptId;
	}
	public void setPsptId(String psptId) {
		this.psptId = psptId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPsptTypeCode() {
		return psptTypeCode;
	}
	public void setPsptTypeCode(String psptTypeCode) {
		this.psptTypeCode = psptTypeCode;
	}
	public String getRemoveTag() {
		return removeTag;
	}
	public void setRemoveTag(String removeTag) {
		this.removeTag = removeTag;
	}
	
}
