/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perez_jiny_proyecto2;

import javax.swing.*;
import java.awt.*;

public class StrategoGame extends javax.swing.JFrame {

    private JButton[][] botones = new JButton[10][10];
    boolean[][] zonaProhibida = new boolean[10][10];

    public StrategoGame() {
        initComponents();
        inicializarBotones();
        zonasProhibidas();
        Listeners();
    }

    private void inicializarBotones() {
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                try {
                    String nombre = "boton" + fila + col;
                    java.lang.reflect.Field campo = getClass().getDeclaredField(nombre);
                    campo.setAccessible(true);
                    botones[fila][col] = (JButton) campo.get(this);
                    botones[fila][col].setOpaque(false);
                    botones[fila][col].setContentAreaFilled(false);
                    botones[fila][col].setFocusPainted(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void zonasProhibidas() {
        int[][] zonaAmarilla = {
            {4, 2}, {4, 3}, {5, 2}, {5, 3}
        };
        int[][] zonaMorada = {
            {4, 6}, {4, 7}, {5, 6}, {5, 7}
        };

        for (int[] casilla : zonaAmarilla) {
            int fila = casilla[0];
            int columna = casilla[1];
            botones[fila][columna].setEnabled(false);
            zonaProhibida[fila][columna] = true;
        }

        for (int[] casilla : zonaMorada) {
            int fila = casilla[0];
            int columna = casilla[1];
            botones[fila][columna].setEnabled(false);
            zonaProhibida[fila][columna] = true;

        }

    }

    private void Listeners() {
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                int f = fila;
                int c = columna;
                botones[f][c].addActionListener(e -> {
                    Color color = botones[f][c].getBackground();
                    if (zonaProhibida[f][c]) {
                        return;
                    }

                });
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        boton00 = new javax.swing.JButton();
        boton01 = new javax.swing.JButton();
        boton02 = new javax.swing.JButton();
        boton03 = new javax.swing.JButton();
        boton04 = new javax.swing.JButton();
        boton05 = new javax.swing.JButton();
        boton06 = new javax.swing.JButton();
        boton07 = new javax.swing.JButton();
        boton08 = new javax.swing.JButton();
        boton09 = new javax.swing.JButton();
        boton10 = new javax.swing.JButton();
        boton11 = new javax.swing.JButton();
        boton12 = new javax.swing.JButton();
        boton13 = new javax.swing.JButton();
        boton14 = new javax.swing.JButton();
        boton15 = new javax.swing.JButton();
        boton16 = new javax.swing.JButton();
        boton17 = new javax.swing.JButton();
        boton18 = new javax.swing.JButton();
        boton19 = new javax.swing.JButton();
        boton20 = new javax.swing.JButton();
        boton21 = new javax.swing.JButton();
        boton22 = new javax.swing.JButton();
        boton23 = new javax.swing.JButton();
        boton24 = new javax.swing.JButton();
        boton25 = new javax.swing.JButton();
        boton26 = new javax.swing.JButton();
        boton27 = new javax.swing.JButton();
        boton28 = new javax.swing.JButton();
        boton29 = new javax.swing.JButton();
        boton30 = new javax.swing.JButton();
        boton31 = new javax.swing.JButton();
        boton32 = new javax.swing.JButton();
        boton33 = new javax.swing.JButton();
        boton34 = new javax.swing.JButton();
        boton35 = new javax.swing.JButton();
        boton36 = new javax.swing.JButton();
        boton37 = new javax.swing.JButton();
        boton38 = new javax.swing.JButton();
        boton39 = new javax.swing.JButton();
        boton40 = new javax.swing.JButton();
        boton41 = new javax.swing.JButton();
        boton42 = new javax.swing.JButton();
        boton43 = new javax.swing.JButton();
        boton44 = new javax.swing.JButton();
        boton45 = new javax.swing.JButton();
        boton46 = new javax.swing.JButton();
        boton47 = new javax.swing.JButton();
        boton48 = new javax.swing.JButton();
        boton49 = new javax.swing.JButton();
        boton50 = new javax.swing.JButton();
        boton51 = new javax.swing.JButton();
        boton52 = new javax.swing.JButton();
        boton53 = new javax.swing.JButton();
        boton54 = new javax.swing.JButton();
        boton55 = new javax.swing.JButton();
        boton56 = new javax.swing.JButton();
        boton57 = new javax.swing.JButton();
        boton58 = new javax.swing.JButton();
        boton59 = new javax.swing.JButton();
        boton60 = new javax.swing.JButton();
        boton61 = new javax.swing.JButton();
        boton62 = new javax.swing.JButton();
        boton63 = new javax.swing.JButton();
        boton64 = new javax.swing.JButton();
        boton65 = new javax.swing.JButton();
        boton66 = new javax.swing.JButton();
        boton67 = new javax.swing.JButton();
        boton68 = new javax.swing.JButton();
        boton69 = new javax.swing.JButton();
        boton70 = new javax.swing.JButton();
        boton71 = new javax.swing.JButton();
        boton72 = new javax.swing.JButton();
        boton73 = new javax.swing.JButton();
        boton74 = new javax.swing.JButton();
        boton75 = new javax.swing.JButton();
        boton76 = new javax.swing.JButton();
        boton77 = new javax.swing.JButton();
        boton78 = new javax.swing.JButton();
        boton79 = new javax.swing.JButton();
        boton80 = new javax.swing.JButton();
        boton81 = new javax.swing.JButton();
        boton82 = new javax.swing.JButton();
        boton83 = new javax.swing.JButton();
        boton84 = new javax.swing.JButton();
        boton85 = new javax.swing.JButton();
        boton86 = new javax.swing.JButton();
        boton87 = new javax.swing.JButton();
        boton88 = new javax.swing.JButton();
        boton89 = new javax.swing.JButton();
        boton90 = new javax.swing.JButton();
        boton91 = new javax.swing.JButton();
        boton92 = new javax.swing.JButton();
        boton93 = new javax.swing.JButton();
        boton94 = new javax.swing.JButton();
        boton95 = new javax.swing.JButton();
        boton96 = new javax.swing.JButton();
        boton97 = new javax.swing.JButton();
        boton98 = new javax.swing.JButton();
        boton99 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(10, 10));

        boton00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton00ActionPerformed(evt);
            }
        });
        jPanel2.add(boton00);

        boton01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton01ActionPerformed(evt);
            }
        });
        jPanel2.add(boton01);
        jPanel2.add(boton02);
        jPanel2.add(boton03);
        jPanel2.add(boton04);
        jPanel2.add(boton05);
        jPanel2.add(boton06);
        jPanel2.add(boton07);
        jPanel2.add(boton08);
        jPanel2.add(boton09);
        jPanel2.add(boton10);
        jPanel2.add(boton11);
        jPanel2.add(boton12);
        jPanel2.add(boton13);
        jPanel2.add(boton14);
        jPanel2.add(boton15);
        jPanel2.add(boton16);
        jPanel2.add(boton17);
        jPanel2.add(boton18);
        jPanel2.add(boton19);
        jPanel2.add(boton20);
        jPanel2.add(boton21);
        jPanel2.add(boton22);
        jPanel2.add(boton23);
        jPanel2.add(boton24);
        jPanel2.add(boton25);
        jPanel2.add(boton26);
        jPanel2.add(boton27);
        jPanel2.add(boton28);
        jPanel2.add(boton29);
        jPanel2.add(boton30);
        jPanel2.add(boton31);
        jPanel2.add(boton32);
        jPanel2.add(boton33);
        jPanel2.add(boton34);
        jPanel2.add(boton35);
        jPanel2.add(boton36);
        jPanel2.add(boton37);
        jPanel2.add(boton38);
        jPanel2.add(boton39);
        jPanel2.add(boton40);
        jPanel2.add(boton41);
        jPanel2.add(boton42);
        jPanel2.add(boton43);
        jPanel2.add(boton44);
        jPanel2.add(boton45);
        jPanel2.add(boton46);
        jPanel2.add(boton47);
        jPanel2.add(boton48);
        jPanel2.add(boton49);
        jPanel2.add(boton50);
        jPanel2.add(boton51);
        jPanel2.add(boton52);
        jPanel2.add(boton53);
        jPanel2.add(boton54);
        jPanel2.add(boton55);
        jPanel2.add(boton56);
        jPanel2.add(boton57);
        jPanel2.add(boton58);
        jPanel2.add(boton59);
        jPanel2.add(boton60);
        jPanel2.add(boton61);
        jPanel2.add(boton62);
        jPanel2.add(boton63);
        jPanel2.add(boton64);
        jPanel2.add(boton65);
        jPanel2.add(boton66);
        jPanel2.add(boton67);
        jPanel2.add(boton68);
        jPanel2.add(boton69);
        jPanel2.add(boton70);
        jPanel2.add(boton71);
        jPanel2.add(boton72);
        jPanel2.add(boton73);
        jPanel2.add(boton74);
        jPanel2.add(boton75);
        jPanel2.add(boton76);
        jPanel2.add(boton77);
        jPanel2.add(boton78);
        jPanel2.add(boton79);
        jPanel2.add(boton80);
        jPanel2.add(boton81);
        jPanel2.add(boton82);
        jPanel2.add(boton83);
        jPanel2.add(boton84);
        jPanel2.add(boton85);
        jPanel2.add(boton86);
        jPanel2.add(boton87);
        jPanel2.add(boton88);
        jPanel2.add(boton89);
        jPanel2.add(boton90);
        jPanel2.add(boton91);
        jPanel2.add(boton92);
        jPanel2.add(boton93);
        jPanel2.add(boton94);
        jPanel2.add(boton95);
        jPanel2.add(boton96);
        jPanel2.add(boton97);
        jPanel2.add(boton98);
        jPanel2.add(boton99);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 860, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/113 sin título_20250609102714.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 860, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton00ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton00ActionPerformed

    private void boton01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton01ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StrategoGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton00;
    private javax.swing.JButton boton01;
    private javax.swing.JButton boton02;
    private javax.swing.JButton boton03;
    private javax.swing.JButton boton04;
    private javax.swing.JButton boton05;
    private javax.swing.JButton boton06;
    private javax.swing.JButton boton07;
    private javax.swing.JButton boton08;
    private javax.swing.JButton boton09;
    private javax.swing.JButton boton10;
    private javax.swing.JButton boton11;
    private javax.swing.JButton boton12;
    private javax.swing.JButton boton13;
    private javax.swing.JButton boton14;
    private javax.swing.JButton boton15;
    private javax.swing.JButton boton16;
    private javax.swing.JButton boton17;
    private javax.swing.JButton boton18;
    private javax.swing.JButton boton19;
    private javax.swing.JButton boton20;
    private javax.swing.JButton boton21;
    private javax.swing.JButton boton22;
    private javax.swing.JButton boton23;
    private javax.swing.JButton boton24;
    private javax.swing.JButton boton25;
    private javax.swing.JButton boton26;
    private javax.swing.JButton boton27;
    private javax.swing.JButton boton28;
    private javax.swing.JButton boton29;
    private javax.swing.JButton boton30;
    private javax.swing.JButton boton31;
    private javax.swing.JButton boton32;
    private javax.swing.JButton boton33;
    private javax.swing.JButton boton34;
    private javax.swing.JButton boton35;
    private javax.swing.JButton boton36;
    private javax.swing.JButton boton37;
    private javax.swing.JButton boton38;
    private javax.swing.JButton boton39;
    private javax.swing.JButton boton40;
    private javax.swing.JButton boton41;
    private javax.swing.JButton boton42;
    private javax.swing.JButton boton43;
    private javax.swing.JButton boton44;
    private javax.swing.JButton boton45;
    private javax.swing.JButton boton46;
    private javax.swing.JButton boton47;
    private javax.swing.JButton boton48;
    private javax.swing.JButton boton49;
    private javax.swing.JButton boton50;
    private javax.swing.JButton boton51;
    private javax.swing.JButton boton52;
    private javax.swing.JButton boton53;
    private javax.swing.JButton boton54;
    private javax.swing.JButton boton55;
    private javax.swing.JButton boton56;
    private javax.swing.JButton boton57;
    private javax.swing.JButton boton58;
    private javax.swing.JButton boton59;
    private javax.swing.JButton boton60;
    private javax.swing.JButton boton61;
    private javax.swing.JButton boton62;
    private javax.swing.JButton boton63;
    private javax.swing.JButton boton64;
    private javax.swing.JButton boton65;
    private javax.swing.JButton boton66;
    private javax.swing.JButton boton67;
    private javax.swing.JButton boton68;
    private javax.swing.JButton boton69;
    private javax.swing.JButton boton70;
    private javax.swing.JButton boton71;
    private javax.swing.JButton boton72;
    private javax.swing.JButton boton73;
    private javax.swing.JButton boton74;
    private javax.swing.JButton boton75;
    private javax.swing.JButton boton76;
    private javax.swing.JButton boton77;
    private javax.swing.JButton boton78;
    private javax.swing.JButton boton79;
    private javax.swing.JButton boton80;
    private javax.swing.JButton boton81;
    private javax.swing.JButton boton82;
    private javax.swing.JButton boton83;
    private javax.swing.JButton boton84;
    private javax.swing.JButton boton85;
    private javax.swing.JButton boton86;
    private javax.swing.JButton boton87;
    private javax.swing.JButton boton88;
    private javax.swing.JButton boton89;
    private javax.swing.JButton boton90;
    private javax.swing.JButton boton91;
    private javax.swing.JButton boton92;
    private javax.swing.JButton boton93;
    private javax.swing.JButton boton94;
    private javax.swing.JButton boton95;
    private javax.swing.JButton boton96;
    private javax.swing.JButton boton97;
    private javax.swing.JButton boton98;
    private javax.swing.JButton boton99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
