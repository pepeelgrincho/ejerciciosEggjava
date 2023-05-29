/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import static Utilidades.PaisComparador.CompararPornombre;
import entidades.Pais;
import entidades.Razas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class PaisServicio {
    private Scanner sc; 
    private HashSet<Pais> p ;

    public PaisServicio() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.p = new HashSet ();
    }
    
    private void crearPais(){
        System.out.println("ingrese un pais");
        String nombre= sc.nextLine();
        p.add(new Pais(nombre));
    }
    public void ingresarPaices(){        
        String bandera;
        do {
            crearPais();
            System.out.println("desea ingresr otro pais s/n");
            bandera=sc.next().toLowerCase();
            sc.nextLine();
        } while (!bandera.equalsIgnoreCase("n"));
    }
    
    public void mostrarPaices(){
        p.forEach(Pais -> System.out.println(Pais));
        System.out.println("");
    }
    
    public void ordenarYMostrar(){
        ArrayList<Pais> pl = new ArrayList(p);
        //Collections.sort(pl);
        pl.sort(CompararPornombre);
        System.out.println("los paices en el conjunto son : ");
        pl.forEach(Pais -> System.out.println(Pais) );
        System.out.println("");
    }
    public void borrarPais() {
        System.out.println("ingrese el pais a borrar");
        String nombre = sc.nextLine();
        Boolean bandera = false;
        for (Iterator<Pais> iterator = p.iterator(); iterator.hasNext();) {
            if (iterator.next().getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                bandera = true;
            }

        }
        if (bandera) {
            System.out.println("se borro el pais solicitado");
        } else {
            System.out.println("el pais ingresado no se encuentra en el conjunto");
        }
        ordenarYMostrar();
        
    }
}        

