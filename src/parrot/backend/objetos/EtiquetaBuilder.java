package parrot.backend.objetos;

/**
 *
 * @author fabricio
 */
public class EtiquetaBuilder {

    String valor;
    Etiqueta siguienteEtiqueta;

    public EtiquetaBuilder() {
    }

    public EtiquetaBuilder valor(String valor) {
        this.valor = valor;
        return this;
    }

    public EtiquetaBuilder siguienteEtiquete(Etiqueta siguienteEtiqueta) {
        this.siguienteEtiqueta = siguienteEtiqueta;
        return this;
    }
    
    public Etiqueta build(){
        return new Etiqueta(this);
    }

    public String getValor() {
        return valor;
    }

    public Etiqueta getSiguienteEtiqueta() {
        return siguienteEtiqueta;
    }
    
}
