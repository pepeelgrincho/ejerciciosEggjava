/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class AlumnoServicio {
    private Scanner sc; 
    private ArrayList<Alumno> la;
    private final int CantidadNotas = 3;

    public AlumnoServicio() {
        sc = new Scanner(System.in).useDelimiter("\n");
        la = new ArrayList ();
        
    }
    private void crearAlumno(){
        Alumno a = new Alumno();
        System.out.println("");
        System.out.println("ingrese el nombre del alumno");
        a.setNombre(sc.nextLine());
        ArrayList<Integer> notas = new ArrayList();
        System.out.println("ingrese las 3 notas del alumno");
        for (int i = 0; i < CantidadNotas; i++) {            
            notas.add(Integer.valueOf(sc.nextInt()));  
        }
        a.setNotas(notas);
        la.add(a);
    }
    
    public void sumarAlumnos(){
        //cargar los alumnos  y agrega en la lista hasta que bandera n
        String bandera;
        do {
            crearAlumno();
            System.out.println("desea ingresar otro alumno S/N");
            bandera = sc.next();     
            sc.nextLine();
        } while (!bandera.equalsIgnoreCase("n"));
    } 
    public void  notaFinal(){
        String nombreAlumno;
        boolean encontro = false;
        System.out.println("ingrese el nombre para saber promedio");
        Integer suma=0; 
        nombreAlumno=sc.next();
        for (Alumno aux : la) {
            if (aux.getNombre().equals(nombreAlumno)) {
                encontro = true;
                System.out.println("se encontro el alumno en la lista");
                System.out.println(aux);
                
                for (Integer n:aux.getNotas()) {
                    suma += n;       
                }
                System.out.println("el promedio es :" + (suma / 3));
                break;
            }
        }
        if (!encontro){ System.out.println("no se encontro al alumno");}
    }
}
