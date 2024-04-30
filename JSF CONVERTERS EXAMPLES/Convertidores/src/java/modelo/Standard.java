package modelo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Standard {
    private int entero;

    public int getEntero() {
        return entero;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }
}