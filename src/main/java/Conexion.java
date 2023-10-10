/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loken
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexion {

    public Connection conexion() throws SQLException, Exception {
        InitialContext initContext;
        Connection cn = null;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/basePostgresql");
            cn = ds.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            throw ex; // Propaga la excepción SQLException
        }

        if (cn == null || cn.isClosed()) {
            throw new SQLException("NO HAY CONEXIÓN A LA BASE DE DATOS");
        } else {
            System.out.println("Conectado");
        }

        return cn;
    }

    public Connection conectarBD(String jdbcName) throws SQLException {
        InitialContext initContext;
        Connection cn = null;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/"
                    + jdbcName);
            cn = ds.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        if ((cn == null) || cn.isClosed()) {
            System.out.println("NO HAY CONEXION A LA BASE DE DATOS");
            throw new SQLException("NO HAY CONEXION A LA BASE DE DATOS " + jdbcName);
        }
        return cn;
    }

}
