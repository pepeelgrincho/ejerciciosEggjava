/*La clase Simulador debe tener un método que genere un listado de alumnos manera
aleatoria y lo retorne. Las combinaciones de nombre y apellido deben ser generadas de
manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los apellidos.
• Ahora hacer un generador de combinaciones de DNI posibles, deben estar dentro de un
rango real de números de documentos. Y agregar a los alumnos su DNI. Este método
debe retornar la lista de dnis.
• Ahora tendremos un método que, usando las dos listas generadas, cree una cantidad de
objetos Alumno, elegidos por el usuario, y le asigne los nombres y los dnis de las dos
listas a cada objeto Alumno. No puede haber dos alumnos con el mismo dni, pero si con el
mismo nombre.
• Se debe imprimir por pantalla el listado de alumnos.
 */
package Entidades;

import static Comparadores.ComparadorAlumnos.compararPorVotos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author molin
 */
public class Simulador {

    private ArrayList<String> nombrecompleto; //se genera a partir de los Enum nombre y apellido
    private ArrayList<Integer> dnis; // se genera por numeros aleatorios distintos entre si
    private Random rnd; //para obtener los numeros aleatorios
    //private Nombre nombre;  los enum los llamo directamente cuando los necesito
    //private Apellido apellido;
    private int cantAlumnos = 20; //para emular la cantidad de alumnos a generar 
    private ArrayList<Alumno> Alumnos; //listado de los 20 alumnos creados
    private ArrayList<Alumno> facilitadores;
    private ArrayList<Alumno> facilitadroesSuplentes;
    private HashSet<Voto> votacion; // has de los 20 Alumnos que votaron y a quienes

    //a partirr de los enum de nombre y apellido creo nombres completos en forma aleatoria
    private void crearnombreCompleto() {
        for (int i = 0; i < cantAlumnos; i++) {
            int na = rnd.nextInt(Nombre.values().length);
            int aa = rnd.nextInt(Apellido.values().length);
            String nc = Nombre.values()[na] + " " + Apellido.values()[aa];
            //System.out.println(nc);
            nombrecompleto.add(nc);
        }
    }

    // creo los dni en forma aleatoria y comparo para que no halla repetidos
    private void crearDNI() {
        for (int i = 0; i < cantAlumnos; i++) {
            int dni = rnd.nextInt(9999999) + 20000000;
            //System.out.println(dni);
            boolean duplicado = false;
            if (!dnis.isEmpty()) {
                for (Integer d : dnis) {
                    if (d == dni) {
                        //System.out.println("es duplicado" + dni);
                        i--;
                        duplicado = true;
                        break;
                    }
                }
                if (!duplicado) {
                    dnis.add(dni);
                    //System.out.println("agrego" + dni);
                }
            } else {
                dnis.add(dni);
                //System.out.println("agrego" + dni); }
            }
        }
    }

    //creo a los Alumnos y los agrego a la lista ALumnos
    public void CrearAlumno() {
        crearnombreCompleto();// llama a crear lista de nombre completo
        crearDNI(); // llama a crear lista de dni sin duplicar
        for (int i = 0; i < cantAlumnos; i++) {
            Alumno a = new Alumno();
            a.setNombreCompleto(nombrecompleto.get(i));
            a.setCantidadVotos(0);
            a.setDNI(dnis.get(i));
            Alumnos.add(a);
        }
    }

    //muestra a los alunos creados en la lista 
    public void mostraralumnos() {

        Alumnos.forEach(Alumno -> System.out.println(Alumno));
    }

    //constructor del simulador
    public Simulador() {
        nombrecompleto = new ArrayList();
        rnd = new Random();
        dnis = new ArrayList();
        Alumnos = new ArrayList(); //listado de los 20 alumnos creados
        facilitadores = new ArrayList();
        facilitadroesSuplentes = new ArrayList();
        votacion = new HashSet();
    }

    /*Crearemos un método votación en la clase Simulador que, recibe el listado de alumnos y
para cada alumno genera tres votos de manera aleatoria. En este método debemos
guardar a el alumno que vota, a los alumnos a los que votó y sumarle uno a la cantidad de
votos a cada alumno que reciba un voto, que es un atributo de la clase Alumno.
Tener en cuenta que un alumno no puede votarse a sí mismo o votar más de una vez al
mismo alumno. Utilizar un hashset para resolver esto.*/

    public void votacion() {
        for (Alumno aux : Alumnos) {
            int cantvotos = 3; // cada alumno vota 3 veces 
            Voto voto = new Voto(); //creo objeto voto para que ingresar quien vota y los 3 a quienes voto
            voto.setAlumno(aux);
            do {
                int v = rnd.nextInt(Alumnos.size()); //voto en forma aleatoria
                if (aux.getDNI() != Alumnos.get(v).getDNI()) { //no puede votarce el mismo
                    if (!voto.getVotados().isEmpty()) { //si todavia no voto a nadie va a agregar directamente el voto

                        boolean duplicado = false;
                        for (Alumno aux2 : voto.getVotados()) { //recorro la lista de los que ya voto para comparar con el nuevo
                            if (Alumnos.get(v).getDNI() == aux2.getDNI()) { //si es igual hay que volver a votar
                                duplicado = true;
                                break;
                            }
                        }
                        if (!duplicado) { // si no esta duplicado se agrega a la lista de votados
                            Alumnos.get(v).setCantidadVotos(Alumnos.get(v).getCantidadVotos() + 1); //al sumar agrega la cantidad de votos de los otros alumnos
                            voto.agregarAlumnoVotacion(Alumnos.get(v));
                            cantvotos--; // voto reduce un voto
                        }
                    } else {
                        Alumnos.get(v).setCantidadVotos(Alumnos.get(v).getCantidadVotos() + 1);
                        voto.agregarAlumnoVotacion(Alumnos.get(v));
                        cantvotos--;
                    } // voto reduce un voto
                }
            } while (cantvotos > 0); // sale al votar 3 veces 
            votacion.add(voto); //agrego el voto del alumno y sus votos  al registro de votacion
        }
    }
    // muestro los votances y a quienes votaron
    public void MostrarVotos() {
        for (Voto aux : votacion) {
            System.out.println("el alumno que voto : ");
            System.out.println(aux.getAlumno());
            System.out.println("sus 3 votos fueron para : ");
            for (Alumno aux2 : aux.getVotados()) {
                System.out.println(aux2);
            }

        }
    }

    /*Se debe crear un método que haga el recuento de votos, este recibe la lista de Alumnos y
    comienza a hacer el recuento de votos.*/

    public void recuentoVotos() {
        Alumnos.sort(compararPorVotos);
        System.out.println("los alumnos ordenados por cantidad de votos son :");
        Alumnos.forEach(Alumno -> System.out.println(Alumno));
    }
    /* Se deben crear 5 facilitadores con los 5 primeros alumnos votados y se deben crear 5
    facilitadores suplentes con los 5 segundos alumnos más votados. A continuación, mostrar
    los 5 facilitadores y los 5 facilitadores suplentes.*/
    public void CrearFacilitadores() {
        for (int i = 0; i < 5; i++) {
            facilitadores.add(Alumnos.get(i));

        }
    }

    public void CrearFacilitadoressuplentes() {
        for (int i = 5; i < 10; i++) {
            facilitadroesSuplentes.add(Alumnos.get(i));

        }
    }
    // muestr los facilitadores titulares y suplentes
    public void mostrarFacilitadores() {
        System.out.println("los facilitadores son : ");
        facilitadores.forEach(Alumno -> System.out.println(Alumno));
        System.out.println("");
        System.out.println("los facilitadoressuplentes son : ");
        facilitadroesSuplentes.forEach(Alumno -> System.out.println(Alumno));
    }
}
