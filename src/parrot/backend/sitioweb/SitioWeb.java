package parrot.backend.sitioweb;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class SitioWeb {

    String id;
    String usuarioCreacion;
    Date fechaCreacion;
    Date fechaModificacion;
    String usuarioModificacion;
    
    SitioWeb(SitioWebBuilder builder){
        this.id = builder.getId();
        this.usuarioCreacion = builder.getUsuarioCreacion();
        this.fechaCreacion = builder.getFechaCreacion();
        this.fechaModificacion = builder.getFechaModificacion();
        this.usuarioModificacion = builder.getUsuarioModificacion();
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
