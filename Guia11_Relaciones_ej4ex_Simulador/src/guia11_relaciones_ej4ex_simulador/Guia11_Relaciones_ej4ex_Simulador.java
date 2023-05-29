/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package guia11_relaciones_ej4ex_simulador;

import Entidades.Simulador;
import java.util.Scanner;
public class Guia11_Relaciones_ej4ex_Simulador {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Simulador s = new Simulador();
        
        s.CrearAlumno();
       
        s.votacion();
        s.MostrarVotos();
        s.recuentoVotos();
        s.CrearFacilitadores();
        s.CrearFacilitadoressuplentes();
        s.mostrarFacilitadores();
        
    }

}
