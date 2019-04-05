package parrot.backend.objetos;

/**
 *
 * @author fabricio
 */
public class ParrafoBuilder {
    
    String texto;
    String alineacion;
    String color;

    public ParrafoBuilder() {
    }

    public ParrafoBuilder texto(String texto) {
        this.texto = texto;
        return this;
    }

    public ParrafoBuilder alineacion(String alineacion) {
        this.alineacion = alineacion;
        return this;
    }

    public ParrafoBuilder color(String color) {
        this.color = color;
        return this;
    }
    
    public Parrafo build(){
        return new Parrafo(this);
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
