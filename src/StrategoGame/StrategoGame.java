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

    private String nombreJugador1;
    private String nombreJugador2;

    public StrategoGame() {
        initComponents();
        tablero();
        zonasProhibidas();
        posicionFichas();
        habilitarClickTablero();
        actualizarTurno();
        
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
        SwingUtilities.invokeLater(() -> {
            visibilidadFichas();
        });
    }

    public StrategoGame(String nombreJugador1, String nombreJugador2) {
        initComponents();
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        tablero();
        zonasProhibidas();
        posicionFichas();
        habilitarClickTablero();
        actualizarTurno();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                new MenuInicial().setVisible(true);
            }
        });
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
        Image imagenEscalada = imagenOculta.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
        JLabel ficha = new JLabel(new ImageIcon(imagenEscalada));

        ficha.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel Destino;
        if (derrotado.getTipo() == Personajes.tipoPersonaje.heroes) {
            Destino = jPDerrotasHeroes;
        } else {
            Destino = jPDerrotasVillanos;
        }

        if (Destino.getComponentCount() >= 5) {
            Destino.remove(0);
        }

        Destino.add(ficha);
        Destino.revalidate();
        Destino.repaint();
    }

    private void visibilidadFichas() {
        for (int fila = 0; fila < 10; fila++) {
            for (int col = 0; col < 10; col++) {
                Personajes personaje = personajesTablero[fila][col];
                JButton boton = tablero[fila][col];

                if (personaje != null) {
                    if ((turnoJugador1 && personaje.getTipo() == Personajes.tipoPersonaje.heroes)
                            || (!turnoJugador1 && personaje.getTipo() == Personajes.tipoPersonaje.villanos)) {
                        boton.setIcon(escalarImagen(personaje.getImagenOculta(), boton));
                    } else {
                        boton.setIcon(escalarImagen(personaje.getImagenOriginal(), boton));
                    }
                } else {
                    boton.setIcon(null);
                }
            }
        }
    }

    private ImageIcon escalarImagen(ImageIcon imagen, JButton boton) {
        int ancho = boton.getWidth() > 0 ? boton.getWidth() : 60;
        int alto = boton.getHeight() > 0 ? boton.getHeight() : 60;
        Image imgEscalada = imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgEscalada);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundStrategoGame = new javax.swing.JPanel();
        Tablero = new javax.swing.JPanel();
        lblMensajeBatalla = new javax.swing.JLabel();
        BackgroundTablero = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblVillanos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblHeroes = new javax.swing.JLabel();
        jPDerrotasVillanos = new javax.swing.JPanel();
        jPDerrotasHeroes = new javax.swing.JPanel();
        lblTurnos = new javax.swing.JLabel();
        btnRetiro = new javax.swing.JToggleButton();
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
        BackgroundStrategoGame.add(Tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 700, 550));

        lblMensajeBatalla.setBackground(new java.awt.Color(51, 0, 0));
        lblMensajeBatalla.setFont(new java.awt.Font("Cooper Black", 1, 22)); // NOI18N
        lblMensajeBatalla.setForeground(new java.awt.Color(0, 0, 0));
        lblMensajeBatalla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundStrategoGame.add(lblMensajeBatalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 990, 30));

        BackgroundTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Tablero.png"))); // NOI18N
        BackgroundTablero.setText("jLabel1");
        BackgroundStrategoGame.add(BackgroundTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 700, 550));

        lblVillanos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/lblVillanos.png"))); // NOI18N
        lblVillanos.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVillanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVillanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BackgroundStrategoGame.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 120, -1));

        lblHeroes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/lblHeroes.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeroes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeroes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BackgroundStrategoGame.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        jPDerrotasVillanos.setBackground(new java.awt.Color(134, 4, 4));
        BackgroundStrategoGame.add(jPDerrotasVillanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 120, 500));

        jPDerrotasHeroes.setBackground(new java.awt.Color(134, 4, 4));
        BackgroundStrategoGame.add(jPDerrotasHeroes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 500));

        lblTurnos.setBackground(new java.awt.Color(51, 0, 0));
        lblTurnos.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        lblTurnos.setForeground(new java.awt.Color(0, 0, 0));
        lblTurnos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BackgroundStrategoGame.add(lblTurnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 990, 30));

        btnRetiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/BotonRetiro.png"))); // NOI18N
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });
        BackgroundStrategoGame.add(btnRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 650, 280, 50));

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

    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que deseas retirarte?\nEl otro jugador ganará la partida.",
                "Confirmar Retiro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            String ganador;
            String bandoJugador1 = "Héroes";
            String bandoJugador2 = "Villanos";
            if (turnoJugador1) {
                ganador = nombreJugador2;
            } else {
                ganador = nombreJugador1;
            }
            RegistroPartidas registro = new RegistroPartidas(nombreJugador1, nombreJugador2, ganador, bandoJugador1, bandoJugador2);
            registro.setGanador(ganador);
            JOptionPane.showMessageDialog(this, "El juego ha terminado. Ganador: " + ganador + " (+3 puntos)");
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRetiroActionPerformed

 
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
    private javax.swing.JToggleButton btnRetiro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPDerrotasHeroes;
    private javax.swing.JPanel jPDerrotasVillanos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblHeroes;
    private javax.swing.JLabel lblMensajeBatalla;
    private javax.swing.JLabel lblStrategoGame;
    private javax.swing.JLabel lblTurnos;
    private javax.swing.JLabel lblVillanos;
    // End of variables declaration//GEN-END:variables
}
