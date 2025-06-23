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

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPartidasConHeroes(int partidasConHeroes) {
        this.partidasConHeroes = partidasConHeroes;
    }

    public void setPartidasConVillanos(int partidasConVillanos) {
        this.partidasConVillanos = partidasConVillanos;
    }

    public String getUsername() {
        return username;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getPartidasConHeroes() {
        return partidasConHeroes;
    }

    public int getPartidasConVillanos() {
        return partidasConVillanos;
    }

    public boolean validarPassword(String pass) {
        return this.password.equals(pass);
    }
}
