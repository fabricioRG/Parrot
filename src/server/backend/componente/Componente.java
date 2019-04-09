package server.backend.componente;

import server.backend.clase.Clase;
import server.backend.paginaweb.PaginaWeb;

/**
 *
 * @author fabricio
 */
public class Componente {

    private String id;
    private PaginaWeb pagina;
    private Clase clase;
    private int posicion;
    
    Componente (ComponenteBuilder builder){
        this.id = builder.getId();
        this.pagina = builder.getPagina();
        this.clase = builder.getClase();
        this.posicion = builder.getPosicion();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaginaWeb getPagina() {
        return pagina;
    }

    public void setPagina(PaginaWeb pagina) {
        this.pagina = pagina;
    }

    public Clase getClase() {
        return clase;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
}
