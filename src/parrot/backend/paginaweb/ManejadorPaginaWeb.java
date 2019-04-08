package parrot.backend.paginaweb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import parrot.backend.etiqueta.Etiqueta;
import parrot.backend.etiqueta.EtiquetaBuilder;
import parrot.backend.etiqueta.ManejadorEtiqueta;
import parrot.backend.manejadores.ManejadorParser;
import parrot.backend.sitioweb.ManejadorSitioWeb;

/**
 *
 * @author fabricio
 */
public class ManejadorPaginaWeb {

    private static ManejadorPaginaWeb INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;
    private List<PaginaWeb> listaPaginaWeb = null;
    private PaginaWeb pw = null;
    private int errores = 0;

    private ManejadorPaginaWeb() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
        listaPaginaWeb = new LinkedList<>();
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorPaginaWeb();
        }
    }

    public static ManejadorPaginaWeb getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -         Crear objeto Pagina Web
         2       -         Asignar Id
         3       -         Asignar Sitio
         4       -         Asignar Padre
         5       -         Asignar Usuario Creacion
         6       -         Asignar Usuario Modificacion
         7       -         Asignar Fecha Creacion
         8       -         Asignar Fecha Modificacion
         9       -         Asignar Etiqueta
         10     -         Asignar Titulo
         11     -         Añadir a ListaPaginaWeb
     */
    public void setPaginaWeb(String parametro, int option) throws ParseException, Exception {
        String paramet = null;
        if (option == 9) {
            if (parametro != null && !parametro.isEmpty()) {
                paramet = parametro.substring(1, parametro.length() - 1);
            }
        } else {
            if (parametro != null && !parametro.isEmpty()) {
                paramet = parametro.substring(1, parametro.indexOf("]")).trim();
            }
        }
        switch (option) {
            case 1:
                pw = new PaginaWebBuilder().build();
                break;
            case 2:
                if (!ManejadorParser.getInstance().isId(paramet)) {
                    pw.setId(paramet);
                } else {
                    errores = 1;
                    throw new Exception("No se ha podido crear la pagina web '" + paramet + "'. El ID introducido ya existe");
                }
                break;
            case 3:
                if (ManejadorSitioWeb.getInstance().getSitioWebById(paramet) != null) {
                    pw.setSitio(ManejadorSitioWeb.getInstance().getSitioWebById(paramet));
                } else {
                    errores = 1;
                    throw new Exception("No ha sido posible crear la pagina web. El sitio web '" + paramet + "' no existe");
                }
                break;
            case 4:
                if (getPaginaWebById(paramet) != null) {
                    if (getPaginaWebById(paramet).getSitio().getId().equals(pw.getSitio().getId())) {
                        pw.setPadre(getPaginaWebById(paramet));
                    } else {
                        errores = 1;
                        throw new Exception("No ha sido posible crear la pagina web '" + pw.getId() + "'. La pagina padre '" + paramet + "' no pertenece al mismo sitio web '" + getPaginaWebById(paramet) + "'");
                    }
                } else {
                    errores = 1;
                    throw new Exception("No ha sido posible crear la pagina web. La pagina padre '" + paramet + "' no existe");
                }
                break;
            case 5:
                pw.setUsuarioCreacion(paramet);
                break;
            case 6:
                pw.setUsuarioModificacion(paramet);
                break;
            case 7:
                pw.setFechaCreacion(fechaFormat.parse(paramet));
                break;
            case 8:
                pw.setFechaModificacion(fechaFormat.parse(paramet));
                break;
            case 9:
                if (pw.getEtiquetaCabeza() == null) {
                    pw.setEtiquetaCabeza(new EtiquetaBuilder().valor(paramet).build());
                } else {
                    ManejadorEtiqueta.getInstance().addEtiquetaToNext(new EtiquetaBuilder().valor(paramet).build(), pw.getEtiquetaCabeza());
                }
                break;
            case 10:
                pw.setTitulo(paramet);
                break;
            case 11:
                if (pw.getId() == null) {
                    errores = 1;
                    throw new Exception("No es posible crear la pagina web. No se ha especificado el ID");
                } else if (pw.getSitio() == null) {
                    errores = 1;
                    throw new Exception("No es posible crear la pagina web '" + pw.getId() + "'. No se ha especificado el SITIO WEB perteneciente");
                }
                if (errores == 0) {
                    listaPaginaWeb.add(pw);
                } else {
                    errores = 0;
                    pw = null;
                }
                System.out.println("algo");
                break;
        }
    }

    public PaginaWeb getPaginaWebById(String id) {
        for (PaginaWeb paginaWeb : listaPaginaWeb) {
            if (paginaWeb.getId().equals(id)) {
                return paginaWeb;
            }
        }
        return null;
    }

}
