package server.backend.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import server.backend.paginaweb.PaginaWeb;
import server.backend.sitioweb.SitioWeb;
import server.backend.sitioweb.SitioWebBuilder;

/**
 *
 * @author fabricio
 */
public class ImportadorXML {

    public static final String ABSOLUTH_PATH_SERVER = "/var/www/BaseDeDatos/BaseDeDatos.xml";
    private SimpleDateFormat fechaFormat = null;
    private List<SitioWeb> listaSitioWeb = null;
    private List<PaginaWeb> listaPaginaWeb = null;
    private SitioWeb sw = null;
    private PaginaWeb pw = null;
    
    public ImportadorXML() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.listaSitioWeb = new LinkedList<>();
        this.listaPaginaWeb = new LinkedList<>();
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
    
    public void setSitioWeb(String parametro, int option) throws ParseException, Exception {
        String paramet = "";
        if(parametro != null && !parametro.isEmpty()){
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch(option){
            case 1:
                sw = new SitioWebBuilder().build();
                sw.setId(paramet);
                break;
            case 2:
                sw.setUsuarioCreacion(paramet);
                break;
            case 3:
                sw.setFechaCreacion(fechaFormat.parse(paramet));
                break;
            case 4:
                sw.setFechaModificacion(fechaFormat.parse(paramet));
                break;
            case 5:
                sw.setUsuarioModificacion(paramet);
                break;
            case 6:
                sw.setPath(paramet);
                break;
            case 7:
                listaSitioWeb.add(sw);
                break;
        }
    }

    public List<SitioWeb> getListaSitioWeb() {
        return listaSitioWeb;
    }

    public List<PaginaWeb> getListaPaginaWeb() {
        return listaPaginaWeb;
    }
    
}
