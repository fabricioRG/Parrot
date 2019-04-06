package parrot.backend.sitioweb;

/**
 *
 * @author fabricio
 */
public class ManejadorSitioWeb {

    private static ManejadorSitioWeb INSTANCE = null;

    private ManejadorSitioWeb() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorSitioWeb();
        }
    }
    
    public static ManejadorSitioWeb getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
