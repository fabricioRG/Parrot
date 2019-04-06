package parrot.backend.titulo;

/**
 *
 * @author fabricio
 */
public class ManejadorTitulo {

private static ManejadorTitulo INSTANCE = null;

    private ManejadorTitulo() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorTitulo();
        }
    }
    
    public static ManejadorTitulo getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
