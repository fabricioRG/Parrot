package parrot.backend.manejadores;

/**
 *
 * @author fabricio
 */
public class ManejadorParser {

    private ManejadorLectorXML ml = null;
    
    public ManejadorParser(ManejadorLectorXML ml) {
        this.ml = ml;
    }
    
    public void showErrorMessege(String error){
        this.ml.showErrorMessege(error);
        System.out.println(error);
    }
    
}
