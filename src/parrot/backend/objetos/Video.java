package parrot.backend.objetos;

/**
 *
 * @author fabricio
 */
public class Video {
    
   String origen;
    int altura;
    int ancho;
    
    Video (VideoBuilder builder){
        this.origen = builder.getOrigen();
        this.altura = builder.getAltura();
        this.ancho = builder.getAncho();
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
}
