package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    
    //private static String url = "jdbc:mysql://localhost:3306/Bussiness_Tour_Management";
    private static String url = "jdbc:mysql://localhost:3306/Camping_Tour_Management";
    private static String username = "root";
    private static String password = "123456";
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
}
    