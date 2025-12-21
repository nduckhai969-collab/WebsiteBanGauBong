package dao;

import java.sql.*;
import beans.Account;
import config.DBContext;

public class AccountDAO {
	private Connection conn;

	public AccountDAO() {
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Đăng nhập
	public Account login(String user, String pass) {
	    String sql = "SELECT * FROM Account WHERE users = ? AND pass = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, user.trim());
	        ps.setString(2, pass.trim());
	        ResultSet rs = ps.executeQuery();	        
	        if (rs.next()) {
	            System.out.println("ĐĂNG NHẬP THÀNH CÔNG!");
	            return new Account(
	                rs.getInt("uid"),
	                rs.getString("users"),
	                rs.getString("pass"),
	                rs.getString("fullName"),
	                rs.getString("email"),
	                rs.getString("phone"),
	                rs.getBoolean("isAdmin")
	            );
	        } else {
	            System.out.println("SAI USER HOẶC PASS");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
		}
		return null;
	}
}
