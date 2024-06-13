package bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import dao.ProductoDAO;
import java.util.List;
import javax.servlet.http.Part;
import modelo.Producto;

@ManagedBean
@ApplicationScoped
public class ProductoBean {
    private Producto producto = new Producto();
    private List<Producto> listaProductos;
    private final ProductoDAO productoDAO = new ProductoDAO();
    private Part imagen;
    
    public void listar() {
        listaProductos = productoDAO.listar();
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
