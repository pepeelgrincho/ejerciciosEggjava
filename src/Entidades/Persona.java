/*
 la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
 */
package Entidades;

import java.util.List;
import Entidades.Perro;
import java.util.ArrayList;

/**
 *
 * @author molin
 */
public class Persona {
    private String nombre, apellido;
    private int documento,edad;
    private ArrayList<Perro> p; 

    public Persona() {
        p = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Perro> getP() {
        return p;
    }

    public void setP(ArrayList<Perro> p) {
        this.p = p;
    }

    public void AgregarPerro(Perro pe){
        p.add(pe);
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", edad=" + edad + '}';
    }


    
    
    
}
