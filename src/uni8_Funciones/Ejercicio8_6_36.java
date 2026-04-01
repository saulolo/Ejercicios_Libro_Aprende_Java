package uni8_Funciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Crea la función de manejo de arrays que tenga la siguiente cabecera y que haga lo que se especifica en los comentarios
 * (puedes incluirla en tu propia biblioteca de rutinas):
 * <br>public static int[] filtraPrimos(int x[])
 * <br>// Devuelve un array con todos los
 * <br>// números primos que se encuentren
 * <br>// en otro array que se pasa como
 * <br>// parámetro.
 * <br>// Obviamente el tamaño del array
 * <br>// que se devuelve será menor o
 * <br>// igual al que se pasa como
 * <br>// parámetro.</br>
 * Utiliza esta función en un programa para comprobar que funcionan bien. Para que el ejercicio resulte más fácil, las
 * repeticiones de primos se conservan; es decir, si en el array x el número 13 se repite 3 veces, en el array devuelto
 * también estará repetido 3 veces. Si no existe ningún número primo en x, se devuelve un array con el número -1 como
 * único elemento.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_36 {

    public static void main(String[] args) {

        System.out.println("=== NÚMEROS PRIMOS FILTRADOS ===");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Arrays.stream(filtrarPrimos(numbers))
                .forEach(System.out::println);

        System.out.println("\n== Escenario sin numeros primos ==");
        int[] numbers2 = {4, 6, 8};
        Arrays.stream(filtrarPrimos(numbers2))
                .forEach(System.out::println);
    }

    /**
     * Devuelve un array con todos los números primos encontrados en el array dado.
     * Si no hay ninguno, devuelve {-1}.
     *
     * @param x Array de enteros a filtrar.
     * @return  Array con los números primos encontrados o {-1} si no hay ninguno.
     */
    public static int[] filtrarPrimos(int[] x) {
        if (x == null || x.length == 0)
            throw new IllegalArgumentException("El array no puede ser nulo ni vacío.");

        List<Integer> primos = new ArrayList<>();
        for (int num : x) {
            if (esPrimo(num)) {
                primos.add(num);
            }
        }
        if (primos.isEmpty()) {
            return new int[] { -1 };
        }
        int[] resultado = new int[primos.size()];
        for (int i = 0; i < primos.size(); i++) {
            resultado[i] = primos.get(i);
        }
        return resultado;

    }

    // Función auxiliar para saber si un número es primo
    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
