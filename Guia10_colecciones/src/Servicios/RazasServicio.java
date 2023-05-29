/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Utilidades.RazasComparadores;
import entidades.Razas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class RazasServicio {
    private Scanner sc;
    private ArrayList<Razas> m; 

    public RazasServicio() {
        this.sc = new Scanner(System.in);
        this.m = new ArrayList();
    }
    private void CrearMascota(){
        System.out.println("ingrese raza de mascota");
        Razas r = new Razas();
        r.setNombre(sc.next());
        m.add(r);
    }
    public void fabricaRazas(){
        //cargar las razas y agrega en la lista hasta que bandera n
        String bandera;
        do {
            CrearMascota();
            System.out.println("desea ingresar otra raza S/N");
            bandera = sc.next();     
        } while (!bandera.equalsIgnoreCase("n"));
    }
    public void MostrarMascotas() {
        System.out.println("las razas de perros ingresadas son : ");
        for (Razas aux : m) {
            System.out.println(aux);
        }

    }
    /*Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
la lista ordenada.*/
    public void borrarRaza(){
        Iterator<Razas> it =  m.iterator();
        String razaborrar;
        System.out.println("ingrese la raza a borrar");
        boolean borro = false;
        razaborrar=sc.next();
        while(it.hasNext()){
            if (it.next().getNombre().equals(razaborrar)){
                it.remove();
                borro = true;
                
            }
        }
        //Collections.sort(m);
        
        //Collections.sort(m, RazasComparadores.ordenarPorNombre);
        //m.sort(RazasComparadores.ordenarPorNombre);
       
        if (borro){
            System.out.println("la raza a sido borrada");
        }else System.out.println("la raza no se encontro no se pudo borrar");
        //
        System.out.println("las razas ordenadas quedan de la siguiente manera : ");
        for(Razas aux:m){
            System.out.println(aux.toString());
        }
        
    }
            
            
            
}
        
    
    

