package server.backend.xml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import server.backend.componente.Componente;
import server.backend.componente.ManejadorComponente;
import server.backend.imagen.Imagen;
import server.backend.manejadores.ManejadorParser;
import server.backend.paginaweb.ManejadorPaginaWeb;
import server.backend.paginaweb.PaginaWeb;
import server.backend.parrafo.Parrafo;
import server.backend.sitioweb.ManejadorSitioWeb;
import static server.backend.sitioweb.ManejadorSitioWeb.NAME_INDEX;
import server.backend.sitioweb.SitioWeb;
import server.backend.titulo.Titulo;
import server.backend.video.Video;

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
    public static final String COMPONENTES_AB = "<componentes>";
    public static final String COMPONENTES_CE = "</componentes>";
    public static final String PAGINAS_AB = "<paginas>";
    public static final String PAGINAS_CE = "</paginas>";
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

    public void exportarXML() {
        String salida = "";
        List<SitioWeb> sitios = new LinkedList<>();
        if (!ManejadorSitioWeb.getInstance().getListaSitioWeb().isEmpty()) {
            sitios.addAll(ManejadorSitioWeb.getInstance().getListaSitioWeb());
        }
        for (SitioWeb sitio : sitios) {
            salida = salida + getSitioWebXML(sitio);
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ABSOLUTH_PATH_SERVER));
            writer.write(salida);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getSitioWebXML(SitioWeb sw) {
        String accion = "";
        if (sw.getFechaCreacion() == null) {

        }
        if (sw.getFechaModificacion() == null) {

        }
        if (sw.getUsuarioCreacion() == null) {
            sw.setUsuarioCreacion(ManejadorParser.getInstance().getUsuario().getId());
        }
        if (sw.getUsuarioModificacion() == null) {
            sw.setUsuarioModificacion(ManejadorParser.getInstance().getUsuario().getId());
        }
        String id = ID_AB + CORCH_ABIERTO + sw.getId() + CORCH_CERRADO + ID_CE + SALTO_LN;
        String usuarioCreacion = USUARIO_CREACION_AB + CORCH_ABIERTO + sw.getUsuarioCreacion() + CORCH_CERRADO
                + USUARIO_CREACION_CE + SALTO_LN;
        String fechaCreacion = FECHA_CREACION_AB + CORCH_ABIERTO + fechaFormat.format(sw.getFechaCreacion()) + CORCH_CERRADO
                + FECHA_CREACION_CE + SALTO_LN;
        String fechaModificacion = FECHA_MOD_AB + CORCH_ABIERTO + fechaFormat.format(sw.getFechaModificacion()) + CORCH_CERRADO
                + FECHA_MOD_CE + SALTO_LN;
        String usuarioModificacion = USUARIO_MOD_AB + CORCH_ABIERTO + sw.getUsuarioModificacion() + CORCH_CERRADO
                + USUARIO_MOD_CE + SALTO_LN;
        String path = PATH_AB + CORCH_ABIERTO + sw.getPath() + CORCH_CERRADO + PATH_CE
                + SALTO_LN;
        accion = SITIO_WEB_AB + SALTO_LN + id + usuarioCreacion + fechaCreacion + fechaModificacion
                + usuarioModificacion + path + getPaginaWebXML(sw) + SITIO_WEB_CE + SALTO_LN;

        return accion;
    }

    private String getPaginaWebXML(SitioWeb sw) {
        String salida = "";
        List<PaginaWeb> paginas = new LinkedList<>();
        if (!ManejadorPaginaWeb.getInstance().getListaPaginaWeb().isEmpty()) {
            paginas.addAll(ManejadorPaginaWeb.getInstance().getListaPaginaWeb());
        }
        salida = PAGINAS_AB + SALTO_LN;
        for (PaginaWeb pagina : paginas) {
            if (pagina.getSitio().getId().equals(sw.getId())) {
                salida = salida + getPaginaXML(pagina);
            }
        }
        salida = salida + PAGINAS_CE + SALTO_LN;
        return salida;
    }

    private String getPaginaXML(PaginaWeb pw) {
        String salida = PAGINA_WEB_AB + SALTO_LN;
        if (pw.getFechaCreacion() == null) {

        }
        if (pw.getFechaModificacion() == null) {

        }
        if (pw.getUsuarioCreacion() == null) {
            pw.setUsuarioCreacion(ManejadorParser.getInstance().getUsuario().getId());
        }
        if (pw.getUsuarioModificacion() == null) {
            pw.setUsuarioModificacion(ManejadorParser.getInstance().getUsuario().getId());
        }
        String id = ID_AB + CORCH_ABIERTO + pw.getId() + CORCH_CERRADO + ID_CE + SALTO_LN;
        salida = salida + id;
        if (pw.getTitulo() != null) {
            String titulo = TITULO_AB + CORCH_ABIERTO + pw.getTitulo() + CORCH_CERRADO + TITULO_CE + SALTO_LN;
            salida = salida + titulo;
        }
        if (pw.getPadre() != null) {
            String padre = PADRE_AB + CORCH_ABIERTO + pw.getPadre().getId() + CORCH_CERRADO + PADRE_CE + SALTO_LN;
            salida = salida + padre;
        }
        String usuarioCreacion = USUARIO_CREACION_AB + CORCH_ABIERTO + pw.getUsuarioCreacion() + CORCH_CERRADO
                + USUARIO_CREACION_CE + SALTO_LN;
        String fechaCreacion = FECHA_CREACION_AB + CORCH_ABIERTO + fechaFormat.format(pw.getFechaCreacion()) + CORCH_CERRADO
                + FECHA_CREACION_CE + SALTO_LN;
        String fechaModificacion = FECHA_MOD_AB + CORCH_ABIERTO + fechaFormat.format(pw.getFechaModificacion()) + CORCH_CERRADO
                + FECHA_MOD_CE + SALTO_LN;
        String usuarioModificacion = USUARIO_MOD_AB + CORCH_ABIERTO + pw.getUsuarioModificacion() + CORCH_CERRADO
                + USUARIO_MOD_CE + SALTO_LN;
        salida = salida + usuarioCreacion + fechaCreacion + fechaModificacion + usuarioModificacion + getComponenteXML(pw)
                + PAGINA_WEB_CE + SALTO_LN;
        return salida;
    }

    private String getComponenteXML(PaginaWeb pw) {
        String salida = COMPONENTES_AB + SALTO_LN;

        List<Componente> componens = new LinkedList<>();
        if (!ManejadorComponente.getInstance().getListaComponente().isEmpty()) {
            componens.addAll(ManejadorComponente.getInstance().getListaComponente());
        }
        for (Componente componen : componens) {
            if (componen.getPagina().getId().equals(pw.getId())) {
                salida = salida + getCompXML(componen);
            }
        }
        salida = salida + COMPONENTES_CE + SALTO_LN;
        return salida;
    }

    private String getCompXML(Componente comp) {
        String salida = COMPONENTE_AB + SALTO_LN;
        if (comp.getClase().getTitulo() != null) {
            salida = salida + getTituloXML(comp.getClase().getTitulo());
        } else if (comp.getClase().getParrafo() != null) {
            salida = salida + getParrafoXML(comp.getClase().getParrafo());
        } else if (comp.getClase().getImagen() != null) {
            salida = salida + getImagenXML(comp.getClase().getImagen());
        } else if (comp.getClase().getVideo() != null) {
            salida = salida + getVideoXML(comp.getClase().getVideo());
        } else if (comp.getClase().getMenu() != null) {

        }
        salida = salida + COMPONENTE_CE + SALTO_LN;
        return salida;
    }

    private String getTituloXML(Titulo titulo) {
        String salida = TITULO_AB + SALTO_LN;
        String texto = TEXTO_AB + CORCH_ABIERTO + titulo.getTexto() + CORCH_CERRADO + TEXTO_CE + SALTO_LN;
        salida = salida + texto;
        if (titulo.getAlineacion() != null) {
            String alineacion = ALINEACION_AB + CORCH_ABIERTO + titulo.getAlineacion() + CORCH_CERRADO + ALINEACION_CE + SALTO_LN;
            salida = salida + alineacion;
        }
        if (titulo.getColor() != null) {
            String color = COLOR_AB + CORCH_ABIERTO + titulo.getColor() + CORCH_CERRADO + COLOR_CE + SALTO_LN;
            salida = salida + color;
        }
        salida = salida + TITULO_CE + SALTO_LN;
        return salida;
    }

    private String getParrafoXML(Parrafo parrafo) {
        String salida = PARRAFO_AB + SALTO_LN;
        String texto = TEXTO_AB + CORCH_ABIERTO + parrafo.getTexto() + CORCH_CERRADO + TEXTO_CE + SALTO_LN;
        salida = salida + texto;
        if (parrafo.getAlineacion() != null) {
            String alineacion = ALINEACION_AB + CORCH_ABIERTO + parrafo.getAlineacion() + CORCH_CERRADO + ALINEACION_CE + SALTO_LN;
            salida = salida + alineacion;
        }
        if (parrafo.getColor() != null) {
            String color = COLOR_AB + CORCH_ABIERTO + parrafo.getColor() + CORCH_CERRADO + COLOR_CE + SALTO_LN;
            salida = salida + color;
        }
        salida = salida + PARRAFO_CE + SALTO_LN;
        return salida;
    }

    private String getImagenXML(Imagen imagen) {
        String salida = IMAGEN_AB + SALTO_LN;
        String origen = ORIGEN_AB + CORCH_ABIERTO + imagen.getOrigen() + CORCH_CERRADO + ORIGEN_CE + SALTO_LN;
        salida = salida + origen;
        if (imagen.getAlineacion() != null) {
            String alineacion = ALINEACION_AB + CORCH_ABIERTO + imagen.getAlineacion() + CORCH_CERRADO + ALINEACION_CE + SALTO_LN;
            salida = salida + alineacion;
        }
        String altura = ALTURA_AB + CORCH_ABIERTO + imagen.getAltura() + CORCH_CERRADO + ALTURA_CE + SALTO_LN;
        String ancho = ANCHO_AB + CORCH_ABIERTO + imagen.getAncho() + CORCH_CERRADO + ANCHO_CE + SALTO_LN;
        salida = salida + altura + ancho;
        salida = salida + IMAGEN_CE + SALTO_LN;
        return salida;
    }

    private String getVideoXML(Video video) {
        String salida = VIDEO_AB + SALTO_LN;
        String origen = ORIGEN_AB + CORCH_ABIERTO + video.getOrigen() + CORCH_CERRADO + ORIGEN_CE + SALTO_LN;
        String altura = ALTURA_AB + CORCH_ABIERTO + video.getAltura() + CORCH_CERRADO + ALTURA_CE + SALTO_LN;
        String ancho = ANCHO_AB + CORCH_ABIERTO + video.getAncho() + CORCH_CERRADO + ANCHO_CE + SALTO_LN;
        salida = salida + origen + altura + ancho;
        salida = salida + VIDEO_CE + SALTO_LN;
        return salida;
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
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

//     private void exportarSitioWeb(SitioWeb sw) {
//        String accion = "";
//        accion = SITIO_WEB_AB + SALTO_LN + ID_AB + CORCH_ABIERTO + sw.getId() + CORCH_CERRADO
//                + ID_CE + SALTO_LN + USUARIO_CREACION_AB + CORCH_ABIERTO + sw.getUsuarioCreacion() + CORCH_CERRADO
//                + USUARIO_CREACION_CE + SALTO_LN + FECHA_CREACION_AB + CORCH_ABIERTO + sw.getFechaCreacion() + CORCH_CERRADO
//                + FECHA_CREACION_CE + SALTO_LN + FECHA_MOD_AB + CORCH_ABIERTO + sw.getFechaModificacion() + CORCH_CERRADO
//                + FECHA_MOD_CE + SALTO_LN + USUARIO_MOD_AB + CORCH_ABIERTO + sw.getUsuarioModificacion() + CORCH_CERRADO
//                + USUARIO_MOD_CE + SALTO_LN + PATH_AB + CORCH_ABIERTO + sw.getPath() + CORCH_CERRADO + PATH_CE
//                + SALTO_LN + SITIO_WEB_CE;
//        writeXML(accion);
//    }
}
