package parrot.backend.parrafo;

/**
 *
 * @author fabricio
 */
public class ManejadorParrafo {

    private static ManejadorParrafo INSTANCE = null;

    private ManejadorParrafo() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorParrafo();
        }
    }
    
    public static ManejadorParrafo getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
