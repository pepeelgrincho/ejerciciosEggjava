/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidades.Baraja;
import Entidades.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class juegoServicio {
    ArrayList<Carta> mazoarepartir = new ArrayList();
    ArrayList<Carta> mazorepartido = new ArrayList();
    Baraja b =new Baraja();
    
    public void barajar(){
        for (Carta carta : b.getMazonuevo()) {
            mazoarepartir.add(carta);
        }
        Collections.shuffle(mazoarepartir) ;
        
        
    }
    
    public void mostrar(){
        System.out.println("la cantidad de cartas en el mazo es " + b.getMazonuevo().size());
        b.getMazonuevo().forEach(Carta -> System.out.println(Carta));
        
    }
    
    /*siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
se haya llegado al final, se indica al usuario que no hay más cartas.*/
    private void siguienteCarta(){
        
        mazorepartido.add(mazoarepartir.get(0));
        mazoarepartir.remove(0);       
            
        }
        public void darCartas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("cuantas quiere : ");
        int c = sc.nextInt();
        sc.nextLine();
        if (c <= mazoarepartir.size()) {

            for (int i = 0; i < c; i++) {
                siguienteCarta();
            }
        }else {System.out.println("no hay suficiente cartas");
            System.out.println("quedan "+ mazoarepartir.size() + " cartas");
        }
    }
        public void cartasDisponibles(){
            System.out.println("quedan "+ mazoarepartir.size() + " cartas");
        }
        
        /*cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
luego se llama al método, este no mostrara esa primera carta.*/
        public void cartasentregadas (){
            if (!mazorepartido.isEmpty()){
                System.out.println("las cartas repartidas son :");
                mazorepartido.forEach(Carta -> System.out.println(Carta));
            }else {System.out.println("no se han repartido cartas ");}
        }
        public void cartasarepartir(){
            if (!mazoarepartir.isEmpty()){
                System.out.println("las cartas que quedan en el mazo son :");
                System.out.println("");
                mazoarepartir.forEach(Carta -> System.out.println(Carta));
            }else {System.out.println("se han repartidos todas las cartas");}

        }
}
