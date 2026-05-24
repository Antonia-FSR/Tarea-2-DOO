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
        // se prueba que la informacion al imprimir coincide
        Departamento depto = new Departamento("Recursos Humanos");
        Empleado emp = new Empleado("1", "Diaz", "Ana", "ana@empresa.com");
        depto.agregarEmpleado(emp);
        String resultado = depto.toString();
        assertTrue(resultado.contains("Recursos Humanos"));
        assertTrue(resultado.contains("1"));
    }
    @Test
    void testAgregarEmpleado() {
        // se prueba que al agregar un empleado este quede almacenado en el departamento
        Departamento depto = new Departamento("Informatica");
        Empleado emp = new Empleado("10", "Perez", "Juan", "juan@empresa.com");
        depto.agregarEmpleado(emp);
        assertEquals(1, depto.obtenerCantidadEmpleados());
        assertTrue(depto.getEmpleados().contains(emp));
    }
    @Test
    void testAgregarEmpleadoNull() {
        // se prueba que no se agreguen empleados null al departamento
        Departamento depto = new Departamento("Marketing");
        depto.agregarEmpleado(null);
        assertEquals(0, depto.obtenerCantidadEmpleados());
    }
    @Test
    void testRelacionBidireccional() {
        // se prueba que al agregar un empleado este guarde referencia a su departamento
        Departamento depto = new Departamento("Ventas");
        Empleado emp = new Empleado("22", "Lopez", "Mario", "mario@empresa.com");
        depto.agregarEmpleado(emp);
        assertEquals(depto, emp.getDepartamento());
    }
}