package parrot.backend.clase;

import java.text.ParseException;
import parrot.backend.parrafo.ManejadorParrafo;
import parrot.backend.titulo.ManejadorTitulo;

/**
 *
 * @author fabricio
 */
public class ManejadorClase {

private static ManejadorClase INSTANCE = null;
private Clase clase = null;

    private ManejadorClase() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorClase();
        }
    }
    
    public static ManejadorClase getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -                  Titulo
         2       -                  Parrafo
         3       -                  Imagen
         4       -                  Video
         5       -                  Menu
     */
    
    public void setClase(int option) throws Exception {
        switch(option){
            case 1:
                if(ManejadorTitulo.getInstance().getTitulo()!=null){
                    clase.setTitulo(ManejadorTitulo.getInstance().getTitulo());
                } else {
                    clase = null;
                }
                break;
            case 2:
                if(ManejadorParrafo.getInstance().getParrafo()!=null){
                    clase.setParrafo(ManejadorParrafo.getInstance().getParrafo());
                } else {
                    clase = null;
                }
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
        }
    }

    public Clase getClase() throws Exception {
        return clase;
    }
    
}
