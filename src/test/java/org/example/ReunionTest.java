package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

class ReunionTest {

    @Test
    void testIniciarYFinalizarReunion() { //Verifica si se calcula el tiempo de duración de la reunión

        Empleado organ = new Empleado("100", "Perez", "Juan", "juan@gmail.com");
        Reunion reunion = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(2), organ, TipoReunion.TECNICA, "https://link.com");

        assertNull(reunion.getHoraInicio()); //Verificar que la hora de inicio y fin no tengan valores
        assertNull(reunion.getHoraFin());
        assertEquals(0f, reunion.calcularTiempoReal());

        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio()); //Verificar el valor de inicio

        reunion.finalizar(); //Verificar el valor de fin
        assertNotNull(reunion.getHoraFin());

        assertTrue(reunion.calcularTiempoReal() >= 0f); //Verificar que el tiempo es mayor a 0
    }

    @Test
    void testAñadirNotas() { //Verificar funcionamiento correcto de las notas añadidas
        Empleado organ = new Empleado("101", "Perez", "Juan", "juan@gmail.com");
        Reunion reunion = new ReunionPresencial(new Date(), Instant.now(), Duration.ofMinutes(45), organ, TipoReunion.MARKETING, "Sala B");

        Nota nota1 = new Nota("Nota1"); //Crear notas
        Nota nota2 = new Nota("Nota2");

        reunion.añadirNota(nota1); //Agregar notas a la reunion
        reunion.añadirNota(nota2);

        String resultadoToString = reunion.toString(); //Obtener el string de las notas
        assertTrue(resultadoToString.contains("Nota1"));
        assertTrue(resultadoToString.contains("Nota2"));
    }

    @Test
    void testCalcularPorcentajeAsistencia() { //Verificar el cálculo del porcentaje de asistencia
        Empleado organ = new Empleado("101", "Perez", "Juan", "juan@gmail.com");
        Reunion reunion = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), organ, TipoReunion.OTRO, "https://meet.google.com");

        Empleado emp1 = new Empleado("1", "Rios", "Carlos", "carlos@gmail.com");
        Empleado emp2 = new Empleado("2", "Mendoza", "Marta", "marta@gmail.com");

        Invitacion inv1 = new Invitacion(emp1, Instant.now());
        Invitacion inv2 = new Invitacion(emp2, Instant.now());
        reunion.agregarInvitacion(inv1);
        reunion.agregarInvitacion(inv2);

        assertEquals(0f, reunion.obtenerPorcentajeAsistencia()); //Verificar que el porcentaje es 0

        Asistencia asistencia1 = new Asistencia(emp1);
        reunion.registrarAsistencia(asistencia1); //Se agrega una asistencia

        assertEquals(50f, reunion.obtenerPorcentajeAsistencia()); //Verificar que el porcentaje es 50
        assertEquals(1, reunion.obtenerTotalAsistencia()); //Verificar la cantidad de personas que asistieron
    }

    @Test
    void testObtenerAusenciasYRetrasos() { //Verificar la correcta obtención de la lista de ausencias y la lista de retrasos
        Empleado organ = new Empleado("101", "Perez", "Juan", "juan@gmail.com");
        Reunion reunion = new ReunionPresencial(new Date(), Instant.now(), Duration.ofHours(1), organ, TipoReunion.TECNICA, "Sala 2");

        Empleado emp1 = new Empleado("10", "Castro", "Luis", "luis@gmail.com");
        Empleado emp2 = new Empleado("20", "Vergara", "Elena", "elena@gmail.com");

        reunion.agregarInvitacion(new Invitacion(emp1, Instant.now()));
        reunion.agregarInvitacion(new Invitacion(emp2, Instant.now()));

        Retraso retrasoEmp1 = new Retraso(emp1, Instant.now()); //Creamos un nuevo retraso
        reunion.registrarAsistencia(retrasoEmp1);

        List<Invitable> ausencias = reunion.obtenerAusencias(); //Obtenemos la lista de ausencias
        assertEquals(1, ausencias.size());
        assertEquals("20", ((Empleado) ausencias.get(0)).getId()); //Confirmamos que sea el empleado correcto

        List<Retraso> retrasos = reunion.obtenerRetrasos(); //Obtenemos la lista de retrasos
        assertEquals(1, retrasos.size());
        assertEquals("10", retrasos.get(0).getEmpleado().getId()); //Confirmamos que sea el empleado correcto
    }

    @Test
    void testObtenerAusenciasPorDepartamento() { //Verificar la correcta obtención de la lista de ausencias y la lista de retrasos para departamentos
        Empleado organ = new Empleado("200", "Perez", "juan", "juan@gmail.com");
        Reunion reunion = new ReunionVirtual(new Date(), Instant.now(), Duration.ofHours(1), organ, TipoReunion.TECNICA, "https://link.com");

        Departamento depto = new Departamento("IT"); //Creamos un nuevo departamento
        Empleado emp1 = new Empleado("50", "Lopez", "Marcos", "marcos@gmail.com");
        Empleado emp2 = new Empleado("51", "Soto", "Ana", "ana@gmail.com");
        depto.agregarEmpleado(emp1); //Agregamos empleados al departamento
        depto.agregarEmpleado(emp2);

        reunion.agregarInvitacion(new Invitacion(depto, Instant.now())); //Invitamos al departamento

        Asistencia asisMarcos = new Asistencia(emp1); //Marcamos la asistencia para un empleado
        reunion.registrarAsistencia(asisMarcos);

        List<Invitable> ausencias = reunion.obtenerAusencias();

        assertEquals(1, ausencias.size());

        assertEquals("51", ((Empleado) ausencias.get(0)).getId()); //Verificamos que sea el empleado correcto
    }

    @Test
    void testGenerarInforme() { //Verificar la creación del archivo txt del informe
        Empleado org = new Empleado("1", "Perez", "Juan", "juan@empresa.com");
        Reunion reunion = new ReunionVirtual(new Date(), Instant.now(), Duration.ofMinutes(60), org, TipoReunion.TECNICA, "meet.com");

        String ruta = System.getProperty("java.io.tmpdir") + "informe_test.txt";

        reunion.generarInforme(ruta);

        File archivo = new File(ruta);

        assertTrue(archivo.exists());
    }
}