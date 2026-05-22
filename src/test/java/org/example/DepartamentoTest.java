package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {
    @Test
    void testCreacionDepartamentoYGetters(){
        // se prueba que al generar un departamento queden los datos guardados
        Departamento depto= new Departamento("Informática");
        assertEquals("Informática",depto.getNombre());
    }
    @Test
    void testSetters(){
        //se prueba que al hacer cambios estos queden guardados
        Departamento depto= new Departamento("Marketing");
        depto.setNombre("Finanzas");
        assertEquals("Finanzas",depto.getNombre());
    }
    @Test
    void testToString(){
        // se prueba que<LAinformacion al imprimor coincide
        Departamento depto = new Departamento("Recursos Humanos");
        String resultado = depto.toString();
        assertTrue(resultado.contains("Recursos Humanos"));
    }

}