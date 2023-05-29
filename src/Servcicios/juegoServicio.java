/*
 
 */
package Servcicios;

import Entidades.Juego;
import Entidades.Jugador;
import Entidades.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class juegoServicio {
    private Juego j  ;
    Scanner sc ;

    public juegoServicio() {
        j = new Juego();
        sc =new Scanner(System.in);
    }
    public void iniciarJuego(){
        System.out.println("ruleta rusa de agua ");
        System.out.println("*********************");
        int jugadores ;
        do { //es para que ingrese la cantidad de jugadores si es mas de 6 se hacen 6
            System.out.println("ingrese cantidad de jugadores entre 1 y 6  ");
            jugadores = sc.nextInt();
            sc.nextLine();
            if (jugadores >0 ){
                if (jugadores > 6){
                    jugadores = 6;
                }
            }
        } while (jugadores <1);
        //creo la lista de  jugadores para pasarcelo al juego 
        ArrayList<Jugador> listaj = new ArrayList();
        for (int i = 0; i < jugadores; i++) {
            Jugador juga = new Jugador(i+1);
            listaj.add(juga);
        }
        j.llenarJuego(listaj, new RevolverDeAgua());  
    }
    public void jugar(){
        int ID;
        do {
            ID = j.ronda();
            if (ID!=99){
                System.out.println("el juego a terminado");
                System.out.println("el jugador mojado es el jugador" + ID);
            }
        } while (ID==99);
        
        
    }
    
}
