package parrot.backend.objetos;

/**
 *
 * @author fabricio
 */
public class PaginaWeb {

    String titulo;
    SitioWeb sitio;
    PaginaWeb padre;
    Etiqueta etiquetaCabeza;
    
    PaginaWeb (PaginaWebBuilder builder){
        this.titulo = builder.getTitulo();
        this.sitio = builder.getSitio();
        this.padre = builder.getPadre();
        this.etiquetaCabeza = builder.getEtiquetaCabeza();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public SitioWeb getSitio() {
        return sitio;
    }

    public void setSitio(SitioWeb sitio) {
        this.sitio = sitio;
    }

    public PaginaWeb getPadre() {
        return padre;
    }

    public void setPadre(PaginaWeb padre) {
        this.padre = padre;
    }

    public Etiqueta getEtiquetaCabeza() {
        return etiquetaCabeza;
    }

    public void setEtiquetaCabeza(Etiqueta etiquetaCabeza) {
        this.etiquetaCabeza = etiquetaCabeza;
    }
    
}
