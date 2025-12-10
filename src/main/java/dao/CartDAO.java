package dao;

import beans.*;
import config.DBContext;
import java.sql.*;
import java.util.*;

public class CartDAO {
	private Connection conn;

	public CartDAO() {
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Lấy giỏ hàng hiện tại của user (status = 0)
	public Cart getActiveCart(int uid) {
		String sql = "SELECT * FROM Cart WHERE uid = ? AND status = 0";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Cart(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Tạo giỏ mới nếu chưa có
	public void createCart(int uid) {
		String sql = "INSERT INTO Cart(uid, buyDate, status) VALUES(?, GETDATE(), 0)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, uid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Lấy danh sách sản phẩm trong giỏ
	public List<CartItem> getCartItems(int cartID) {
		List<CartItem> list = new ArrayList<>();
		String sql = """
				SELECT cd.*, p.name, p.image, p.image, p.price as currentPrice
				FROM CartDetail cd
				JOIN Product p ON cd.pid = p.pid
				WHERE cd.cartID = ?
				""";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, cartID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartItem item = new CartItem();
				item.setId(rs.getInt("id"));
				item.setCartID(rs.getInt("cartID"));
				item.setQuantity(rs.getInt("quantity"));
				item.setPrice(rs.getDouble("price"));

				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setName(rs.getString("name"));
				p.setImage(rs.getString("image"));
				item.setProduct(p);
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Thêm sản phẩm vào giỏ
	public void addToCart(int uid, int pid, int quantity) {
        Cart cart = getActiveCart(uid);
        if (cart == null) {
            createCart(uid);
            cart = getActiveCart(uid);
        }

        String sql = "SELECT price FROM Product WHERE pid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double price = rs.getDouble("price");

                // Kiểm tra đã có trong giỏ chưa
                String check = "SELECT * FROM CartDetail WHERE cartID = ? AND pid = ?";
                try (PreparedStatement ps2 = conn.prepareStatement(check)) {
                    ps2.setInt(1, cart.getCartID());
                    ps2.setInt(2, pid);
                    ResultSet rs2 = ps2.executeQuery();
                    if (rs2.next()) {
                        // Đã có → tăng số lượng
                        String update = "UPDATE CartDetail SET quantity = quantity + ? WHERE cartID = ? AND pid = ?";
                        try (PreparedStatement ps3 = conn.prepareStatement(update)) {
                            ps3.setInt(1, quantity);
                            ps3.setInt(2, cart.getCartID());
                            ps3.setInt(3, pid);
                            ps3.executeUpdate();
                        }
                    } else {
                        // Chưa có → thêm mới
                        String insert = "INSERT INTO CartDetail(cartID, pid, quantity, price) VALUES(?,?,?,?)";
                        try (PreparedStatement ps3 = conn.prepareStatement(insert)) {
                            ps3.setInt(1, cart.getCartID());
                            ps3.setInt(2, pid);
                            ps3.setInt(3, quantity);
                            ps3.setDouble(4, price);
                            ps3.executeUpdate();
                        }
                    }
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}