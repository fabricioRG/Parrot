package parrot.backend.componente;

import parrot.backend.clase.Clase;
import parrot.backend.paginaweb.PaginaWeb;

/**
 *
 * @author fabricio
 */
public class ComponenteBuilder {

    String id;
    PaginaWeb pagina;
    Clase clase;

    public ComponenteBuilder() {
    }

    public ComponenteBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ComponenteBuilder pagina(PaginaWeb pagina) {
        this.pagina = pagina;
        return this;
    }

    public ComponenteBuilder clase(Clase clase) {
        this.clase = clase;
        return this;
    }
    
    public Componente build(){
        return new Componente(this);
    }

    public String getId() {
        return id;
    }

    public PaginaWeb getPagina() {
        return pagina;
    }

    public Clase getClase() {
        return clase;
    }
    
}
