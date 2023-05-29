/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author molin
 */
public class Baraja {

    ArrayList<Carta> mazonuevo = new ArrayList();
    

    public Baraja() {
        for (EnumPalo aux : EnumPalo.values()) {
            for (int i = 1; i < 13; i++) {
                if (i != 8 && i != 9) {
                    Carta naipe = new Carta();
                    naipe.setPalo(aux);
                    naipe.setNumero(i);
                    mazonuevo.add(naipe);
                }
            }
        }
    }
    

    public ArrayList<Carta> getMazonuevo() {
        return mazonuevo;
    }

    public void setMazonuevo(ArrayList<Carta> mazonuevo) {
        this.mazonuevo = mazonuevo;
    }

    @Override
    public String toString() {
        return "Baraja{" + "mazonuevo=" + mazonuevo + '}';
    }
    

    
    
}
