package parrot.backend.menu;

/**
 *
 * @author fabricio
 */
public class ManejadorMenu {

private static ManejadorMenu INSTANCE = null;

    private ManejadorMenu() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorMenu();
        }
    }
    
    public static ManejadorMenu getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
