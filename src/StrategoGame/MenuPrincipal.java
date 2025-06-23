package StrategoGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal(LogIn logIn) {
        initComponents();
        setSize(970, 730);

        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                new MenuInicial().setVisible(true);
            }
        });

    }

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnUniversoMarvel = new javax.swing.JToggleButton();
        btnCerrarSesion = new javax.swing.JToggleButton();
        btnStratego = new javax.swing.JToggleButton();
        btnMiPerfil = new javax.swing.JToggleButton();
        BackgroundMenuPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUniversoMarvel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotnUniversoMarvel.png"))); // NOI18N
        btnUniversoMarvel.setText("jToggleButton1");
        btnUniversoMarvel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnUniversoMarvel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUniversoMarvelActionPerformed(evt);
            }
        });
        jPanel2.add(btnUniversoMarvel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 330, 130));
        btnUniversoMarvel.getAccessibleContext().setAccessibleName("");

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonCerrarSesion.png"))); // NOI18N
        btnCerrarSesion.setText("jToggleButton1");
        btnCerrarSesion.setActionCommand("");
        btnCerrarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 610, 230, 70));

        btnStratego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonStratego.png"))); // NOI18N
        btnStratego.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnStratego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStrategoActionPerformed(evt);
            }
        });
        jPanel2.add(btnStratego, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 330, 130));

        btnMiPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonPerfil.png"))); // NOI18N
        btnMiPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnMiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiPerfilActionPerformed(evt);
            }
        });
        jPanel2.add(btnMiPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 330, 130));

        BackgroundMenuPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BackgroungMenuPrincipal.png"))); // NOI18N
        BackgroundMenuPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel2.add(BackgroundMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUniversoMarvelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUniversoMarvelActionPerformed

    }//GEN-LAST:event_btnUniversoMarvelActionPerformed

    private void btnStrategoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStrategoActionPerformed
        if (CrearPlayer.totalJugadores <= 1) {
            JOptionPane.showMessageDialog(this, "Debe de existir dos jugadores registrados para jugar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int jugadoresDisponibles = 0;
        for (int i = 0; i < CrearPlayer.totalJugadores; i++) {
            Usuario u = CrearPlayer.jugadores[i];
            if (u != null && !u.getUsername().equalsIgnoreCase(LogIn.jugadorPrincipal.getUsername())) {
                jugadoresDisponibles++;
            }
        }
        if (jugadoresDisponibles == 0) {
            JOptionPane.showMessageDialog(this, "No hay jugadores disponibles diferentes al usuario actual.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] opciones = new String[jugadoresDisponibles];
        int posicionJugadores = 0;
        for (int i = 0; i < CrearPlayer.totalJugadores; i++) {
            Usuario u = CrearPlayer.jugadores[i];
            if (u != null && !u.getUsername().equalsIgnoreCase(LogIn.jugadorPrincipal.getUsername())) {
                opciones[posicionJugadores++] = u.getUsername();
            }
        }
        String jugadorElegido = (String) JOptionPane.showInputDialog(this, "Seleccione su contrincante:", "Elegir jugador", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (jugadorElegido == null) {
            return;
        }
        Usuario oponente = null;
        for (int i = 0; i < CrearPlayer.totalJugadores; i++) {
            Usuario u = CrearPlayer.jugadores[i];
            if (u != null && u.getUsername().equalsIgnoreCase(jugadorElegido)) {
                oponente = u;
                break;
            }
        }
        String[] bandos = {"Héroes", "Villanos"};
        String bandoElegido = (String) JOptionPane.showInputDialog(this, "Seleccione su bando:", "Elegir bando", JOptionPane.PLAIN_MESSAGE, null, bandos, bandos[0]);
        if (bandoElegido == null) {
            return;
        }
        String bandoOponente = bandoElegido.equals("Héroes") ? "Villanos" : "Héroes";
        JOptionPane.showMessageDialog(this,
                "Iniciando partida:\n"
                + LogIn.jugadorPrincipal.getUsername() + " (" + bandoElegido + ") vs "
                + oponente.getUsername() + " (" + bandoOponente + ")");

        // Aquí pasamos los nombres reales a StrategoGame:
        String jugador1 = LogIn.jugadorPrincipal.getUsername();
        String jugador2 = oponente.getUsername();

        StrategoGame juego = new StrategoGame(jugador1, jugador2);
        juego.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnStrategoActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        new MenuInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnMiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiPerfilActionPerformed
        new MiPerfil().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMiPerfilActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundMenuPrincipal;
    private javax.swing.JToggleButton btnCerrarSesion;
    private javax.swing.JToggleButton btnMiPerfil;
    private javax.swing.JToggleButton btnStratego;
    private javax.swing.JToggleButton btnUniversoMarvel;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
