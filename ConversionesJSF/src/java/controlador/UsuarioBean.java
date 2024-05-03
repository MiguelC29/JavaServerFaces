package controlador;

import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {
    private String nombre;
    private Date fechaNacimiento;

    public UsuarioBean() {
    }

    public UsuarioBean(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}