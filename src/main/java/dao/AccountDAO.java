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
		String sql = "SELECT * FROM Account WHERE user = ? AND pass = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(rs.getInt("uid"), rs.getString("user"), rs.getString("pass"),
						rs.getString("fullName"), rs.getString("email"), rs.getString("phone"),
						rs.getBoolean("isAdmin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
