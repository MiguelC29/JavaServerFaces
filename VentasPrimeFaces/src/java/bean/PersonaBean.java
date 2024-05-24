package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.Persona;
import dao.PersonaDAO;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PersonaBean {
    private Persona persona = new Persona();
    private List<Persona> listPersonas;
    private PersonaDAO pDAO;

    public void listar() {
        pDAO = new PersonaDAO();
        listPersonas = pDAO.listar();
    }
    
    public String guardar() {
        pDAO = new PersonaDAO();
        pDAO.guardar(persona);
        listar();
        
        return "index";
    }
    
    public String editar(int codigoP) {
        pDAO = new PersonaDAO();
        persona = pDAO.buscarPorId(codigoP);
        
        return "editarPersona";
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
