package parrot.backend.titulo;

/**
 *
 * @author fabricio
 */
public class ManejadorTitulo {

private static ManejadorTitulo INSTANCE = null;
private Titulo titulo = null;

    private ManejadorTitulo() {
    }
    
    private synchronized static void createInstance(){
        if (INSTANCE == null){
            INSTANCE = new ManejadorTitulo();
        }
    }
    
    public static ManejadorTitulo getInstance(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }
    
    /* Metodo que recibe parametros de tipo string y opciones tipo int, los cuales
    al reconocerse su tipo realizan una accion especifica los cuales son:
    OPTION                      ACCION
         1       -                  Texto
         2       -                  Alineacion
         3       -                  Color
     */
    
    public void setTitulo(String parametro, int option){
        String paramet = null;
        if (parametro != null && !parametro.isEmpty()) {
            paramet = parametro.substring(1, parametro.indexOf("]")).trim();
        }
        switch(option){
            case 1:
                titulo = new TituloBuilder().texto(paramet).build();
                break;
            case 2:
                titulo.setAlineacion(paramet);
                break;
            case 3:
                titulo.setColor(paramet);
                break;
        }
        
    }

    public Titulo getTitulo() {
        if(titulo.getTexto() == null){
            titulo = null;
        }
        return titulo;
    }
    
}
