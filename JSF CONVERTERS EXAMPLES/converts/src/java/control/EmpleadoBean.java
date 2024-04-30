package control;

import javax.faces.bean.ManagedBean;
import modelo.Empleado;

@ManagedBean
public class EmpleadoBean {
    Empleado emp = new Empleado();

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
}