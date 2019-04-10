package server;

import server.backend.error.ManejadorErrores;
import server.backend.manejadores.Connector;
import server.backend.xml.ImportadorXML;

/**
 *
 * @author fabricio
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ImportadorXML.getInstance().updateDatos();
        ServidorFrontend sf = new ServidorFrontend();
        sf.setVisible(true);
    }
    
}
