package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoReunionTest {
    @Test
    void testEnumValues() {
        // se verifica que los valores existan
        assertNotNull(TipoReunion.valueOf("TECNICA"));
        assertNotNull(TipoReunion.valueOf("MARKETING"));
        assertNotNull(TipoReunion.valueOf("OTRO"));
    }

    @Test
    void testEnumValuesCount() {
        //se verifica que existan 3 tipos de reuniones
        TipoReunion[] tipos = TipoReunion.values();
        assertEquals(3, tipos.length, "Debe haber exactamente 3 tipos de reunión");
    }

}