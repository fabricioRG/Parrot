package server.backend.clase;

import server.backend.menu.Menu;
import server.backend.video.Video;
import server.backend.imagen.Imagen;
import server.backend.parrafo.Parrafo;
import server.backend.titulo.Titulo;

/**
 *
 * @author fabricio
 */
public class ClaseBuilder {

    Titulo titulo;
    Parrafo parrafo;
    Imagen imagen;
    Video video;
    Menu menu;

    public ClaseBuilder() {
    }

    public ClaseBuilder titulo(Titulo titulo) {
        this.titulo = titulo;
        return this;
    }

    public ClaseBuilder parrafo(Parrafo parrafo) {
        this.parrafo = parrafo;
        return this;
    }

    public ClaseBuilder imagen(Imagen imagen) {
        this.imagen = imagen;
        return this;
    }

    public ClaseBuilder video(Video video) {
        this.video = video;
        return this;
    }

    public ClaseBuilder menu(Menu menu) {
        this.menu = menu;
        return this;
    }
    
    public Clase build(){
        return new Clase(this);
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Parrafo getParrafo() {
        return parrafo;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public Video getVideo() {
        return video;
    }

    public Menu getMenu() {
        return menu;
    }
    
}
