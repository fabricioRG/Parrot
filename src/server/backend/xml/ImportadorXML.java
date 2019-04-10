package server.backend.xml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import server.backend.analizadores.Lexer2;
import server.backend.analizadores.parser2;
import server.backend.clase.ManejadorClase;
import server.backend.componente.ManejadorComponente;
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
public class ImportadorXML {

    private static ImportadorXML INSTANCE = null;
    public static final String ABSOLUTH_PATH_SERVER = "/var/www/BaseDeDatos/BaseDeDatos.xml";
    private SimpleDateFormat fechaFormat = null;
    private List<SitioWeb> listaSitioWeb = null;
    private List<PaginaWeb> listaPaginaWeb = null;
    private SitioWeb sw = null;
    private PaginaWeb pw = null;

    private ImportadorXML() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.listaSitioWeb = new LinkedList<>();
        this.listaPaginaWeb = new LinkedList<>();
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ImportadorXML();
        }
    }

    public static ImportadorXML getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    } 

    public void updateDatos(){
        BufferedReader reader;
        FileReader file;
        String entrada = "";
        try {
            file = new FileReader(ABSOLUTH_PATH_SERVER);
            reader = new BufferedReader(file);
            while (reader.ready()) {
                entrada = entrada + reader.readLine() + "\n";
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(entrada);
        StringReader sr = new StringReader(entrada);
        Lexer2 lexer = new Lexer2(sr);
        parser2 pars = new parser2(lexer, this);
        try {
            if (entrada.isEmpty()) {
                throw new Exception("Entrada vacia, intente de nuevo");
            }
            pars.parse();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -         Asignar Id
         2       -         Asignar Usuario Creacion
         3       -         Asignar Fecha de Creacion
         4       -         Asignar Fecha de Modificacion
         5       -         Asignar Usuario Modificacion
         6       -        Asignar path                                                        */
    public void setSitioWeb(String parametro, int option) {
        try {
            ManejadorSitioWeb.getInstance().setSitioWeb(parametro, option);
        } catch (Exception e) {
        }
    }

    public void setPaginaWeb(String parametro, int option) {
        try {
            if (option == 9) {
                String param = "\"" + parametro.substring(1, parametro.length() - 1) + "\"";
                ManejadorPaginaWeb.getInstance().setPaginaWeb(param, option);
            } else {
                ManejadorPaginaWeb.getInstance().setPaginaWeb(parametro, option);
            }
        } catch (Exception e) {
        }
    }

    public void setComponente(String parametro, int option) {
        try {
            ManejadorComponente.getInstance().setComponente(parametro, option);
        } catch (Exception e) {
        }
    }

    public void setClase(int option) {
        try {
            ManejadorClase.getInstance().setClase(option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitulo(String parametro, int option) {
        ManejadorTitulo.getInstance().setTitulo(parametro, option);
    }

    public void setParrafo(String parametro, int option) {
        ManejadorParrafo.getInstance().setParrafo(parametro, option);
    }

    public void setImagen(String parametro, int option) {
        ManejadorImagen.getInstance().setImagen(parametro, option);
    }

    public void setVideo(String parametro, int option) {
        ManejadorVideo.getInstance().setVideo(parametro, option);
    }

    public void setMenu(String parametro, int option) {
        try {
            ManejadorMenu.getInstance().setMenu(parametro, option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SitioWeb> getListaSitioWeb() {
        return listaSitioWeb;
    }

    public List<PaginaWeb> getListaPaginaWeb() {
        return listaPaginaWeb;
    }

    public SitioWeb getSitioWeb() {
        return ManejadorSitioWeb.getInstance().getSw();
    }

    public PaginaWeb getPaginaWeb() {
        return ManejadorPaginaWeb.getInstance().getPw();
    }

}
