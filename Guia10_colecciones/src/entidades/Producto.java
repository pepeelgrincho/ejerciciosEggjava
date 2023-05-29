/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Comparator;

/**
 *
 * @author molin
 */
public class Producto {
    
    private String nombre;
    private Double valor;

    public Producto() {
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" + "valor=" + valor + ", nombre=" + nombre + '}';
    }

    public Producto(String nombre,Double valor) {
        this.nombre = nombre;
        this.valor = valor;

    }
    
   
}
