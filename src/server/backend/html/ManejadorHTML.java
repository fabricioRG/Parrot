package server.backend.html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import server.backend.componente.Componente;
import server.backend.componente.ManejadorComponente;
import server.backend.etiqueta.Etiqueta;
import server.backend.imagen.Imagen;
import server.backend.menu.Menu;
import server.backend.paginaweb.ManejadorPaginaWeb;
import server.backend.paginaweb.PaginaWeb;
import server.backend.parrafo.Parrafo;
import server.backend.sitioweb.ManejadorSitioWeb;
import static server.backend.sitioweb.ManejadorSitioWeb.ABSOLUTH_PATH_SERVER;
import static server.backend.sitioweb.ManejadorSitioWeb.NAME_INDEX;
import server.backend.sitioweb.SitioWeb;
import server.backend.titulo.Titulo;
import server.backend.video.Video;

/**
 *
 * @author fabricio
 */
public class ManejadorHTML {

    private static ManejadorHTML INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;
    public static final String HTML_AB = "<html>";
    public static final String HTML_CE = "</html>";
    public static final String BODY_AB = "<body>";
    public static final String BODY_CE = "</body>";
    public static final String HEAD_AB = "<head>";
    public static final String HEAD_CE = "</head>";
    public static final String TITLE_AB = "<title>";
    public static final String TITLE_CE = "</title>";
    public static final String TITULO_AB = "<h2 ";
    public static final String TITULO_NORMAL = "<h2>";
    public static final String TITULO_CE = "</h2>";
    public static final String COLOR_AB = "style=\"color:";
    public static final String COLOR_CE = ";\" ";
    public static final String ALIGN_DERECHA = " align=right ";
    public static final String ALIGN_IZQUIERDA = " align=left ";
    public static final String ALIGN_CENTRO = " align=middle ";
    public static final String ALIGN_JUSTIFICAR = " align=justify ";
    public static final String ABRIR = "<";
    public static final String CERRAR = ">";
    public static final String SALTO_LN = "\n";
    public static final String PARRAFO_NORMAL = "<p>";
    public static final String PARRAFO_AB = "<p ";
    public static final String PARRAFO_CE = "</p>";
    public static final String IMAGEN_AB = "<img ";
    public static final String SRC_AB = " src=\"";
    public static final String SRC_CE = "\" ";
    public static final String ABSOLUTH_PATH_SERVER = "/var/www/html";
    public static final String INDEX_NAME = "index.html";
    public static final String HTML = ".html";
    public static final String NAME_INDEX = "index.html";
    public static final String ANCHO_AB = " width=\"";
    public static final String ANCHO_CE = "\" ";
    public static final String ALTO_AB = " height=\"";
    public static final String ALTO_CE = "\" ";
    public static final String VIDEO_AB = "<iframe ";
    public static final String VIDEO_CE = "</iframe>";
    public static final String SALTO_LINEA = "<br>";
    public static final String LISTA_AB = "<ul>";
    public static final String LISTA_CE = "</ul>";
    public static final String ELEM_LISTA_AB = "<li>";
    public static final String ELEM_LISTA_CE = "</li>";
    public static final String LINK_AB = "<a ";
    public static final String LINK_CE = "</a>";
    public static final String HREF = " href=\"";
    public static final String HREF_CE = "\" ";
    public static final String CENTRAR = "CENTRAR";
    public static final String IZQUIERDA = "IZQUIERDA";
    public static final String DERECHA = "DERECHA";
    public static final String JUSTIFICAR = "JUSTIFICAR";

    private ManejadorHTML() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorHTML();
        }
    }

    public static ManejadorHTML getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void updateServidor() {
        File f = new File(ABSOLUTH_PATH_SERVER);
        deleteDirectory(f);
        makeDirectories();
    }

    private void deleteDirectory(File f) {
        File[] ficheros = f.listFiles();
        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].isDirectory()) {
                deleteDirectory(ficheros[i]);
            }
            ficheros[i].delete();
        }
    }

    private void makeDirectories() {
        List<SitioWeb> sitios = new LinkedList<>();
        if (ManejadorSitioWeb.getInstance().getListaSitioWeb() != null) {
            sitios.addAll(ManejadorSitioWeb.getInstance().getListaSitioWeb());
        }
        for (SitioWeb sitio : sitios) {
            createDirectory(sitio.getPath());
            createSitioWeb(sitio);
        }
    }

    private void createDirectory(String path) {
        new File(path).mkdir();
    }

    private void createSitioWeb(SitioWeb sw) {
        List<PaginaWeb> paginas = new LinkedList<>();
        if (!ManejadorPaginaWeb.getInstance().getListaPaginaWeb().isEmpty()) {
            paginas.addAll(ManejadorPaginaWeb.getInstance().getListaPaginaWeb());
        }
        String salida = HTML_AB + SALTO_LN + BODY_AB + SALTO_LN + TITULO_NORMAL + "Index of \"" + sw.getId() + "\"" + TITULO_CE + SALTO_LN
                + LISTA_AB;
        for (PaginaWeb pagina : paginas) {
            if (pagina.getSitio().getId().equals(sw.getId())) {
                if (pagina.getPadre() == null) {
                    crearPaginas(sw.getPath() + "/" + pagina.getId() + HTML, pagina);
                    salida = salida + getEtiqueta(pagina);
                }
            }
        }
        salida = salida + LISTA_CE + SALTO_LN + BODY_CE + SALTO_LN + HTML_CE;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(sw.getPath() + "/" + INDEX_NAME));
            writer.write(salida);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void crearPaginas(String path, PaginaWeb pw){
        String salida = getPaginaWeb(pw);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(salida);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String getEtiqueta(PaginaWeb pw) {
        String salida = ELEM_LISTA_AB + LINK_AB + HREF + "/" + pw.getSitio().getId() + "/" + pw.getId() + HTML + HREF_CE
                + CERRAR + pw.getId() + LINK_CE + ELEM_LISTA_CE + SALTO_LN;
        return salida;
    }

    private String getPaginaWeb(PaginaWeb pw) {
        String salida = HTML_AB + SALTO_LN;
        if (pw.getTitulo() != null) {
            salida = salida + getTitle(pw.getTitulo());
        }
        salida = salida + BODY_AB + SALTO_LN;
        List<Componente> componentes = new LinkedList<>();
        if (!ManejadorComponente.getInstance().getListaComponente().isEmpty()) {
            componentes.addAll(ManejadorComponente.getInstance().getListaComponente());
        }
        for (Componente comp : componentes) {
            if (comp.getPagina().getId().equals(pw.getId())) {
                salida = salida + getComponente(comp);
            }
        }
        salida = salida + BODY_CE + SALTO_LN + HTML_CE;
        return salida;
    }

    private String getComponente(Componente comp) {
        if (comp.getClase().getTitulo() != null) {
            return getTitulo(comp.getClase().getTitulo());
        } else if (comp.getClase().getParrafo() != null) {
            return getParrafo(comp.getClase().getParrafo());
        } else if (comp.getClase().getImagen() != null) {
            return getImagen(comp.getClase().getImagen());
        } else if (comp.getClase().getVideo() != null) {
            return getVideo(comp.getClase().getVideo());
        } else if (comp.getClase().getMenu() != null) {
            return getMenu(comp.getClase().getMenu());
        }
        return "";
    }

    private String getTitle(String titulo) {
        return HEAD_AB + SALTO_LN + TITLE_AB + titulo + TITLE_CE + SALTO_LN + HEAD_CE + SALTO_LN;
    }

    private String getTitulo(Titulo titulo) {
        String salida = TITULO_AB;
        if (titulo.getColor() != null) {
            String color = COLOR_AB + titulo.getColor() + COLOR_CE;
            salida = salida + color;
        }
        if (titulo.getAlineacion() != null) {
            String alineacion = "";
            if (titulo.getAlineacion().equals(CENTRAR)) {
                alineacion = ALIGN_CENTRO;
            } else if (titulo.getAlineacion().equals(IZQUIERDA)) {
                alineacion = ALIGN_IZQUIERDA;
            } else if (titulo.getAlineacion().equals(DERECHA)) {
                alineacion = ALIGN_DERECHA;
            } else if (titulo.getAlineacion().equals(JUSTIFICAR)) {
                alineacion = ALIGN_JUSTIFICAR;
            }
            salida = salida + alineacion;
        }
        salida = salida + CERRAR + titulo.getTexto() + TITULO_CE + SALTO_LN;
        return salida;
    }

    private String getParrafo(Parrafo parrafo) {
        String salida = PARRAFO_AB;
        if (parrafo.getColor() != null) {
            String color = COLOR_AB + parrafo.getColor() + COLOR_CE;
            salida = salida + color;
        }
        if (parrafo.getAlineacion() != null) {
            String alineacion = "";
            if (parrafo.getAlineacion().equals(CENTRAR)) {
                alineacion = ALIGN_CENTRO;
            } else if (parrafo.getAlineacion().equals(IZQUIERDA)) {
                alineacion = ALIGN_IZQUIERDA;
            } else if (parrafo.getAlineacion().equals(DERECHA)) {
                alineacion = ALIGN_DERECHA;
            } else if (parrafo.getAlineacion().equals(JUSTIFICAR)) {
                alineacion = ALIGN_JUSTIFICAR;
            }
            salida = salida + alineacion;
        }
        salida = salida + CERRAR + parrafo.getTexto() + PARRAFO_CE + SALTO_LN;
        return salida;
    }

    private String getImagen(Imagen imagen) {
        String salida =  IMAGEN_AB;
        salida = salida + SRC_AB + imagen.getOrigen() + SRC_CE;
        if (imagen.getAlineacion() != null) {
            String alineacion = "";
            if (imagen.getAlineacion().equals(CENTRAR)) {
                alineacion = ALIGN_CENTRO;
            } else if (imagen.getAlineacion().equals(IZQUIERDA)) {
                alineacion = ALIGN_IZQUIERDA;
            } else if (imagen.getAlineacion().equals(DERECHA)) {
                alineacion = ALIGN_DERECHA;
            } else if (imagen.getAlineacion().equals(JUSTIFICAR)) {
                alineacion = ALIGN_JUSTIFICAR;
            }
            salida = salida + alineacion;
        }
        salida = salida + ANCHO_AB + imagen.getAncho() + ANCHO_CE + ALTO_AB + imagen.getAltura() 
                + ALTO_CE + CERRAR + SALTO_LN;
        return salida;
    }

    private String getVideo(Video video) {
        String salida = VIDEO_AB + SRC_AB + video.getOrigen() + SRC_CE + ANCHO_AB + video.getAncho() + ANCHO_CE
                + ALTO_AB + video.getAltura() + ALTO_CE + CERRAR + SALTO_LN + VIDEO_CE + SALTO_LN;
        return salida;
    }

    private String getMenu(Menu menu) {
        List<PaginaWeb> paginas = new LinkedList<>();
        if (!ManejadorPaginaWeb.getInstance().getListaPaginaWeb().isEmpty()) {
            paginas.addAll(ManejadorPaginaWeb.getInstance().getListaPaginaWeb());
        }
        String salida = LISTA_AB + SALTO_LN;
        if (menu.getEtiquetas() != null && menu.getPadre() != null) {
            for (PaginaWeb pagina : paginas) {
                if (pagina.getPadre() != null) {
                    if (pagina.getPadre().getId().equals(menu.getPadre().getId())) {
                        if (pagina.getEtiquetaCabeza() != null) {
                            if (isEtiqueta(pagina.getEtiquetaCabeza(), menu.getEtiquetas())) {
                                salida = salida + ELEM_LISTA_AB + LINK_AB + HREF + "/" + pagina.getSitio().getId() + "/" + pagina.getId() + HTML + HREF_CE
                                        + CERRAR + pagina.getId() + LINK_CE + ELEM_LISTA_CE + SALTO_LN;
                            }
                        }
                    }
                }
            }
        } else if (menu.getPadre() != null) {
            for (PaginaWeb pagina : paginas) {
                if (pagina.getPadre() != null) {
                    if (pagina.getPadre().getId().equals(menu.getPadre().getId())) {
                        salida = salida + ELEM_LISTA_AB + LINK_AB + HREF + "/" + pagina.getSitio().getId() + "/" + pagina.getId() + HTML + HREF_CE
                                + CERRAR + pagina.getId() + LINK_CE + ELEM_LISTA_CE + SALTO_LN;
                    }
                }
            }
        } else if (menu.getEtiquetas() != null) {
            for (PaginaWeb pagina : paginas) {
                if (pagina.getEtiquetaCabeza() != null) {
                    if (isEtiqueta(pagina.getEtiquetaCabeza(), menu.getEtiquetas())) {
                        salida = salida + ELEM_LISTA_AB + LINK_AB + HREF + "/" + pagina.getSitio().getId() + "/" + pagina.getId() + HTML + HREF_CE
                                + CERRAR + pagina.getId() + LINK_CE + ELEM_LISTA_CE + SALTO_LN;
                    }
                }
            }
        }
        salida = salida + LISTA_CE + SALTO_LN;
        return salida;
    }

    private boolean isEtiqueta(Etiqueta etiqueta1, Etiqueta etiqueta2) {
        Etiqueta i = etiqueta1;
        Etiqueta j = null;
        while (i != null) {
                j = etiqueta2;
            while (j != null) {
                if (i.getValor().equals(j.getValor())) {
                    return true;
                }
                j = j.getSiguienteEtiqueta();
            }
            i = i.getSiguienteEtiqueta();
        }
        return false;
    }

    private void createIndex(SitioWeb sw, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write("<html><body><h1>Index of \"" + sw.getId() + "\"</h1></body></html>");
        writer.close();
    }

}
