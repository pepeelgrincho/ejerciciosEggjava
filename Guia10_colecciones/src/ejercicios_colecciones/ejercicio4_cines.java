/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package ejercicios_colecciones;

import Servicios.PeliculaServicio;
import java.util.Scanner;
public class ejercicio4_cines {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PeliculaServicio ps = new PeliculaServicio();
        ps.crearPeliculas();
        ps.MostrarPeliculasOpciones();
    }

}
