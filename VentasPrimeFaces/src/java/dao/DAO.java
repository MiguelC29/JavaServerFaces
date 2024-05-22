package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    
    Connection conn;
    
    void conectar() {
        conn = null;
        
        try {
            Driver drv = new Driver();
            DriverManager.registerDriver(drv);
            
            String cad = "jdbc:mysql://localhost:3306/ventas?user=root&useSSL=false";
            
            conn = DriverManager.getConnection(cad);
            
        } catch(SQLException ex) {
            
        }
    }
}
