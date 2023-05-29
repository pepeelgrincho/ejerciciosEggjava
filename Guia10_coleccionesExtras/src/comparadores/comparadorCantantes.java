/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparadores;

import Entidades.CantanteFamoso;
import java.util.Comparator;

/**
 *
 * @author molin
 */
public class comparadorCantantes {
    public static Comparator<CantanteFamoso> ordenarpornombreasc = new Comparator<CantanteFamoso> (){
        
        @Override
        public int compare(CantanteFamoso t, CantanteFamoso t1) {
            return t.getNombre().compareTo(t1.getNombre());
        }
        
    };
}
