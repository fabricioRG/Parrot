package server.backend.paginaweb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import server.backend.componente.ManejadorComponente;
import server.backend.error.ManejadorErrores;
import server.backend.etiqueta.Etiqueta;
import server.backend.etiqueta.EtiquetaBuilder;
import server.backend.etiqueta.ManejadorEtiqueta;
import server.backend.manejadores.ManejadorParser;
import server.backend.sitioweb.ManejadorSitioWeb;

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
    private int modificacion = 0;

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
                if (getPaginaWebById(paramet) == null) {
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
                if(paramet.equals(paramet))
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
                    ManejadorErrores.getInstance().accionExitosa("Se ha creado la pagina web \"" + pw.getId() +"\"");
                } else {
                    errores = 0;
                    pw = null;
                }
                break;
        }
    }

    public void modifyPaginaWeb(String parametro, int option) throws Exception {
        String paramet = null;
        if (option == 4) {
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
                if (getPaginaWebById(paramet) != null) {
                    pw.setId(getPaginaWebById(paramet).getId());
                } else {
                    errores = 1;
                    throw new Exception("No se ha podido modificar la pagina web \"" + paramet + "\". El ID no existe");
                }
                break;
            case 3:
                modificacion = 1;
                pw.setTitulo(paramet);
                break;
            case 4:
                modificacion = 1;
                if (pw.getEtiquetaCabeza() == null) {
                    pw.setEtiquetaCabeza(new EtiquetaBuilder().valor(paramet).build());
                } else {
                    ManejadorEtiqueta.getInstance().addEtiquetaToNext(new EtiquetaBuilder().valor(paramet).build(), pw.getEtiquetaCabeza());
                }
                break;
            case 5:
                if (errores == 0) {
                    if (pw.getId() != null) {
                        if (modificacion == 1) {
                            ManejadorErrores.getInstance().accionExitosa("Se ha modificado la pagina web \"" + pw.getId() +"\"");
                            modifyAtributosPagina(pw);
                            modificacion = 0;
                        } else {
                            throw new Exception("No se ha especificado algun parametro para modificar la pagina web \" "+ pw.getId() +"\"");
                        }
                    } else {
                        throw new Exception("No se ha especificado el ID de la pagina web a modificar.");
                    }
                } else {
                    errores = 0;
                }
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
    
    public void deletePaginaWeb(String parametro, int option) throws Exception{
        String paramet = "";
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch (option) {
            case 1:
                pw = new PaginaWebBuilder().build();
                break;
            case 2:
                if (getPaginaWebById(paramet) != null) {
                    pw.setId(paramet);
                } else {
                    errores = 1;
                    throw new Exception("No se ha podido eliminar el sitio web \""+paramet+"\", ID no encontrado");
                }
                break;
            case 3:
                if(errores == 0){
                    ManejadorErrores.getInstance().accionExitosa("Se ha eliminado la pagina web  \"" + pw.getId() +" \"");
                    removePaginaById(pw.getId());
                } else {
                    errores = 0;
                }
                break;
        }
    }
    
    public void removePaginasBySitioId(String id){
        List<PaginaWeb> paginas = new LinkedList<>();
        for (PaginaWeb paginaWeb : listaPaginaWeb) {
            if(paginaWeb.getSitio().getId().equals(id)){
                ManejadorComponente.getInstance().removeComponentesByPaginaId(paginaWeb.getId());
            } else {
                paginas.add(paginaWeb);
            }
        }
        listaPaginaWeb.clear();
        if(!paginas.isEmpty()){
            listaPaginaWeb.addAll(paginas);
        }
        
    }
    
    public void removePaginaById(String id){
        List<PaginaWeb> paginas = new LinkedList<>();
        for (PaginaWeb paginaWeb : listaPaginaWeb) {
            if(paginaWeb.getId().equals(id)){
                ManejadorComponente.getInstance().removeComponentesByPaginaId(id);
            } else {
                paginas.add(paginaWeb);
            }
        }
        listaPaginaWeb.clear();
        if(!paginas.isEmpty()){
            listaPaginaWeb.addAll(paginas);
        }
    }

    private void modifyAtributosPagina(PaginaWeb pg) {
        if (pg.getTitulo() != null) {
            getPaginaWebById(pg.getId()).setTitulo(pg.getTitulo());
        }
        if (pg.getEtiquetaCabeza() != null) {
            getPaginaWebById(pg.getId()).setEtiquetaCabeza(pg.getEtiquetaCabeza());
        }
    }

    public List<PaginaWeb> getListaPaginaWeb() {
        return listaPaginaWeb;
    }

    public PaginaWeb getPw() {
        return pw;
    }

}
