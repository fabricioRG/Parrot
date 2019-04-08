package parrot.backend.sitioweb;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class SitioWeb {

    private String id;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuarioModificacion;
    private String path;
    
    SitioWeb(SitioWebBuilder builder){
        this.id = builder.getId();
        this.usuarioCreacion = builder.getUsuarioCreacion();
        this.fechaCreacion = builder.getFechaCreacion();
        this.fechaModificacion = builder.getFechaModificacion();
        this.usuarioModificacion = builder.getUsuarioModificacion();
        this.path = builder.getPath();
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
