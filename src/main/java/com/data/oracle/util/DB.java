package com.data.oracle.util;

import java.sql.*;

public class DB {

	public static Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.124.0.41:1521/ngcrm", "UCR_CRM1", "cbss_UCR_CRM1");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

	public static PreparedStatement getPreparedStatment(Connection con, String sql) {

		PreparedStatement pst = null;

		try {
			if (con != null)
				pst = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pst;

	}

	public static ResultSet getResultSt(PreparedStatement pst) {

		ResultSet rs = null;

		try {
			if (pst != null)
				rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}
	
	public static void close (Statement stt) {
		if (stt != null)
			try {
				stt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void close (ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void close (Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
