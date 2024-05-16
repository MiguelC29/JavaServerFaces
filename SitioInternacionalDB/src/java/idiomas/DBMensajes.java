package idiomas;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListResourceBundle;
import java.util.Map;

public class DBMensajes extends ListResourceBundle{

    @Override
    protected Object[][] getContents() {
        PreparedStatement ps;
        Map<String, String> bundle = new HashMap<>();
        Object[][] mensajes = new Object[0][0];
        
        String sql = "SELECT * FROM idiomas WHERE codid = 'es'";
        
        try {
            ps = conectar().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            
            while (rs.next()) {                
                bundle.put(rs.getString("etiqueta"), rs.getString("content"));
            }
            
            mensajes = new Object[bundle.size()][2];
            int index = 0;
            
            for (Iterator key = bundle.keySet().iterator(); key.hasNext();) {
                Object clave = key.next();
                mensajes[index][0] = clave;
                mensajes[index][1] = bundle.get(clave.toString());
                index++;
            }
        } catch (SQLException e) {
        }
        
        return mensajes;
    }
    
    private Connection conectar() {
        Connection conn;
        
        try {
            Driver drv = new Driver();
            DriverManager.registerDriver(drv);
            
            String cad = "jdbc:mysql://localhost:3306/i18n?user=root&useSSL=false";
            conn = DriverManager.getConnection(cad);
        } catch (SQLException e) {
            conn = null;
        }
        
        return conn;
    }
    
}