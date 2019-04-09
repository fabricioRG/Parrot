package server.backend.menu;

import server.backend.etiqueta.ManejadorEtiqueta;
import server.backend.paginaweb.ManejadorPaginaWeb;

/**
 *
 * @author fabricio
 */
public class ManejadorMenu {

private static ManejadorMenu INSTANCE = null;
private Menu menu = null;
private int error = 0;

    private ManejadorMenu() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorMenu();
        }
    }
    
    public static ManejadorMenu getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
    public void setMenu(String parametro, int option) throws Exception{
        String paramet = "";
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        if(option == 1){
            menu = new MenuBuilder().build();
        } else if (option == 2){
            if(ManejadorPaginaWeb.getInstance().getPaginaWebById(paramet)!= null){
                menu.setPadre(ManejadorPaginaWeb.getInstance().getPaginaWebById(paramet));
            } else {
                error = 1;
                throw new Exception("Padre en Clase \"Menu\" no existente en el sistema.");
            }
        } else if (option == 3){
            ManejadorEtiqueta.getInstance().setEtiqueta(paramet);
            if(ManejadorEtiqueta.getInstance().getCabeza()!= null){
                menu.setEtiquetas(ManejadorEtiqueta.getInstance().getCabeza());
            }
        }
    }

    public Menu getMenu() throws Exception {
        if(error == 1){
            error = 0;
            return null;
        }
        return menu;
    }
    
}
