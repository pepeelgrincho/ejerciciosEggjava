/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Perro;
import Entidades.Persona;
import Enum.Raza;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author molin
 */
public class PersonaPerroServicio {
   private Scanner sc;
     private ArrayList<Persona> humano;
    private ArrayList<Perro> animal;

    public PersonaPerroServicio() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.humano = new ArrayList();
        this.animal = new ArrayList();
    }
    private boolean crearPersona(int documento) {
        
        boolean creo =false;
        boolean existe = false;
        if (!humano.isEmpty()) {
            for (Persona p : humano) {
                if (p.getDocumento() == documento) {
                    existe = true;
                    creo = false;
                    break;
                }
            }
        }
        if (!existe) {
            Persona h = new Persona();
            h.setDocumento(documento);
            System.out.println("ingrese nombre de la persona");
            h.setNombre(sc.nextLine());
            System.out.println("ingrese apellido de la persona");
            h.setApellido(sc.nextLine());
            System.out.println("ingrese edad de la persona");
            h.setEdad(sc.nextInt());
            sc.nextLine();
            humano.add(h);
            creo = true;
            System.out.println("se ingreso la persona correctamente");

        } else {
            System.out.println("el documento ya esta en la lista");
            creo= false;
        }
        return creo;
    }
   public void agregarPersonas(){
       boolean salir ;
       int documento;
        do {
            salir = false;
            System.out.println("ingrese documento de la persona, ingrese 0 para no cargar mas ");
            documento = sc.nextInt();
            sc.nextLine();
            if (documento == 0) {
                if (humano.isEmpty()){
                    System.out.println("no se ha ingresado ninguna persona");
                    System.out.println("desea salir de todas formas S/N");
                    String opcion = sc.next();
                    sc.nextLine();
                    if (opcion.equalsIgnoreCase("s")){
                        salir = true;
                    } else salir = false;
                } else salir = true;
            } else if (documento < 99999999 || documento > 10000000) {
                if (!crearPersona(documento)) {
                    salir = false;
                }
            }
            
        } while (!salir);
        
    }
    private boolean crearPerro(String nombre) {   
        boolean creo = false;
        
        boolean existe = false;
        if (!animal.isEmpty()) {
            for (Perro p : animal) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    existe = true;
                    creo = false;
                    break;
                }
            }
        }
        if (!existe) {
            Perro p=new Perro();
            p.setNombre(nombre);
            int  raza;
            do {
                System.out.println("ingrese la raza del perro");
                int i=0;
                for (Raza r : Raza.values()) {
                    System.out.println(i + " : " + r.toString() );
                    i++;
                }
                raza = sc.nextInt();
                sc.nextLine(); 
            } while (raza<0 && raza < Raza.values().length);
            p.setRaza(Raza.values()[raza]); //asigno el valor del enum 
            
            System.out.println("ingrese el tamaño del perro");
            p.setTamanio(sc.nextLine());
            System.out.println("ingrese edad del perro");
            p.setEdad(sc.nextInt());
            sc.nextLine();
            animal.add(p);
            creo = true;
            System.out.println("se ingreso el animal correctamente");
        } else {
            System.out.println("el nombre del perro ya esta en la lista");
            creo= false;
        }
        return creo;
    }
    public void agregarPerros() {
        String nombre;
        boolean salir;
        do {
            salir = false;
            System.out.println("ingrese nombre del perro, enter para salir ");
            nombre = sc.nextLine();
            if (!nombre.equalsIgnoreCase("")) { //si es distinto a vacio voy a crear el perro
                if (!crearPerro(nombre)) { // si no se ingreso el perro vuelvo a ingresar otro
                    salir = false;
                }
            } else {
                salir = true;
            }
        } while (!salir);
    }
    /* Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.*/
    
   
   
    public void unirPersonaPerro() {
        System.out.println("adopcion de animales : ");
        System.out.println("*************************");
        int perroseleccionado = 99;
        ArrayList<String> pa = new ArrayList(); //listado de perros adoptados

        for (Persona p : humano) {
            boolean verificar = true;
            do {
                System.out.println("para " + p.getNombre() + " " + p.getApellido() + " seleccione uno de los siguientes perros :");
                System.out.println("");
                //muestro los perros disponibles sin los ya seleccionados si no hay perros disponibles salimos de la persona
                if (MostrarPerrosDisponibles(pa)){
                    System.out.println("no hay mas perros para adoptar");
                    break;
                }
                //leo el perro que ingreso el usuario 
                perroseleccionado = sc.nextInt();
                sc.nextLine();
                //el numero seleccionado debe ser menos al total del tamaño de la lista
                if (perroseleccionado < animal.size()) { 
                    verificar = true;
                    if (!pa.isEmpty()) {
                        for (String nombre : pa) {
                            if (nombre.equalsIgnoreCase(animal.get(perroseleccionado).getNombre())) {
                                System.out.println("el perro seleccionado ya esta adoptado");
                                verificar = false;
                                break;
                            }
                        }

                    }
                    if (verificar) {
                        // le agrego al array de perros en la persona el perro seleccionado
                        p.AgregarPerro(animal.get(perroseleccionado));     
                        System.out.println(p.getNombre() + " adopto a " + animal.get(perroseleccionado).getNombre());
                        pa.add(animal.get(perroseleccionado).getNombre());
                        System.out.println("");
                        
                        System.out.println("desea adoptar un perro mas para " + p.getNombre() + " " + p.getApellido()+" S/N");
                        String opcion = sc.next();
                if (opcion.equalsIgnoreCase("S")){
                    verificar = false;
                }
                    }
                } else {
                    System.out.println("seleccione un numero entre los dados");
                }
                
                    
            } while ( perroseleccionado < 0 || !verificar);

        }

    }
   public void mostrarPersonaPerro(){
       System.out.println("los datos de las personas son ");
       for(Persona p: humano){
           System.out.println(p);
           System.out.println("y su perro es : ");
           if (!p.getP().isEmpty()){
               for (Perro pe : p.getP()) {
                   System.out.println(pe);
               }
           } else System.out.println("no adopto ningun perro");

           System.out.println("");
       }
   }
   private boolean MostrarPerrosDisponibles(ArrayList<String> pa){
       boolean vacio = false;
       boolean verificar=true;
                //muestra el listado de perros disponibles 
                for (int i = 0; i < animal.size(); i++) {
                    verificar=true;
                    vacio = false;
                    if (!pa.isEmpty()) {
                        for (String nombre : pa) {
                            if (nombre.equalsIgnoreCase(animal.get(i).getNombre())) {
                                verificar = false;
                            }
                        }
                    }
                    if (verificar) {
                        System.out.println(i + ": " + animal.get(i).getNombre());
                    }else vacio= true;
                }
        return vacio;
   }
}
