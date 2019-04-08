package parrot.backend.clase;

import parrot.backend.menu.Menu;
import parrot.backend.video.Video;
import parrot.backend.imagen.Imagen;
import parrot.backend.parrafo.Parrafo;
import parrot.backend.titulo.Titulo;

/**
 *
 * @author fabricio
 */
public class Clase {

    Titulo titulo;
    Parrafo parrafo;
    Imagen imagen;
    Video video;
    Menu menu;
    
    Clase (ClaseBuilder build){
        this.titulo = build .getTitulo();
        this.parrafo = build.getParrafo();
        this.imagen = build.getImagen();
        this.video = build.getVideo();
        this.menu = build.getMenu();
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public Parrafo getParrafo() {
        return parrafo;
    }

    public void setParrafo(Parrafo parrafo) {
        this.parrafo = parrafo;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
}
