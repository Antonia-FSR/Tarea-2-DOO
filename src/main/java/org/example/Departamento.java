package org.example;
/**
 * Representa un departamento que puede ser invitadoa a la reunion
 * @author Antonia-FSR
 */

public class Departamento implements Invitable{
    private String nombre;
    /**
     * Constructor para crear un nuevo departamento
     * @param nombre, el nombre del departamento
     */
    public Departamento(String nombre){
        this.nombre=nombre;
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
        return "Departamento: "+nombre;
    }
}
