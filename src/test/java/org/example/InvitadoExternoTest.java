package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvitadoExternoTest {

    @Test
    void testCreacionInvitadoExterno() {

        InvitadoExterno invitado = new InvitadoExterno("Carlos Ramirez", "carlos@gmail.com");

        assertEquals("Carlos Ramirez", invitado.getNombreCompleto());

        assertEquals("carlos@gmail.com", invitado.getCorreo());
    }

    @Test
    void testSetters() {

        InvitadoExterno invitado = new InvitadoExterno( "A", "a@gmail.com");

        invitado.setNombreCompleto("Pedro Soto");
        invitado.setCorreo("pedro@gmail.com");

        assertEquals("Pedro Soto", invitado.getNombreCompleto());

        assertEquals("pedro@gmail.com", invitado.getCorreo());
    }

    @Test
    void testToString() {

        InvitadoExterno invitado = new InvitadoExterno("Maria Lopez", "maria@gmail.com");

        String resultado = invitado.toString();

        assertTrue(resultado.contains("Maria Lopez"));
        assertTrue(resultado.contains("maria@gmail.com"));
    }


}
