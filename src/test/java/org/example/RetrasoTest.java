package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Instant;

class RetrasoTest {
    @Test
    void testCreacionYGetter() {
        // se prueba que al generar el retraso se guarde la hora exacta
        Instant momentoActual = Instant.now();
        Retraso retraso = new Retraso(momentoActual);

        assertEquals(momentoActual, retraso.getHora());
    }
    @Test
    void testSetter() {
        // se prueba que al hacer los cambios se guarden
        Retraso retraso = new Retraso(Instant.now());

        // una hora inventada para probar el cambio
        Instant nuevaHora = Instant.parse("2031-07-09T10:15:30Z");
        retraso.setHora(nuevaHora);

        assertEquals(nuevaHora, retraso.getHora());
    }

    @Test
    void testToString() {
        // se prueba que la informacion al imprimir sea la correcta
        Instant horaFija = Instant.parse("1984-10-02T11:18:41Z");
        Retraso retraso = new Retraso(horaFija);

        assertTrue(retraso.toString().contains("1984-10-02T11:18:41Z"));
    }

}