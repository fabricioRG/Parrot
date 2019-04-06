package parrot;

import parrot.backend.manejadores.ManejadorLectorXML;
import parrot.frontend.entrada.LectorXML;

/**
 *
 * @author fabricio
 */
public class Parrot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LectorXML lector = new LectorXML();
        lector.setVisible(true);
    }
    
}
