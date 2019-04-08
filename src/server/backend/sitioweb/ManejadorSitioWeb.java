package parrot.backend.sitioweb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;
import parrot.backend.manejadores.ManejadorParser;
import parrot.backend.xml.ExportadorXML;

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
                    throw new Exception("No se ha podido crear el sitio web '"+ paramet +"'. El ID introducido ya existe");
                }
                break;
            case 5:
                sw.setUsuarioCreacion(paramet);
                break;
            case 6:
                sw.setUsuarioModificacion(paramet);
                break;
            case 7:
                if (sw.getId() == null) {
                    errores = 1;
                    throw new Exception("No se ha podido crear el sitio web, no se ha especificado ID");
                }
                sw.setPath(ABSOLUTH_PATH_SERVER + "/" + sw.getId());
                listaSitioWeb.add(sw);
//                createDirectory("/" + sw.getId());
//                ExportadorXML.getInstance().exportarSitioWeb(sw);
                System.out.println(sw.getId());
                System.out.println(sw.getFechaCreacion());
                System.out.println(sw.getFechaModificacion());
                System.out.println(sw.getUsuarioCreacion());
                System.out.println(sw.getUsuarioModificacion());
                break;
        }
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
