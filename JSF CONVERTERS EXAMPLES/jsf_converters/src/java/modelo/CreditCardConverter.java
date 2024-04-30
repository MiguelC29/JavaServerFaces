package modelo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("ccno")
public class CreditCardConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("Inside getAsObject");
        System.out.println("Inside getAsObject value=>" + value);
        if (value == null) {
            return null;
        }
        // Since this is only a String to String conversion,
        // this conversion does not throw ConverterException.

        return value.replaceAll("-", "").trim();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Inside getAsString");
        if (value == null) {
            return null;
        }
        System.out.println("Inside getAsString value=>" + value.toString());

        String ccno = value.toString();
        StringBuffer formattedBuffer = new StringBuffer();
        String part1 = ccno.substring(0, 4);
        String part2 = ccno.substring(4, 8);
        String part3 = ccno.substring(8, 12);
        String part4 = ccno.substring(12, 16);

        formattedBuffer.append(part1);
        formattedBuffer.append("-");
        formattedBuffer.append(part2);
        formattedBuffer.append("-");
        formattedBuffer.append(part3);
        formattedBuffer.append("-");
        formattedBuffer.append(part4);

        return formattedBuffer.toString();
    }
}