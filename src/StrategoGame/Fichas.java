package StrategoGame;

import javax.swing.*;
import java.util.*;

public class Fichas {

    private static Random rand = new Random();

    public static void posicionPersonajes(Personajes[] heroes, Personajes[] villanos, JButton[][] tablero,
            Personajes[][] personajesTablero, boolean[][] zonaProhibida) {

        int cantHeroes = heroes.length;
        boolean[] totalHeroes = new boolean[cantHeroes];

        int cantVillanos = villanos.length;
        boolean[] totalVillanos = new boolean[cantVillanos];

        int[] tierraHeroe = tierra(heroes, totalHeroes, tablero, personajesTablero, true);
        int[] tierraVillano = tierra(villanos, totalVillanos, tablero, personajesTablero, false);

        bombasAlrededor(heroes, totalHeroes, tablero, personajesTablero, tierraHeroe, true);
        bombasAlrededor(villanos, totalVillanos, tablero, personajesTablero, tierraVillano, false);

        bombas(heroes, totalHeroes, tablero, personajesTablero, true);
        bombas(villanos, totalVillanos, tablero, personajesTablero, false);

        rango2(heroes, totalHeroes, 2, tablero, personajesTablero, new int[]{6, 7});
        rango2(villanos, totalVillanos, 2, tablero, personajesTablero, new int[]{2, 3});

        espaciosRestantes(heroes, totalHeroes, new int[]{6, 7, 8, 9}, tablero, personajesTablero);
        espaciosRestantes(villanos, totalVillanos, new int[]{0, 1, 2, 3}, tablero, personajesTablero);
    }

    private static int[] tierra(Personajes[] personajes, boolean[] ocupado, JButton[][] tablero,
            Personajes[][] personajeColocado, boolean esHeroe) {

        int fila = esHeroe ? 9 : 0;
        int columna;
        do {
            columna = rand.nextInt(8) + 1;
        } while (personajeColocado[fila][columna] != null);

        String nombreTierra = esHeroe ? "dieErdeH" : "dieErdeV";
        Personajes tierra = extraerNombre(personajes, ocupado, nombreTierra);

        if (tierra != null) {
            colocarTierra(tierra, fila, columna, tablero, personajeColocado);
            return new int[]{fila, columna};
        }

        return new int[]{-1, -1};
    }

    private static void bombasAlrededor(Personajes[] personajes, boolean[] ocupado, JButton[][] tablero,
            Personajes[][] personajesTablero, int[] coordenadasTierra, boolean esHeroe) {

        if (coordenadasTierra[0] == -1) {
            return;
        }

        int fila = coordenadasTierra[0];
        int columna = coordenadasTierra[1];

        String nombreBomba = esHeroe ? "novaexplosion" : "Kurbisbombe";

        int[][] posiciones = new int[3][2];

        posiciones[0][0] = fila;         
        posiciones[0][1] = columna - 1;    

        posiciones[1][0] = fila;          
        posiciones[1][1] = columna + 1;   

        posiciones[2][0] = esHeroe ? fila - 1 : fila + 1;
        posiciones[2][1] = columna;

        for (int i = 0; i < 3; i++) {
            int f = posiciones[i][0];
            int c = posiciones[i][1];

            if (verificacionPosicionBombas(f, c, esHeroe, personajesTablero)) {
                Personajes bomba = extraerNombre(personajes, ocupado, nombreBomba);
                if (bomba != null) {
                    personajesTablero[f][c] = bomba;
                }
            }
        }
    }

    private static boolean verificacionPosicionBombas(int fila, int columna, boolean esHeroe, Personajes[][] personajesTablero) {
        if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
            return false;
        }
        if (personajesTablero[fila][columna] != null) {
            return false;
        }

        if (esHeroe) {
            return fila == 8 || fila == 9;
        } else {
            return fila == 0 || fila == 1;
        }
    }

    private static void bombas(Personajes[] personajes, boolean[] ocupado, JButton[][] tablero,
            Personajes[][] personajeColocado, boolean esHeroe) {

        int[] filas = esHeroe ? new int[]{8, 9} : new int[]{0, 1};
        int bombasColocadas = 0;

        while (bombasColocadas < 3) {
            String nombreBomba = esHeroe ? "novaexplosion" : "Kurbisbombe";
            Personajes bomba = extraerNombre(personajes, ocupado, nombreBomba);
            if (bomba == null) {
                break;
            }

            boolean colocada = colocarBomba(bomba, filas, tablero, personajeColocado);
            if (colocada) {
                bombasColocadas++;
            }
        }
    }

    private static void rango2(Personajes[] personajes, boolean[] ocupado, int rango, JButton[][] tablero,
            Personajes[][] personajeColocado, int[] filas) {
        for (int i = 0; i < personajes.length; i++) {
            if (!ocupado[i] && personajes[i].getRango() == rango) {
                if (colocarBomba(personajes[i], filas, tablero, personajeColocado)) {
                    ocupado[i] = true;
                }
            }
        }
    }

    private static void espaciosRestantes(Personajes[] personajes, boolean[] usados, int[] filas,
            JButton[][] tablero, Personajes[][] personajeColocado) {
        for (int i = 0; i < personajes.length; i++) {
            if (!usados[i]) {
                if (colocarBomba(personajes[i], filas, tablero, personajeColocado)) {
                    usados[i] = true;
                }
            }
        }
    }

    private static boolean colocarBomba(Personajes personajes, int[] filas, JButton[][] tablero,
            Personajes[][] personajeColocado) {
        for (int intento = 0; intento < 100; intento++) {
            int fila = filas[rand.nextInt(filas.length)];
            int columna = rand.nextInt(10);
            if (personajeColocado[fila][columna] == null) {
                colocarTierra(personajes, fila, columna, tablero, personajeColocado);
                return true;
            }
        }
        return false;
    }

    private static void colocarTierra(Personajes personajes, int fila, int columna, JButton[][] tablero,
            Personajes[][] personajeColocado) {
        personajeColocado[fila][columna] = personajes;
        tablero[fila][columna].setIcon(personajes.getImagenOculta());
    }


    private static Personajes extraerNombre(Personajes[] personajes, boolean[] ocupado, String nombre) {
        for (int i = 0; i < personajes.length; i++) {
            if (!ocupado[i] && personajes[i].getNombre().equals(nombre)) {
                ocupado[i] = true;
                return personajes[i];
            }
        }
        for (int i = 0; i < personajes.length; i++) {
            if (!ocupado[i]) {
                String caracter = personajes[i].getNombre();
                if (caracter.length() >= nombre.length()) {
                    String inicio = caracter.substring(0, nombre.length());
                    if (inicio.equals(nombre)) {
                        ocupado[i] = true;
                        return personajes[i];
                    }
                }
            }
        }
        return null;
    }

}
