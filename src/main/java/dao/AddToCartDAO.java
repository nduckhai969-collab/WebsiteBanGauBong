package dao;

import java.sql.*;
import beans.*;
import config.DBContext;

public class AddToCartDAO {
    private Connection conn;

    public AddToCartDAO() {
        try {
            conn = new DBContext().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Thêm sản phẩm vào giỏ hàng của user
     * @param uid ID người dùng (từ session acc.getUid())
     * @param pid ID sản phẩm
     * @param quantity Số lượng thêm (mặc định 1)
     */
    public void addToCart(int uid, int pid, int quantity) {
        try {
            // Lấy giỏ hàng hiện tại của user (status = 0)
            int cartID = getActiveCartID(uid);
            if (cartID == -1) {
                cartID = createNewCart(uid);
            }

            //Lấy giá 
            double price = getProductPrice(pid);

            if (price == -1) {
                System.out.println("Sản phẩm không tồn tại: pid = " + pid);
                return;
            }

            // Kiểm tra đã có trong giỏ 
            if (isProductInCart(cartID, pid)) {
                updateQuantity(cartID, pid, quantity);
            } else {
                insertNewItem(cartID, pid, quantity, price);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy cartID của giỏ đang hoạt động
    private int getActiveCartID(int uid) {
        String sql = "SELECT cartID FROM Cart WHERE uid = ? AND status = 0";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, uid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("cartID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // chưa có giỏ
    }

    // Tạo giỏ mới
    private int createNewCart(int uid) {
        String sql = "INSERT INTO Cart (uid, buyDate, status) OUTPUT INSERTED.cartID VALUES (?, GETDATE(), 0)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, uid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Lấy giá sản phẩm
    private double getProductPrice(int pid) {
        String sql = "SELECT price FROM Product WHERE pid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("price");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Kiểm tra sản phẩm đã có trong giỏ chưa
    private boolean isProductInCart(int cartID, int pid) {
        String sql = "SELECT 1 FROM CartDetail WHERE cartID = ? AND pid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cartID);
            ps.setInt(2, pid);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Tăng số lượng
    private void updateQuantity(int cartID, int pid, int quantity) {
        String sql = "UPDATE CartDetail SET quantity = quantity + ? WHERE cartID = ? AND pid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, cartID);
            ps.setInt(3, pid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Thêm mới sản phẩm vào giỏ
    private void insertNewItem(int cartID, int pid, int quantity, double price) {
        String sql = "INSERT INTO CartDetail (cartID, pid, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cartID);
            ps.setInt(2, pid);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public int getCartItemCount(int uid) {
    int count = 0;
    try {
        int cartID = getActiveCartID(uid);
        if (cartID == -1) return 0;

        String sql = "SELECT COUNT(*) FROM CartDetail WHERE cartID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cartID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return count;
}
}