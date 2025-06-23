
package StrategoGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class LogIn extends javax.swing.JFrame {
    public static Usuario jugadorPrincipal;

    public LogIn(MenuInicial menuInicial) {
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

    public LogIn() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JToggleButton();
        btnIniciarSesion = new javax.swing.JToggleButton();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        lblContraseña = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        BackgroundIniciarSesion = new javax.swing.JLabel();

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

        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonIniciarSesion.png"))); // NOI18N
        btnIniciarSesion.setText("jToggleButton1");
        btnIniciarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel2.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 290, 100));

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

        BackgroundIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BackgroundIniciarSesion.png"))); // NOI18N
        BackgroundIniciarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel2.add(BackgroundIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1000, 700));

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

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        String usuario = txtUsuario.getText().trim();
        String contra = new String(txtContra.getPassword()).trim();

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            txtUsuario.requestFocus();
            return;
        }
        if (contra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
            txtContra.requestFocus();
            return;
        }

        Usuario jugador = validarIniciarSesion(usuario, contra);
        if (jugador != null) {
            LogIn.jugadorPrincipal= jugador;
            JOptionPane.showMessageDialog(this, "Bienvenido " + usuario + "!", "Login exitoso", JOptionPane.INFORMATION_MESSAGE);
            new MenuPrincipal(this).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            txtContra.setText("");
            txtUsuario.requestFocus();
            txtUsuario.selectAll();
        }
    }

    private Usuario validarIniciarSesion(String usuario, String contra) {
        for (int i = 0; i < CrearPlayer.totalJugadores; i++) {
            Usuario user = CrearPlayer.jugadores[i];
            if (user != null && user.getUsername().equalsIgnoreCase(usuario) && user.validarPassword(contra)) {
                return user;
            }
        }
        return null;
         
    }//GEN-LAST:event_btnIniciarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundIniciarSesion;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnIniciarSesion;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
