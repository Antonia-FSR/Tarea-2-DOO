package org.example;
import java.time.Instant;

/**
 * representa el instanto que el empleado llego tarde a la reunion
 * @author Antonia-FSR
 */
public class Retraso {
    private Instant hora;

    public Retraso(Instant hora) {
        this.hora = hora;
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * @return Cadena de texto con la hora del retraso
     */
    @Override
    public String toString() {
        return "Retraso en el instante: " + hora.toString();
    }
}
