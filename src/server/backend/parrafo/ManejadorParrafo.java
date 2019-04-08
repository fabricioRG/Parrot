package parrot.backend.parrafo;

/**
 *
 * @author fabricio
 */
public class ManejadorParrafo {

    private static ManejadorParrafo INSTANCE = null;
    private Parrafo parrafo = null;

    private ManejadorParrafo() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorParrafo();
        }
    }
    
    public static ManejadorParrafo getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    public void setParrafo(String parametro, int option){
        String paramet = null;
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch(option){
            case 1:
                parrafo = new ParrafoBuilder().texto(paramet).build();
                break;
            case 2:
                parrafo.setAlineacion(paramet);
                break;
            case 3:
                parrafo.setColor(paramet);
                break;
        }
        
    }

    public Parrafo getParrafo() {
        if(parrafo.getTexto() == null){
            return null;
        }
        return parrafo;
    }
}
