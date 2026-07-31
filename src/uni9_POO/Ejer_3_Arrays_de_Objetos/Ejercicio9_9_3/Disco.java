package uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_3;

import java.time.Year;

public class Disco {

    private static int consecutivo = 1;

    private  int id;
    private String titulo;
    private String artista;
    private Year anioLanzamiento;
    private int numeroPistas;

    public Disco() {
        this.id = consecutivo++;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public void setArtista(String artista) {
        this.artista = artista;
    }


    public void setAnioLanzamiento(Year anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }


    public void setNumeroPistas(int numeroPistas) {
        this.numeroPistas = numeroPistas;
    }

    @Override
    public String toString() {
        String anioStr = (anioLanzamiento != null) ? anioLanzamiento.toString() : "N/A";

        String lineaDivisoria = "+------+----------------------+----------------------+------------+----------+\n";
        String encabezado     = "| ID   | TÍTULO               | ARTISTA              | AÑO        | PISTAS   |\n";
        String formatoFila    = "| %-4d | %-20s | %-20s | %-10s | %-8d |\n";

        String t = (titulo != null && titulo.length() > 20) ? titulo.substring(0, 17) + "..." : (titulo != null ? titulo : "");
        String a = (artista != null && artista.length() > 20) ? artista.substring(0, 17) + "..." : (artista != null ? artista : "");

        return lineaDivisoria +
                encabezado +
                lineaDivisoria +
                String.format(formatoFila, id, t, a, anioStr, numeroPistas) +
                lineaDivisoria;
    }
}
