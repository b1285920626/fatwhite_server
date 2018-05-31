package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConn {
	
    public static Connection getConnect() {  
        String url = "jdbc:mysql://localhost:3306/fatwhite?serverTimezone=GMT&useSSL=false"; // ���ݿ��Url  
        Connection connecter = null;  
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver"); // java���䣬�̶�д��  
            connecter = (Connection) DriverManager.getConnection(url, "root", "bxh123456");  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            System.out.println("SQLException: " + e.getMessage());  
            System.out.println("SQLState: " + e.getSQLState());  
            System.out.println("VendorError: " + e.getErrorCode());  
        }  
        return connecter;  
    } 
}
