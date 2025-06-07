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

        panelTablero = new javax.swing.JPanel();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTablero.setLayout(new java.awt.GridLayout(10, 10));

        boton00.setToolTipText("");
        boton00.setAutoscrolls(true);
        boton00.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        boton00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton00ActionPerformed(evt);
            }
        });
        panelTablero.add(boton00);

        boton01.setToolTipText("");
        boton01.setAutoscrolls(true);
        boton01.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton01);

        boton02.setToolTipText("");
        boton02.setAutoscrolls(true);
        boton02.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        boton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton02ActionPerformed(evt);
            }
        });
        panelTablero.add(boton02);

        boton03.setToolTipText("");
        boton03.setAutoscrolls(true);
        boton03.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton03);

        boton04.setToolTipText("");
        boton04.setAutoscrolls(true);
        boton04.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton04);

        boton05.setToolTipText("");
        boton05.setAutoscrolls(true);
        boton05.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton05);

        boton06.setToolTipText("");
        boton06.setAutoscrolls(true);
        boton06.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton06);

        boton07.setToolTipText("");
        boton07.setAutoscrolls(true);
        boton07.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton07);

        boton08.setToolTipText("");
        boton08.setAutoscrolls(true);
        boton08.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton08);

        boton09.setToolTipText("");
        boton09.setAutoscrolls(true);
        boton09.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton09);

        boton10.setToolTipText("");
        boton10.setAutoscrolls(true);
        boton10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton10);

        boton11.setToolTipText("");
        boton11.setAutoscrolls(true);
        boton11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton11);

        boton12.setToolTipText("");
        boton12.setAutoscrolls(true);
        boton12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton12);

        boton13.setToolTipText("");
        boton13.setAutoscrolls(true);
        boton13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton13);

        boton14.setToolTipText("");
        boton14.setAutoscrolls(true);
        boton14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton14);

        boton15.setToolTipText("");
        boton15.setAutoscrolls(true);
        boton15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton15);

        boton16.setToolTipText("");
        boton16.setAutoscrolls(true);
        boton16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton16);

        boton17.setToolTipText("");
        boton17.setAutoscrolls(true);
        boton17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton17);

        boton18.setToolTipText("");
        boton18.setAutoscrolls(true);
        boton18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton18);

        boton19.setToolTipText("");
        boton19.setAutoscrolls(true);
        boton19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton19);

        boton20.setToolTipText("");
        boton20.setAutoscrolls(true);
        boton20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton20);

        boton21.setToolTipText("");
        boton21.setAutoscrolls(true);
        boton21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton21);

        boton22.setToolTipText("");
        boton22.setAutoscrolls(true);
        boton22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton22);

        boton23.setToolTipText("");
        boton23.setAutoscrolls(true);
        boton23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton23);

        boton24.setToolTipText("");
        boton24.setAutoscrolls(true);
        boton24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton24);

        boton25.setToolTipText("");
        boton25.setAutoscrolls(true);
        boton25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton25);

        boton26.setToolTipText("");
        boton26.setAutoscrolls(true);
        boton26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton26);

        boton27.setToolTipText("");
        boton27.setAutoscrolls(true);
        boton27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton27);

        boton28.setToolTipText("");
        boton28.setAutoscrolls(true);
        boton28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton28);

        boton29.setToolTipText("");
        boton29.setAutoscrolls(true);
        boton29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton29);

        boton30.setToolTipText("");
        boton30.setAutoscrolls(true);
        boton30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton30);

        boton31.setToolTipText("");
        boton31.setAutoscrolls(true);
        boton31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton31);

        boton32.setToolTipText("");
        boton32.setAutoscrolls(true);
        boton32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton32);

        boton33.setToolTipText("");
        boton33.setAutoscrolls(true);
        boton33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton33);

        boton34.setToolTipText("");
        boton34.setAutoscrolls(true);
        boton34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton34);

        boton35.setToolTipText("");
        boton35.setAutoscrolls(true);
        boton35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton35);

        boton36.setToolTipText("");
        boton36.setAutoscrolls(true);
        boton36.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton36);

        boton37.setToolTipText("");
        boton37.setAutoscrolls(true);
        boton37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton37);

        boton38.setToolTipText("");
        boton38.setAutoscrolls(true);
        boton38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton38);

        boton39.setToolTipText("");
        boton39.setAutoscrolls(true);
        boton39.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton39);

        boton40.setToolTipText("");
        boton40.setAutoscrolls(true);
        boton40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton40);

        boton41.setToolTipText("");
        boton41.setAutoscrolls(true);
        boton41.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton41);

        boton42.setToolTipText("");
        boton42.setAutoscrolls(true);
        boton42.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton42);

        boton43.setToolTipText("");
        boton43.setAutoscrolls(true);
        boton43.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton43);

        boton44.setToolTipText("");
        boton44.setAutoscrolls(true);
        boton44.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton44);

        boton45.setToolTipText("");
        boton45.setAutoscrolls(true);
        boton45.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton45);

        boton46.setToolTipText("");
        boton46.setAutoscrolls(true);
        boton46.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton46);

        boton47.setToolTipText("");
        boton47.setAutoscrolls(true);
        boton47.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton47);

        boton48.setToolTipText("");
        boton48.setAutoscrolls(true);
        boton48.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton48);

        boton49.setToolTipText("");
        boton49.setAutoscrolls(true);
        boton49.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton49);

        boton50.setToolTipText("");
        boton50.setAutoscrolls(true);
        boton50.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton50);

        boton51.setToolTipText("");
        boton51.setAutoscrolls(true);
        boton51.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton51);

        boton52.setToolTipText("");
        boton52.setAutoscrolls(true);
        boton52.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton52);

        boton53.setToolTipText("");
        boton53.setAutoscrolls(true);
        boton53.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton53);

        boton54.setToolTipText("");
        boton54.setAutoscrolls(true);
        boton54.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton54);

        boton55.setToolTipText("");
        boton55.setAutoscrolls(true);
        boton55.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton55);

        boton56.setToolTipText("");
        boton56.setAutoscrolls(true);
        boton56.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton56);

        boton57.setToolTipText("");
        boton57.setAutoscrolls(true);
        boton57.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton57);

        boton58.setToolTipText("");
        boton58.setAutoscrolls(true);
        boton58.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton58);

        boton59.setToolTipText("");
        boton59.setAutoscrolls(true);
        boton59.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton59);

        boton60.setToolTipText("");
        boton60.setAutoscrolls(true);
        boton60.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton60);

        boton61.setToolTipText("");
        boton61.setAutoscrolls(true);
        boton61.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton61);

        boton62.setToolTipText("");
        boton62.setAutoscrolls(true);
        boton62.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton62);

        boton63.setToolTipText("");
        boton63.setAutoscrolls(true);
        boton63.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton63);

        boton64.setToolTipText("");
        boton64.setAutoscrolls(true);
        boton64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton64);

        boton65.setToolTipText("");
        boton65.setAutoscrolls(true);
        boton65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton65);

        boton66.setToolTipText("");
        boton66.setAutoscrolls(true);
        boton66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton66);

        boton67.setToolTipText("");
        boton67.setAutoscrolls(true);
        boton67.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton67);

        boton68.setToolTipText("");
        boton68.setAutoscrolls(true);
        boton68.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton68);

        boton69.setToolTipText("");
        boton69.setAutoscrolls(true);
        boton69.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton69);

        boton70.setToolTipText("");
        boton70.setAutoscrolls(true);
        boton70.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton70);

        boton71.setToolTipText("");
        boton71.setAutoscrolls(true);
        boton71.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton71);

        boton72.setToolTipText("");
        boton72.setAutoscrolls(true);
        boton72.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton72);

        boton73.setToolTipText("");
        boton73.setAutoscrolls(true);
        boton73.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton73);

        boton74.setToolTipText("");
        boton74.setAutoscrolls(true);
        boton74.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton74);

        boton75.setToolTipText("");
        boton75.setAutoscrolls(true);
        boton75.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton75);

        boton76.setToolTipText("");
        boton76.setAutoscrolls(true);
        boton76.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton76);

        boton77.setToolTipText("");
        boton77.setAutoscrolls(true);
        boton77.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton77);

        boton78.setToolTipText("");
        boton78.setAutoscrolls(true);
        boton78.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton78);

        boton79.setToolTipText("");
        boton79.setAutoscrolls(true);
        boton79.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton79);

        boton80.setToolTipText("");
        boton80.setAutoscrolls(true);
        boton80.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton80);

        boton81.setToolTipText("");
        boton81.setAutoscrolls(true);
        boton81.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton81);

        boton82.setToolTipText("");
        boton82.setAutoscrolls(true);
        boton82.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton82);

        boton83.setToolTipText("");
        boton83.setAutoscrolls(true);
        boton83.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton83);

        boton84.setToolTipText("");
        boton84.setAutoscrolls(true);
        boton84.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton84);

        boton85.setToolTipText("");
        boton85.setAutoscrolls(true);
        boton85.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton85);

        boton86.setToolTipText("");
        boton86.setAutoscrolls(true);
        boton86.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton86);

        boton87.setToolTipText("");
        boton87.setAutoscrolls(true);
        boton87.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton87);

        boton88.setToolTipText("");
        boton88.setAutoscrolls(true);
        boton88.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton88);

        boton89.setToolTipText("");
        boton89.setAutoscrolls(true);
        boton89.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton89);

        boton90.setToolTipText("");
        boton90.setAutoscrolls(true);
        boton90.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton90);

        boton91.setToolTipText("");
        boton91.setAutoscrolls(true);
        boton91.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton91);

        boton92.setToolTipText("");
        boton92.setAutoscrolls(true);
        boton92.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton92);

        boton93.setToolTipText("");
        boton93.setAutoscrolls(true);
        boton93.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton93);

        boton94.setToolTipText("");
        boton94.setAutoscrolls(true);
        boton94.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton94);

        boton95.setToolTipText("");
        boton95.setAutoscrolls(true);
        boton95.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton95);

        boton96.setToolTipText("");
        boton96.setAutoscrolls(true);
        boton96.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton96);

        boton97.setToolTipText("");
        boton97.setAutoscrolls(true);
        boton97.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton97);

        boton98.setToolTipText("");
        boton98.setAutoscrolls(true);
        boton98.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton98);

        boton99.setToolTipText("");
        boton99.setAutoscrolls(true);
        boton99.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTablero.add(boton99);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton00ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton00ActionPerformed

    private void boton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton02ActionPerformed

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
}
