package parrot.backend.manejadores;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import parrot.backend.clase.ManejadorClase;
import parrot.backend.componente.ManejadorComponente;
import parrot.backend.error.ManejadorErrores;
import parrot.backend.paginaweb.ManejadorPaginaWeb;
import parrot.backend.paginaweb.PaginaWeb;
import parrot.backend.parrafo.ManejadorParrafo;
import parrot.backend.sitioweb.ManejadorSitioWeb;
import parrot.backend.sitioweb.SitioWeb;
import parrot.backend.sitioweb.SitioWebBuilder;
import parrot.backend.titulo.ManejadorTitulo;

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
        ManejadorLectorXML.getInstance().showErrorMessege(error);
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
        }
    }

    public void setTitulo(String parametro, int option) {
        ManejadorTitulo.getInstance().setTitulo(parametro, option);
    }

    public void setParrafo(String parametro, int option){
        ManejadorParrafo.getInstance().setParrafo(parametro, option);
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
