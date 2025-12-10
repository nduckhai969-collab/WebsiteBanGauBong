package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static final String DB_NAME = "ToyShopDB";
    private static final String SERVER_NAME = "localhost";  
    private static final String PORT = "1433";

    // Chuỗi kết nối Windows Authentication
    private static final String URL = "jdbc:sqlserver://" + SERVER_NAME + ":" + PORT +
            ";databaseName=" + DB_NAME +
            ";integratedSecurity=true" +
            ";encrypt=true;trustServerCertificate=true;";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy driver SQL Server", e);
        }
        return DriverManager.getConnection(URL);
    }

    // Test kết nối (chạy main này để kiểm tra)
    public static void main(String[] args) {
        try (Connection conn = new DBContext().getConnection()) {
            System.out.println("Kết nối SQL Server thành công bằng Windows Authentication!");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
            e.printStackTrace();
        }
    }
}