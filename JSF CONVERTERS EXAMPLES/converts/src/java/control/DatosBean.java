package control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Datos;

@ManagedBean
@RequestScoped
public class DatosBean {
    Datos datos = new Datos();

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }
    
    public void doProcesar() {
        datos.setOtraFecha(datos.getFechaIngreso());
    }
}