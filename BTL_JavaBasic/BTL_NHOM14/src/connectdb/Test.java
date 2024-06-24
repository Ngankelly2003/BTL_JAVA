package connectdb;

import java.sql.Connection;
public class Test {

    public static void main(String[] args) {
           Connection conn = JDBCUtil.getConnection();
        
        // Kiểm tra kết nối
        if (conn != null) {
            System.out.println("Connected to the database!");
            
            // Đóng kết nối
            try {
                conn.close();
                System.out.println("Disconnected from the database.");
            } catch (Exception e) {
                System.out.println("Error while disconnecting: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to connect to the database!");
        }
    }
}
