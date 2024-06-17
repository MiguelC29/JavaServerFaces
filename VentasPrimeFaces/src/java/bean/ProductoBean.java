package bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import dao.ProductoDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import modelo.Producto;

@ManagedBean
@ApplicationScoped
public class ProductoBean {
    Producto producto = new Producto();
    List<Producto> listaProductos;
    ProductoDAO productoDAO = new ProductoDAO();
    Part imagen;
    
    public void listar() {
        listaProductos = productoDAO.listar();
    }
    
    public void guardar() {
        try {
            ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = sc.getRealPath("/");
            
            InputStream in = imagen.getInputStream();
            
            File f = new File(path + "/img", producto.getCodigo() + ".jpg");
            f.createNewFile();
            
            FileOutputStream out = new FileOutputStream(f);
            
            byte[] buffer = new byte[1024];
            int tamanio;
            
            while ((tamanio = in.read(buffer)) > 0) {                
                out.write(buffer, 0, tamanio);
            }
            
            producto.setImagen(f.getName());
            out.close();
            in.close();
            
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error con Imagen", "No se puede subir la imagen."));
        }
        
        try {
            productoDAO.guardar(producto);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Crear Producto", "Producto agregado exitosamente."));
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Crear Producto", "No se pudo agregar Producto. Error: " + e.getMessage()));
        }
    }
    
    public void limpiar() {
        producto = new Producto();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Part getImagen() {
        return imagen;
    }

    public void setImagen(Part imagen) {
        this.imagen = imagen;
    }    
}
