package org.example;

/**

 Representa un invitado externo a la empresa
 que puede participar en una reunión.
 @author 9ghtBug
 */
public class InvitadoExterno implements Invitable {

    private String nombreCompleto;
    private String correo;

    /**
     Constructor de la clase InvitadoExterno.

     @param nombreCompleto nombre del invitado externo
     @param correo correo electrónico del invitado
     */
    public InvitadoExterno(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     Envía invitación al invitado externo.
     */
    @Override
    public void invitar() {

        System.out.println("Enviando invitación a externo: "+correo);
    }

    /**
     Convierte el invitado externo a String.

     @return información descriptiva del invitado.
     */
    @Override
    public String toString() {

        return "Invitado Externo [Nombre: "+nombreCompleto+", Correo: "+correo+ "]";
    }
}