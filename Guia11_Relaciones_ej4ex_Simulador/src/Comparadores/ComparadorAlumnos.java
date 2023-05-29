/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparadores;

import Entidades.Alumno;
import java.util.Comparator;

/**
 *
 * @author molin
 */
public class ComparadorAlumnos {
    public static Comparator<Alumno> compararPorVotos = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno t, Alumno t1) {
            return t1.getCantidadVotos().compareTo(t.getCantidadVotos());
        }
    };
}
