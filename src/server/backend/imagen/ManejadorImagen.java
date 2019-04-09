package server.backend.imagen;

/**
 *
 * @author fabricio
 */
public class ManejadorImagen {

    private static ManejadorImagen INSTANCE = null;
    private Imagen imagen = null;

    private ManejadorImagen() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorImagen();
        }
    }
    
    public static ManejadorImagen getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -                  Origen
         2       -                  Alineacion
         3       -                  Altura
         4       -                 Ancho
     */
    
    public void setImagen(String parametro, int option){
        String paramet = null;
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch(option){
            case 1:
                imagen = new ImagenBuilder().build();
                break;
            case 2:
                imagen.setOrigen(paramet);
                break;
            case 3:
                imagen.setAlineacion(paramet);
                break;
            case 4:
                imagen.setAltura(Integer.parseInt(paramet));
                break;
            case 5:
                imagen.setAncho(Integer.parseInt(paramet));
                break;
        }
    }

    public Imagen getImagen() throws Exception {
        if(imagen.getOrigen() == null){
            throw new Exception("Origen en clase \"Imagen\" vacio. Intentelo de nuevo");
        } else if (imagen.getAltura() == 0 || imagen.getAncho() == 0){
            throw new Exception("Altura y/u origen en clase \"Imagen\" vacio. Intentelo de nuevo");
        }
        System.out.println(imagen.getOrigen());
        return imagen;
    }
    
}
