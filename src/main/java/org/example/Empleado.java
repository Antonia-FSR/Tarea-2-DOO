package org.example;

/**
 * @author Antonia-FSR
 * representa a un empleado que puede ser invitado a la reunion
 */
public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;

    /**
     * constructor para crear al empleado
     * @param id    identificador unico del empleado
     * @param apellidos  apellidos del empleado
     * @param nombre   nombre del empleado
     * @param correo   correo corporativo del empleado
     */
    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * implementacion del metodo de la interfaz Invitable
     */
    @Override
    public void invitar() {
        System.out.println("Enviando invitacion a:" + correo);
    }

    /**
     *
     * @return cadena de texto con los datos del empleado
     */
    @Override
    public String toString(){
        String nombreDepto = (departamento != null) ? departamento.getNombre() : "Sin departamento";
        return "Empleado [Id:"+id+"] |Nombre: "+nombre+", Apellidos: "+apellidos+", Correo: "+correo+", Departamento: "+nombreDepto+".";
    }
}
