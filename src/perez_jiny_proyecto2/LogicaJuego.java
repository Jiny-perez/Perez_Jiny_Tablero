package perez_jiny_proyecto2;

public class LogicaJuego {

    public static boolean Movimiento(Personajes personaje, int filaSeleccionada, int columnaSeleccionada, int filaDestino, int columnaDestino, Personajes[][] personajesTablero, boolean[][] zonaProhibida) {
        if (filaDestino < 0 || filaDestino >= 10 || columnaDestino < 0 || columnaDestino >= 10) {
            return false;
        }

        if (zonaProhibida[filaDestino][columnaDestino]) {
            return false;
        }

        String nombre = personaje.getNombre();
        int rango = personaje.getRango();

        if (nombre.equals("dieErdeH") || nombre.equals("dieErdeV")
                || nombre.equals("novaexplosion") || nombre.equals("Kurbisbombe")) {
            return false;
        }

        if (rango == 2) {
            if (filaSeleccionada == filaDestino) {
                int movimiento;
                if (columnaDestino > columnaSeleccionada) {
                    movimiento = 1;
                } else {
                    movimiento = -1;
                }
                for (int i = columnaSeleccionada + movimiento; i != columnaDestino; i += movimiento) {
                    if (personajesTablero[filaSeleccionada][i] != null) {
                        return false;
                    }
                }
                return true;
            } else if (columnaSeleccionada == columnaDestino) {
                int movimiento;
                if (filaDestino > filaSeleccionada) {
                    movimiento = 1;
                } else {
                    movimiento = -1;
                }
                for (int i = filaSeleccionada + movimiento; i != filaDestino; i += movimiento) {
                    if (personajesTablero[i][columnaSeleccionada] != null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        if ((filaSeleccionada == filaDestino && (columnaDestino == columnaSeleccionada + 1 || columnaDestino == columnaSeleccionada - 1)) || (columnaSeleccionada == columnaDestino && (filaDestino == filaSeleccionada + 1 || filaDestino == filaSeleccionada - 1))) {
            return true;
        }

        return false;
    }

    public static String batalla(Personajes heroes, Personajes villanos) {
        int jugador1 = heroes.getRango();
        int jugador2 = villanos.getRango();
        
        String nombrehereoe = heroes.getNombre();
        String nombrevillano = villanos.getNombre();
        
        boolean esBomba = nombrevillano.equals("novaexplosion") || nombrevillano.equals("Kurbisbombe");
        if (esBomba) {
            if (jugador1 == 3) {
                return "Gana";
            }
            return "Pierde";
        }
        if (nombrevillano.equals("dieErdeH") || nombrevillano.equals("dieErdeV")) {
            return "JuegoGanado";
        }
        if (jugador1 == 1 && jugador2 == 10) {
            return "Gana";
        }
        if (jugador1 > jugador2) {
            return "Gana";
        } else if (jugador1 < jugador2) {
            return "Pierde";
        } else {
            return "Empate";
        }
    }
}

