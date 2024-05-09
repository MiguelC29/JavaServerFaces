package controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    
    public String calcularEdad() {
        int edad;
        
        Calendar hoy = Calendar.getInstance();
        hoy.get(Calendar.DATE);
        
        Calendar fNacimiento = Calendar.getInstance();
        fNacimiento.setTime(fechaNacimiento);
        
        edad = hoy.get(Calendar.YEAR) - fNacimiento.get(Calendar.YEAR);
        
        String patron = "dd 'de' MMMM 'de' yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(patron);
        
        String fecha = sdf.format(fechaNacimiento);
        
        return nombre + " nacido el " + fecha + ", tiene " + edad + " años";
    }
}