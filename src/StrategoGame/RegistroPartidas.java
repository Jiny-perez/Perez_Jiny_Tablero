package StrategoGame;

public class RegistroPartidas {

    private String jugador1;
    private String jugador2;
    private String ganador;
    private String bandoJugador1;
    private String bandoJugador2;

    public RegistroPartidas(String jugador1, String jugador2, String ganador,
            String bandoJugador1, String bandoJugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = ganador;
        this.bandoJugador1 = bandoJugador1;
        this.bandoJugador2 = bandoJugador2;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public String getGanador() {
        return ganador;
    }

    public String getBandoJugador1() {
        return bandoJugador1;
    }

    public String getBandoJugador2() {
        return bandoJugador2;
    }

    public String getBandoJugador(String nombreJugador) {
        if (jugador1.equals(nombreJugador)) {
            return bandoJugador1;
        } else if (jugador2.equals(nombreJugador)) {
            return bandoJugador2;
        }
        return "";
    }

    public String getOponente(String nombreJugador) {
        if (jugador1.equals(nombreJugador)) {
            return jugador2;
        } else if (jugador2.equals(nombreJugador)) {
            return jugador1;
        }
        return "";
    }

    public boolean ganoElJugador(String nombreJugador) {
        return ganador.equals(nombreJugador);
    }

    public String ResetearLog(String jugadorActual) {
        String oponente = getOponente(jugadorActual);
        String rolActual = getBandoJugador(jugadorActual);
        String rolOponente = getBandoJugador(oponente);
        String resultado = ganoElJugador(jugadorActual) ? "GANÓ" : "PERDIÓ";

        return "vs " + oponente + " | " + jugadorActual + ": " + rolActual
                + " - " + oponente + ": " + rolOponente + " | " + resultado;
    }

    @Override
    public String toString() {
        return jugador1 + ": " + bandoJugador1 + " vs " + jugador2 + ": " + bandoJugador2
                + " - Ganador: " + ganador;
    }
}
