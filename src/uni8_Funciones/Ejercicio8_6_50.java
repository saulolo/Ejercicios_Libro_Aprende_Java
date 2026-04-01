package uni8_Funciones;

import java.util.Arrays;

/**
 * Define la función mezcla con la siguiente cabecera:
 * <br>public static int[] mezcla(int[] a, int[] b)
 * <br>Esta función toma dos arrays como parámetros y devuelve un array que es el resultado de mezclar los números de
 * ambos de forma alterna, se coge un número de a, luego de b, luego de a, etc. Los arrays a y b pueden tener longitudes
 * diferentes; por tanto, si se terminan los números de un array se terminan de coger todos los que quedan del otro.
 * <br>Ejemplo:
 * <br>Si a = {8, 9, 0} y b = {1, 2, 3}, mezcla(a, b) devuelve {8, 1, 9, 2, 0, 3 }
 * <br>Si a = {4, 3} y b = {7, 8, 9, 10}, mezcla(a, b) devuelve {4, 7, 3, 8, 9, 10}
 * <br>Si a = {8, 9, 0, 3} y b = {1}, mezcla(a, b) devuelve {8, 1, 9, 0, 3}
 * <br>Si a = { } y b = {1, 2, 3}, mezcla(a, b) devuelve {1, 2, 3}
 * @author Saulolo
 */
public class Ejercicio8_6_50 {

    public static void main(String[] args) {

        System.out.println("=== ARRAYS INTERCALADOS ===");
        int[] numbersA = {1, 2, 3, 4, 5};
        int[] numbersB = {6, 7, 8, 9, 10};

        Arrays.stream(mezcla(numbersA, numbersB))
                .forEach(System.out::println);

    }

    /**
     * Mezcla dos arrays alternando sus elementos.
     * Si un array es más largo, se añaden al final sus elementos restantes.
     *
     * @param a Primer array.
     * @param b Segundo array.
     * @return Nuevo array mezcla alterna de a y b.
     */
    public static int[] mezcla(int[] a , int[] b) {
        int[] resultado = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;

        // Alterna hasta que uno se acabe
        while (i < a.length && j < b.length) {
            resultado[k++] = a[i++];
            resultado[k++] = b[j++];
        }

        // Agrega el resto de a
        while (i < a.length) {
            resultado[k++] = a[i++];
        }

        // Agrega el resto de b
        while (j < b.length) {
            resultado[k++] = b[j++];
        }

        return resultado;
    }

}
