package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    @Test
    void testCreacionEmpleadoYGetters() {
        // se prueba que al generar al empleado se guarden
        Empleado emp = new Empleado("58", "Sandoval", "Florencia", "Florencia.Sandoval@empresa.com");

        assertEquals("58", emp.getId());
        assertEquals("Florencia", emp.getNombre());
        assertEquals("Sandoval", emp.getApellidos());
        assertEquals("Florencia.Sandoval@empresa.com", emp.getCorreo());
    }
    @Test
    void testSettersEmpleado() {
        // se prueba que al hacer los cambios se guarden
        Empleado emp = new Empleado("23", "Reyes", "Gustavo", "Gustavo.Reyes@empresa.com");
        emp.setId("15");
        emp.setNombre("Bastian");
        emp.setApellidos("Hidalgo");
        emp.setCorreo("Bastian.Hidalgo@empresa.com");

        assertEquals("15",emp.getId());
        assertEquals("Bastian", emp.getNombre());
        assertEquals("Hidalgo",emp.getApellidos());
        assertEquals("Bastian.Hidalgo@empresa.com", emp.getCorreo());
    }
    @Test
    void testToString() {
        // se prueba que la informacion al imprimir sea la correcta
        Empleado emp = new Empleado("77", "Gomez", "Ana", "Ana.Gomez@empresa.com");
        String resultado = emp.toString();

        assertTrue(resultado.contains("77"));
        assertTrue(resultado.contains("Ana"));
        assertTrue(resultado.contains("Gomez"));
        assertTrue(resultado.contains("Ana.Gomez@empresa.com"));
    }
    @Test
    void testDepartamentoEmpleado() {
        // se prueba que el departamento asignado al empleado se guarde correctamente
        Departamento depto = new Departamento("Informatica");
        Empleado emp = new Empleado("11", "Perez", "Juan", "juan@empresa.com");
        emp.setDepartamento(depto);

        assertEquals("Informatica", emp.getDepartamento().getNombre());
    }
    @Test
    void testToStringConDepartamento() {
        // se prueba que el toString incluya el nombre del departamento
        Departamento depto = new Departamento("Marketing");
        Empleado emp = new Empleado("33", "Lopez", "Maria", "maria@empresa.com");
        emp.setDepartamento(depto);

        String resultado = emp.toString();

        assertTrue(resultado.contains("Marketing"));
    }
    @Test
    void testToStringSinDepartamento() {
        // se prueba que el toString muestre "Sin departamento" cuando no exista uno asignado
        Empleado emp = new Empleado("44", "Diaz", "Pedro", "pedro@empresa.com");

        String resultado = emp.toString();

        assertTrue(resultado.contains("Sin departamento"));
    }

}