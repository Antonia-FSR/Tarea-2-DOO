package org.example;
/**
 * Representa una nota de texto que puede ser añadida a una reunión.
 * * @author Antonia-FSR
 */
public class Nota {
    private String contenido;

    /**
     * Constructor para crear una nueva nota.
     * * @param contenido El texto que contendrá la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el contenido actual de la nota.
     * * @return El texto de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * modifica el contenido de la nota.
     * * @param contenido El nuevo texto para la nota.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve una descripcion en texto de la nota.
     * * @return Cadena de texto con el formato de la nota.
     */
    @Override
    public String toString() {
        return "Nota: '" + contenido + "'";
    }
}
