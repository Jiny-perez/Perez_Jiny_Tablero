package perez_jiny_proyecto2;

import javax.swing.*;
import java.util.*;

public class Fichas {

    private static Random rand = new Random();

    public static void posicionPersonajes(Personajes[] heroes, Personajes[] villanos, JButton[][] tablero,
            Personajes[][] personajesTablero, boolean[][] zonaProhibida) {

        int cantHeroes = 0;
        for (Personajes h : heroes) {
            cantHeroes++;
        }
        boolean[] totalHeroes = new boolean[cantHeroes];

        int cantVillanos = 0;
        for (Personajes v : villanos) {
            cantVillanos++;
        }
        boolean[] totalVillanos = new boolean[cantVillanos];

        tierra(heroes, totalHeroes, tablero, personajesTablero, true);
        tierra(villanos, totalVillanos, tablero, personajesTablero, false);

        bombas(heroes, totalHeroes, tablero, personajesTablero, true);
        bombas(villanos, totalVillanos, tablero, personajesTablero, false);

        rango2(heroes, totalHeroes, 2, tablero, personajesTablero, new int[]{6, 7});
        rango2(villanos, totalVillanos, 2, tablero, personajesTablero, new int[]{2, 3});

        espaciosRestantes(heroes, totalHeroes, new int[]{6, 7, 8, 9}, tablero, personajesTablero);
        espaciosRestantes(villanos, totalVillanos, new int[]{0, 1, 2, 3}, tablero, personajesTablero);
    }

    private static void tierra(Personajes[] personajes, boolean[] ocupado, JButton[][] tablero, Personajes[][] personajeColocado, boolean esHeroe) {

        int fila = esHeroe ? 9 : 0;
        int columna = rand.nextInt(8) + 1;

        Personajes tierra = extraerNombre(personajes, ocupado, esHeroe ? "dieErdeH" : "dieErdeV");
        if (tierra != null) {
            colocarTierra(tierra, fila, columna, tablero, personajeColocado);
        }

    }

    private static void bombas(Personajes[] personajes, boolean[] ocupado, JButton[][] tablero, Personajes[][] personajeColocado, boolean esHeroe) {

        int[] filas = esHeroe ? new int[]{8, 9} : new int[]{0, 1};

        while (true) {
            Personajes bomba = extraerNombre(personajes, ocupado, esHeroe ? "novaexplosion" : "Kurbisbombe");
            if (bomba == null) {
                break;
            }
            colocarBomba(bomba, filas, tablero, personajeColocado);
        }
    }

    private static void rango2(Personajes[] personajes, boolean[] ocupado, int rango, JButton[][] tablero, Personajes[][] personajeColocado, int[] filas) {
        for (int i = 0; i < personajes.length; i++) {
            if (!ocupado[i] && personajes[i].getRango() == rango) {
                if (colocarBomba(personajes[i], filas, tablero, personajeColocado)) {
                    ocupado[i] = true;
                }
            }
        }
    }

    private static void espaciosRestantes(Personajes[] personajes, boolean[] usados, int[] filas, JButton[][] tablero, Personajes[][] personajeColocado) {

        for (int i = 0; i < personajes.length; i++) {

            if (!usados[i]) {

                if (colocarBomba(personajes[i], filas, tablero, personajeColocado)) {
                    usados[i] = true;
                }
            }
        }
    }

    private static boolean colocarBomba(Personajes personajes, int[] filas, JButton[][] tablero, Personajes[][] personajeColocado) {

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

    private static void colocarTierra(Personajes personajes, int fila, int columna, JButton[][] tablero, Personajes[][] personajeColocado) {
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
