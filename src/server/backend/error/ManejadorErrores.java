package server.backend.error;

/**
 *
 * @author fabricio
 */
public class ManejadorErrores {

    private static ManejadorErrores INSTANCE = null;
    private String errores = "";

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
        errores = errores + "> Error: " + error + "\n";
    }
    
    public void accionExitosa(String accion){
        errores = errores + "> Exito: " + accion + "\n";
    }

    public String getErrores() {
        return errores;
    }
    
}
