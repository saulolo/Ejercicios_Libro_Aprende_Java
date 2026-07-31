package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_12;

public class Publicacion {

    private String codigoISBN;
    private String titulo;
    private int anioPublicacion;

    public Publicacion(String codigoISBN, String titulo, int anioPublicacion) {
        this.codigoISBN = codigoISBN;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }


    @Override
    public String toString() {
        return "ISBN: " + codigoISBN + ", título: " + titulo + ", año de publicación: " + anioPublicacion;
    }
}
