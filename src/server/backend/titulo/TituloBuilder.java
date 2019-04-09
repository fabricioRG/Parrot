package server.backend.titulo;

/**
 *
 * @author fabricio
 */
public class TituloBuilder {
    
    private String texto;
    private String alineacion;
    private String color;

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
