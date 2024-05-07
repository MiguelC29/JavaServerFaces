package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cfecha")
public class ConvFecha implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Date f = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            f = sdf.parse(value);
        } catch(ParseException e) {
            
        }
        
        return f;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return "";
    }
}