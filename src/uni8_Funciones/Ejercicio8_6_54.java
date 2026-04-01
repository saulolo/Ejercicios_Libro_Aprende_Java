package uni8_Funciones;

/**
 * Crea las funciones cuyas cabeceras se muestran a continuación, observa que tienen el mismo nombre:
 * <br>public static int ocurrencias(int digito, int n)
 * <br>public static int ocurrencias(int digito, int[] n)
 * <br>La función ocurrencias devuelve el número de veces que aparece un dígito dentro de un número (primera función) o
 * bien el número de veces que aparece un dígito en una serie de números contenidos en un array (segunda función).
 * <br>Ejemplo:
 * <br>console ocurrencias(8, 4672) devuelve 0 ocurrencias(5, 25153) devuelve 2 ocurrencias(2,123456)
 * devuelve 1 Si a = {714, 81, 9, 11}, ocurrencias(1, a) devuelve 4 Si a = {42, 13, 12345, 4},
 * ocurrencias(4, a) devuelve 3 Si a = {6, 66, 666}, ocurrencias(6, a) devuelve 6 console
 * <br>Utiliza estas funciones en un programa para comprobar que funcionan bien.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_54 {

    public static void main(String[] args) {

        System.out.println("=== OCURRENCIAS ===");

        System.out.println("== Pruebas individuales con números ==");
        System.out.println(ocurrencias(8, 4672));

        System.out.println("== Pruebas con array ==");
        int[] a1 = {714, 81, 9, 11};
        System.out.println(ocurrencias(1, a1));

    }

    /**
     * Devuelve el número de veces que aparece un dígito en un número dado.
     *
     * @param digito El dígito a buscar (0-9).
     * @param n El número donde buscar.
     * @return Número de veces que digito aparece en n.
     */
    public static int ocurrencias(int digito, int n) {
        int contador = 0;
        int num = Math.abs(n);

        // Caso especial: si n = 0 y digito = 0
        if (num == 0 && digito == 0) return 1;

        // Recorre las cifras
        while (num > 0) {
            if (num % 10 == digito) contador++;
            num /= 10;
        }
        return contador;

    }

    /**
     * Devuelve el número total de ocurrencias de un dígito en todos los elementos de un array.
     *
     * @param digito El dígito a buscar (0-9).
     * @param n Array de enteros donde buscar.
     * @return Suma de veces que digito aparece en todos los elementos del array.
     */
    public static int ocurrencias(int digito, int[] n) {
        int total = 0;
        for (int numero : n) {
            total += ocurrencias(digito, numero);
        }
        return total;
    }

}
