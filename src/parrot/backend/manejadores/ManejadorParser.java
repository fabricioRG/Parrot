package parrot.backend.manejadores;

import java.io.File;
import java.text.SimpleDateFormat;
import parrot.backend.sitioweb.SitioWeb;
import parrot.backend.sitioweb.SitioWebBuilder;

/**
 *
 * @author fabricio
 */
public class ManejadorParser {

    public static final String ABSOLUTH_PATH_SERVER = "/var/www/html"; 
    private SimpleDateFormat fechaFormat = null;
    private static ManejadorParser INSTANCE = null;
    
    private ManejadorParser() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorParser();
        }
    }
    
    public static ManejadorParser getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
    public void showErrorMessege(String error){
        ManejadorLectorXML.getInstance().showErrorMessege(error);
        System.out.println(error);
    }
    
    /*
    Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -         Crear objeto Sitio Web
         2       -         Asignar Fecha de Creacion
         3       -         Asignar Fecha de Modificacion
         4       -         Asignar Id
         5       -         Asignar Usuario Creacion
         6       -        Asignar Usuario Modificacion
    */
    public SitioWeb setSitioWeb(String parametro, int option, SitioWeb sitioWeb) throws Exception{
        SitioWeb sw = sitioWeb;
        String paramet = "";
        if(parametro != null && !parametro.isEmpty()){
            paramet = parametro.substring(1, parametro.indexOf("]"));
        }
        switch(option){
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
                sw.setId(paramet);
                break;
            case 5:
                sw.setUsuarioCreacion(paramet);
                break;
            case 6:
                sw.setUsuarioModificacion(paramet);
                break;
            case 7:
                if(sw.getId() == null){
                    throw new Exception("No se ha podido crear el sitio web, no se ha especificado ID");
                }
                createDirectory("/" + sw.getId());
                
                System.out.println(sw.getId());
                System.out.println(sw.getFechaCreacion());
                System.out.println(sw.getFechaModificacion());
                System.out.println(sw.getUsuarioCreacion());
                System.out.println(sw.getUsuarioModificacion());
                break;
        }
        return sw;
    }
    
    private void createDirectory(String path){
        new File(ABSOLUTH_PATH_SERVER + path).mkdir();
    }
    
}
