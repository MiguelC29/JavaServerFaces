package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.Converter;

@ManagedBean
@RequestScoped
public class ManagedB {
    private String texto;
    private Converter convertidor;

    public ManagedB() {
        this.convertidor = new CustomConvertidor(); // Instancia del convertidor personalizado
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public Converter getConvertidor() {
        return convertidor;
    }

    public void setConvertidor(Converter convertidor) {
        this.convertidor = convertidor;
    }
}