package dao;

import java.sql.*;
import java.util.*;
import beans.*;
import config.DBContext;
public class ProductDAO {
	private Connection conn;

	public ProductDAO() {
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM Product WHERE status = 1 ORDER BY pid DESC";
		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Product p = new Product(rs.getInt("pid"), rs.getString("name"), rs.getString("image"),
						rs.getDouble("price"), rs.getString("title"), rs.getString("description"), rs.getInt("cateID"),
						rs.getInt("stock"), rs.getInt("sellCount"), rs.getBoolean("status"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	// test kết nối
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.getAllProducts();
		for (Product p : list) {
			System.out.println(p.getPid() + " - " + p.getName() + " - " + p.getPrice() + "₫");
		}
	}

	
}