package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_12;

public class Libro extends Publicacion implements Prestable{


    private boolean prestado;


    public Libro(String codigoISBN, String titulo, int anioPublicacion) {
        super(codigoISBN, titulo, anioPublicacion);
        this.prestado = false;
    }


    /**
     * Presta el libro si no está prestado.
     * Si ya está prestado, muestra un mensaje.
     */
    @Override
    public void presta() {
        if (prestado) {
            System.out.println("Lo siento, este libro ya esta prestado.");
        } else {
            prestado = true;
        }
    }

    @Override
    public void devuelve() {
        prestado = false;

    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    @Override
    public String toString() {
        return super.toString() + (prestado ? " (prestado)" : " (no prestado)");
    }
}
