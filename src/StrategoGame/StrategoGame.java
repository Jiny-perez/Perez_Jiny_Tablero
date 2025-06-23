package StrategoGame;

import javax.swing.*;
import java.awt.*;

public class StrategoGame extends javax.swing.JFrame {

    private JButton[][] tablero = new JButton[10][10];
    boolean[][] zonaProhibida = new boolean[10][10];
    private Personajes[][] personajesTablero;

    private int filaSeleccionada = -1;
    private int columnaSeleccionada = -1;
    private Personajes personajeSeleccionado = null;
    private boolean turnoJugador1 = true;

    public StrategoGame() {
        initComponents();
        tablero();
        zonasProhibidas();
        posicionFichas();
        habilitarClickTablero();
        actualizarTurno();
    }

    public StrategoGame(MenuPrincipal menuPrinicipal) {
        initComponents();

    }

    private void tablero() {
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                int fil = fila;
                int col = columna;

                JButton boton = new JButton();
                tablero[fila][col] = boton;
                Tablero.add(boton);

                boton.setPreferredSize(new Dimension(60, 60));
                boton.setOpaque(false);
                boton.setContentAreaFilled(false);
                boton.setFocusPainted(false);

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

    private void posicionFichas() {
        Personajes[] heroes = ListaPersonajes.Heroes();
        Personajes[] villanos = ListaPersonajes.Villanos();
        personajesTablero = new Personajes[10][10];

        Fichas.posicionPersonajes(heroes, villanos, tablero, personajesTablero, zonaProhibida);
        visibilidadFichas();

    }

    private void habilitarClickTablero() {
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                int fil = fila;
                int col = columna;
                tablero[fil][col].addActionListener(e -> clickBotones(fil, col));
            }
        }
    }

    private void clickBotones(int filaDestino, int columnaDestino) {
        if (personajeSeleccionado == null) {
            FichaSeleccionada(filaDestino, columnaDestino);
        } else {
            movimiento(filaDestino, columnaDestino);
        }
    }

    private void FichaSeleccionada(int fila, int columna) {
        Personajes seleccionado = personajesTablero[fila][columna];

        if (seleccionado == null) {
            JOptionPane.showMessageDialog(null, "No hay ficha para seleccionar aquí.");
            return;
        }

        boolean turnoValido = (turnoJugador1 && seleccionado.getTipo() == Personajes.tipoPersonaje.heroes) || (!turnoJugador1 && seleccionado.getTipo() == Personajes.tipoPersonaje.villanos);

        if (!turnoValido) {
            JOptionPane.showMessageDialog(null, "Espera tu turno...");
            return;
        }

        personajeSeleccionado = seleccionado;
        filaSeleccionada = fila;
        columnaSeleccionada = columna;
    }

    private void movimiento(int filaDestino, int columnaDestino) {
        if (!LogicaJuego.Movimiento(personajeSeleccionado, filaSeleccionada, columnaSeleccionada, filaDestino, columnaDestino, personajesTablero, zonaProhibida)) {
            JOptionPane.showMessageDialog(null, "Movimiento inválido.");
            resetearSeleccion();
            return;
        }

        Personajes destino = personajesTablero[filaDestino][columnaDestino];

        if (destino == null) {
            moverFicha(filaDestino, columnaDestino);
        } else if (personajeSeleccionado.getTipo().equals(destino.getTipo())) {
            JOptionPane.showMessageDialog(null, "Movimiento inválido. Estas atacando a tu propio bando.");
        } else {
            batalla(destino, filaDestino, columnaDestino);
        }

        resetearSeleccion();
    }

    private void moverFicha(int fila, int col) {

        personajesTablero[fila][col] = personajeSeleccionado;
        personajesTablero[filaSeleccionada][columnaSeleccionada] = null;
        tablero[fila][col].setIcon(personajeSeleccionado.getImagenOculta());
        tablero[filaSeleccionada][columnaSeleccionada].setIcon(null);

        turnoJugador1 = !turnoJugador1;
        actualizarTurno();
        lblMensajeBatalla.setText("");

    }

    private void batalla(Personajes villano, int fila, int col) {

        String nombreAtacante = personajeSeleccionado.getNombre();
        String tipoAtacante = personajeSeleccionado.getTipo().toString().toUpperCase();

        String nombreDefensor = villano.getNombre();
        String tipoDefensor = villano.getTipo().toString().toUpperCase();

        String mensaje = nombreAtacante + " vs " + nombreDefensor + " | \n";

        String resultado = LogicaJuego.batalla(personajeSeleccionado, villano);

        switch (resultado) {
            case "Gana":
                mensaje += " Gana la batalla: " + nombreAtacante + " - Eliminado: " + nombreDefensor;
                agregarDerrotado(villano);
                personajesTablero[fila][col] = personajeSeleccionado;
                tablero[fila][col].setIcon(personajeSeleccionado.getImagenOculta());
                break;
            case "Pierde":
                mensaje += " Gana la batalla: " + nombreDefensor + " - Eliminado: " + nombreAtacante;
                agregarDerrotado(personajeSeleccionado);
                break;
            case "Empate":
                mensaje += "Empate: ambos eliminados.";
                agregarDerrotado(personajeSeleccionado);
                agregarDerrotado(villano);
                personajesTablero[fila][col] = null;
                tablero[fila][col].setIcon(null);
                break;
            case "JuegoGanado":
                mensaje += nombreAtacante + "Ha ganado el juego.";
                lblMensajeBatalla.setText(mensaje);
                return;
        }

        personajesTablero[filaSeleccionada][columnaSeleccionada] = null;
        tablero[filaSeleccionada][columnaSeleccionada].setIcon(null);

        lblMensajeBatalla.setText(mensaje);

        turnoJugador1 = !turnoJugador1;
        actualizarTurno();

    }

    private void resetearSeleccion() {
        personajeSeleccionado = null;
        filaSeleccionada = -1;
        columnaSeleccionada = -1;
    }

    private void actualizarTurno() {
        if (turnoJugador1) {
            lblTurnos.setText("Turno: Héroes");
        } else {
            lblTurnos.setText("Turno: Villanos");
        }
        visibilidadFichas();
    }

    private void agregarDerrotado(Personajes derrotado) {
        ImageIcon imagenOculta = derrotado.getImagenOculta();
        Image imagenEscalada = imagenOculta.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel ficha = new JLabel(new ImageIcon(imagenEscalada));

        if (derrotado.getTipo() == Personajes.tipoPersonaje.heroes) {
            jPDerrotasHeroes.add(ficha);
            jPDerrotasHeroes.revalidate();
            jPDerrotasHeroes.repaint();
        } else {
            jPDerrotasVillanos.add(ficha);
            jPDerrotasVillanos.revalidate();
            jPDerrotasVillanos.repaint();
        }
    }

    private void visibilidadFichas() {
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                Personajes personajes = personajesTablero[fila][col];
                if (personajes != null) {
                    if ((turnoJugador1 && personajes.getTipo() == Personajes.tipoPersonaje.heroes)
                            || (!turnoJugador1 && personajes.getTipo() == Personajes.tipoPersonaje.villanos)) {
                        tablero[fila][col].setIcon(personajes.getImagenOculta());
                    } else {
                        tablero[fila][col].setIcon(personajes.getImagenOriginal());
                    }
                } else {
                    tablero[fila][col].setIcon(null);
                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundStrategoGame = new javax.swing.JPanel();
        Tablero = new javax.swing.JPanel();
        lblMensajeBatalla = new javax.swing.JLabel();
        BackgroundTablero = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPDerrotasVillanos = new javax.swing.JPanel();
        jPDerrotasHeroes = new javax.swing.JPanel();
        lblTurnos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblStrategoGame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundStrategoGame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tablero.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        Tablero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tablero.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        Tablero.setDoubleBuffered(false);
        Tablero.setOpaque(false);
        Tablero.setLayout(new java.awt.GridLayout(10, 10));
        BackgroundStrategoGame.add(Tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 700, 550));

        lblMensajeBatalla.setBackground(new java.awt.Color(51, 0, 0));
        lblMensajeBatalla.setFont(new java.awt.Font("Cooper Black", 1, 22)); // NOI18N
        lblMensajeBatalla.setForeground(new java.awt.Color(0, 0, 0));
        lblMensajeBatalla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundStrategoGame.add(lblMensajeBatalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 990, 30));

        BackgroundTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Tablero.png"))); // NOI18N
        BackgroundTablero.setText("jLabel1");
        BackgroundStrategoGame.add(BackgroundTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 700, 550));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        BackgroundStrategoGame.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 120, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        BackgroundStrategoGame.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        javax.swing.GroupLayout jPDerrotasVillanosLayout = new javax.swing.GroupLayout(jPDerrotasVillanos);
        jPDerrotasVillanos.setLayout(jPDerrotasVillanosLayout);
        jPDerrotasVillanosLayout.setHorizontalGroup(
            jPDerrotasVillanosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPDerrotasVillanosLayout.setVerticalGroup(
            jPDerrotasVillanosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        BackgroundStrategoGame.add(jPDerrotasVillanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, -1, -1));

        javax.swing.GroupLayout jPDerrotasHeroesLayout = new javax.swing.GroupLayout(jPDerrotasHeroes);
        jPDerrotasHeroes.setLayout(jPDerrotasHeroesLayout);
        jPDerrotasHeroesLayout.setHorizontalGroup(
            jPDerrotasHeroesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPDerrotasHeroesLayout.setVerticalGroup(
            jPDerrotasHeroesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        BackgroundStrategoGame.add(jPDerrotasHeroes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 490));

        lblTurnos.setBackground(new java.awt.Color(51, 0, 0));
        lblTurnos.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        lblTurnos.setForeground(new java.awt.Color(0, 0, 0));
        lblTurnos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundStrategoGame.add(lblTurnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 990, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/153 sin título_20250622215612.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(153, 0, 0)));
        BackgroundStrategoGame.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 80));

        lblStrategoGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BackgroundTablero.png"))); // NOI18N
        BackgroundStrategoGame.add(lblStrategoGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(BackgroundStrategoGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(BackgroundStrategoGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StrategoGame().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundStrategoGame;
    private javax.swing.JLabel BackgroundTablero;
    private javax.swing.JPanel Tablero;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPDerrotasHeroes;
    private javax.swing.JPanel jPDerrotasVillanos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMensajeBatalla;
    private javax.swing.JLabel lblStrategoGame;
    private javax.swing.JLabel lblTurnos;
    // End of variables declaration//GEN-END:variables
}
