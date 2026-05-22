package org.example;

/**
 * Se encarga de representar la asistencia a la reunión a la que una entidad fue invitada.
 * @author jaocSec
 */
public class Asistencia {
    private Empleado empleado;

    /**
     * Constructor de la clase Asistencia.
     *
     * @param empleado empleado el cual se confirma que ha asistido a la reunión.
     */
    public Asistencia(Empleado empleado){
        this.empleado= empleado;
    }

    /**
     * Obtiene el empleado que se asocia al registro de asistencia.
     *
     * @return instancia del objeto Empleado que está presente.
     */
    public Empleado getEmpleado(){
        return empleado;
    }

    public void setEmpleado(Empleado empleado){
        this.empleado= empleado;
    }

    /**
     * Convierte el registro de asistencia a String.
     *
     * @return cadena de caracteres con el nombre completo del empleado que asistió.
     */
    @Override
    public String toString(){
        return "Asistente: " + empleado.getNombre()+ " " +empleado.getApellidos();
    }
}
