/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.swing.JTextPane;
import server.backend.manejadores.Connector;

/**
 *
 * @author fabricio
 */
public class ServidorFrontend extends javax.swing.JFrame {

    /**
     * Creates new form ServidorFrontend
     */
    public ServidorFrontend() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Servidor");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName("Server"); // NOI18N

        jScrollPane1.setViewportView(jTextPane);

        jButton1.setBackground(new java.awt.Color(2, 179, 19));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Iniciar Servidor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(230, 3, 0));
        jButton2.setForeground(new java.awt.Color(254, 254, 254));
        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 5, 82));
        jLabel1.setText("Servidor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        jTextPane.setText("algo");
//        Connector.getInstance().initServer(this);
        String lectura = "<acciones>\n"
                + "<accion nombre=\"NUEVO_SITIO_WEB\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre = \"ID\">\n"
                + "                  [productos]\n"
                + "            </parametro>\n"
                + "              <parametro nombre = \"USUARIO_CREACION\">\n"
                + "                  [nombre1]\n"
                + "            </parametro>\n"
                + "              <parametro nombre=\"FECHA_CREACION\">\n"
                + "                  [2018-03-01]\n"
                + "            </parametro>\n"
                + "              <parametro nombre=\"FECHA_MODIFICACION\">\n"
                + "                  [2019-02-01]\n"
                + "            </parametro>\n"
                + "              <parametro nombre=\"USUARIO_MODIFICACION\">\n"
                + "                  [nombre2]\n"
                + "            </parametro>\n"
                + "    </parametros>\n"
                + "</accion>\n"
                + "<accion nombre=\"NUEVA_PAGINA\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre=\"ID\">\n"
                + "                  [productos1]\n"
                + "            </parametro>\n"
                + "             <parametro nombre =  \"SITIO\">\n"
                + "                 [productos]\n"
                + "             </parametro>\n"
                + "    </parametros>\n"
                + "     <etiquetas>\n"
                + "        <etiqueta valor=\"etiqueta1\"/>\n"
                + "        <etiqueta valor=\"etiqueta2\"/>\n"
                + "    </etiquetas>\n"
                + "</accion>\n"
                + "<accion nombre=\"NUEVO_SITIO_WEB\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre = \"ID\">\n"
                + "                  [productos20]\n"
                + "            </parametro>\n"
                + "              <parametro nombre = \"USUARIO_CREACION\">\n"
                + "                  [nombre1]\n"
                + "            </parametro>\n"
                + "              <parametro nombre=\"FECHA_CREACION\">\n"
                + "                  [2018-03-01]\n"
                + "            </parametro>\n"
                + "              <parametro nombre=\"FECHA_MODIFICACION\">\n"
                + "                  [2019-02-01]\n"
                + "            </parametro>\n"
                + "              <parametro nombre=\"USUARIO_MODIFICACION\">\n"
                + "                  [nombre2]\n"
                + "            </parametro>\n"
                + "    </parametros>\n"
                + "</accion>\n"
                + "<accion nombre=\"NUEVA_PAGINA\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre=\"ID\">\n"
                + "                  [productos2]\n"
                + "            </parametro>\n"
                + "             <parametro nombre =  \"SITIO\">\n"
                + "                 [productos]\n"
                + "             </parametro>\n"
                + "    </parametros>\n"
                + "     <etiquetas>\n"
                + "        <etiqueta valor=\"etiqueta1\"/>\n"
                + "        <etiqueta valor=\"etiqueta2\"/>\n"
                + "    </etiquetas>\n"
                + "</accion>\n"
                + "<accion nombre=\"AGREGAR_COMPONENTE\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre=\"ID\">\n"
                + "                  [comp-1]\n"
                + "            </parametro>\n"
                + "             <parametro nombre =  \"PAGINA\">\n"
                + "                 [productos2]\n"
                + "             </parametro>\n"
                + "             <parametro nombre =  \"CLASE\">\n"
                + "                 [TITULO]\n"
                + "             </parametro>\n"
                + "    </parametros>\n"
                + "     <atributos>\n"
                + "             <atributo nombre =  \"TEXTO\">\n"
                + "                 [Texto de ejemplo]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"ALINEACION\">\n"
                + "                 [DERECHA]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"COLOR\">\n"
                + "                 [#5A5A5A]\n"
                + "             </atributo>\n"
                + "    </atributos>\n"
                + "</accion>\n"
                + "<accion nombre=\"AGREGAR_COMPONENTE\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre=\"ID\">\n"
                + "                  [comp-2]\n"
                + "            </parametro>\n"
                + "             <parametro nombre =  \"PAGINA\">\n"
                + "                 [productos2]\n"
                + "             </parametro>\n"
                + "             <parametro nombre =  \"CLASE\">\n"
                + "                 [PARRAFO]\n"
                + "             </parametro>\n"
                + "    </parametros>\n"
                + "     <atributos>\n"
                + "             <atributo nombre =  \"TEXTO\">\n"
                + "                 [Texto de ejemplo 2]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"ALINEACION\">\n"
                + "                 [DERECHA]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"COLOR\">\n"
                + "                 [#5A5A5A]\n"
                + "             </atributo>\n"
                + "    </atributos>\n"
                + "</accion>\n"
                + "<accion nombre=\"AGREGAR_COMPONENTE\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre=\"ID\">\n"
                + "                  [comp-3]\n"
                + "            </parametro>\n"
                + "             <parametro nombre =  \"PAGINA\">\n"
                + "                 [productos2]\n"
                + "             </parametro>\n"
                + "             <parametro nombre =  \"CLASE\">\n"
                + "                 [IMAGEN]\n"
                + "             </parametro>\n"
                + "    </parametros>\n"
                + "     <atributos>\n"
                + "             <atributo nombre =  \"ORIGEN\">\n"
                + "                 [https://www.algo.com/algomas]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"ALINEACION\">\n"
                + "                 [DERECHA]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"ALTURA\">\n"
                + "                 [120]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"ANCHO\">\n"
                + "                 [140]\n"
                + "             </atributo>\n"
                + "    </atributos>\n"
                + "</accion>\n"
                + "<accion nombre=\"AGREGAR_COMPONENTE\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre=\"ID\">\n"
                + "                  [comp-4]\n"
                + "            </parametro>\n"
                + "             <parametro nombre =  \"PAGINA\">\n"
                + "                 [productos2]\n"
                + "             </parametro>\n"
                + "             <parametro nombre =  \"CLASE\">\n"
                + "                 [VIDEO]\n"
                + "             </parametro>\n"
                + "    </parametros>\n"
                + "     <atributos>\n"
                + "             <atributo nombre =  \"ORIGEN\">\n"
                + "                 [https://www.algo2.com/algomas]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"ALTURA\">\n"
                + "                 [120]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"ANCHO\">\n"
                + "                 [140]\n"
                + "             </atributo>\n"
                + "    </atributos>\n"
                + "</accion>\n"
                + "<accion nombre=\"AGREGAR_COMPONENTE\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre=\"ID\">\n"
                + "                  [comp-5]\n"
                + "            </parametro>\n"
                + "             <parametro nombre =  \"PAGINA\">\n"
                + "                 [productos2]\n"
                + "             </parametro>\n"
                + "             <parametro nombre =  \"CLASE\">\n"
                + "                 [MENU]\n"
                + "             </parametro>\n"
                + "    </parametros>\n"
                + "     <atributos>\n"
                + "             <atributo nombre =  \"PADRE\">\n"
                + "                 [productos2]\n"
                + "             </atributo>\n"
                + "             <atributo nombre =  \"ETIQUETAS\">\n"
                + "                 [algo1 | algo2]\n"
                + "             </atributo>\n"
                + "    </atributos>\n"
                + "</accion>\n"
                + "<accion nombre=\"MODIFICAR_PAGINA\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre=\"ID\">\n"
                + "                  [productos1]\n"
                + "            </parametro>\n"
                + "             <parametro nombre =  \"TITULO\">\n"
                + "                 [productosSSS]\n"
                + "             </parametro>\n"
                + "    </parametros>\n"
                + "     <etiquetas>\n"
                + "        <etiqueta valor=\"ETIQUETA\"/>\n"
                + "        <etiqueta valor=\"ETIQUETA2\"/>\n"
                + "    </etiquetas>\n"
                + "</accion>\n"
                + "<accion nombre=\"BORRAR_SITIO_WEB\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre = \"ID\">\n"
                + "                  [productos20]\n"
                + "            </parametro>\n"
                + "    </parametros>\n"
                + "</accion>\n"
                + "<accion nombre=\"BORRAR_PAGINA\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre = \"ID\">\n"
                + "                  [productos1]\n"
                + "            </parametro>\n"
                + "    </parametros>\n"
                + "</accion>\n"
                + "<accion nombre=\"BORRAR_COMPONENTE\">\n"
                + "    <parametros>\n"
                + "              <parametro nombre = \"ID\">\n"
                + "                  [comp-4]\n"
                + "            </parametro>\n"
                + "              <parametro nombre = \"PAGINA\">\n"
                + "                  [productos2]\n"
                + "            </parametro>\n"
                + "    </parametros>\n"
                + "</accion>\n"
                + "</acciones>";
        Connector.getInstance().procesarTexto(lectura);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    public JTextPane getjTextPane() {
        return jTextPane;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane;
    // End of variables declaration//GEN-END:variables
}
