/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perez_jiny_proyecto2;

import javax.swing.ImageIcon;

public class Personajes {
    private String nombre;
    private int rango;
    private tipoPersonaje tipo;
    private boolean movimiento;
    private boolean atacar;
    private ImageIcon imagenOculta;
    private ImageIcon  imagenOriginal;
    
    public enum tipoPersonaje{
        heroes,villanos
    }
    
    public Personajes (String nombre, int rango, tipoPersonaje tipo, boolean movimiento, boolean atacar, ImageIcon oculta, ImageIcon original){
        this.nombre=nombre;
        this.rango=rango;
        this.tipo=tipo;
        this.atacar=atacar;
        this.movimiento=movimiento;
        this.imagenOculta=imagenOculta;
        this.imagenOriginal=imagenOriginal;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public int getRango(){
        return rango;
    }
    
    public tipoPersonaje getTipo(){
        return tipo;
    }
    
    public boolean getMovimiento(){
        return movimiento;
    }
    
    public boolean getAtacar(){
        return atacar;
    }
    
    public ImageIcon getImagenOculta(){
        return imagenOculta;
    }
    
    public ImageIcon getImagenOriginal(){
        return imagenOriginal;
    }
            
}
