package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotaTest {
    @Test
    void testCreacionYGetter() {
        // se prueba que al crear la nota esta guarde bien el texto
        Nota nota = new Nota("Revisar presupuesto anual");
        assertEquals("Revisar presupuesto anual", nota.getContenido(), "El contenido no coincide con el original");
    }

    @Test
    void testSetter() {
        //se prueba que el setter cambie el texto correctamente
        Nota nota = new Nota("Texto inicial");
        nota.setContenido("Texto modificado");
        assertEquals("Texto modificado", nota.getContenido(), "El setter no actualizó el texto");
    }

    @Test
    void testToString() {
        // se prueba que el toString devuelva una descripcion relevante
        Nota nota = new Nota("Traer proyector");
        String resultado = nota.toString();
        assertTrue(resultado.contains("Traer proyector"), "El toString no incluye el contenido de la nota");
    }

}