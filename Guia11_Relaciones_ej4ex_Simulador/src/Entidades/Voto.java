/*
 Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como atributos,
un objeto Alumno que será el alumno que vota y una lista de los alumnos a los que votó.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author molin
 */
public class Voto {
    private Alumno alumno; //alumno que vota 
    private ArrayList<Alumno> votados; //los 3 alumnos a losque vota 

    public ArrayList<Alumno> getVotados() {
        return votados;
    }

   
    public void agregarAlumnoVotacion(Alumno a){
        votados.add(a);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    

    public Voto() {
        this.votados = new ArrayList();
    }
}
