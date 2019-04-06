package parrot.backend.imagen;

/**
 *
 * @author fabricio
 */
public class ManejadorImagen {

    private static ManejadorImagen INSTANCE = null;

    private ManejadorImagen() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorImagen();
        }
    }
    
    public static ManejadorImagen getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
