


import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "empleadosBean")
@SessionScoped
public class EmpleadoDAO implements Serializable{

    private Conexion cn = null;
    private ResultSet rs;
    private Empleado p = new Empleado();
    private Statement stm;
    PreparedStatement ps;

    public List listar() {
        ArrayList<Empleado> list = new ArrayList<>();
        String sql = "select * from empleado";
        try {
            cn = new Conexion();
            Connection con = cn.conectarBD("basePostgresql");
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado per = new Empleado();
                per.setClave(rs.getString("clave"));
                per.setNombre(rs.getString("nombre"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                list.add(per);
            }
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    public boolean Crear(Empleado emp){
        try {
            String sql ="INSERT INTO empleado (clave, nombre, telefono, direccion) VALUES(?,?,?,?)";
            cn = new Conexion();
            Connection con = cn.conectarBD("basePostgresql");
            ps= con.prepareStatement(sql);
            ps.setString(1, emp.getClave());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getTelefono());
            ps.setString(4, emp.getDireccion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}

