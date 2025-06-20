package perez_jiny_proyecto2;

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

        int fila;
        if (esHeroe) {
            fila = 9;
        } else {
            fila = 0;
        }

        int columna;     
        do {
            columna = rand.nextInt(8) + 1; 
        } while (personajeColocado[fila][columna] != null);

        String nombreTierra;
        if (esHeroe) {
            nombreTierra = "dieErdeH";
        } else {
            nombreTierra = "dieErdeV";
        }

        Personajes tierra = extraerNombre(personajes, ocupado, nombreTierra);
        if (tierra != null) {
            colocarTierra(tierra, fila, columna, tablero, personajeColocado);
            return new int[]{fila, columna};
        }

        return new int[]{-1, -1}; 
    }

    private static void bombasAlrededor(Personajes[] personajes, boolean[] ocupado, JButton[][] tablero, 
            Personajes[][] personajesTablero, int[] coordenadasTierra, boolean esHeroe) {
       
        if (coordenadasTierra[0] == -1) return;

        int tierraFila = coordenadasTierra[0];
        int tierraColumna = coordenadasTierra[1];

        int[][] casillaValida = new int[8][2];
        int contador = 0;

        for (int desplazamientoFila = -1; desplazamientoFila <= 1; desplazamientoFila++) {
            for (int desplazamientoColumna = -1; desplazamientoColumna <= 1; desplazamientoColumna++) {
                if (desplazamientoFila == 0 && desplazamientoColumna == 0) continue;

                int filaNueva = tierraFila + desplazamientoFila;
                int columnaNueva = tierraColumna + desplazamientoColumna;

                if (verificacionPosicion (filaNueva, columnaNueva, esHeroe, personajesTablero)) {
                    casillaValida[contador][0] = filaNueva;
                    casillaValida[contador][1] = columnaNueva;
                    contador++;
                }
            }
        }

        String nombreBomba;
        if (esHeroe) {
            nombreBomba = "novaexplosion";
        } else {
            nombreBomba = "Kurbisbombe";
        }

        int bombasColocadas = 0;
        while (contador > 0 && bombasColocadas < 6) {
            Personajes bomba = extraerNombre(personajes, ocupado, nombreBomba);
            if (bomba == null) break;

            int indice = rand.nextInt(contador);
            int fila = casillaValida[indice][0];
            int columna = casillaValida [indice][1];

            personajesTablero[fila][columna] = bomba;
            tablero[fila][columna].setIcon(bomba.getImagenOculta());

            casillaValida[indice][0] = casillaValida[contador - 1][0];
            casillaValida[indice][1] = casillaValida[contador - 1][1];
            contador--;
            bombasColocadas++;
        }
    }

    private static boolean verificacionPosicion (int fila, int columna, boolean esHeroe, Personajes[][] personajesTablero) {
        if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
            return false;
        }
        if (personajesTablero[fila][columna] != null) {
            return false;
        }
        if (esHeroe) {
            return fila >= 6; 
        } else {
            return fila <= 3; 
    }
    }

    private static void bombas(Personajes[] personajes, boolean[] ocupado, JButton[][] tablero,
                               Personajes[][] personajeColocado, boolean esHeroe) {

        int[] filas;
        if (esHeroe) {
            filas = new int[]{8, 9};
        } else {
            filas = new int[]{0, 1};
        }

        while (true) {
            String nombreBomba;
            if (esHeroe) {
                nombreBomba = "novaexplosion";
            } else {
                nombreBomba = "Kurbisbombe";
            }

            Personajes bomba = extraerNombre(personajes, ocupado, nombreBomba);
            if (bomba == null) {
                break;
            }
            colocarBomba(bomba, filas, tablero, personajeColocado);
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