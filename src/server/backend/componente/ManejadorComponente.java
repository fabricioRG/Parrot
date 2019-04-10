package server.backend.componente;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import server.backend.clase.ManejadorClase;
import server.backend.manejadores.ManejadorParser;
import server.backend.paginaweb.ManejadorPaginaWeb;

/**
 *
 * @author fabricio
 */
public class ManejadorComponente {

    private static ManejadorComponente INSTANCE = null;
    private List<Componente> listaComponente = null;
    private Componente comp = null;
    private int errores = 0;

    private ManejadorComponente() {
        this.listaComponente = new LinkedList<>();
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorComponente();
        }
    }

    public static ManejadorComponente getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -         Asignar Id
         2       -         Asignar Pagina
         3       -         Asignar Clase
     */
    public void setComponente(String parametro, int option) throws Exception {
        String paramet = null;
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch (option) {
            case 1:
                comp = new ComponenteBuilder().build();
                if (getComponenteById(paramet) == null) {
                    comp.setId(paramet);
                } else {
                    errores = 1;
                    throw new Exception("No se ha podido crear el componente '" + paramet + "'. El ID introducido ya existe");
                }
                break;
            case 2:
                if (ManejadorPaginaWeb.getInstance().getPaginaWebById(paramet) != null) {
                    comp.setPagina(ManejadorPaginaWeb.getInstance().getPaginaWebById(paramet));
                } else {
                    errores = 1;
                    throw new Exception("No es posible agregar el componente '" + comp.getId() + "'. La pagina web '" + paramet + "'no existe");
                }
                break;
            case 3:
                if (errores == 0) {
                    if (ManejadorClase.getInstance().getClase() != null) {
                        comp.setClase(ManejadorClase.getInstance().getClase());
                        listaComponente.add(comp);
                    } else {
                        errores = 1;
                        throw new Exception("No es posible agregar el componente '" + comp.getId() + "'. Error en clase");
                    }
                }
                break;
        }
    }

    public void updateComponente(String parametro, int option) throws Exception {
        String paramet = null;
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch (option) {
            case 1:
                comp = new ComponenteBuilder().build();
                if (getComponenteById(paramet) != null) {
                    comp.setId(paramet);
                } else {
                    errores = 1;
                    throw new Exception("No se ha podido modificar el componente '" + paramet + "'. El ID introducido no existe");
                }
                break;
            case 2:
                if (ManejadorPaginaWeb.getInstance().getPaginaWebById(paramet) != null) {
                    comp.setPagina(ManejadorPaginaWeb.getInstance().getPaginaWebById(paramet));
                } else {
                    errores = 1;
                    throw new Exception("No es posible modificar el componente '" + comp.getId() + "'. La pagina web '" + paramet + "'no existe");
                }
                break;
            case 3:
                if (errores == 0) {
                    if (ManejadorClase.getInstance().getClase() != null) {
                        comp.setClase(ManejadorClase.getInstance().getClase());
                        getComponenteById(comp.getId()).setClase(comp.getClase());
                    } else {
                        throw new Exception("No es posible agregar el componente '" + comp.getId() + "'. Error en clase");
                    }
                } else {
                    errores = 0;
                }
                System.out.println("");
                break;
        }
    }

    public void deleteComponenteById(String parametro, int option) throws Exception {
        String paramet = "";
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch (option) {
            case 1:
                comp = new ComponenteBuilder().build();
                break;
            case 2:
                if (errores == 0) {
                    if (getComponenteById(paramet) != null) {
                        comp.setId(paramet);
                    } else {
                        errores = 1;
                        throw new Exception("No se ha podido eliminar el componente \"" + paramet + "\", ID no encontrado");
                    }
                }
                break;
            case 3:
                if (errores == 0) {
                    if (comp.getId() != null) {
                        if (getComponenteById(comp.getId()).getPagina().getId().equals(paramet)) {
                            comp.setPagina(getComponenteById(comp.getId()).getPagina());
                        } else {
                            errores = 1;
                            throw new Exception("Pagina ID \"" + paramet + "\" no coincide con el ID de la pagina web del componente \"" + comp.getId() + "\"");
                        }
                    } else {
                        errores = 1;
                        throw new Exception("No se ha podido eliminar el componente de la pagina \"" + paramet + "\". ID de componente no especificado");
                    }
                }
                break;
            case 4:
                if (errores == 0) {
                    removeComponenteById(comp.getId());
                } else {
                    errores = 0;
                }
                break;
        }
    }

    public void removeComponentesByPaginaId(String id) {
        List<Componente> componentes = new LinkedList<>();
        System.out.println("");
        for (Componente componente : listaComponente) {
            if (!componente.getPagina().getId().equals(id)) {
                componentes.add(componente);
            }
        }
        listaComponente.clear();
        if (!componentes.isEmpty()) {
            listaComponente.addAll(componentes);
        }
        System.out.println("");
    }

    public void removeComponenteById(String id) {
        List<Componente> componentes = new LinkedList<>();
        System.out.println("");
        for (Componente componente : listaComponente) {
            if (!componente.getId().equals(id)) {
                componentes.add(componente);
            }
        }
        listaComponente.clear();
        if (!componentes.isEmpty()) {
            listaComponente.addAll(componentes);
        }
        System.out.println("");
    }

    public Componente getComponenteById(String id) {
        for (Componente componente : listaComponente) {
            if (componente.getId().equals(id)) {
                return componente;
            }
        }
        return null;
    }

    public List<Componente> getListaComponente() {
        return listaComponente;
    }
    
}
