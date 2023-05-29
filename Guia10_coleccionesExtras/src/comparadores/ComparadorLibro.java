/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparadores;

import Entidades.Libro;
import java.util.Comparator;

/**
 *
 * @author molin
 */
public class ComparadorLibro {
    public static Comparator<Libro> ordenarpornombre = new Comparator<Libro>() {
        @Override
        public int compare(Libro t, Libro t1) {
          return t.getNombre().compareTo(t1.getNombre());
        }
    };
    public static Comparator<Libro> ordenarporejemplares = new Comparator<Libro>() {
        @Override
        public int compare(Libro t, Libro t1) {
            return t.getNejemplares().compareTo(t1.getNejemplares());
        }
    };
}
