package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.Persona;
import dao.PersonaDAO;
import javax.faces.bean.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class PersonaBean {
    private Persona persona = new Persona();
    private List<Persona> listPersonas;
    private List<Persona> listPersonasFiltro;
    private PersonaDAO pDAO;

    public void listar() {
        pDAO = new PersonaDAO();
        listPersonas = pDAO.listar();
    }
    
    public String guardar() {
        pDAO = new PersonaDAO();
        pDAO.guardar(persona);
        listar();
        limpiar();
        return "index";
    }
    
    public String editar(int codigoP) {
        pDAO = new PersonaDAO();
        persona = pDAO.buscarPorId(codigoP);
        return "editarPersona";
    }
    
    public void actualizar() {
        pDAO = new PersonaDAO();
        pDAO.actualizar(persona);
        limpiar();
    }
     
    public void eliminar(int codigo) {
        pDAO = new PersonaDAO();
        pDAO.eliminar(codigo);
    }
    
    public void limpiar() {
        persona = new Persona();
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

    public List<Persona> getListPersonasFiltro() {
        return listPersonasFiltro;
    }

    public void setListPersonasFiltro(List<Persona> listPersonasFiltro) {
        this.listPersonasFiltro = listPersonasFiltro;
    }
}
