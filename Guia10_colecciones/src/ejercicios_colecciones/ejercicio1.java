/*
 Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.
 */
package ejercicios_colecciones;

import Servicios.RazasServicio;


public class ejercicio1 {

    
    public static void main(String[] args) {
       RazasServicio rs = new RazasServicio();
       rs.fabricaRazas();
       rs.MostrarMascotas();
       rs.borrarRaza();
       
        
            
        
    }

}
