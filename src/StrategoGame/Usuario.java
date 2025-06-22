/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategoGame;

public class Usuario {

    private String username;
    private String password;
    private int puntos;
    private int partidasConHeroes;
    private int partidasConVillanos;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.puntos = 0;
        this.partidasConVillanos = 0;
        this.partidasConHeroes = 0;
    }

    public String getUsername() {
        return username;
    }

    public boolean validarContra(String contra) {
        return this.password.equals(contra);
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPartidasConHeroes(int partidasConHeroes) {
        this.partidasConHeroes = partidasConHeroes;
    }

    public void setPartidasConVillanos(int partidasConVillanos) {
        this.partidasConVillanos = partidasConVillanos;
    }
}
