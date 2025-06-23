package StrategoGame;

import javax.swing.JFrame;

public class MiPerfil extends javax.swing.JFrame {

    private Usuario usuario;
    private RegistroPartidas[] registros;

    public MiPerfil() {
        initComponents();
        this.usuario = usuario;
        this.registros = registros;
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                new MenuPrincipal().setVisible(true);
                dispose();

            }
        });
    }

    public MiPerfil(MenuPrincipal MenuPrinicipal) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnElminarCuenta = new javax.swing.JToggleButton();
        BotonLog = new javax.swing.JToggleButton();
        btnCambiarPassword = new javax.swing.JToggleButton();
        BackgroundMiPerfil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnElminarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonEliminarCuenta.png"))); // NOI18N
        btnElminarCuenta.setText("jToggleButton1");
        btnElminarCuenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnElminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElminarCuentaActionPerformed(evt);
            }
        });
        jPanel2.add(btnElminarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 330, 130));

        BotonLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonLog.png"))); // NOI18N
        BotonLog.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLogActionPerformed(evt);
            }
        });
        jPanel2.add(BotonLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 330, 130));

        btnCambiarPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonPassword.png"))); // NOI18N
        btnCambiarPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(btnCambiarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 330, 130));

        BackgroundMiPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundMiPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BackgroundMiPerfil.png"))); // NOI18N
        BackgroundMiPerfil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel2.add(BackgroundMiPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 700));

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

    private void btnElminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElminarCuentaActionPerformed

    }//GEN-LAST:event_btnElminarCuentaActionPerformed

    private void BotonLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLogActionPerformed
        Log VentanaLog = new Log(usuario, registros);
        VentanaLog.setVisible(true);
    }//GEN-LAST:event_BotonLogActionPerformed

    private void btnCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPasswordActionPerformed

    }//GEN-LAST:event_btnCambiarPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundMiPerfil;
    private javax.swing.JToggleButton BotonLog;
    private javax.swing.JToggleButton btnCambiarPassword;
    private javax.swing.JToggleButton btnElminarCuenta;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
