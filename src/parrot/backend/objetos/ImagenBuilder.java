package parrot.backend.objetos;

/**
 *
 * @author fabricio
 */
public class ImagenBuilder {
    
    String origen;
    String alineacion;
    int altura;
    int ancho;

    public ImagenBuilder() {
    }

    public ImagenBuilder origen(String origen) {
        this.origen = origen;
        return this;
    }

    public ImagenBuilder alineacion(String alineacion) {
        this.alineacion = alineacion;
        return this;
    }

    public ImagenBuilder altura(int altura) {
        this.altura = altura;
        return this;
    }

    public ImagenBuilder ancho(int ancho) {
        this.ancho = ancho;
        return this;
    }
    
    public Imagen build(){
        return new Imagen(this);
    }

    public String getOrigen() {
        return origen;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public int getAltura() {
        return altura;
    }

    public int getAncho() {
        return ancho;
    }
    
}
