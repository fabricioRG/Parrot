package server.backend.parrafo;

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
                parrafo = new ParrafoBuilder().build();
                break;
            case 2:
                parrafo.setTexto(paramet);
                break;
            case 3:
                parrafo.setAlineacion(paramet);
                break;
            case 4:
                parrafo.setColor(paramet);
                break;
        }
        
    }

    public Parrafo getParrafo() throws Exception {
        if(parrafo.getTexto() == null){
            throw new Exception("Texto en clase \"Parrafo\" vacio. Intentelo de nuevo");
        }
        System.out.println(parrafo.getTexto());
        return parrafo;
    }
}
