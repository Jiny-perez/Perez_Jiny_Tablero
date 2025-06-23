/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package StrategoGame;


public class MiPerfil extends javax.swing.JFrame {

    public MiPerfil() {
        initComponents();
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

        BotonLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/146 sin título_20250623072401.png"))); // NOI18N
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
     
    }//GEN-LAST:event_BotonLogActionPerformed

    private void btnCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPasswordActionPerformed
    
    }//GEN-LAST:event_btnCambiarPasswordActionPerformed


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
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundMiPerfil;
    private javax.swing.JToggleButton BotonLog;
    private javax.swing.JToggleButton btnCambiarPassword;
    private javax.swing.JToggleButton btnElminarCuenta;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
