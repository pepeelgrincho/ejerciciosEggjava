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
public class Espectadores {
    /*
Por Ãºltimo, del espectador, nos interesa saber su
nombre, edad y el dinero que tiene disponible.
*/
  private String nombre;
    private int edad;
    private Double dineroDisp;

    public Espectadores() {
    }

    public Espectadores(String nombre, int edad, Double dineroDisp) {
        this.nombre = nombre;
        this.edad = edad;
        this.dineroDisp = dineroDisp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getDineroDisp() {
        return dineroDisp;
    }

    public void setDineroDisp(Double dineroDisp) {
        this.dineroDisp = dineroDisp;
    }

    @Override
    public String toString() {
        return "Espectadores{" + "nombre=" + nombre + ", edad=" + edad + ", dineroDisp=" + dineroDisp + '}';
    }
    
}
