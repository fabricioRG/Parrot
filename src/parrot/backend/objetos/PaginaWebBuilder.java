package parrot.backend.objetos;

/**
 *
 * @author fabricio
 */
public class PaginaWebBuilder {

    String titulo;
    SitioWeb sitio;
    PaginaWeb padre;
    Etiqueta etiquetaCabeza;

    public PaginaWebBuilder() {
    }

    public PaginaWebBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public PaginaWebBuilder sitio(SitioWeb sitio) {
        this.sitio = sitio;
        return this;
    }

    public PaginaWebBuilder padre(PaginaWeb padre) {
        this.padre = padre;
        return this;
    }

    public PaginaWebBuilder etiquetaCabeza(Etiqueta etiquetaCabeza) {
        this.etiquetaCabeza = etiquetaCabeza;
        return this;
    }
    
    public PaginaWeb build(){
        return new PaginaWeb(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public SitioWeb getSitio() {
        return sitio;
    }

    public PaginaWeb getPadre() {
        return padre;
    }

    public Etiqueta getEtiquetaCabeza() {
        return etiquetaCabeza;
    }
    
}
