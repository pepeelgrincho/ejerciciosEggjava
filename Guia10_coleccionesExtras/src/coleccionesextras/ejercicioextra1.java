/*
 1. Diseñar un programa que lea una serie de valores numéricos enteros desde el teclado
y los guarde en un ArrayList de tipo Integer. La lectura de números termina cuando se
introduzca el valor -99. Este valor no se guarda en el ArrayList. A continuación, el
programa mostrará por pantalla el número de valores que se han leído, su suma y su
media (promedio)
 */


package coleccionesextras;

import java.util.ArrayList;
import java.util.Scanner;
public class ejercicioextra1 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList();
        Integer n=0;
        while (n!=99) {
            System.out.println("ingrese un numero sale con 99");
            //n = Integer.valueOf(sc.nextInt());
            n = sc.nextInt();
            if(n !=99){
                numeros.add(n);   
            }else System.out.println("se termino la carga de numeros");   
        }
        
        Integer suma =0;
        
        if (!numeros.isEmpty()){
            for(Integer i:numeros){
                suma +=i;
            }
            System.out.println("los numeros ingresados son : ");
            numeros.forEach(Integer -> System.out.println(Integer));
            System.out.println("") ;
            System.out.println("la cantidad de numeros ingresados son : " + numeros.size());
            System.out.println("la suma de los numeros ingresados es : " + suma);
            System.out.println("el promedio de los numeros ingresados es : " + suma/numeros.size());
        }else System.out.println("la lista esta vacia");
    }

}
