/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CantanteServicio;

import Entidades.Libro;
import static comparadores.ComparadorLibro.ordenarporejemplares;
import static comparadores.ComparadorLibro.ordenarpornombre;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class LibroServicio {
    Scanner sc ; 
    HashSet<Libro> libreria;  

    public LibroServicio() {
        sc = new Scanner(System.in).useDelimiter("\n");
        libreria = new HashSet<Libro>();
    }
    private void ingresarlibro(){
        System.out.println("ingrese el nombre del libro");
        String nombre = sc.nextLine();
        boolean bandera = true;
        for (Libro l: libreria){
            if (l.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("ya ha ingresado ese nombre libro");
                bandera = false;
            }       
        }
        if (bandera){
            int ejemplares;
            do {
                System.out.println("ingrese cantidad de numeros de ejemplares ");
                ejemplares = sc.nextInt();
                
            } while (ejemplares < 0 );
            libreria.add(new Libro(nombre,ejemplares,0));   
        }
    }
    /*• Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al
método. El método se incrementa de a uno, como un carrito de compras, el
atributo ejemplares prestados, del libro que ingresó el usuario. Esto sucederá
cada vez que se realice un préstamo del libro. No se podrán prestar libros de los
que no queden ejemplares disponibles para prestar. Devuelve true si se ha
podido realizar la operación y false en caso contrari*/
    private boolean prestamo(String nombre){
        boolean bandera = false;
        for (Libro l: libreria){
            if (l.getNombre().equalsIgnoreCase(nombre)){
                if (l.getEprestados()<l.getNejemplares())  {
                    bandera = true;
                    l.setEprestados(l.getEprestados()+1);
                }       
            }       
        }
        return bandera;
    }
    private boolean buscarlibro(String nombre){
        boolean bandera = false;
        for (Libro l: libreria){
            if (l.getNombre().equalsIgnoreCase(nombre)){
                    bandera = true;
                }       
            }       
        return bandera;
   
    }private boolean devolucion(String nombre){
        boolean bandera = false;
        for (Libro l: libreria){
            if (l.getNombre().equalsIgnoreCase(nombre)){
                if (l.getEprestados()>0 )  {
                    bandera = true;
                    l.setEprestados(l.getEprestados()+1);
                }       
            }       
        }
        return bandera;
    }
    private void ordenpornombre(){
        if (!libreria.isEmpty()){
            ArrayList<Libro> ll = new ArrayList(libreria);
            ll.sort(ordenarpornombre);
            ll.forEach(Libro -> System.out.println(Libro));
    } else System.out.println("no hay libros ingresados");
    }
    private void ordenporejemplares(){
        if (!libreria.isEmpty()){
            ArrayList<Libro> ll = new ArrayList(libreria);
            ll.sort(ordenarporejemplares);
            ll.forEach(Libro -> System.out.println(Libro));
    }else System.out.println("no hay libros ingresados");
    }
     public void menu (){
         int opcion =1;
         while (opcion !=0) {
             System.out.println("ingrese una opcion ");
             System.out.println("1: ingrese un nuevo libro");
             System.out.println("2: prestamo");
             System.out.println("3: devolucion ");
             System.out.println("4:mostrar listado de libro ordenado por nombre ");
             System.out.println("5: mostrar listado de libros ordenados por cantidad de ejemplares");
             System.out.println("0: salir");
             opcion = sc.nextInt();
             sc.nextLine();
             String nombre;
             switch (opcion) {
                 case 1: ingresarlibro();
                     
                     break;
                 case 2:    System.out.println("ingrese el nombre del libro a prestar");
                            nombre = sc.nextLine();
                            if (buscarlibro(nombre)){ 
                                if (prestamo(nombre)){ System.out.println("se ha prestado el libro");   
                                }else System.out.println("no hay ejemplares para prestar");
                            }else System.out.println("no se encontro el nombre del libro en la BD");
                     break;
                 case 3:    System.out.println("ingrese el nombre del libro a devolver");
                            nombre = sc.nextLine();
                            if (buscarlibro(nombre)){ 
                                if (devolucion(nombre)){ System.out.println("se ha realizado la devolucion del libro");   
                                }else System.out.println("no se presto ningun ejemplar");
                            }else System.out.println("no se encontro el nombre del libro en la BD");
                     
                     break;
                 case 4: ordenpornombre();
                     
                     break;
                 case 5: ordenporejemplares();
                     
                     break;
                 case 0: System.out.println("saliendo ....");
                     
                     break;
                         
                 default:
                     System.out.println("ingrese opcion valida!!!");
             }
         }
     }       
}
