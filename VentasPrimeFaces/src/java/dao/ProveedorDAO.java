package dao;

import modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO extends DAO {
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Proveedor> listar() {
        
        List<Proveedor> listProveedores = new ArrayList<>();
        
        try {
            conectar();
            
            ps = this.conn.prepareStatement("SELECT * FROM proveedor;");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                
                proveedor.setNit(rs.getString("nit"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setPaginaWeb(rs.getString("paginaWeb"));
                
                listProveedores.add(proveedor);
            }
            
        } catch (SQLException e) {
        }
        
        return listProveedores;
    }
    
    public void agregar(Proveedor proveedor) throws SQLException {
        try {
            conectar();
            
            ps = conn.prepareStatement("INSERT INTO proveedor VALUES(?, ?, ?, ?, ?);");
            ps.setString(1, proveedor.getNit());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getPaginaWeb());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new SQLException("Error guardando Proveedor");
        }
    }
    
    public void actualizar(Proveedor proveedor) throws SQLException {
        try {
            conectar();
            
            ps = conn.prepareStatement("UPDATE proveedor SET nombre=?, direccion=?, telefono=?, paginaWeb=? WHERE nit=?;");
            
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getPaginaWeb());
            ps.setString(5, proveedor.getNit());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new SQLException("Error actualizando Proveedor");
        }
    }
    
    public void eliminar(Proveedor proveedor) throws SQLException {
        try {
            conectar();
            
            ps = conn.prepareStatement("DELETE FROM proveedor WHERE nit = ?");
            
            ps.setString(1, proveedor.getNit());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new SQLException("Error eliminando Proveedor");
        }
    }
    
    public Proveedor buscarProveedor(String nit) {
        Proveedor proveedor = new Proveedor();
        
        try {
            conectar();
            
            ps = conn.prepareStatement("SELECT * FROM proveedor WHERE nit = ?;");
            
            ps.setString(1, nit);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                proveedor.setNit(rs.getString("nit"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setPaginaWeb(rs.getString("paginaWeb"));
            }
        } catch (SQLException e) {
        }
        
        return proveedor;
    }
}
