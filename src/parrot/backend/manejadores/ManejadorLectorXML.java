package parrot.backend.manejadores;

import java.io.StringReader;
import parrot.backend.analizadores.Lexer1;
import parrot.backend.analizadores.parser;
import parrot.frontend.entrada.LectorXML;

/**
 *
 * @author fabricio
 */
public class ManejadorLectorXML {

    private LectorXML lector = null;
    private static ManejadorLectorXML INSTANCE = null;

    private  ManejadorLectorXML() {
    }
    
    private synchronized static void createInstance(){
        if(INSTANCE == null){
            INSTANCE = new ManejadorLectorXML();
        }
    }
    
    public static ManejadorLectorXML getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
    public void setLectorXML(LectorXML lector){
        this.lector = lector;
    }
    
    public void procesarTexto(String entrada) {
        this.lector.getErroresPane().setVisible(false);
        StringReader sr = new StringReader(entrada);
        Lexer1 lexer = new Lexer1(sr);
        parser pars = new parser(lexer, ManejadorParser.getInstance());

        try {
            if (entrada.isEmpty()) {
                throw new Exception("Entrada vacia, intente de nuevo");
            }
            pars.parse();
        } catch (Exception ex) {
            ex.printStackTrace();
            showErrorMessege(ex.getMessage());
        }
    }
    
    public void showErrorMessege(String error){
        this.lector.getErroresPane().setVisible(true);
         this.lector.getjErroresPane().setText(this.lector.getjErroresPane().getText() + error + "\n");
    }

}
