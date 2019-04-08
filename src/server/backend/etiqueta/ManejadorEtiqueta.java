
package parrot.backend.etiqueta;

/**
 *
 * @author fabricio
 */
public class ManejadorEtiqueta {

private static ManejadorEtiqueta INSTANCE = null;

    private ManejadorEtiqueta() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorEtiqueta();
        }
    }
    
    public static ManejadorEtiqueta getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
    public void addEtiquetaToNext(Etiqueta etiqueta, Etiqueta cabeza){
        Etiqueta i = cabeza;
        Etiqueta j = null;
        while (i != null) {            
            j = i;
            i = i.getSiguienteEtiqueta();
        }
        j.setSiguienteEtiqueta(etiqueta);
    }
    
}
