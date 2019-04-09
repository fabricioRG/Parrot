package server.backend.etiqueta;

/**
 *
 * @author fabricio
 */
public class ManejadorEtiqueta {

    private static ManejadorEtiqueta INSTANCE = null;
    private Etiqueta cabeza = null;

    private ManejadorEtiqueta() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorEtiqueta();
        }
    }

    public static ManejadorEtiqueta getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void setEtiqueta(String entrada) {
        String[] etiquetas = null;
        cabeza = null;
        if (entrada.contains("|")) {
            etiquetas = entrada.split("\\|");
        } else {
            etiquetas[0] = entrada;
        }
        for (String etiqueta : etiquetas) {
            if (!etiqueta.trim().isEmpty()) {
                if (cabeza == null) {
                    cabeza = new EtiquetaBuilder().valor(etiqueta.trim()).build();
                } else {
                    addEtiquetaToNext(new EtiquetaBuilder().valor(etiqueta.trim()).build(), cabeza);
                }
            }
        }
    }

    public void addEtiquetaToNext(Etiqueta etiqueta, Etiqueta cabeza) {
        Etiqueta i = cabeza;
        Etiqueta j = null;
        while (i != null) {
            j = i;
            i = i.getSiguienteEtiqueta();
        }
        j.setSiguienteEtiqueta(etiqueta);
    }

    public Etiqueta getCabeza() throws Exception {
        if (cabeza == null) {
            throw new Exception("Etiquetas en Clase \"Etiqueta\" vacio.");
        }
        return cabeza;
    }

}
