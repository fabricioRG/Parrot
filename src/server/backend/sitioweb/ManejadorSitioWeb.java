package server.backend.sitioweb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;
import server.backend.manejadores.ManejadorParser;
import server.backend.paginaweb.ManejadorPaginaWeb;
import server.backend.xml.ExportadorXML;

/**
 *
 * @author fabricio
 */
public class ManejadorSitioWeb {

    private static ManejadorSitioWeb INSTANCE = null;
    public static final String ABSOLUTH_PATH_SERVER = "/var/www/html";
    public static final String NAME_INDEX = "index.html";
    private SimpleDateFormat fechaFormat = null;
    private List<SitioWeb> listaSitioWeb = null;
    private SitioWeb sw = null;
    private int errores = 0;

    private ManejadorSitioWeb() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.listaSitioWeb = new LinkedList<>();
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorSitioWeb();
        }
    }

    public static ManejadorSitioWeb getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -         Crear objeto Sitio Web
         2       -         Asignar Fecha de Creacion
         3       -         Asignar Fecha de Modificacion
         4       -         Asignar Id
         5       -         Asignar Usuario Creacion
         6       -        Asignar Usuario Modificacion                                                  */
    public void setSitioWeb(String parametro, int option) throws ParseException, Exception {
        String paramet = "";
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch (option) {
            case 1:
                sw = new SitioWebBuilder().build();
                break;
            case 2:
                sw.setFechaCreacion(fechaFormat.parse(paramet));
                break;
            case 3:
                sw.setFechaModificacion(fechaFormat.parse(paramet));
                break;
            case 4:
                if (!ManejadorParser.getInstance().isId(paramet)) {
                    sw.setId(paramet);
                } else {
                    errores = 1;
                    throw new Exception("No se ha podido crear el sitio web '" + paramet + "'. El ID introducido ya existe");
                }
                break;
            case 5:
                sw.setUsuarioCreacion(paramet);
                break;
            case 6:
                sw.setUsuarioModificacion(paramet);
                break;
            case 7:
                if (errores == 0) {
                    if (sw.getId() == null) {
                        throw new Exception("No se ha podido crear el sitio web, no se ha especificado ID");
                    }
                    sw.setPath(ABSOLUTH_PATH_SERVER + "/" + sw.getId());
                    errores = 0;
                    listaSitioWeb.add(sw);
//                createDirectory("/" + sw.getId());
//                ExportadorXML.getInstance().exportarSitioWeb(sw);
                    System.out.println(sw.getId());
                }
        }
    }

    public void deleteSitioWeb(String parametro, int option) throws Exception {
        String paramet = "";
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch (option) {
            case 1:
                sw = new SitioWebBuilder().build();
                break;
            case 2:
                if (getSitioWebById(paramet) != null) {
                    sw.setId(paramet);
                } else {
                    errores = 1;
                    throw new Exception("No se ha podido eliminar el sitio web \""+paramet+"\", ID no encontrado");
                }
                break;
            case 3:
                if(errores == 0){
                    removeSitioWeb(sw.getId());
                } else {
                    errores = 0;
                }
                break;
        }
    }

    public void removeSitioWeb(String id) {
        List<SitioWeb> sitios = new LinkedList<>();
        System.out.println("");
        for (SitioWeb sitioWeb : listaSitioWeb) {
            if(sitioWeb.getId().equals(id)){
            ManejadorPaginaWeb.getInstance().removePaginasBySitioId(id);
            } else {
                sitios.add(sitioWeb);
            }
        }
        listaSitioWeb.clear();
        if(!sitios.isEmpty()){
            listaSitioWeb.addAll(sitios);
        }
        System.out.println("");
    }

    public SitioWeb getSitioWebById(String id) {
        for (SitioWeb sitioWeb : listaSitioWeb) {
            if (sitioWeb.getId().equals(id)) {
                return sitioWeb;
            }
        }
        return null;
    }

    private void createDirectory(String path) {
        new File(ABSOLUTH_PATH_SERVER + path).mkdir();
    }

    private void createIndex(SitioWeb sw) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(sw.getPath() + "/" + NAME_INDEX));
        writer.write("<html><body><h1>Index of \"" + sw.getId() + "\"</h1></body></html>");
        writer.close();
    }

}
