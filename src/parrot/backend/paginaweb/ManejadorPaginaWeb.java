package parrot.backend.paginaweb;

/**
 *
 * @author fabricio
 */
public class ManejadorPaginaWeb {
    
    private static ManejadorPaginaWeb INSTANCE = null;

    private ManejadorPaginaWeb() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorPaginaWeb();
        }
    }
    
    public static ManejadorPaginaWeb getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
