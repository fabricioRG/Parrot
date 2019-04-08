
package parrot.backend.video;

/**
 *
 * @author fabricio
 */
public class ManejadorVideo {

private static ManejadorVideo INSTANCE = null;
private Video video = null;

    private ManejadorVideo() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorVideo();
        }
    }
    
    public static ManejadorVideo getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -                  Origen
         2       -                  Altura
         3       -                 Ancho
     */
    
    public void setImagen(String parametro, int option){
        String paramet = null;
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch(option){
            case 1:
                video = new VideoBuilder().origen(paramet).build();
                break;
            case 2:
                video.setAltura(Integer.parseInt(paramet));
                break;
            case 3:
                video.setAncho(Integer.parseInt(paramet));
                break;
        }
    }

    public Video getVideo() {
        if(video.getOrigen() == null){
            video = null;
        } else if (video.getAltura() == 0 || video.getAncho() == 0){
            video = null;
        }
        return video;
    }
}
