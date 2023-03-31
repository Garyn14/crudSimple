
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Inicio;
import modelo.*;

/**
 *
 * @author Garyn
 */
public class ControladorInicio {
    // atributos
    private Inicio vista;
    private Usuario user;
    private OperacionesMySql bd;
    
    public ControladorInicio(Inicio vista, Usuario user, OperacionesMySql bd){
        this.vista = vista;
        this.user = user;
        this.bd = bd;
        eventos();
    }
    
    private void eventos(){
        // botón registrar
        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // limpiar usuario
                limpiarUsuario(user);
                
                // asignar valores
                user.setCodigo(vista.codigo_input.getText());
                user.setNombres(vista.nombres_input.getText());
                user.setEdad(vista.edad_input.getText());
                
                // registrar en la base de datos
                if(bd.registrar(user)){
                    JOptionPane.showMessageDialog(null, "COLABORADOR REGISTRADO EXITOSAMENTE");
                } else{
                    JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR INTENTALO EN UNOS MINUTOS");
                }
                limpiarFormulario();
            }
        });
        
        // botón modificar
        this.vista.btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // limpiar usuario
                limpiarUsuario(user);
                
                // asignar valores
                user.setCodigo(vista.codigo_input.getText());
                user.setNombres(vista.nombres_input.getText());
                user.setEdad(vista.edad_input.getText());
                
                // modificar en la base de datos
                if(bd.modificar(user)){
                    JOptionPane.showMessageDialog(null, "COLABORADOR MODIFICADO EXITOSAMENTE");
                } else{
                    JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR INTENTALO EN UNOS MINUTOS");
                }
                limpiarFormulario();
            }
        });
        
        // botón eliminar
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // limpiar usuario
                limpiarUsuario(user);
                
                user.setCodigo(vista.codigo_input.getText());
                if(bd.eliminar(user)){
                    JOptionPane.showMessageDialog(null, "COLABORADOR ELIMINADO EXITOSAMENTE");
                } else{
                    JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR INTENTALO EN UNOS MINUTOS");
                }
                limpiarFormulario();
            }
        });
        
        // botón buscar
        this.vista.btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // limpiar usuario
                limpiarUsuario(user);
                
                user.setCodigo(vista.codigo_input.getText());
                if(bd.buscar(user)){
                    vista.nombres_input.setText(user.getNombres());
                    vista.edad_input.setText(user.getEdad());
                } else{
                    JOptionPane.showMessageDialog(null, "COLABORADOR NO ENCONTRADO");
                }
            }
        });
        
        // botón limpiar
        this.vista.btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                limpiarUsuario(user);
            }
        });
    }
    
    private void limpiarUsuario(Usuario u){
        u.setCodigo(null);
        u.setNombres(null);
        u.setEdad(null);
    }
    
    private void limpiarFormulario(){
        this.vista.codigo_input.setText(null);
        this.vista.nombres_input.setText(null);
        this.vista.edad_input.setText(null);
    }
    
    public void init(){
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }
}
