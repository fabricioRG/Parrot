package server.backend.sitioweb;

import server.backend.sitioweb.SitioWeb; 
import java.util.Date;

/**
 *
 * @author fabricio
 */
public class SitioWebBuilder {

    private String id;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuarioModificacion;
    private String path;

    public SitioWebBuilder() {
    }

    public SitioWebBuilder id(String id) {
        this.id = id;
        return this;
    }

    public SitioWebBuilder usuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
        return this;
    }

    public SitioWebBuilder fechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public SitioWebBuilder fechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
        return this;
    }

    public SitioWebBuilder usuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
        return this;
    }

    public SitioWebBuilder path(String path) {
        this.path = path;
        return this;
    }
    
    public SitioWeb build(){
        return new SitioWeb(this);
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

    public String getPath() {
        return path;
    }
    
}
