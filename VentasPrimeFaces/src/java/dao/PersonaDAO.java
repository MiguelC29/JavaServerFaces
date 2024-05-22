package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

public class PersonaDAO extends DAO {
    public List<Persona> listar() {
        List<Persona> listaPer = null;
        
        ResultSet rs;
        
        try {
            conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM persona;");
            
            rs = ps.executeQuery();
            
            listaPer = new ArrayList<>();
            
            while (rs.next()) {                
                Persona p = new Persona();
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                if (rs.getString("sexo").equals("M")) {
                    p.setSexo("Masculino");
                } else {
                    p.setSexo("Femenino");
                }
                
                listaPer.add(p);
                
            }
            
        } catch (SQLException e) {
            
        }
        
        return listaPer;
    }
}
