package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_12;

public class Revista extends Publicacion{

    private int numero;


    public Revista(String codigoISBN, String titulo, int anioPublicacion, int numero) {
        super(codigoISBN, titulo, anioPublicacion);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
