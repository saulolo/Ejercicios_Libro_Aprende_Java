package uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_12;

public interface Prestable {


    /**
     * Marca el elemento como prestado.
     */
    void presta();

    /**
     * Marca el elemento como devuelto.
     */
    void devuelve();

    /**
     * Indica si el elemento está prestado.
     *
     * @return true si está prestado, false en caso contrario
     */
    boolean estaPrestado();

}
