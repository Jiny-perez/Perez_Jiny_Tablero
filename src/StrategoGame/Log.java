/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package StrategoGame;

public class Log extends javax.swing.JFrame {

    public Log() {
        initComponents();
    }

    public Log(Usuario usuario, RegistroPartidas[] registros) {
        initComponents();
        cargarDatos(usuario, registros);
    }

    private void cargarDatos(Usuario usuario, RegistroPartidas[] registros) {
        // Mostrar datos del usuario
        lblUsername.setText("Nombre de usuario: " + usuario.getUsername());
        lblPuntos.setText("Puntos: " + usuario.getPuntos());
        lblPartidas.setText("Partidas con Héroes: " + usuario.getPartidasConHeroes()
                + " | Villanos: " + usuario.getPartidasConVillanos());

        StringBuilder texto = new StringBuilder();
        for (int i = registros.length - 1; i >= 0; i--) {
            RegistroPartidas r = registros[i];
            if (r.getJugador1().equals(usuario.getUsername()) || r.getJugador2().equals(usuario.getUsername())) {
                texto.append(r.ResetearLog(usuario.getUsername())).append("\n");
            }
        }
        areaLogs.setText(texto.toString());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblPartidas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaLogs = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setText("jLabel2");
        jPanel2.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 200, 40));
        jPanel2.add(lblPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 250, 60));

        lblPartidas.setText("jLabel4");
        jPanel2.add(lblPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 200, 100));

        areaLogs.setColumns(20);
        areaLogs.setRows(5);
        jScrollPane1.setViewportView(areaLogs);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 340, 470));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BackgroundMenuInicial.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 990, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaLogs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
