package parrot.backend.clase;

/**
 *
 * @author fabricio
 */
public class ManejadorClase {

private static ManejadorClase INSTANCE = null;

    private ManejadorClase() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorClase();
        }
    }
    
    public static ManejadorClase getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
