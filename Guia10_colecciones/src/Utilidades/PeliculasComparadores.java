/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import entidades.Pelicula;
import java.util.Comparator;
import java.util.function.ToIntFunction;


/**
 *
 * @author molin
 */
public class PeliculasComparadores {
    public static Comparator<Pelicula> ordenarpornombreasc = new Comparator<Pelicula> (){
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return t.getNombre().compareTo(t1.getNombre());
        }
        
    };
    public static Comparator<Pelicula> ordenarpordirectorasc = new Comparator<Pelicula> (){
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return t.getDirector().compareTo(t1.getDirector());
        }     
    };
    public static Comparator<Pelicula> ordenarporduracionasc = new Comparator<Pelicula> (){
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return Double.compare(t.getDuracion(),t1.getDuracion());
        }
        
    };
    public static Comparator<Pelicula> ordenarporduraciondesc = new Comparator<Pelicula> (){
        @Override
        public int compare(Pelicula t, Pelicula t1) {
            return Double.compare(t1.getDuracion(),t.getDuracion());
        }   
    };
       
}
