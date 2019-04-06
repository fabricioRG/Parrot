package parrot.backend.video;

/**
 *
 * @author fabricio
 */
public class VideoBuilder {
    String origen;
    String alineacion;
    int altura;
    int ancho;

    public VideoBuilder() {
    }

    public VideoBuilder origen(String origen) {
        this.origen = origen;
        return this;
    }

    public VideoBuilder altura(int altura) {
        this.altura = altura;
        return this;
    }

    public VideoBuilder ancho(int ancho) {
        this.ancho = ancho;
        return this;
    }
    
    public Video build(){
        return new Video(this);
    }

    public String getOrigen() {
        return origen;
    }

    public int getAltura() {
        return altura;
    }

    public int getAncho() {
        return ancho;
    }
}
