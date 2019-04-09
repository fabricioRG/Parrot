package server.backend.titulo;

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
                titulo = new TituloBuilder().build();
                break;
            case 2:
                titulo.setTexto(paramet);
                break;
            case 3:
                titulo.setAlineacion(paramet);
                break;
            case 4:                
                titulo.setColor(paramet);
                break;
        }
    }

    public Titulo getTitulo() throws Exception {
        if(titulo.getTexto() == null){
            throw new Exception("Texto en clase \"Titulo\" vacio. Intentelo de nuevo.");
        }
        System.out.println(titulo.getTexto());
        return titulo;
    }
    
}
