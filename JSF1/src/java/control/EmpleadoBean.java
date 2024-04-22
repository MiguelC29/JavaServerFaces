package control;

import java.sql.Connection;
import javax.faces.bean.ManagedBean;
import modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ManagedBean
public class EmpleadoBean {

    Empleado emp = new Empleado();

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
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
