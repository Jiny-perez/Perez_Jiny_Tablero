/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perez_jiny_proyecto2;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


public class ListaPersonajes {
    
    private static ImageIcon imagenOriginal (String nombre){
        return new ImageIcon(ListaPersonajes.class.getResource("/Imagenes/"+nombre+".png"));
    }
    
    private static ImageIcon imagenOculta (Personajes.tipoPersonaje tipo){
      if ( tipo== Personajes.tipoPersonaje.heroes)  {
        return new ImageIcon (ListaPersonajes.class.getResource("/Imagenes/ocultoheroes.png"));
    }else{
        return new ImageIcon (ListaPersonajes.class.getResource("/Imagenes/ocultoVillanos.png"));
    }
    }  
    
    public static List<Personajes>Heroes(){
        List<Personajes>heroes=new ArrayList<>();
        
        Object [][] Nombre_Rango = {
            {"Mr.Fantastic",10},
            {"CaptainAmerica",9},
            {"ProfessorX",8},
            {"NickFury",8},
            {"Spider-Man",7},
            {"Wolverine",7},
            {"Namor",7},
            {"Daredevil",6},
            {"Silver Surfer",6},
            {"Hulk",6},
            {"IronMan",6},
            {"Thor",5},
            {"HumanTorch",5},
            {"Cyclops",5},
            {"InvisibleWoman",5},
            {"GhostRider",4},
            {"Punisher",4},
            {"Blade",4},
            {"DasDing",4},
            {"Emma Frost",3},   
            {"She-Hulk",3},
            {"Giant-Man",3},
            {"Beast",3},
            {"Colossus",3},
            {"Gambit",2},
            {"Spider-Girl",2},
            {"IceMan",2},
            {"Storm",2},
            {"Phoenix",2},
            {"Dr.Strange",2},
            {"Elektra",2},
            {"Nightcrawler",2},
            {"Black Widow",1},
            {"novaexplosion"},
            {"dieErde"}
        };
        
        for (Object[] Heroes : Nombre_Rango) {
        String nombre = (String) Heroes[0];
        int rango = (int) Heroes[1];

        heroes.add(new Personajes(
            nombre,
            rango,
            Personajes.tipoPersonaje.heroes,
            true,
            true,
            imagenOriginal(nombre),
            imagenOculta(Personajes.tipoPersonaje.heroes)
        ));
    }
        return heroes;
    }
    
    public static List<Personajes>Villanos(){
        List<Personajes>villanos=new ArrayList<>();
        Object [][] Nombre_Rango = {
            {"Dr.Moon",10},
            {"Galactus",9},
            {"KingPin",8},
            {"Magneto",8},
            {"Apocalypse",7},
            {"GreenGoblin",7},
            {"Venom",7},
            {"Bullseye",6},
            {"OmegaRed",6},
            {"Onslaught",6},
            {"RedSkull",6},
            {"Mystique",5},
            {"Mysterio",5},
            {"Dr.Octopus",5},
            {"Deadpool",5},
            {"Abomination",4},
            {"Thanos",4},
            {"BlackCat",4},
            {"Sabretooth",4},
            {"Juggernaut",3},   
            {"Rhino",3},
            {"Carnage",3},
            {"MoleMan",3},
            {"Lizard",3},
            {"Mr.Sinister",2},
            {"Sentinel1",2},
            {"Ultron",2},
            {"Sandman",2},
            {"Leader",2},
            {"Viper",2},
            {"Sentinel2",2},
            {"Electro",2},
            {"Black Widow",1},
            {"Kurbisbombe"},
            {"dieErde"}
        };
        
        for (Object[] Villanos: Nombre_Rango) {
        String nombre = (String) Villanos[0];
        int rango = (int) Villanos[1];

        villanos.add(new Personajes(
            nombre,
            rango,
            Personajes.tipoPersonaje.villanos,
            true,
            true,
            imagenOriginal(nombre),
            imagenOculta(Personajes.tipoPersonaje.villanos)
        ));
    }
        return villanos;
  }
}