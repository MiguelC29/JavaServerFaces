package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class ProductoDAO extends DAO {
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Producto> listar() {
        List<Producto> listaProductos = new ArrayList<>();
        
        try {
            conectar();
            
            ps = this.conn.prepareCall("SELECT * FROM producto;");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setImagen(rs.getString("imagen"));
                producto.setNitProveedor(rs.getString("nitProveedor"));
                producto.setFotoProdImg("../img/" + rs.getString("fotoProducto"));
                
                ProveedorDAO proveedor = new ProveedorDAO();
                producto.setProveedor(proveedor.buscarProveedor(rs.getString("nitProveedor")));           
                
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
        }
        
        return listaProductos;
    }
    
    public void guardar(Producto producto) throws SQLException {
        try {
            conectar();
            
            ps = this.conn.prepareStatement("INSERT INTO producto VALUES(null, ?, ?, ?, ?, ?);");
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getStock());
            ps.setString(3, producto.getImagen());
            ps.setDouble(4, producto.getPrecio());
            ps.setString(5, producto.getNitProveedor());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error creando producto " + e.getMessage());
        }
    }
    
    public void actualizar(Producto producto) {
        try {
            conectar();
            
            ps = this.conn.prepareStatement("UPDATE producto SET nombre=?, stock=?, imagen=?, precio=?, nitProveedor=?, WHERE codigo=?;");
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getStock());
            ps.setString(3, producto.getImagen());
            ps.setDouble(4, producto.getPrecio());
            ps.setString(5, producto.getNitProveedor());
            ps.setInt(6, producto.getCodigo());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void eliminar(int codigo) {
        try {
            conectar();
            
            ps = this.conn.prepareStatement("DELETE FROM producto WHERE codigo=?");
            ps.setInt(1, codigo);
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
    }
}
