package server.backend.manejadores;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import server.backend.clase.ManejadorClase;
import server.backend.componente.ManejadorComponente;
import server.backend.error.ManejadorErrores;
import server.backend.etiqueta.ManejadorEtiqueta;
import server.backend.imagen.ManejadorImagen;
import server.backend.menu.ManejadorMenu;
import server.backend.paginaweb.ManejadorPaginaWeb;
import server.backend.paginaweb.PaginaWeb;
import server.backend.parrafo.ManejadorParrafo;
import server.backend.sitioweb.ManejadorSitioWeb;
import server.backend.sitioweb.SitioWeb;
import server.backend.sitioweb.SitioWebBuilder;
import server.backend.titulo.ManejadorTitulo;
import server.backend.video.ManejadorVideo;

/**
 *
 * @author fabricio
 */
public class ManejadorParser {

    public static final String ABSOLUTH_PATH_SERVER = "/var/www/html";
    private static ManejadorParser INSTANCE = null;

    private ManejadorParser() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorParser();
        }
    }

    public static ManejadorParser getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void showErrorMessege(String error) {
        Connector.getInstance().showErrorMessege(error);
        System.out.println(error);
    }

    public void setSitioWeb(String parametro, int option) {
        try {
            ManejadorSitioWeb.getInstance().setSitioWeb(parametro, option);
        } catch (ParseException pe) {
            ManejadorErrores.getInstance().errorByDate(parametro);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
        }
    }

    public void setPaginaWeb(String parametro, int option) {
        try {
            ManejadorPaginaWeb.getInstance().setPaginaWeb(parametro, option);
        } catch (ParseException pe) {
            ManejadorErrores.getInstance().errorByDate(parametro);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
        }
    }

    public void setComponente(String parametro, int option) {
        try {
            ManejadorComponente.getInstance().setComponente(parametro, option);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
        }
    }

    public void setClase(int option) {
        try {
            ManejadorClase.getInstance().setClase(option);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
            e.printStackTrace();
        }
    }

    public void setTitulo(String parametro, int option) {
        ManejadorTitulo.getInstance().setTitulo(parametro, option);
    }

    public void setParrafo(String parametro, int option){
        ManejadorParrafo.getInstance().setParrafo(parametro, option);
    }
    
    public void setImagen(String parametro, int option){
        ManejadorImagen.getInstance().setImagen(parametro, option);
    }
    
    public void setVideo(String parametro, int option){
        ManejadorVideo.getInstance().setVideo(parametro, option);
    }
    
    public void setMenu(String parametro, int option){
        try {
            ManejadorMenu.getInstance().setMenu(parametro, option);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void modifyPaginaWeb(String parametro, int option){
        try {
            ManejadorPaginaWeb.getInstance().modifyPaginaWeb(parametro, option);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
        }
    }
    
    public void deleteSitioWeb(String parametro, int option){
        try {
            ManejadorSitioWeb.getInstance().deleteSitioWeb(parametro, option);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
        }
    }
    
    public void deletePaginaWeb(String parametro, int option){
        try {
            ManejadorPaginaWeb.getInstance().deletePaginaWeb(parametro, option);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
        }
    }
    
    public void deleteComponente(String parametro, int option){
        try {
            ManejadorComponente.getInstance().deleteComponenteById(parametro, option);
        } catch (Exception e) {
            ManejadorErrores.getInstance().errorByEmpty(e.getMessage());
        }
    }
    
    public boolean isId(String id) {
        if (ManejadorSitioWeb.getInstance().getSitioWebById(id) != null) {
            return true;
        } else if (ManejadorPaginaWeb.getInstance().getPaginaWebById(id) != null) {
            return true;
        } else if (ManejadorComponente.getInstance().getComponenteById(id) != null) {
            return true;
        }
        return false;
    }

}
