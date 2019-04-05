package parrot.backend.objetos;

/**
 *
 * @author fabricio
 */
public class Etiqueta {
    
    String valor;
    Etiqueta siguienteEtiqueta;
    
    Etiqueta(EtiquetaBuilder builder){
        this.valor = builder.getValor();
        this.siguienteEtiqueta = builder.getSiguienteEtiqueta();
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Etiqueta getSiguienteEtiqueta() {
        return siguienteEtiqueta;
    }

    public void setSiguienteEtiqueta(Etiqueta siguienteEtiqueta) {
        this.siguienteEtiqueta = siguienteEtiqueta;
    }
    
}
