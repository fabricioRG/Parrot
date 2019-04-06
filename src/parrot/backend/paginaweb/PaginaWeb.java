package parrot.backend.paginaweb;

import parrot.backend.sitioweb.SitioWeb;
import java.util.Date;
import parrot.backend.etiqueta.Etiqueta;

/**
 *
 * @author fabricio
 */
public class PaginaWeb {

    String id;
    String titulo;
    SitioWeb sitio;
    PaginaWeb padre;
    String usuarioCreacion;
    Date fechaCreacion;
    Date fechaModificacion;
    String usuarioModificacion;
    Etiqueta etiquetaCabeza;
    
    PaginaWeb (PaginaWebBuilder builder){
        this.id = builder.getId();
        this.titulo = builder.getTitulo();
        this.sitio = builder.getSitio();
        this.padre = builder.getPadre();
        this.etiquetaCabeza = builder.getEtiquetaCabeza();
        this.usuarioCreacion = builder.getUsuarioCreacion();
        this.fechaCreacion = builder.getFechaCreacion();
        this.fechaModificacion = builder.getFechaModificacion();
        this.usuarioModificacion = builder.getUsuarioModificacion();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
    
}