package server.backend.menu;

import server.backend.etiqueta.Etiqueta;
import server.backend.paginaweb.PaginaWeb;

/**
 *
 * @author fabricio
 */
public class MenuBuilder {

    PaginaWeb padre;
    Etiqueta etiquetas;

    public MenuBuilder() {
    }

    public MenuBuilder padre(PaginaWeb padre) {
        this.padre = padre;
        return this;
    }

    public MenuBuilder etiquetas(Etiqueta etiquetas) {
        this.etiquetas = etiquetas;
        return this;
    }
    
    public Menu build(){
        return new Menu(this);
    }

    public PaginaWeb getPadre() {
        return padre;
    }

    public Etiqueta getEtiquetas() {
        return etiquetas;
    }
    
}
