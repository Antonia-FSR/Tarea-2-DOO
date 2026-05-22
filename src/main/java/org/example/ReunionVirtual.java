package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;


/**
 * Representa a una reunión del tipo virtual.
 * Extiende a la clase Reunión.
 *
 * @author jaocSec
 */
public class ReunionVirtual extends Reunion {
    private String enlace;

    /**
     * Constructor de la clase ReunionVirtual.
     *
     * @param fecha Fecha programada para la reunión
     * @param horaPrevista tiempo en el cual se iniciará la reunión
     * @param duracionPrevista Duración estimada de la reunión
     * @param organizador Empleado organizador de la reunión
     * @param tipoReunion Categoria de la reunión (TÉCNICA, MARKETING, OTRO)
     * @param enlace enlace URL o link de acceso a la llamada
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipoReunion, String enlace){
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.enlace= enlace;
    }

    /**
     * Entrega el enlace de conexión a la reunión.
     *
     * @return cadena del URL de la reunión.
     */
    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return super.toString() + "Modalidad: Virtual, Enlace: " + enlace + "\n";
    }
}
