package parrot.backend.componente;

/**
 *
 * @author fabricio
 */
public class ManejadorComponente {

    private static ManejadorComponente INSTANCE = null;

    private ManejadorComponente() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorComponente();
        }
    }
    
    public static ManejadorComponente getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
