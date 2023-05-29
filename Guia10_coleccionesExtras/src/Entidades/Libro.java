/*
 . La clase Libro debe guardar
el título del libro, autor, número de ejemplares y número de ejemplares prestados.

 */
package Entidades;

/**
 *
 * @author molin
 */
public class Libro {
    private String nombre;
    private Integer nejemplares,eprestados;

    public Integer getNejemplares() {
        return nejemplares;
    }

    public void setNejemplares(Integer nejemplares) {
        this.nejemplares = nejemplares;
    }

    public Integer getEprestados() {
        return eprestados;
    }

    public void setEprestados(Integer eprestados) {
        this.eprestados = eprestados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Libro(String nombre, Integer nejemplares, Integer eprestados) {
        this.nombre = nombre;
        this.nejemplares = nejemplares;
        this.eprestados = eprestados;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", numero de ejemplares=" + nejemplares + ", ejemplares prestados=" + eprestados + '}';
    }

    
    

    

    
}
