package server.backend.error;

/**
 *
 * @author fabricio
 */
public class ManejadorErrores {

    private static ManejadorErrores INSTANCE = null;

    private ManejadorErrores() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorErrores();
        }
    }

    public static ManejadorErrores getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void errorByDate(String error){
        System.out.println("Error de fecha !!!");
    }
    
    public void errorByEmpty(String error){
        System.out.println(error);
    }
    
}
