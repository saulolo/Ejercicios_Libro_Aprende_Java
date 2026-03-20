package uni8_Funciones;

import java.util.*;

/**
 * Crea una biblioteca de funciones para arrays (de una dimensión) de números enteros que contenga las siguientes funciones:
 * <br>1. {@code generaArrayInt}: Genera un array de tamaño n con números aleatorios cuyo intervalo (mínimo y máximo) se
 * indica como parámetro.</br>
 * <br>2. {@code minimoArrayInt}: Devuelve el mínimo del array que se pasa como parámetro.</br>
 * <br>3. {@code maximoArrayInt}: Devuelve el máximo del array que se pasa como parámetro.</br>
 * <br>4. {@code mediaArrayInt}: Devuelve la media del array que se pasa como parámetro.</br>
 * <br>5. {@code estaEnArrayInt}: Dice si un número está o no dentro de un array.</br>
 * <br>6. {@code posicionEnArray}: Busca un número en un array y devuelve la posición (el índice) en la que se encuentra.</br>
 * <br>7. {@code volteaArrayInt}: Le da la vuelta a un array.</br>
 * <br>8. {@code rotaDerechaArrayInt}: Rota n posiciones a la derecha los números de un array.</br>
 * <br>9. {@code rotaIzquierdaArrayInt:}: Rota n posiciones a la izquierda los números de un array.</br>
 * @author Saulolo
 */
public class Ejercicio8_6_20_a_8_6_28 {

    public static void main(String[] args) {

        System.out.println("=== BIBLIOTECA FUNCIONES ARRAYS ===");

        int[] miArray = generaArrayInt(10, 9, 50);
        int[] miArrayNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        //Ejercicio 8.6.21. Generar array aleatorio
        System.out.println("Lista de números aleatorios ==> ");
        for (int num : miArray) {
            System.out.println(num);
        }

        //Ejercicio 8.6.22. Devuelvo el minimo del array
        System.out.println("Mínimo del array => " + minimoArrayInt(miArray));

        //Ejercicio 8.6.23. Devuelvo el máximo del array
        System.out.println("Mínimo del array => " + maximoArrayInt(miArray));

        //Ejercicio 8.6.24. Devuelvo la media del array
        System.out.println("Promedio del array => " + mediaArrayInt(miArray));

        //Ejercicio 8.6.25. El número esta dentro del array?
        System.out.println("Esta el número en el array => " + estaEnArrayInt(miArray, 4));

        //Ejercicio 8.6.26. Devuelve la posición del número dentro del array
        System.out.println("Indice del número => " + posicionEnArray(numbers, 2));

        //Ejercicio 8.6.27. Devuelve el array inverso
        System.out.println("Array invertido => " + Arrays.toString(volteaArrayInt(miArrayNumbers)));

        //Ejercicio 8.6.28. Devuelve la rotacion a la derecha de un array en n posiciones.
        System.out.println("Rotación a la derecha => " + Arrays.toString(rotaDerechaArrayInt(miArrayNumbers, 4)));

        //Ejercicio 8.6.29. Devuelve la rotacion a la izquierda de un array en n posiciones.
        System.out.println("Rotación a la izquierda => " + Arrays.toString(rotaIzquierdaArrayInt(miArrayNumbers, 4)));
    }


    /**
     * Genera un array de enteros aleatorios en el intervalo [min, max].
     *
     * @param n   Tamaño del array.
     * @param min Valor mínimo (incluido).
     * @param max Valor máximo (incluido).
     * @return    Array generado con números aleatorios.
     * @throws IllegalArgumentException si n <= 0 o min > max.
     */
    public static int[] generaArrayInt(int n, int min, int max) {
        if (n <= 0) throw new IllegalArgumentException("El tamaño del array debe de ser mayor que 0.");
        if (min > max)
            throw new IllegalArgumentException("El valor " + min + " debe de ser mayor o igual que el valor " + max);

        int[] numbers = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt((max - min + 1)) + min;
        }
        return numbers;
    }

    /**
     * Devuelve el valor mínimo del array dado.
     *
     * @param array Array de enteros no vacío.
     * @return      Valor mínimo encontrado.
     * @throws IllegalArgumentException si el array es nulo o vacío.
     */
    public static int minimoArrayInt(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array debe no ser nulo y tener al menos un elemento.");
        int min = array[0];
        for (int valor : array) {
            if (valor < min) min = valor;
        }
        return min;
    }

    /**
     * Devuelve el valor máximo del array dado.
     *
     * @param array Array de enteros no vacío.
     * @return      Valor máximo encontrado.
     * @throws IllegalArgumentException si el array es nulo o vacío.
     */
    public static int maximoArrayInt(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array debe no ser nulo y tener al menos un elemento.");
        int max = array[0];
        for (int valor : array) {
            if (valor > max) max = valor;
        }
        return max;
    }

    /**
     * Calcula la media aritmética de los valores del array.
     *
     * @param array Array de enteros no vacío.
     * @return      Media aritmética como double.
     * @throws IllegalArgumentException si el array es nulo o vacío.
     */
    public static double mediaArrayInt(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array debe no ser nulo y tener al menos un elemento.");
        int suma = 0;
        for (int valor : array) {
            suma += valor;
        }
        return (double) suma / array.length;
    }

    /**
     * Indica si un número se encuentra en el array.
     *
     * @param array Array de enteros no vacío.
     * @param num   Número a buscar.
     * @return      true si el número está en el array, false en caso contrario.
     * @throws IllegalArgumentException si el array es nulo o vacío.
     */
    public static boolean estaEnArrayInt(int[] array, int num) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array debe no ser nulo y tener al menos un elemento.");

        for (int valor : array) {
            if (valor == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un número en una lista y devuelve el índice de su primera ocurrencia.
     *
     * @param numbers Lista de enteros sobre la que se realiza la búsqueda.
     * @param num     Número a buscar.
     * @return        Índice de la primera ocurrencia encontrada.
     * @throws NoSuchElementException Si el número no está presente en la lista.
     */
    public static int posicionEnArray(List<Integer> numbers, int num) {
        int position = numbers.indexOf(num);

        if (position == -1) {
            throw new NoSuchElementException("Número no encontrado en el array");
        }
        return position;
    }

    /**
     * Devuelve un nuevo array con los elementos del array original en orden inverso.
     *
     * @param array Array de enteros a invertir (no nulo ni vacío).
     * @return      Nuevo array con los elementos en orden inverso.
     * @throws IllegalArgumentException si el array es nulo o vacío.
     */
    private static int[] volteaArrayInt(int[] array) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array debe no ser nulo y tener al menos un elemento.");
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length -1 -i];
        }
        return result;
    }

    /**
     * Rota los elementos del array n posiciones a la derecha.
     * Los elementos que se desplazan fuera del final vuelven al inicio.
     *
     * @param array    Array de enteros a rotar (no nulo ni vacío).
     * @param position Número de posiciones a rotar (puede ser mayor que el tamaño del array).
     * @return         Nuevo array con los elementos rotados a la derecha.
     * @throws IllegalArgumentException si el array es nulo o vacío.
     */
    private static int[]  rotaDerechaArrayInt(int[] array, int position) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array debe no ser nulo y tener al menos un elemento.");

        int len = array.length;
        int[] result = new int[len];
        int rot = position % len;
        if (rot < 0) rot += len;

        for (int i = 0; i < len; i++) {
            int newPos = (i + rot) % len;
            result[newPos] = array[i];
        }
        return result;
    }

    /**
     * Rota los elementos de un array n posiciones a la izquierda.
     * Los elementos que se "salen" por la izquierda vuelven por la derecha.
     *
     * @param array Array de enteros a rotar (no nulo ni vacío).
     * @param n     Número de posiciones a rotar (puede ser mayor que el tamaño).
     * @return      Nuevo array con los elementos rotados a la izquierda.
     * @throws IllegalArgumentException si el array es nulo o vacío.
     */
    public static int[] rotaIzquierdaArrayInt(int[] array, int n) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array debe no ser nulo y tener al menos un elemento.");

        int len = array.length;
        int[] result = new int[len];
        int rot = n % len;
        if (rot < 0) rot += len;

        for (int i = 0; i < len; i++) {
            int newPos = (i + len - rot) % len;
            result[newPos] = array[i];
        }
        return result;
    }

}
