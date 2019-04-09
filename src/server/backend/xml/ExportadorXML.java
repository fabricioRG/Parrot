package server.backend.xml;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import server.backend.sitioweb.SitioWeb;

/**
 *
 * @author fabricio
 */
public class ExportadorXML {
    
    public static final String SITIO_WEB_AB = "<sitioWeb>";
    public static final String SITIO_WEB_CE = "</sitioWeb>";
    public static final String ID_AB = "<id>";
    public static final String ID_CE = "</id>";
    public static final String USUARIO_CREACION_AB = "<usuarioCreacion>";
    public static final String USUARIO_CREACION_CE = "</usuarioCreacion>";
    public static final String USUARIO_MOD_AB = "<usuarioModificacion>";
    public static final String USUARIO_MOD_CE = "</usuarioModificacion>";
    public static final String FECHA_CREACION_AB = "<fechaCreacion>";
    public static final String FECHA_CREACION_CE = "</fechaCreacion>";
    public static final String FECHA_MOD_AB = "<fechaModificacion>";
    public static final String FECHA_MOD_CE = "</fechaModificacion>";
    public static final String PAGINA_WEB_AB = "<paginaWeb>";
    public static final String PAGINA_WEB_CE = "</paginaWeb>";
    public static final String TITULO_AB = "<titulo>";
    public static final String TITULO_CE = "</titulo>";
    public static final String SITIO_AB = "<sitio>";
    public static final String SITIO_CE = "</sitio>";
    public static final String PADRE_AB = "<padre>";
    public static final String PADRE_CE = "</padre>";
    public static final String COMPONENTE_AB = "<componente>";
    public static final String COMPONENTE_CE = "</componente>";
    public static final String PAGINA_AB = "<pagina>";
    public static final String PAGINA_CE = "</pagina>";
    public static final String TEXTO_AB = "<texto>";
    public static final String TEXTO_CE = "</texto>";
    public static final String ALINEACION_AB = "<alineacion>";
    public static final String ALINEACION_CE = "</alineacion>";
    public static final String COLOR_AB = "<color>";
    public static final String COLOR_CE = "</color>";
    public static final String PARRAFO_AB = "<parrafo>";
    public static final String PARRAFO_CE = "</parrafo>";
    public static final String IMAGEN_AB = "<imagen>";
    public static final String IMAGEN_CE = "</imagen>";
    public static final String ORIGEN_AB = "<origen>";
    public static final String ORIGEN_CE = "</origen>";
    public static final String ALTURA_AB = "<altura>";
    public static final String ALTURA_CE = "</altura>";
    public static final String ANCHO_AB = "<ancho>";
    public static final String ANCHO_CE = "</ancho>";
    public static final String VIDEO_AB = "<video>";
    public static final String VIDEO_CE = "</video>";
    public static final String MENU_AB = "<menu>";
    public static final String MENU_CE = "</menu>";
    public static final String ETIQUETA_AB = "<etiqueta>";
    public static final String ETIQUETA_CE = "</etiqueta>";
    public static final String PATH_AB = "<path>";
    public static final String PATH_CE = "</path>";
    public static final String CORCH_ABIERTO = "[";
    public static final String CORCH_CERRADO = "]";
    public static final String SALTO_LN = "\n";
    public static final String ABSOLUTH_PATH_SERVER = "/var/www/BaseDeDatos/BaseDeDatos.xml";
    
    private SimpleDateFormat fechaFormat = null;
    private static ExportadorXML INSTANCE = null;

    public ExportadorXML() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ExportadorXML();
        }
    }

    public static ExportadorXML getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void exportarSitioWeb(SitioWeb sw) {
        String accion = "";
        accion = SITIO_WEB_AB + SALTO_LN + ID_AB + CORCH_ABIERTO + sw.getId() + CORCH_CERRADO
                + ID_CE + SALTO_LN + USUARIO_CREACION_AB + CORCH_ABIERTO + sw.getUsuarioCreacion() + CORCH_CERRADO
                + USUARIO_CREACION_CE + SALTO_LN + FECHA_CREACION_AB + CORCH_ABIERTO + sw.getFechaCreacion() + CORCH_CERRADO
                + FECHA_CREACION_CE + SALTO_LN + FECHA_MOD_AB + CORCH_ABIERTO + sw.getFechaModificacion() + CORCH_CERRADO
                + FECHA_MOD_CE + SALTO_LN + USUARIO_MOD_AB + CORCH_ABIERTO + sw.getUsuarioModificacion() + CORCH_CERRADO
                + USUARIO_MOD_CE + SALTO_LN + PATH_AB + CORCH_ABIERTO + sw.getPath() + CORCH_CERRADO + PATH_CE
                + SALTO_LN + SITIO_WEB_CE;
        writeXML(accion);
    }

    public void writeXML(String entrada) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ABSOLUTH_PATH_SERVER, true);
            pw = new PrintWriter(fichero);
            pw.println(entrada);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

}
