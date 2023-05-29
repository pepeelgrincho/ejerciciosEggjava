/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import static Utilidades.PeliculasComparadores.ordenarpordirectorasc;
import static Utilidades.PeliculasComparadores.ordenarporduracionasc;
import static Utilidades.PeliculasComparadores.ordenarporduraciondesc;
import static Utilidades.PeliculasComparadores.ordenarpornombreasc;
import entidades.Pelicula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class PeliculaServicio {
    Scanner sc;
    ArrayList<Pelicula> cine ;

    public PeliculaServicio() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.cine = new ArrayList();
    }
    
    private void creasPelicula(){
        System.out.println("ingrese nombre de Pelicula");
        String nombre = sc.nextLine();
        System.out.println("ingrese director de la pelicula");
        String director = sc.nextLine();
        System.out.println("ingrese duracion de la pelicula");
        double duracion = sc.nextDouble();
        sc.nextLine();
        cine.add(new Pelicula(nombre,director,duracion));
    }
    public void crearPeliculas(){
        //cargar las peliculas  y agrega en la lista hasta que bandera n
        String bandera;
        do {
            creasPelicula();
            System.out.println("desea ingresar otra pelicula S/N");
            bandera = sc.next();     
            sc.nextLine();
        } while (!bandera.equalsIgnoreCase("n"));
        MostrarPeliculas(); //muestras las peliculas al final de la carga
    } 
    public void MostrarPeliculas(){
        if (!cine.isEmpty()){
            if (cine.size()>1){
                System.out.println("listado de peliculas del cine : ");
                cine.forEach(Pelicula -> System.out.println(Pelicula.toString()));
            }else { System.out.println("la pelicula en el cine es : ");
            cine.forEach(Pelicula -> System.out.println(Pelicula.toString()));}
                    
        }else System.out.println("no hay Peliculas en el cine");       
    }
    
    private void MostrarPeliculasporNombre() {
        System.out.println("");
        System.out.println("listado de peliculas del cine ordenadas por nombre: ");
        cine.sort(ordenarpornombreasc);
        cine.forEach(Pelicula -> System.out.println(Pelicula));
        
    }
    private void MostrarPeliculaspordirector() {
        System.out.println("listado de peliculas del cine ordenadas por director: ");
        cine.sort(ordenarpordirectorasc);
        cine.forEach(Pelicula -> System.out.println(Pelicula));
       
    }
    public void MostrarPeliculasporduracionasc() {
        System.out.println("listado de peliculas del cine ordenadas por duracion ascendente: ");
        cine.sort(ordenarporduracionasc);
        cine.forEach(Pelicula -> System.out.println(Pelicula));
        /*for (Pelicula aux : cine){
                    System.out.println(aux.toString());  
                }*/
    }
    public void MostrarPeliculasporduraciondesc() {
        System.out.println("listado de peliculas del cine ordenadas por duracion descendente: ");
        //cine.sort(ordenarporduraciondesc);
        cine.sort(ordenarporduraciondesc.reversed());
        cine.forEach(Pelicula -> System.out.println(Pelicula));
        /*for (Pelicula aux : cine){
                    System.out.println(aux.toString());  
                }*/
    }
    public void MostrarPeliculasMenorHora() {
        System.out.println("");
        System.out.println("listado de peliculas del cine con duracion menor a la hora : ");
        for (Pelicula aux : cine) {
            if (aux.getDuracion() < 1) {
                System.out.println(aux);
            }
        }
    }
    public void MostrarPeliculasOpciones(){     
        if (!cine.isEmpty()){
            if (cine.size()>1){
                int opcion;
                System.out.println("");
                do {
                    System.out.println("mostrar peliculas segun la selecion de opciones:");
                    System.out.println("");
                    System.out.println("ingrese opcion deseada \n "
                    + "1: ordenada por nombre \n"
                    + "2: ordenada por director \n"
                    + "3: duracion menos de una hora \n"
                    + "4: ordenada por duracion ascendente \n"
                    + "5: ordenada por duracion desendente \n"
                    + "0: salir");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1: MostrarPeliculasporNombre();
                            break;
                        case 2: MostrarPeliculaspordirector();
                        
                            break;
                        case 3:MostrarPeliculasMenorHora();
                        
                            break;
                        case 4:MostrarPeliculasporduracionasc();
                        
                            break;
                        case 5:MostrarPeliculasporduraciondesc();
                        
                            break;
                        case 0:System.out.println("saliendo..");;
                        
                            break;
                        default:
                            System.out.println("ingrese una opcion valida");
                }
                } while (opcion !=0);
                
                
            }else { if (cine.get(0).getDuracion()>1){
                System.out.println("la unica pelicula en el cine es : ");
                System.out.println(cine.get(0).toString());}
            }
                    
        }else System.out.println("No hay Peliculas en el cine para mostrar");       
    }
}
