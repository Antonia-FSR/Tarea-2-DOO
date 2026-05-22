package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;

class RetrasoTest {
    @Test
    void testCreacionYGetter() {
        // se prueba que al generar el retraso se guarde la hora exacta
        Empleado empleado= new Empleado("1", "Perez", "Juan", "juan@gmail.com");
        Instant momentoActual = Instant.now();
        Retraso retraso = new Retraso(empleado, momentoActual);

        assertEquals(momentoActual, retraso.getHora());
    }
    @Test
    void testSetter() {
        // se prueba que al hacer los cambios se guarden
        Empleado empleado= new Empleado("2", "Gomez", "Ana", "ana@gmail.com");
        Retraso retraso = new Retraso(empleado, Instant.now());

        // una hora inventada para probar el cambio
        Instant nuevaHora = Instant.parse("2031-07-09T10:15:30Z");
        retraso.setHora(nuevaHora);

        assertEquals(nuevaHora, retraso.getHora());
    }

    @Test
    void testToString() {
        Empleado empleado = new Empleado("3", "Torres", "Luis", "luis@gmail.com");
        // se prueba que la informacion al imprimir sea la correcta
        Instant horaFija = Instant.parse("1984-10-02T11:18:41Z");
        Retraso retraso = new Retraso(empleado, horaFija);

        assertTrue(retraso.toString().contains("1984-10-02T11:18:41Z"));
    }

}