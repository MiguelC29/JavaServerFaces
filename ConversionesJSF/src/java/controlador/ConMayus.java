package controlador;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cmay")
public class ConMayus implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String cad = "";
        
        if(value != null && !value.isEmpty()) {
            cad = value.toUpperCase();
        }
        
        return cad;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String cad = "";
        
        if(value != null && !((String) value).isEmpty()) {
            cad = value.toString().toUpperCase();
        }
        
        return cad;
    }
    
}