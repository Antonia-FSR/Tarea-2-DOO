Tarea-2-DOO
Diego Antonio Gavilan Ramirez
Jorge Andres Orellana Cuevas 
Antonia Florencia Sandoval Reyes

DESCRIPCIÓN GENERAL 
Este proyecto implementa un sistema de gestión de reuniones en Java mediante el paradigma de Programación Orientada a Objetos. El sistema permite planificar reuniones (virtuales o presenciales), gestionar invitaciones, registrar la asistencia (incluyendo el control de retrasos) y añadir notas a cada sesión.

JUSTIFICACIÓN DE CAMBIOS EN EL DIAGRAMA UML

1. Inclusión de la clase InvitadoExterno
Cambio: Se agregó una nueva clase InvitadoExterno que implementa la interfaz Invitable.

Justificación: El sistema original solo contemplaba invitar a Empleados o Departamentos. Al agregar esta clase, el sistema se vuelve más escalable, permitiendo incluir a personas ajenas a la empresa en las reuniones sin forzarlas a ser instanciados como empleados internos.

2. Relación bidireccional entre Empleado y Departamento
Cambio: Se agregó el atributo departamento: Departamento dentro de la clase Empleado.

Justificación: En el diseño inicial, la relación era unidireccional (solo el departamento conocía a sus miembros). Al permitir que cada Empleado guarde una referencia a su Departamento de origen, se facilita la navegación bidireccional en el código, permitiendo saber de forma directa a qué área pertenece un empleado.

3. Estructura interna de Departamento
Cambio: Se añadió el atributo empleados: List<Empleado> y el método agregarEmpleado(empleado: Empleado) a la clase Departamento.

Justificación: El diagrama original mostraba la agregación, pero omitía la estructura de datos. Al agregar esta lista y su método, permitimos que el objeto gestione a sus miembros de forma segura, manteniendo la encapsulación y haciendo posible la funcionalidad de invitar().

4. Referencia explícita en Asistencia
Cambio: Se añadió el atributo empleado: Empleado a la clase Asistencia.

Justificación: En el diagrama original, Asistencia no tenía atributos. A nivel de código, esto hacía imposible saber a quién correspondía dicho registro. Al vincular el empleado al momento de registrar la asistencia, resolvemos este vacío.

5. Atributos y encapsulación en Reunion
Cambio: Se explicitaron los atributos organizador: Empleado, tipoReunion: TipoReunion, y las colecciones invitaciones: List<Invitacion>, notes: List<Nota> y asistencias: List<Asistencia>.

Justificación: En el UML inicial, estos elementos figuraban solo como líneas de relación (asociación, agregación y composición). Para poder programar la clase, fue indispensable materializarlos como atributos privados, permitiendo que la reunión conserve la referencia de quién la organiza, qué tipo de reunión es y contenga las estructuras de datos necesarias para almacenar la información.

6. Nuevos métodos en Reunion
Cambio: Se añadieron los métodos públicos añadirNota(nota: Nota), agregarInvitacion(invitacion: Invitacion) y registrarAsistencia(asis: Asistencia).

Justificación: Al transformar las relaciones en listas privadas (encapsulación), se requería definir el comportamiento para interactuar con ellas. Estos métodos permiten poblar y manipular las notas, invitaciones y asistencias de la reunión de forma segura desde el exterior.

7. Atributo objetivo en Invitacion
Cambio: Se le agregó el atributo invitado: Invitable a la clase Invitacion.

Justificación: Originalmente la invitación solo tenía una hora. Era estrictamente necesario vincular la invitación con su destinatario a través del polimorfismo que nos da la interfaz Invitable.

8. Generación de Informes
Cambio: Se añadió el método generarInforme(nombreArchivo: String) en la clase abstracta Reunion.

Justificación: Provee una salida tangible de los datos procesados por la reunión (asistentes, ausentes, notas, tiempos), cumpliendo con el propósito final de documentar el evento en un archivo.
