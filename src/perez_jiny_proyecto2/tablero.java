/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perez_jiny_proyecto2;
import javax.swing.*;
import java.awt.*;

public class tablero extends javax.swing.JFrame {
    
    private JButton[][]tablero=new JButton [10][10];
    
  
    public tablero() {
        initComponents();
        this.setTitle("Stratego");
        this.setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        for(int fila =0; fila<10; fila++){
            for(int columna=0; columna<10; columna++){
                JButton casilla=new JButton ();
                casilla.setBackground(Color.LIGHT_GRAY);
                tablero[fila][columna]=casilla;
                
                if ((fila>=4&&fila<=5)&&(columna>=2&&columna<=3||columna>=6&&columna<=7)){
                    casilla.setBackground(Color.YELLOW);
                    casilla.setEnabled(false);
                    
                    
                }
                 add(casilla);
            }
            
        }
  
        setVisible(true);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton83 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jButton88 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jButton92 = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jButton100 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(10, 10));

        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton2);

        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton4);

        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton5);

        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton6);

        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton7);

        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton8);

        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton9);

        jButton10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton10);

        jButton11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton11);

        jButton12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton12);

        jButton13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton13);

        jButton14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton14);

        jButton15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton15);

        jButton16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton16);

        jButton17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton17);

        jButton18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton18);

        jButton19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton19);

        jButton20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton20);

        jButton21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton21);

        jButton22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton22);

        jButton23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton23);

        jButton24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton24);

        jButton25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton25);

        jButton26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton26);

        jButton27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton27);

        jButton28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton28);

        jButton29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton29);

        jButton30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton30);

        jButton31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton31);

        jButton32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton32);

        jButton33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton33);

        jButton34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton34);

        jButton35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton35);

        jButton36.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton36);

        jButton37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton37);

        jButton38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton38);

        jButton39.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton39);

        jButton40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton40);

        jButton41.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton41);

        jButton42.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton42);

        jButton43.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton43);

        jButton44.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton44);

        jButton45.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton45);

        jButton46.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton46);

        jButton47.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton47);

        jButton48.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton48);

        jButton49.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton49);

        jButton50.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton50);

        jButton51.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton51);

        jButton52.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton52);

        jButton53.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton53);

        jButton54.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton54);

        jButton55.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton55);

        jButton56.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton56);

        jButton63.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton63);

        jButton57.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton57);

        jButton58.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton58);

        jButton59.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton59);

        jButton60.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton60);

        jButton61.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton61);

        jButton62.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton62);

        jButton64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton64);

        jButton65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton65);

        jButton66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton66);

        jButton67.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton67);

        jButton68.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton68);

        jButton69.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton69);

        jButton70.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton70);

        jButton71.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton71);

        jButton72.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton72);

        jButton73.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton73);

        jButton74.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton74);

        jButton75.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton75);

        jButton76.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton76);

        jButton77.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton77);

        jButton78.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton78);

        jButton79.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton79);

        jButton80.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton80);

        jButton81.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton81);

        jButton82.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton82);

        jButton83.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton83);

        jButton84.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton84);

        jButton85.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton85);

        jButton86.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton86);

        jButton87.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton87);

        jButton88.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton88);

        jButton89.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton89);

        jButton90.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton90);

        jButton91.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton91);

        jButton92.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton92);

        jButton93.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton93);

        jButton94.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton94);

        jButton95.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton95);

        jButton96.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton96);

        jButton97.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton97);

        jButton98.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton98);

        jButton99.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton99);

        jButton100.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jButton100);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton10;
    public javax.swing.JButton jButton100;
    public javax.swing.JButton jButton11;
    public javax.swing.JButton jButton12;
    public javax.swing.JButton jButton13;
    public javax.swing.JButton jButton14;
    public javax.swing.JButton jButton15;
    public javax.swing.JButton jButton16;
    public javax.swing.JButton jButton17;
    public javax.swing.JButton jButton18;
    public javax.swing.JButton jButton19;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton20;
    public javax.swing.JButton jButton21;
    public javax.swing.JButton jButton22;
    public javax.swing.JButton jButton23;
    public javax.swing.JButton jButton24;
    public javax.swing.JButton jButton25;
    public javax.swing.JButton jButton26;
    public javax.swing.JButton jButton27;
    public javax.swing.JButton jButton28;
    public javax.swing.JButton jButton29;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton30;
    public javax.swing.JButton jButton31;
    public javax.swing.JButton jButton32;
    public javax.swing.JButton jButton33;
    public javax.swing.JButton jButton34;
    public javax.swing.JButton jButton35;
    public javax.swing.JButton jButton36;
    public javax.swing.JButton jButton37;
    public javax.swing.JButton jButton38;
    public javax.swing.JButton jButton39;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton40;
    public javax.swing.JButton jButton41;
    public javax.swing.JButton jButton42;
    public javax.swing.JButton jButton43;
    public javax.swing.JButton jButton44;
    public javax.swing.JButton jButton45;
    public javax.swing.JButton jButton46;
    public javax.swing.JButton jButton47;
    public javax.swing.JButton jButton48;
    public javax.swing.JButton jButton49;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton50;
    public javax.swing.JButton jButton51;
    public javax.swing.JButton jButton52;
    public javax.swing.JButton jButton53;
    public javax.swing.JButton jButton54;
    public javax.swing.JButton jButton55;
    public javax.swing.JButton jButton56;
    public javax.swing.JButton jButton57;
    public javax.swing.JButton jButton58;
    public javax.swing.JButton jButton59;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton60;
    public javax.swing.JButton jButton61;
    public javax.swing.JButton jButton62;
    public javax.swing.JButton jButton63;
    public javax.swing.JButton jButton64;
    public javax.swing.JButton jButton65;
    public javax.swing.JButton jButton66;
    public javax.swing.JButton jButton67;
    public javax.swing.JButton jButton68;
    public javax.swing.JButton jButton69;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton70;
    public javax.swing.JButton jButton71;
    public javax.swing.JButton jButton72;
    public javax.swing.JButton jButton73;
    public javax.swing.JButton jButton74;
    public javax.swing.JButton jButton75;
    public javax.swing.JButton jButton76;
    public javax.swing.JButton jButton77;
    public javax.swing.JButton jButton78;
    public javax.swing.JButton jButton79;
    public javax.swing.JButton jButton8;
    public javax.swing.JButton jButton80;
    public javax.swing.JButton jButton81;
    public javax.swing.JButton jButton82;
    public javax.swing.JButton jButton83;
    public javax.swing.JButton jButton84;
    public javax.swing.JButton jButton85;
    public javax.swing.JButton jButton86;
    public javax.swing.JButton jButton87;
    public javax.swing.JButton jButton88;
    public javax.swing.JButton jButton89;
    public javax.swing.JButton jButton9;
    public javax.swing.JButton jButton90;
    public javax.swing.JButton jButton91;
    public javax.swing.JButton jButton92;
    public javax.swing.JButton jButton93;
    public javax.swing.JButton jButton94;
    public javax.swing.JButton jButton95;
    public javax.swing.JButton jButton96;
    public javax.swing.JButton jButton97;
    public javax.swing.JButton jButton98;
    public javax.swing.JButton jButton99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
