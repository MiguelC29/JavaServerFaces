package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.Persona;
import dao.PersonaDAO;

@ManagedBean
public class PersonaBean {
    private Persona persona = new Persona();
    private List<Persona> listPersonas;
    private PersonaDAO pDAO;

    public void listar() {
        pDAO = new PersonaDAO();
        listPersonas = pDAO.listar();
    }
    
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }
}
