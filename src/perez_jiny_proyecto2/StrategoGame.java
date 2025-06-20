package perez_jiny_proyecto2;

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
    }

    private void tablero() {
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                int fil = fila;
                int col = columna;

                JButton boton = new JButton();
                tablero[fila][col] = boton;
                jPanel2.add(boton);

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
        System.out.println("Ficha seleccionada: " + personajeSeleccionado.getNombre());
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
    }

    private void batalla(Personajes villano, int fila, int col) {

        String resultado = LogicaJuego.batalla(personajeSeleccionado, villano);

        switch (resultado) {
            case "Gana":
                agregarDerrotado(villano);
                personajesTablero[fila][col] = personajeSeleccionado;
                tablero[fila][col].setIcon(personajeSeleccionado.getImagenOculta());
                break;

            case "Pierde":
                agregarDerrotado(personajeSeleccionado);
                break;

            case "Empate":
                agregarDerrotado(personajeSeleccionado);
                agregarDerrotado(villano);
                personajesTablero[fila][col] = null;
                tablero[fila][col].setIcon(null);
                break;

            case "JuegoGanado":
                JOptionPane.showMessageDialog(null, "¡Felicidades, has ganado el juego!");
                System.exit(0);
                break;
        }

        personajesTablero[filaSeleccionada][columnaSeleccionada] = null;
        tablero[filaSeleccionada][columnaSeleccionada].setIcon(null);
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
        Image imagenEscalada = imagenOculta.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel etiqueta = new JLabel(new ImageIcon(imagenEscalada));

        int limite = 7;
        if (derrotado.getTipo() == Personajes.tipoPersonaje.heroes) {
            if (heroesDerrotado.getComponentCount() >= limite) {
                heroesDerrotado.remove(0);
            }
            heroesDerrotado.add(etiqueta);
            heroesDerrotado.revalidate();
            heroesDerrotado.repaint();
        } else {
            if (villanosDerrotados.getComponentCount() >= limite) {
                villanosDerrotados.remove(0);
            }
            villanosDerrotados.add(etiqueta);
            villanosDerrotados.revalidate();
            villanosDerrotados.repaint();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTurnos = new javax.swing.JLabel();
        heroesDerrotado = new javax.swing.JPanel();
        etiquetaH = new javax.swing.JLabel();
        villanosDerrotados = new javax.swing.JPanel();
        etiquetaV = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(10, 10));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 860, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bc.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 860, 650));

        lblTurnos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnos.setText("Turno: Héroes");

        etiquetaH.setText("HEROES");
        heroesDerrotado.add(etiquetaH);

        etiquetaV.setText("VILLANOS");
        villanosDerrotados.add(etiquetaV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(heroesDerrotado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(villanosDerrotados, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(lblTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTurnos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(villanosDerrotados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(heroesDerrotado, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
    private javax.swing.JLabel etiquetaH;
    private javax.swing.JLabel etiquetaV;
    private javax.swing.JPanel heroesDerrotado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTurnos;
    private javax.swing.JPanel villanosDerrotados;
    // End of variables declaration//GEN-END:variables
}
