
package modelo;

/**
 *
 * @author Garyn
 */
public class Usuario {
    // atributos
    private String codigo;
    private String nombres;
    private String edad;
    
    public Usuario(){
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
}
