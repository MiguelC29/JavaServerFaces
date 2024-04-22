package control;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    public static Connection conectar() {
        Connection conn = null;
        try {
            Driver drv = new Driver();
            DriverManager.registerDriver(drv);

            String cad = "jdbc:mysql://localhost:3306/usuarios?user=root&useSSL=false";
            conn = DriverManager.getConnection(cad);

        } catch (SQLException e) {
            System.out.println("Error en Conexión");
            System.out.println("Eror: " + e.getMessage());
        }
        return conn;
    }
}
