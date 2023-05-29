/*
 Perro, que tendrá como atributos: nombre, raza, edad y tamaño;
 */
package Entidades;

import Enum.Raza;

/**
 *
 * @author molin
 */
public class Perro {
    private String nombre, tamanio;
    private Raza raza;
    private int edad;

    public Perro() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Perro{" + "nombre=" + nombre + ", tamanio=" + tamanio + ", raza=" + raza + ", edad=" + edad + '}';
    }

   
}
