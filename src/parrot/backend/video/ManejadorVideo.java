
package parrot.backend.video;

/**
 *
 * @author fabricio
 */
public class ManejadorVideo {

private static ManejadorVideo INSTANCE = null;

    private ManejadorVideo() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorVideo();
        }
    }
    
    public static ManejadorVideo getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
}
