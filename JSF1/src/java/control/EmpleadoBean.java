package control;

import java.sql.Connection;
import javax.faces.bean.ManagedBean;
import modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

@ManagedBean
public class EmpleadoBean {

    Empleado emp = new Empleado();

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }
    
    public void LargoIdUsr(FacesContext contexto, UIComponent componente, Object valor) {
        contexto = FacesContext.getCurrentInstance();
        String cad = (String)valor;
        
        if (cad.length() < 3 || cad.length() > 10) {
            ((UIInput)componente).setValid(false);
            
            contexto.addMessage(componente.getClientId(contexto), new FacesMessage("  Id de Usuario no válido - Imperativo"));
        }
    }

    public String autenticar() {
        try {
            Connection con = ConexionDB.conectar();

            String sql = "SELECT * FROM empleado WHERE codigo = ? AND clave = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emp.getCodigo());
            ps.setString(2, emp.getClave());
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return "Código y Contraseña correctos. \n Bienvenid@ " + rs.getString("nombre");
            } else {
                return "Código y/o Contraseña no válidos";
            }

        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
