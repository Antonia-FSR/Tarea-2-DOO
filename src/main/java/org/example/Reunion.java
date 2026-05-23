package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase abstracta que representa la estructura y comportamiento de una reunion.
 * Se encarga de gestionar la duración, el control de asistencia, la administración de notas y la generación de informes
 *
 * @author jaocSec
 */
public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private Empleado organizador;
    private TipoReunion tipoReunion;
    private List<Invitacion> invitaciones;
    private List<Nota> notas;
    private List<Asistencia> asistencias;

    /**
     * Constructor de la clase Reunion, inicializa los datos base y prepara listas vacias de invitaciones, notas y asistencia.
     *
     * @param fecha Fecha programada para la reunión
     * @param horaPrevista tiempo en el cual se iniciará la reunión
     * @param duracionPrevista Duración estimada de la reunión
     * @param organizador Empleado organizador de la reunión
     * @param tipoReunion Categoria de la reunión (TÉCNICA, MARKETING, OTRO)
     */
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipoReunion) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipoReunion = tipoReunion;

        this.invitaciones = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }

    /**
     * Marca el inicio de la reunión registrando el instante de tiempo actual.
     */
    public void iniciar() {
        this.horaInicio = Instant.now();
    }

    /**
     * Marca el fin de la reunión registrando el instante de tiempo actual.
     */
    public void finalizar() {
        this.horaFin = Instant.now();
    }

    /**
     * Calcula la diferencia de tiempo real transcurrido entre el inicio y el fin de la reunión.
     *
     * @return Cantidad de minutos que duró la reunión en total. Si no ha iniciado o terminado, retorna 0.
     */
    public float calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return (float) Duration.between(horaInicio, horaFin).toMinutes();
        }
        return 0f;
    }

    /**
     * Obtiene la lista que contiene el registro de la asistencia.
     *
     * @return Lista con los objetos de tipo Asistencia.
     */
    public List<Asistencia> obtenerAsistencias() {
        return this.asistencias;
    }

    /**
     * Identifica y calcula quiénes fueron invitados a la reunión pero no se registraron en la asistencia.
     *
     * @return lista de entidades Invitable que se encuentran ausentes.
     */
    public List<Invitable> obtenerAusencias() {
        List<Invitable> ausencias = new ArrayList<>();

        for (Invitacion inv : this.invitaciones) {
            Invitable invitado = inv.getInvitado();

            if (invitado instanceof Empleado) {
                Empleado empInvitado = (Empleado) invitado;
                if (!verificarAsis(empInvitado)) {
                    ausencias.add(empInvitado);
                }
            }

            else if (invitado instanceof Departamento) {
                Departamento deptoInvitado = (Departamento) invitado;

                for (Empleado emp : deptoInvitado.getEmpleados()) {
                    if (!verificarAsis(emp)) {
                        ausencias.add(emp);
                    }
                }
            }
        }
        return ausencias;
    }

    /**
     *Filtra la lista de asistentes para obtener a los invitados que se incorporaron luego de la horaPrevista.
     *
     * @return lista con las instancias de tipo Retraso encontradas.
     */
    public List<Retraso> obtenerRetrasos(){
        List<Retraso> retrasos = new ArrayList<>();
        for(Asistencia asis : this.asistencias){
            if(asis instanceof Retraso){
                retrasos.add((Retraso) asis);
            }
        }
        return retrasos;
    }

    /**
     * Cuenta la cantidad total de asistencias.
     *
     * @return número entero de asistentes registrados.
     */
    public int obtenerTotalAsistencia() {
        return this.asistencias.size();
    }

    /**
     * Calcula el porcentaje de invitados que sí asistió a la reunión.
     *
     * @return Valor flotante entre 0 y 100 que representa el porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia() {
        if (invitaciones.isEmpty()){
            return 0f;
        }
        return ((float) obtenerTotalAsistencia() / invitaciones.size()) * 100;
    }

    /**
     * Añade una nueva nota a la lista de notas.
     *
     * @param nota Objeto Nota con el contenido que se quiere agregar.
     */
    public void añadirNota(Nota nota){
        this.notas.add(nota);
    }

    /**
     * Registra una invitación enviada para la reunión.
     *
     * @param invitacion objeto Invitacion asignado a un empleado, departamento o externo.
     */
    public void agregarInvitacion(Invitacion invitacion){
        this.invitaciones.add(invitacion);
    }

    /**
     * Añade una nueva asistencia o retraso a la lista de asistentes de la reunión.
     *
     * @param asiste instancia de Asistencia que se va a procesar.
     */
    public void registrarAsistencia(Asistencia asiste){
        this.asistencias.add(asiste);
    }



    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha= fecha;}

    public Instant getHoraPrevista() {return horaPrevista;}
    public void setHoraPrevista(Instant horaPrevista) {this.horaPrevista= horaPrevista;}

    public Duration getDuracionPrevista() { return duracionPrevista;}
    public void setDuracionPrevista(Duration duracionPrevista) { this.duracionPrevista = duracionPrevista;}

    public Instant getHoraInicio() { return horaInicio;}
    public Instant getHoraFin() { return horaFin;}

    public Empleado getOrganizador() { return organizador;}
    public void setOrganizador(Empleado organizador) { this.organizador = organizador;}

    public TipoReunion getTipoReunion() { return tipoReunion;}
    public void setTipoReunion(TipoReunion tipoReunion) { this.tipoReunion = tipoReunion;}



    /**
     * Transforma la información general de la reunión en una cadena.
     *
     * @return cadena de caracteres formateada con los datos descriptivos de la reunión.
     */
    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Reunión [Fecha: ").append(fecha).append(", Tipo: ").append(tipoReunion).append(", Organizador: ").append(organizador.getNombre()).append(" ").append(organizador.getApellidos()).append("]\n");

        sb.append("Notas:\n");
        for(Nota nota : notas){
            sb.append("- ").append(nota.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Busca de manera interna si el id de un empleado se encuentra en la lista de asistencia.
     *
     * @param empleado instancia del empleado que se desea corroborar.
     * @return true si el empleado asistió, false en caso de que esté ausente.
     */
    private boolean verificarAsis(Empleado empleado) {
        for (Asistencia asis : this.asistencias) {
            if (asis.getEmpleado().getId().equals(empleado.getId())) {
                return true;
            }
        }
        return false;
    }

    /**

     * Genera un informe completo de la reunión
     * y lo guarda en un archivo txt.
     *
     * @param nombreArchivo nombre del archivo txt.
     */
    public void generarInforme(String nombreArchivo) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("INFORME DE REUNION");

            writer.println("Fecha: " + fecha);

            writer.println("Tipo reunión: " + tipoReunion);

            writer.println("Organizador: " + organizador.getNombre() + " " + organizador.getApellidos());

            writer.println("Hora prevista: " + horaPrevista);

            writer.println("Hora inicio: " + horaInicio);

            writer.println("Hora fin: " + horaFin);

            writer.println("Duración real: " + calcularTiempoReal() + " minutos");

            writer.println();

            writer.println("ASISTENTES");

            for (Asistencia asis : asistencias) {writer.println(asis.toString());}

            writer.println();

            writer.println("AUSENTES");

            for (Invitable ausente : obtenerAusencias()) {writer.println(ausente.toString());}

            writer.println();

            writer.println("RETRASOS");

            for (Retraso retraso : obtenerRetrasos()) {writer.println(retraso.toString());}

            writer.println();

            writer.println("NOTAS");

            for (Nota nota : notas) {writer.println(nota.toString());}

            writer.println();

            System.out.println("Informe generado correctamente.");

        }

        catch (IOException e) {

            System.out.println("Error al generar informe: " + e.getMessage()
            );
            
        }
    }

}
