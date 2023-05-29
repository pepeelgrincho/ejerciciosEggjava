
package Servicio;

import Entidades.Butaca;
import Entidades.Cine;
import Entidades.Espectadores;
import Entidades.Pelicula;
import Entidades.Sala;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author molin
 */
public class ServicioCine {
    
    private Cine cine = new Cine();
    private String letras = "ABCDEF"; //letras para completar las columnas de la sala
    private  int  filas = 8; //filas de la sala
    private  int  columnas = letras.length();
    private Butaca [][] matriz = new Butaca[filas][columnas]; // matriz simula la sala
    
    
    Sala sala = new Sala();
    ArrayList<Espectadores> espectadores = new ArrayList();
    //se crearon posibles espectadores con edades y dinero al asar
    public void CrearEspectadores(){
        espectadores.add(new Espectadores("jose",44,1000.1));
        espectadores.add(new Espectadores("pancho",42,500.1));
        espectadores.add(new Espectadores("luis",41,300.1));
        espectadores.add(new Espectadores("lean",40,600.1));
        espectadores.add(new Espectadores("cristian",15,700.1));
        espectadores.add(new Espectadores("marcos",10,200.1));
        espectadores.add(new Espectadores("juan",17,100.1));
        espectadores.add(new Espectadores("celina",12,10000.1));
        espectadores.add(new Espectadores("hernan",6,900.1));
        espectadores.add(new Espectadores("pepe",14,800.1));  
    }
    
    //se crea el cine con la pelicula precio y edad minima
    public void crearCine(){
        cine.setSala(sala);
        cine.setPrecioEntrada(1500.0);
        cine.setPeli(new Pelicula("star", "lucas", 500.0, 45));
    }
    
    
    public void rellenarSala() {
        int ocupacion = 0;
        //nombra a todos los espectadores que ingresan a la sala 
        System.out.println("los espectadores que ingresaron son :");
        for (Espectadores espectador : espectadores) {
            if (espectador.getDineroDisp() >= cine.getPrecioEntrada() && espectador.getEdad() >= cine.getPeli().getEdadMin()) {
                Random rnd = new Random();
                boolean ingreso;
                do {
                    ingreso = false;
                    int fila = rnd.nextInt(filas);
                    int letra = rnd.nextInt(columnas);

                    if (!cine.getSala().getButaca()[fila][letra].isOcupado()) {
                        matriz[fila][letra].setEspectador(espectador);
                        matriz[fila][letra].setOcupado(true);
                        sala.setButaca(matriz);
                        cine.setSala(sala);
                        ocupacion++;
                        ingreso = true;
                        System.out.println("espectador : " + espectador.getNombre());
                    }
                } while (ocupacion < (filas*columnas) && !ingreso);
            }
        }
    }

    //crear sala vacia
    public void crearSala() {    
        for (int i = filas; i > 0; i--) {
            for (int j = 0; j < columnas; j++) {
                Butaca butaca = new Butaca();
                butaca.setFilas(i);
                butaca.setLetra(letras.charAt(j));
                butaca.setOcupado(false);
                matriz[i - 1][j] = butaca;
            }
        }
        sala.setButaca(matriz);
    }
    
    // muestra la sala con las butacas libres y/o ocupadas X ocupadas L libres 
    public void mostrarSala() {
        System.out.println("");
        System.out.println("la sala de cine : ");
        //la matriz de la butaca va de 7 a 0 filas 
        for (int i = filas; i > 0; i--) {
            for (int j = 0; j < columnas; j++) {
                if (sala.getButaca()[i - 1][j].isOcupado()) {
                    System.out.print(sala.getButaca()[i - 1][j].getFilas() + "" + sala.getButaca()[i - 1][j].getLetra() + "X  ");
                } else {
                    System.out.print(sala.getButaca()[i - 1][j].getFilas() + "" + sala.getButaca()[i - 1][j].getLetra() + "L  ");
                }
            }
            System.out.println("");
        }
    }
    
    
    
    
}
