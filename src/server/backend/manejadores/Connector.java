package server.backend.manejadores;

import java.io.StringReader;
import server.backend.analizadores.Lexer1;
import server.backend.analizadores.parser;
import java.net.*;
import java.io.*;
import server.ServidorFrontend;
import server.backend.error.ManejadorErrores;
import server.backend.manejadores.ManejadorParser;
import server.backend.usuario.UsuarioBuilder;

/**
 *
 * @author fabricio
 */
public class Connector {

    private static Connector INSTANCE = null;

    private Connector() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Connector();
        }
    }

    public static Connector getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

//SERVIDOR
    public void initServer(ServidorFrontend sf) {
        try {
           final  int PUERTO = 5000;
            ServerSocket servidor = null;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;

            servidor = new ServerSocket(PUERTO);/* crea socket servidor que escuchara en puerto 5000*/
            System.out.println("Servidor iniciado");
            sf.getjTextPane().setText("Servidor Iniciado");

            while (true) {
                sc = servidor.accept();
                
                System.out.println("Cliente conectado");
                sf.getjTextPane().setText("Cliente conectado");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF();

                procesarTexto(mensaje);
                String respuesta  = ManejadorErrores.getInstance().getErrores();
                
                out.writeUTF(respuesta);
                
                sc.close();
                sf.getjTextPane().setText("Cliente desconectado");
                System.out.println("Cliente desconectado");
                
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void procesarTexto(String entrada) {
        String entrada1 = entrada.substring(1, entrada.indexOf(")"));
        ManejadorParser.getInstance().setUsuario(new UsuarioBuilder().id(entrada1).build());
        String entrada2 = entrada.substring(entrada.indexOf(")") + 3, entrada.length() - 1);
        StringReader sr = new StringReader(entrada2);
        Lexer1 lexer = new Lexer1(sr);
        parser pars = new parser(lexer, ManejadorParser.getInstance());
        try {
            if (entrada.isEmpty()) {
                throw new Exception("Entrada vacia, intente de nuevo");
            }
            pars.parse();
        } catch (Exception ex) {
            ex.printStackTrace();
            showErrorMessege(ex.getMessage());
        }
    }

    public void showErrorMessege(String error) {

    }

}
