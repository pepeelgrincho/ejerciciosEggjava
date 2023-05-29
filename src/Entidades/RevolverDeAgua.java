/*
 Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)
 */
package Entidades;

import java.util.Random;

/**
 *
 * @author molin
 */
public class RevolverDeAgua {
    private int posicionActual, posicionAgua;

    @Override
    public String toString() {
        return "RevolverDeAgua{" + "posicion Actual=" + posicionActual + ", posicion del Agua=" + posicionAgua + '}';
    }
    public void llenarRevolver(){
        //Random ra = new Random();
        posicionActual = (int)(Math.random()*6)+1;
        posicionAgua = (int)(Math.random()*6)+1;
    }
    public boolean mojar(){
        return posicionActual == posicionAgua;
    }
    public void siguienteChorro(){
        if (posicionActual < 6){
            posicionActual++;
        }else posicionActual = 1;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(int posicionAgua) {
        this.posicionAgua = posicionAgua;
    }
}
