package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Representa a una reunión del tipo presencial.
 * Extiende a la clase Reunión.
 *
 * @author jaocSec
 */
public class ReunionPresencial extends Reunion{
    private String sala;

    /**
     * Constructor de la clase ReunionVirtual.
     *
     * @param fecha Fecha programada para la reunión
     * @param horaPrevista tiempo en el cual se iniciará la reunión
     * @param duracionPrevista Duración estimada de la reunión
     * @param organizador Empleado organizador de la reunión
     * @param tipoReunion Categoria de la reunión (TÉCNICA, MARKETING, OTRO)
     * @param sala Identificador de la sala en la que se realizará la reunión
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipoReunion, String sala) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala= sala;
    }

    /**
     * Entrega la ubicación donde se realizará la reunión.
     *
     * @return cadena de la sala de la reunión.
     */
    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return super.toString() + "Modalidad: Presencial, Sala: " + sala + "\n";
    }
}
