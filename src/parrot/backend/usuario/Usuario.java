package parrot.backend.usuario;

/**
 *
 * @author fabricio
 */
public class Usuario {

    String id;
    String nombre;
    String pass;
    
    Usuario(UsuarioBuilder builder){
        this.id = builder.getId();
        this.nombre = builder.getNombre();
        this.pass = builder.getPass();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
