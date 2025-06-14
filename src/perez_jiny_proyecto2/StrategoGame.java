/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package perez_jiny_proyecto2;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class StrategoGame extends javax.swing.JFrame {

    private JButton[][] tablero = new JButton[10][10];
    boolean[][] zonaProhibida = new boolean[10][10];
     Random rand = new Random ();
      private Personajes[][] personajesTablero;

    public StrategoGame() {
        initComponents();
        tablero();
        zonasProhibidas();
        colocarPersonajesAleatoriamente();
        
    }

    private void tablero() {
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
            int fil = fila;
            int col = columna;
            
            JButton boton = new JButton();
            tablero [fila][col] = boton;
            jPanel2.add(boton);
            
            boton.setPreferredSize(new Dimension(60, 60));
            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setFocusPainted(false);
            
            boton.addActionListener(e -> {
            if (zonaProhibida[fil][col]) {
                return;
            }
            });
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
            tablero[fila][columna].setEnabled(false);
            zonaProhibida[fila][columna] = true;
        }

        for (int[] casilla : zonaMorada) {
            int fila = casilla[0];
            int columna = casilla[1];
            tablero[fila][columna].setEnabled(false);
            zonaProhibida[fila][columna] = true;

        }

    }

    private void colocarPersonajesAleatoriamente() {
    Personajes[] heroes = ListaPersonajes.Heroes();
    Personajes[] villanos = ListaPersonajes.Villanos();
    personajesTablero = new Personajes[10][10]; 

    int colocadosHeroes = 0;
    while (colocadosHeroes < heroes.length) {
        int fila = rand.nextInt(4); 
        int columna = rand.nextInt(10);

        if (!zonaProhibida[fila][columna] && personajesTablero[fila][columna] == null) {
            personajesTablero[fila][columna] = heroes[colocadosHeroes];
            tablero[fila][columna].setIcon(heroes[colocadosHeroes].getImagenOculta());
            colocadosHeroes++;
        }
    }

    int colocadosVillanos = 0;
    while (colocadosVillanos < villanos.length) {
        int fila = rand.nextInt(4) + 6; 
        int columna = rand.nextInt(10);

        if (!zonaProhibida[fila][columna] && personajesTablero[fila][columna] == null) {
            personajesTablero[fila][columna] = villanos[colocadosVillanos];
            tablero[fila][columna].setIcon(villanos[colocadosVillanos].getImagenOculta());
            colocadosVillanos++;
        }
    }
}
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(10, 10));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 860, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bc.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 860, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
