package parrot.backend.componente;

import parrot.backend.clase.Clase;
import parrot.backend.paginaweb.PaginaWeb;

/**
 *
 * @author fabricio
 */
public class Componente {

    String id;
    PaginaWeb pagina;
    Clase clase;
    
    Componente (ComponenteBuilder builder){
        this.id = builder.getId();
        this.pagina = builder.getPagina();
        this.clase = builder.getClase();
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

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    
}
