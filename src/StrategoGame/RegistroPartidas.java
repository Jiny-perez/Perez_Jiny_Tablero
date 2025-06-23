/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
 public boolean ganoElJugador(String nombreJugador) {
        return ganador.equals(nombreJugador);
    }
}
