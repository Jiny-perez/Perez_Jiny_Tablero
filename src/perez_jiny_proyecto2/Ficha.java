/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perez_jiny_proyecto2;
import java.util.Scanner;

public class Ficha {
    private String nombre;
    private int rango;
    private boolean movimiento;
    private boolean heroes;
    
    public Ficha (String nombre, int rango, boolean movimiento, boolean heroes){
        this.nombre=nombre;
        this.rango = rango;
        this.movimiento=movimiento;
        this.heroes=heroes;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getRango(){
        return rango;
    }
    
    public boolean getMovimiento(){
        return movimiento;
    }
    public boolean getHeroes(){
        return heroes;
    }
}
