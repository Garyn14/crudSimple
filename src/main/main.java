
package main;
import controlador.ControladorInicio;
import modelo.Usuario;
import modelo.OperacionesMySql;
import vista.Inicio;

/**
 *
 * @author Garyn
 */
public class main {
    public static void main(String[] args) {
        ControladorInicio c1 = new ControladorInicio(new Inicio(), new Usuario(), new OperacionesMySql());
        c1.init();
    }
}
