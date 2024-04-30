package modelo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("customConverter")
public class CustomConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // Lógica de conversión de String a Objeto
        // Por ejemplo, convertir el texto a mayúsculas
        return value.toUpperCase();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // Lógica de conversión de Objeto a String
        // En este caso, simplemente devolvemos el objeto como String
        return value.toString();
    }   
}