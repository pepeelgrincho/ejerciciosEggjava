/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author molin
 */
public class Butaca {
    private Espectadores espectador;
    private int filas;
    private char letra;
    private boolean ocupado;

    @Override
    public String toString() {
        return "Butaca{" + "espectador=" + espectador + ", filas=" + filas + ", letra=" + letra + ", ocupado=" + ocupado + '}';
    }

    public Espectadores getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectadores espectador) {
        this.espectador = espectador;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Butaca() {
    }
}
