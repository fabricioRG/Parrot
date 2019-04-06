package parrot.backend.usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorUsuario {

    private static ManejadorUsuario INSTANCE = null;

    private ManejadorUsuario() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorUsuario();
        }
    }
    
    public static ManejadorUsuario getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
