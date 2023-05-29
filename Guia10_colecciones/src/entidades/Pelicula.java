/*
 */
package entidades;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author molin
 */
public class Pelicula {
    private String nombre,director;
    double duracion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }   
    

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + ", director=" + director + ", duracion=" + duracion + '}';
    }

    public Pelicula() {
    }

    public Pelicula(String nombre, String director, double duracion) {
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
    }
}
