package org.example;
import java.util.List;
import java.util.ArrayList;
/**
 * Representa un departamento que puede ser invitadoa a la reunion
 * @author Antonia-FSR
 */

public class Departamento implements Invitable{
    private String nombre;
    private List<Empleado> empleados;
    /**
     * Constructor para crear un nuevo departamento
     * @param nombre, el nombre del departamento
     */
    public Departamento(String nombre){
        this.nombre=nombre;
        this.empleados= new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null) {
            this.empleados.add(empleado);
            empleado.setDepartamento(this);
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    /**
     * implementacion del metodo de la interfaz Invitable
     * imprime un mensaje diciendo que se invito a todos en el departammento
     */
    @Override
    public void invitar(){
        System.out.println("Enviando invitación a todo el departamento: "+nombre);
    }

    /**
     * @return cadena de texto con nombre del departamento
     */
    @Override
    public String toString(){
        return "Departamento: "+nombre+ " | Cantidad empleados: "+empleados.size();
    }
}
