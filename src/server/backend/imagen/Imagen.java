package server.backend.imagen;

/**
 *
 * @author fabricio
 */
public class Imagen {
    
    String origen;
    String alineacion;
    int altura = 0;
    int ancho = 0;
    
    Imagen (ImagenBuilder builder){
        this.origen = builder.getOrigen();
        this.alineacion = builder.getAlineacion();
        this.altura = builder.getAltura();
        this.ancho = builder.getAncho();
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
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
