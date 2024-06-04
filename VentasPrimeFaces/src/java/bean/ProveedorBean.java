package bean;

import dao.ProveedorDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Proveedor;

@ManagedBean
public class ProveedorBean {
    Proveedor proveedor = new Proveedor();
    List<Proveedor> listProveedores;
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    
    public void listar() {
        listProveedores = proveedorDAO.listar();
    }
    
    public void crear() {
        try {
            proveedorDAO.agregar(proveedor);
            
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Crear Proveedor", "Proveedor Creado Exitosamente"));
            
        } catch (SQLException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Crear Proveedor", e.getMessage()));
        }
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getListProveedores() {
        return listProveedores;
    }

    public void setListProveedores(List<Proveedor> listProveedores) {
        this.listProveedores = listProveedores;
    }
}
