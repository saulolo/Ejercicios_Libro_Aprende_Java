package uni8_Funciones;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Define la función concatena con la siguiente cabecera:
 * <br>public static int[] concatena(int[] a, int[] b)
 * <br>Esta función toma dos arrays como parámetros y devuelve un array que es el resultado de concatenar ambos. Por ej.
 * si a = { 8, 9, 0 } y b = { 1, 2, 3 }, concatena(a, b) devuelve { 8, 9, 0, 1, 2, 3 }.
 * @author Saulolo
 */
public class Ejercicio8_6_48 {

    public static void main(String[] args) {

        System.out.println("=== CONCATENACIÓN DE ARRAYS ===");
        int[] numbersA = {1, 2, 3, 4, 5};
        int[] numbersB = {6, 7, 8, 9, 10};

        Arrays.stream(concatena(numbersA, numbersB)).forEach(System.out::println);

    }

    /**
     * Concatena dos arrays de enteros en uno solo.
     *
     * @param a Primer array.
     * @param b Segundo array.
     * @return Nuevo array con los elementos de a seguidos de los de b.
     */
    public static int[] concatena(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
    }

}
