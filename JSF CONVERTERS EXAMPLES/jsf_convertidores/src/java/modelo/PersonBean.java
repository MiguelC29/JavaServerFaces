package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.convert.Converter;

@ManagedBean
public class PersonBean {
    private Persona persona;
    private Converter personConverter = new PersonConverter();

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Converter getPersonConverter() {
        return personConverter;
    }
}