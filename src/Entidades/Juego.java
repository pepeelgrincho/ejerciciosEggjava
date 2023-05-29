/*
 Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.

10
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
package Entidades;

import Entidades.Jugador;
import Entidades.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class Juego {
    private ArrayList<Jugador>jugadores ;
    private RevolverDeAgua r;  

    public Juego() {
        this.jugadores = new ArrayList();
        this.r = new RevolverDeAgua();
    }    
    public void llenarJuego(ArrayList<Jugador>jugadores, RevolverDeAgua r){
        for(Jugador j:jugadores){
            this.jugadores.add(j);
        }
        r.llenarRevolver();
        this.r = r;
        System.out.println("la posicion actual" +r.getPosicionActual());
        System.out.println("la posicion del agua" + r.getPosicionAgua());
    }
    /*ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.*/
    public int ronda(){
        int ID = 99;
        for(Jugador j:jugadores){
            if (j.disparo(r)){
                ID = j.getID();
                j.setMojado(true);
                break;
            }
        }
        return ID;
    }
}
