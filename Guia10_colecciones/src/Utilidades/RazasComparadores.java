/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import entidades.Razas;
import java.util.Comparator;

/**
 *
 * @author molin
 */
public class RazasComparadores {

    public static Comparator<Razas> ordenarPorNombre = new Comparator<Razas>() {

        @Override

        public int compare(Razas r1, Razas r2) {

            return r1.getNombre().compareTo(r2.getNombre());

        }
    };
}
