package control;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("lius")
public class LongIdUsr implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String cad = (String)value;
        
        if(cad.length() < 3 || cad.length() > 10) {
            FacesMessage msj = new FacesMessage("  Id de Usuario no es válido - Personalizado");
            msj.setSeverity(FacesMessage.SEVERITY_ERROR);
            
            throw new ValidatorException(msj);
        }
        
    }
}