package StrategoGame;

import javax.swing.*;
import java.awt.*;

public class MenuInicial extends javax.swing.JFrame {

    public MenuInicial() {
        initComponents();
        
        setSize(970, 730);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JButton();
        BtnCrearPlayer = new javax.swing.JButton();
        BtnLogIn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonSalir.png"))); // NOI18N
        BtnSalir.setText("jButton1");
        BtnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnSalir.setSelected(true);
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, 290, 100));

        BtnCrearPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonCrearPlayer.png"))); // NOI18N
        BtnCrearPlayer.setText("jButton1");
        BtnCrearPlayer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnCrearPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearPlayerActionPerformed(evt);
            }
        });
        jPanel2.add(BtnCrearPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 290, 100));

        BtnLogIn.setBackground(java.awt.SystemColor.activeCaptionBorder);
        BtnLogIn.setForeground(new java.awt.Color(204, 255, 255));
        BtnLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonLogIn.png"))); // NOI18N
        BtnLogIn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogInActionPerformed(evt);
            }
        });
        jPanel2.add(BtnLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 290, 100));

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

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogInActionPerformed
        new LogIn(this).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnLogInActionPerformed

    private void BtnCrearPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearPlayerActionPerformed
        new CrearPlayer(this).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCrearPlayerActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrearPlayer;
    private javax.swing.JButton BtnLogIn;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
