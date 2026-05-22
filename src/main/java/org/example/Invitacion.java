package org.example;
import java.time.Duration;
import java.time.Instant;

/**
 * Clase que gestiona la invitación enviada a un empleado, departamento o externo.
 *
 * @author jaocSec
 */
public class Invitacion {
    private Instant hora;

    private Invitable invitado;

    /**
     * Constructor para registrar una nueva invitación asociada a una entidad.
     *
     * @param invitado entidad que recibe la invitación.
     * @param hora instante en el que se emite la invitación
     */
    public Invitacion(Invitable invitado, Instant hora){
        this.invitado= invitado;
        this.hora= hora;
    }

    public Instant getHora(){
        return hora;
    }

    public void setHora(Instant hora){
        this.hora= hora;
    }

    /**
     * Recupera a la entidad que fue invitada a la reunión.
     *
     * @return entidad de tipo Invitable que fue invitada.
     */
    public Invitable getInvitado(){
        return invitado;
    }

    public void setInvitado(Invitable invitado){
        this.invitado= invitado;
    }

    public void enviarInvitacion(){
        if (invitado != null){
            invitado.invitar();
        }
    }

    @Override
    public String toString(){
        String detalleInvitado= (invitado != null) ? invitado.toString() : "Sin destinatario";
        return "Invitacion [" + detalleInvitado + " | Fecha/Hora: " + hora + "]";
    }
}
