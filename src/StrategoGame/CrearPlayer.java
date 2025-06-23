
package StrategoGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class CrearPlayer extends javax.swing.JFrame {

    private static int CantidadMaxUsuario = 100;
    public static Usuario[] jugadores = new Usuario[CantidadMaxUsuario];
    public static int totalJugadores = 0;

    public CrearPlayer() {
        initComponents();

    }

    public CrearPlayer(MenuInicial menu) {
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

    private void registrarJugador() {
        String usuario = txtUsuario.getText().trim();
        String contra = new String(txtContra.getPassword()).trim();

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            txtUsuario.requestFocus();
            return;
        }

        if (UsuarioExistente(usuario)) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Intente otro.", "Error", JOptionPane.ERROR_MESSAGE);
            txtUsuario.requestFocus();
            return;
        }

        if (contra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
            txtContra.requestFocus();
            return;
        }

        if (contra.length() != 5) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener exactamente 5 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            txtContra.requestFocus();
            return;
        }

        if (totalJugadores >= CantidadMaxUsuario) {
            return;
        }

        Usuario nuevoJugador = new Usuario(usuario, contra);
        jugadores[totalJugadores] = nuevoJugador;
        totalJugadores++;

        JOptionPane.showMessageDialog(this, "Jugador creado con éxito.\nUsuario: " + usuario,
                "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

        new MenuInicial().setVisible(true);
        dispose();
    }

    private boolean UsuarioExistente(String nombre) {
        for (int i = 0; i < totalJugadores; i++) {
            if (jugadores[i].getUsername().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JToggleButton();
        btnCrearJugador = new javax.swing.JToggleButton();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        lblContraseña = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        BackgroundCrearPlayer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonCancelar.png"))); // NOI18N
        btnCancelar.setText("jToggleButton1");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 290, 100));

        btnCrearJugador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonCrearJugador.png"))); // NOI18N
        btnCrearJugador.setText("jToggleButton1");
        btnCrearJugador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearJugadorActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrearJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 290, 100));

        txtUsuario.setBackground(new java.awt.Color(153, 0, 0));
        txtUsuario.setFont(new java.awt.Font("Maiandra GD", 0, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 390, 70));

        txtContra.setBackground(new java.awt.Color(153, 0, 0));
        txtContra.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        txtContra.setForeground(new java.awt.Color(255, 255, 255));
        txtContra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel2.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 390, 70));

        lblContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/LblContra.png"))); // NOI18N
        jPanel2.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 290, 80));

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/LblUsuario.png"))); // NOI18N
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 280, 70));

        BackgroundCrearPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundCrearPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BackgroundCrearPlayer.png"))); // NOI18N
        BackgroundCrearPlayer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel2.add(BackgroundCrearPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 990, 700));

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new MenuInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCrearJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearJugadorActionPerformed
        registrarJugador();

    }//GEN-LAST:event_btnCrearJugadorActionPerformed

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
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundCrearPlayer;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnCrearJugador;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
