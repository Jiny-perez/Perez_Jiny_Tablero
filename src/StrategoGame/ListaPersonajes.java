/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategoGame;

import javax.swing.ImageIcon;

public class ListaPersonajes {

    public static Personajes[] Heroes() {
        String[] nombres = {
            "MrFantastic", "CapitanAmerica", "ProfessorX", "NickFury", "SpiderMan",
            "Wolverine", "Namor", "Daredevil", "SilverSurfer", "Hulk",
            "IronMan", "Thor", "HumanTorch", "Cyclops", "InvisibleWoman",
            "GhostRider", "Punisher", "Blade", "DasDing", "EmmaFrost",
            "She-Hulk", "GiantMan", "Beast", "Colossus", "Gambit",
            "Spider-Girl", "IceMan", "Storm", "Phoenix", "DrStrange",
            "Elektra", "Nightcrawler", "BlackWidowH", "novaexplosion1", "novaexplosion2",
            "novaexplosion3", "novaexplosion4", "novaexplosion5", "novaexplosion6", "dieErdeH"
        };

        int[] rangos = {
            10, 9, 8, 8, 7, 7, 7, 6,
            6, 6, 6, 5, 5, 5, 5, 4,
            4, 4, 4, 3, 3, 3, 3, 3,
            2, 2, 2, 2, 2, 2, 2, 2,
            1, 0, 0, 0, 0, 0, 0, 0
        };

        Personajes[] heroes = new Personajes[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            String nombre = nombres[i];
            int rango = rangos[i];

            boolean movimiento = true;
            if (nombre.startsWith("novaexplosion") || nombre.equals("dieErdeH")) {
                movimiento = false;
            }

            heroes[i] = new Personajes(
                    nombre,
                    rango,
                    Personajes.tipoPersonaje.heroes,
                    movimiento,
                    true,
                    imagenOriginal(nombre),
                    imagenOculta(Personajes.tipoPersonaje.heroes)
            );
        }
        return heroes;
    }

    public static Personajes[] Villanos() {
        String[] nombres = {
            "DrDoom", "Galactus", "KingPin", "Magneto", "Apocalypse",
            "GreenGoblin", "Venom", "Bullseye", "OmegaRed", "Onslaught",
            "RedSkull", "Mystique", "Mysterio", "DrOctopus", "Deadpool",
            "Abomination", "Thanos", "BlackCat", "Sabretooth", "Juggernaut",
            "Rhino", "Carnage", "MoleMan", "Lizard", "MrSinister",
            "Sentinel1", "Ultron", "Sandman", "Leader", "Viper",
            "Sentinel2", "Electro", "BlackWidowV", "Kurbisbombe1", "dieErdeV",
            "Kurbisbombe2", "Kurbisbombe3", "Kurbisbombe4", "Kurbisbombe5", "Kurbisbombe6"
        };

        int[] rangos = {
            10, 9, 8, 8, 7, 7, 7, 6,
            6, 6, 6, 5, 5, 5, 5, 4,
            4, 4, 4, 3, 3, 3, 3, 3,
            2, 2, 2, 2, 2, 2, 2, 2,
            1, 0, 0, 0, 0, 0, 0, 0
        };

        Personajes[] villanos = new Personajes[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            String nombre = nombres[i];
            int rango = rangos[i];
            
            boolean movimiento = true;
            if (nombre.startsWith("Kurbisbombe") || nombre.equals("dieErdeV")) {
                movimiento = false;
            }

            villanos[i] = new Personajes(
                    nombre,
                    rango,
                    Personajes.tipoPersonaje.villanos,
                    movimiento,
                    true,
                    imagenOriginal(nombre),
                    imagenOculta(Personajes.tipoPersonaje.villanos)
            );
        }
        return villanos;
    }

    private static ImageIcon imagenOriginal(String nombre) {
        String ruta = "/Imagenes/" + nombre + ".png";
        java.net.URL recurso = ListaPersonajes.class.getResource(ruta);

        return new ImageIcon(recurso);
    }

    private static ImageIcon imagenOculta(Personajes.tipoPersonaje tipo) {
        String ruta;

        if (tipo == Personajes.tipoPersonaje.heroes) {
            ruta = "/Imagenes/ocultoheroes.jpg";
        } else {
            ruta = "/Imagenes/ocultoVillanos.jpg";
        }

        java.net.URL recurso = ListaPersonajes.class.getResource(ruta);

        return new ImageIcon(recurso);
    }
}
