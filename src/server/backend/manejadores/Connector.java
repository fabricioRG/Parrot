package server.backend.manejadores;

import java.io.StringReader;
import server.backend.analizadores.Lexer1;
import server.backend.analizadores.parser;
import java.net.*;
import java.io.*;
import server.ServidorFrontend;
import server.backend.manejadores.ManejadorParser;
import server.backend.usuario.UsuarioBuilder;

/**
 *
 * @author fabricio
 */
public class Connector {

    private static Connector INSTANCE = null;

    final int PUERTO = 8600;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    String mensajeRecibido;

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
        BufferedReader entrada;

        try {
            sc = new ServerSocket(PUERTO);/* crea socket servidor que escuchara en puerto 5000*/
            so = new Socket();
            System.out.println("Esperando una conexion:");
            so = sc.accept();

            //Inicia el socket, ahora esta esperando una conexión por parte del cliente
            System.out.println("Un cliente se ha conectado.");

            //Canales de entrada y salida de datos
            entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
            salida = new DataOutputStream(so.getOutputStream());
            System.out.println("Confirmando conexion al cliente....");

            salida.writeUTF("Conexión exitosa...\n envia un mensaje :D");

            //Recepcion de mensaje
            mensajeRecibido = entrada.readLine();
            System.out.println(mensajeRecibido);

            salida.writeUTF("Se recibio el mensaje.\n Terminando conexion...");
            salida.writeUTF("Gracias por conectarte, adios!");
            System.out.println("Cerrando conexión...");
            sc.close();//Aqui se cierra la conexión con el cliente

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
