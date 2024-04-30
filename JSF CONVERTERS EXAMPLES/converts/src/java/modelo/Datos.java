package modelo;

import java.util.Date;

public class Datos {
    private Date fechaIngreso, otraFecha;

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getOtraFecha() {
        return otraFecha;
    }

    public void setOtraFecha(Date otraFecha) {
        this.otraFecha = otraFecha;
    }
}