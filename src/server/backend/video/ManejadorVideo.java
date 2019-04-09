
package server.backend.video;

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
    
    public void setVideo(String parametro, int option){
        String paramet = null;
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch(option){
            case 1:
                video = new VideoBuilder().build();
                break;
            case 2:
                video.setOrigen(paramet);
                break;
            case 3:
                video.setAltura(Integer.parseInt(paramet));
                break;
            case 4:
                video.setAncho(Integer.parseInt(paramet));
                break;
        }
    }

    public Video getVideo() throws Exception {
        if(video.getOrigen() == null){
            throw new Exception("Origen en clase \"Video\" vacio. Intentelo de nuevo");
        } else if (video.getAltura() == 0 || video.getAncho() == 0){
            throw new Exception("Altura y/u origen en clase \"Video\" vacio. Intentelo de nuevo");
        }
        System.out.println(video.getOrigen());
        return video;
    }
}
