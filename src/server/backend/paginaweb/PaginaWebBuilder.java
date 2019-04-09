package server.backend.paginaweb; 

import server.backend.sitioweb.SitioWeb;
import java.util.Date;
import server.backend.etiqueta.Etiqueta;

/**
 *
 * @author fabricio
 */
public class PaginaWebBuilder {

    private String id;
    private String titulo;
    private SitioWeb sitio;
    private PaginaWeb padre;
    private Etiqueta etiquetaCabeza;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuarioModificacion;
    private String path;

    public PaginaWebBuilder() {
    }

    public PaginaWebBuilder id(String id) {
        this.id = id;
        return this;
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

    public PaginaWebBuilder usuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
        return this;
    }

    public PaginaWebBuilder fechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public PaginaWebBuilder fechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
        return this;
    }

    public PaginaWebBuilder usuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
        return this;
    }

    public PaginaWebBuilder path(String path) {
        this.path = path;
        return this;
    }
    
    public PaginaWeb build(){
        return new PaginaWeb(this);
    }

    public String getPath() {
        return path;
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

    public String getId() {
        return id;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }
    
}
