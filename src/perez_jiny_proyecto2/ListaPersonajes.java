/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perez_jiny_proyecto2;

import javax.swing.ImageIcon;

public class ListaPersonajes {

    private static ImageIcon imagenOriginal(String nombre) {
        return new ImageIcon(ListaPersonajes.class.getResource("/Imagenes/" + nombre + ".png"));
    }

    private static ImageIcon imagenOculta(Personajes.tipoPersonaje tipo) {
        if (tipo == Personajes.tipoPersonaje.heroes) {
            return new ImageIcon(ListaPersonajes.class.getResource("/Imagenes/ocultoheroes.png"));
        } else {
            return new ImageIcon(ListaPersonajes.class.getResource("/Imagenes/ocultoVillanos.png"));
        }
    }

    public static Personajes[] Heroes() {
        String[] nombres = {
            "MrFantastic", "CaptainAmerica", "ProfessorX", "NickFury", "Spider-Man",
            "Wolverine", "Namor", "Daredevil", "Silver Surfer", "Hulk",
            "IronMan", "Thor", "HumanTorch", "Cyclops", "InvisibleWoman",
            "GhostRider", "Punisher", "Blade", "DasDing", "Emma Frost",
            "She-Hulk", "Giant-Man", "Beast", "Colossus", "Gambit",
            "Spider-Girl", "IceMan", "Storm", "Phoenix", "DrStrange",
            "Elektra", "Nightcrawler", "Black Widow", "novaexplosion", "dieErde"
        };

        int[] rangos = {
            10, 9, 8, 8, 7,
            7, 7, 6, 6, 6,
            6, 5, 5, 5, 5,
            4, 4, 4, 4, 3,
            3, 3, 3, 2, 2,
            2, 2, 2, 2, 2,
            2, 1, 0, 0
        };

        Personajes[] heroes = new Personajes[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            String nombre = nombres[i];
            int rango = rangos[i];

            heroes[i] = new Personajes(
                    nombre,
                    rango,
                    Personajes.tipoPersonaje.heroes,
                    true,
                    true,
                    imagenOriginal(nombre),
                    imagenOculta(Personajes.tipoPersonaje.heroes)
            );
        }
        return heroes;
    }

    public static Personajes[] Villanos() {
        String[] nombres = {
            "Dr.Doom", "Galactus", "KingPin", "Magneto", "Apocalypse",
            "GreenGoblin", "Venom", "Bullseye", "OmegaRed", "Onslaught",
            "RedSkull", "Mystique", "Mysterio", "Dr.Octopus", "Deadpool",
            "Abomination", "Thanos", "BlackCat", "Sabretooth", "Juggernaut",
            "Rhino", "Carnage", "MoleMan", "Lizard", "Mr.Sinister",
            "Sentinel1", "Ultron", "Sandman", "Leader", "Viper",
            "Sentinel2", "Electro", "Black Widow", "Kurbisbombe", "dieErde"
        };

        int[] rangos = {
            10, 9, 8, 8, 7,
            7, 7, 6, 6, 6,
            6, 5, 5, 5, 5,
            4, 4, 4, 4, 3,
            3, 3, 3, 3, 2,
            2, 2, 2, 2, 2,
            2, 1, 0, 0
        };

        Personajes[] villanos = new Personajes[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            String nombre = nombres[i];
            int rango = rangos[i];

            villanos[i] = new Personajes(
                    nombre,
                    rango,
                    Personajes.tipoPersonaje.villanos,
                    true,
                    true,
                    imagenOriginal(nombre),
                    imagenOculta(Personajes.tipoPersonaje.villanos)
            );
        }
        return villanos;
    }
}
