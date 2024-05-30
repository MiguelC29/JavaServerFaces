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
    
    public void guardar(Persona persona) {
        if (persona != null) {
            try {
                conectar();
            
                PreparedStatement ps = this.conn.prepareStatement("INSERT INTO persona(nombre, sexo) VALUES(?, ?);");
                ps.setString(1, persona.getNombre());
                ps.setString(2, persona.getSexo());
                
                ps.executeUpdate();
            } catch (SQLException e) {
            }
        }
    }
    
    public Persona buscarPorId(int codigo) {
        Persona persona = null;
        try {
            conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM persona WHERE codigo=?;");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                persona = new Persona();
                persona.setCodigo(rs.getInt("codigo"));
                persona.setNombre(rs.getString("nombre"));
                persona.setSexo(rs.getString("sexo"));
            }
            
        } catch (SQLException e) {
        }
        return persona;
    }
    
    public void actualizar(Persona persona) {
        try {
            conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("UPDATE persona SET nombre=?, sexo=? WHERE codigo=?;");
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getSexo());
            ps.setInt(3, persona.getCodigo());
            
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(int codigo) {
        try {
            conectar();
            
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM persona WHERE codigo=?");
            ps.setInt(1, codigo);
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
    }
}
