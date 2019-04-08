package parrot.backend.imagen;

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
                imagen = new ImagenBuilder().origen(paramet).build();
                break;
            case 2:
                imagen.setAlineacion(paramet);
                break;
            case 3:
                imagen.setAltura(Integer.parseInt(paramet));
                break;
            case 4:
                imagen.setAncho(Integer.parseInt(paramet));
                break;
        }
    }

    public Imagen getImagen() {
        if(imagen.getOrigen() == null){
            imagen = null;
        } else if (imagen.getAltura() == 0 || imagen.getAncho() == 0){
            imagen = null;
        }
        return imagen;
    }
    
}
