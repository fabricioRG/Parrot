package parrot.backend.titulo;

/**
 *
 * @author fabricio
 */
public class TituloBuilder {
    
    String texto;
    String alineacion;
    String color;

    public TituloBuilder() {
    }

    public TituloBuilder texto(String texto) {
        this.texto = texto;
        return this;
    }

    public TituloBuilder alineacion(String alineacion) {
        this.alineacion = alineacion;
        return this;
    }

    public TituloBuilder color(String color) {
        this.color = color;
        return this;
    }
    
    public Titulo build(){
        return new Titulo(this);
    }

    public String getTexto() {
        return texto;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public String getColor() {
        return color;
    }
    
}
