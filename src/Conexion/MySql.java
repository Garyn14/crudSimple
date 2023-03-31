
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Garyn
 */
public class MySql {
    // Atribuots
    Connection conectar = null;
    
    String user = "root";
    String password = "Fern@ndo123";
    String dataBase = "empresa";
    String ip ="localhost"; // ip de la base de dato(127.0.0.1 = localhost)
    String puerto = "3306"; // puerto al que se encuentra conectado mySql
                            // por defecto es 3306
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://" + ip + ":" + puerto + "/" + dataBase;  
    
    public Connection establecerConexion(){
        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, user, password);
            //System.out.println("Conexion exitosa a la base de datos");             
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo conectar a la base de datos pipipi\n" + "mensaje: " + e.getMessage());
        }
        
        return conectar;
    }
}
