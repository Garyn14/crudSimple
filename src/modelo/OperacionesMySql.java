
package modelo;

import java.sql.*;
import Conexion.MySql;

/**
 *
 * @author Garyn
 */
public class OperacionesMySql implements OperacionesBD{

    @Override
    public boolean registrar(Usuario u) {
        boolean condition = false;
        PreparedStatement ps = null;
        Connection con = new MySql().establecerConexion();
        String sql = "INSERT INTO colaborador(codigo, nombres, edad) VALUES(?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getCodigo());
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getEdad());
            ps.execute();
            condition = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "PIPIPI no se pudo registrar al usuario");
        } finally{
            // cerrar la conexion
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + "PIPIP no se pudo cerrar la conexión");
            }
        }
        
        return condition;
    }

    @Override
    public boolean modificar(Usuario u) {
        boolean condition = false;
        PreparedStatement ps = null;
        Connection con = new MySql().establecerConexion();
        String sql = "UPDATE colaborador SET nombres = ?, edad= ? WHERE codigo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getEdad());
            ps.setString(3, u.getCodigo());
            ps.execute();
            condition = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "PIPIPI no se pudo modificar al usuario");
        } finally{
            // cerrar la conexion
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + "PIPIP no se pudo cerrar la conexión");
            }
        }
        
        return condition;
    }

    @Override
    public boolean eliminar(Usuario u) {
        boolean condition = false;
        PreparedStatement ps = null;
        Connection con = new MySql().establecerConexion();
        String sql = "DELETE FROM colaborador WHERE codigo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getCodigo());
            ps.execute();
            condition = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "PIPIPI no se pudo eliminar al usuario");
        } finally{
            // cerrar la conexion
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + "PIPIP no se pudo cerrar la conexión");
            }
        }
        
        return condition;
    }

    @Override
    public boolean buscar(Usuario u) {
        boolean condition = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = new MySql().establecerConexion();
        String sql = "SELECT * FROM colaborador WHERE codigo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getCodigo());
            rs = ps.executeQuery();
            
            // guardar resultado de la consulta
            if(rs.next()){
                u.setNombres(rs.getString("nombres"));
                u.setEdad(rs.getString("edad"));
                condition = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "PIPIPI no se pudo buscar al usuario");
        } finally{
            // cerrar la conexion
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + "PIPIP no se pudo cerrar la conexión");
            }
        }
        
        return condition;
    }
    
}
