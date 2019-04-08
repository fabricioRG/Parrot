package parrot.backend.componente;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import parrot.backend.clase.ManejadorClase;
import parrot.backend.manejadores.ManejadorParser;
import parrot.backend.paginaweb.ManejadorPaginaWeb;

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
                if (!ManejadorParser.getInstance().isId(paramet)) {
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
                if(ManejadorClase.getInstance().getClase() != null){
                    comp.setClase(ManejadorClase.getInstance().getClase());
                } else {
                    errores = 1;
                    throw new Exception("No es posible agregar el componente '" + comp.getId() + "'. Error en clase");
                }
                break;
            case 4:
                listaComponente.add(comp);
                break;
        }
    }

    public Componente getComponenteById(String id) {
        for (Componente componente : listaComponente) {
            if (componente.getId().equals(id)) {
                return componente;
            }
        }
        return null;
    }

}
