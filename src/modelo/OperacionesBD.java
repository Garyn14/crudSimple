
package modelo;

/**
 *
 * @author Garyn
 */
public interface OperacionesBD {
    public boolean registrar(Usuario u);
    public boolean modificar(Usuario u);
    public boolean eliminar(Usuario u);
    public boolean buscar(Usuario u);
}
