package modelo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class PersonConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // Lógica para convertir la cadena a un objeto Persona
        String[] partes = value.split(",");
        String nombre = partes[0];
        int edad = Integer.parseInt(partes[1]);
        return new Persona(nombre, edad);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // Lógica para convertir el objeto Persona a una cadena
        Persona persona = (Persona) value;
        return persona.getNombre() + "," + persona.getEdad();
    }
}