package bean;

import dao.ProveedorDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Proveedor;

@ManagedBean
@ViewScoped
public class ProveedorBean {
    Proveedor proveedor = new Proveedor();
    List<Proveedor> listProveedores;
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    private String accion, btnAccion;
    
    public void operar() {
        if (accion.charAt(0) == 'A') {
            actualizar();
        } else {
            guardar();
        }
    }
    
    public void listar() {
        listProveedores = proveedorDAO.listar();
    }
    
    public void guardar() {
        try {
            proveedorDAO.agregar(proveedor);
            
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Crear Proveedor", "Proveedor Creado Exitosamente"));
            
        } catch (SQLException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Crear Proveedor", e.getMessage()));
        }
    }
    
    public void limpiar() {
        proveedor.setNit("");
        proveedor.setNombre("");
        proveedor.setDireccion("");
        proveedor.setTelefono("");
        proveedor.setPaginaWeb("");
    }
    
    public void buscar(Proveedor proveedorN) {
        try {
            Proveedor temp = proveedorDAO.buscarProveedor(proveedorN.getNit());
            
            if (temp != null) {
                proveedor = temp;
                setAccion("Actualizar");
            }
        } catch (Exception e) {
        }
    }
    
    public void actualizar() {
        try {
            proveedorDAO.actualizar(proveedor);
            listar();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizar Proveedor", "Proveedor Actualizado Exitosamente"));
        } catch (SQLException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Actualizar Proveedor", e.getMessage()));
        }
    }
    
    public void eliminar(Proveedor proveedor) {
        try {
            proveedorDAO.eliminar(proveedor);
            
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar Proveedor", "Proveedor Eliminado Exitosamente"));
        } catch (SQLException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eliminar Proveedor", e.getMessage()));
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
        
        if (accion.charAt(0) == 'A'){
            btnAccion = "Actualizar";
        } else{
            btnAccion = "Guardar";
            limpiar();
        }
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
    }
}
