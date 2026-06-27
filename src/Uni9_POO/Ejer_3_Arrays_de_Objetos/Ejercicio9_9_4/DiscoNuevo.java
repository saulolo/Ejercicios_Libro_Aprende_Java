package Uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_4;

import java.time.Year;

public class DiscoNuevo {

    private static int consecutivo = 1;

    private  int id;
    private String titulo;
    private String artista;
    private Year anioLanzamiento;
    private int numeroPistas;
    private String genero;
    private int duracion;

    /**
     * Crea un disco con ID único autoincremental.
     */
    public DiscoNuevo() {
        this.id = consecutivo++;
    }

    public int getId() {
        return id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setAnioLanzamiento(Year anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public Year getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setNumeroPistas(int numeroPistas) {
        this.numeroPistas = numeroPistas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        String anioStr = (anioLanzamiento != null) ? anioLanzamiento.toString() : "N/A";
        String generoStr = (genero != null) ? genero : "N/A";
        String duracionStr = duracion + " min";

        String lineaDivisoria = "+------+----------------------+----------------------+------+-------+----------+----------+\n";
        String encabezado     = "| ID   | TÍTULO               | ARTISTA              | AÑO  | PISTAS| GÉNERO   | DURACIÓN |\n";
        String formatoFila    = "| %-4d | %-20s | %-20s | %-4s | %-5d | %-8s | %-8s |\n";

        String t = (titulo != null && titulo.length() > 20) ? titulo.substring(0, 17) + "..." : (titulo != null ? titulo : "");
        String a = (artista != null && artista.length() > 20) ? artista.substring(0, 17) + "..." : (artista != null ? artista : "");

        return lineaDivisoria +
                encabezado +
                lineaDivisoria +
                String.format(formatoFila, id, t, a, anioStr, numeroPistas, generoStr, duracionStr) +
                lineaDivisoria;
    }
}
