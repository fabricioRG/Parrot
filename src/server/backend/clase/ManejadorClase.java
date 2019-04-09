package server.backend.clase;

import java.text.ParseException;
import server.backend.imagen.ManejadorImagen;
import server.backend.menu.ManejadorMenu;
import server.backend.parrafo.ManejadorParrafo;
import server.backend.titulo.ManejadorTitulo;
import server.backend.video.ManejadorVideo;

/**
 *
 * @author fabricio
 */
public class ManejadorClase {

    private static ManejadorClase INSTANCE = null;
    private Clase clase = null;

    private ManejadorClase() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorClase();
        }
    }

    public static ManejadorClase getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -                  Titulo
         2       -                  Parrafo
         3       -                  Imagen
         4       -                  Video
         5       -                  Menu
     */
    public void setClase(int option) throws Exception {
        clase = new ClaseBuilder().build();
        switch (option) {
            case 1:
                if (ManejadorTitulo.getInstance().getTitulo() != null) {
                    clase.setTitulo(ManejadorTitulo.getInstance().getTitulo());
                }
                break;
            case 2:
                if (ManejadorParrafo.getInstance().getParrafo() != null) {
                    clase.setParrafo(ManejadorParrafo.getInstance().getParrafo());
                }
                break;
            case 3:
                if (ManejadorImagen.getInstance().getImagen() != null) {
                    clase.setImagen(ManejadorImagen.getInstance().getImagen());
                }
                break;
            case 4:
                if (ManejadorVideo.getInstance().getVideo() != null) {
                    clase.setVideo(ManejadorVideo.getInstance().getVideo());
                }
                break;
            case 5:
                if (ManejadorMenu.getInstance().getMenu() != null) {
                    clase.setMenu(ManejadorMenu.getInstance().getMenu());
                }
                break;
        }
    }

    public Clase getClase() throws Exception {
        return clase;
    }

}
