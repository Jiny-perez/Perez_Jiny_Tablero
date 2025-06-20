package perez_jiny_proyecto2;

public class LogicaJuego {

    public static boolean Movimiento(Personajes personaje, int filaSeleccionada, int columnaSeleccionada, int filaDestino, int columnaDestino, Personajes[][] personajesTablero, boolean[][] zonaProhibida) {
        if (filaDestino < 0 || filaDestino >= 10 || columnaDestino < 0 || columnaDestino >= 10) {
            return false;
        }

        if (zonaProhibida[filaDestino][columnaDestino]) {
            return false;
        }

        if (!personaje.getMovimiento()) {
            return false;
        }

        int rango = personaje.getRango();

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

        int rangoHeroe = heroes.getRango();
        int rangoVillano = villanos.getRango();

        String nombrehereoe = heroes.getNombre();
        String nombrevillano = villanos.getNombre();

        if (nombrevillano.startsWith("novaexplosion") || nombrevillano.startsWith("Kurbisbombe")) {
            if (rangoHeroe == 3) {
                return "Gana";
            } else {
                return "Pierde";
            }
        }

        if (nombrevillano.equals("dieErdeH") || nombrevillano.equals("dieErdeV")) {
            return "JuegoGanado";
        }

        if (rangoHeroe == 1 && rangoVillano == 10) {
            return "Gana";
        }
        if (rangoHeroe > rangoVillano) {
            return "Gana";
        } else if (rangoHeroe < rangoVillano) {
            return "Pierde";
        } else {
            return "Empate";
        }
    }
}
