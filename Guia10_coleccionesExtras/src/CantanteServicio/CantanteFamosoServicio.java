/*
 2. Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos y
tendrá como atributos el nombre y discoConMasVentas.
Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar 5
objetos de tipo CantanteFamoso a la lista. Luego, se debe mostrar los nombres de
cada cantante y su disco con más ventas por pantalla.
Una vez agregado los 5, en otro bucle, crear un menú que le de la opción al usuario de
agregar un cantante más, mostrar todos los cantantes, eliminar un cantante que el
usuario elija o de salir del programa. Al final se deberá mostrar la lista con todos los
cambios.
 */
package CantanteServicio;

import Entidades.CantanteFamoso;
import static comparadores.comparadorCantantes.ordenarpornombreasc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class CantanteFamosoServicio {
    private Scanner sc;
    private ArrayList<CantanteFamoso> c ;
    private final int cantantesinicial = 3;

    public CantanteFamosoServicio() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.c = new ArrayList();
    }
    private void agregarCantante(){
        boolean bandera = false;
        System.out.println("ingrese el nombre del cantante");
        String nombre = sc.nextLine();
        if (!c.isEmpty()){
            for(CantanteFamoso x:c){
                if (x.getNombre().equalsIgnoreCase(nombre)){
                    System.out.println("el nombre que ingreso ya esta en la lista");
                    bandera = true;
                }
            }
        }
        if (!bandera){
            System.out.println("ingrese el disco Con Mas Ventas");
            String disco = sc.nextLine();
            c.add(new CantanteFamoso(nombre,disco));
            System.out.println("se agrego el cantante y su disco correctamente");
        }
    }
    public void mostrarCantantes(){  
        System.out.println("el listado de los cantantes y su disco mas vendido es el siguiente : ");
        c.sort(ordenarpornombreasc);
        c.forEach(CantanteFamoso -> System.out.println(CantanteFamoso));   
    }
    public void ingresarCantantesInicial(){
        System.out.println("va a ingresar los 5 primeros cantantes : ");
        for (int i = 1; i < cantantesinicial+1; i++) {
                System.out.println("");
                System.out.println("ingrese los datos del cantante : "+ i );
                System.out.println("");
                agregarCantante();
                if (c.size()<i){
                    i--;
                }
        }
    }
    public void menu(){
        int opcion = 1;
        while (opcion!=0) {
            System.out.println("ingrese opcion :");
            System.out.println("1: ingresar nuevo cantante y su disco mas vendido");
            System.out.println("2: mostrar todos los cantantes con sus discos");
            System.out.println("3: eliminar un cantante y su disco mas vendido");
            System.out.println("0: para salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1: agregarCantante();
                    
                    break;
                case 2:  mostrarCantantes();
                    
                    break;
                case 3: eliminarCantante();
                    
                    break;
                case 0: mostrarCantantes();
                        System.out.println("saliendo ....");
                    
                    break;
                default:
                    System.out.println("ingrese una opcion valida");
            }
        }
    }
    private void eliminarCantante() {
        System.out.println("ingrese nombre del cantante a eliminar");
        String nombre = sc.nextLine();
        if (!c.isEmpty()) {
            Iterator<CantanteFamoso> iterator = c.iterator();

            while (iterator.hasNext()) {
                if (iterator.next().getNombre().equalsIgnoreCase(nombre)) {
                    iterator.remove();
                    System.out.println("el cantante a sido borrado");
                }
            }
        } else System.out.println("la lista de cantantes esta vacia");
        
    }
    
    
}
