/*
 El sistema de votación de Egg tiene una clase llamada Alumno con los siguientes atributos:

nombre completo, DNI y cantidad de votos.
 */
package Entidades;

/**
 *
 * @author molin
 */
public class Alumno {
    private String nombreCompleto;
    private Integer DNI;
    private Integer CantidadVotos;

    @Override
    public String toString() {
        return "Alumno{" + "nombre Completo=" + nombreCompleto + ", DNI=" + DNI + ", Cantidad de Votos=" + CantidadVotos + '}';
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Integer getCantidadVotos() {
        return CantidadVotos;
    }

    public void setCantidadVotos(int CantidadVotos) {
        this.CantidadVotos = CantidadVotos;
    }
    public Alumno() {
    }
    
}
