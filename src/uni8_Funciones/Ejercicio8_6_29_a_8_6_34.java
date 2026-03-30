package uni8_Funciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Crea una biblioteca de funciones para arrays bidimensionales (de dos dimensiones) de números enteros que contenga las
 * siguientes funciones:
 * <br>1. {@code generaArrayBiInt:}: Genera un array de tamaño n x m con números aleatorios cuyo intervalo (mínimo y
 * máximo) se indica como parámetro.</br>
 * <br>2. {@code filaDeArrayBiInt:}: Devuelve la fila i-ésima del array que se pasa como parámetro..</br>
 * <br>3. {@code columnaDeArrayBiInt:}: Devuelve la columna j-ésima del array que se pasa como parámetro..</br>
 * <br>4. {@code coordenadasEnArrayBiInt:}: Devuelve la fila y la columna (en un array con dos elementos) de la primera
 * ocurrencia de un número dentro de un array bidimensional. Si el número no se encuentra en el array, la función
 * devuelve el array {-1, -1}.</br>
 * <br>5. {@code esPuntoDeSilla:}: Dice si un número es o no punto de silla, es decir, mínimo en su fila y máximo en su columna.</br>
 * <br>6. {@code diagonal:}: Devuelve un array que contiene una de las diagonales del array bidimensional que se pasa
 * como parámetro. Se pasan como parámetros fila, columna y dirección. La fila y la columna determinan el número que
 * marcará las dos posibles diagonales dentro del array. La dirección es una cadena de caracteres que puede ser “nose”
 * o “neso”. La cadena “nose” indica que se elige la diagonal que va del noroeste hacia el sureste, mientras que la
 * cadena “neso” indica que se elige la diagonal que va del noreste hacia el suroeste.</br>
 * @author Saulolo
 */
public class Ejercicio8_6_29_a_8_6_34 {

    public static void main(String[] args) {

        System.out.println("=== BIBLIOTECA FUNCIONES ARRAYS BIDIMENSIONALES ===");

        //Matriz
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //Mostrar matriz
        System.out.println("== Matriz ==");
        //System.out.println(Arrays.deepToString(matriz));
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }

        //Ejercicio 8.6.29. Generar array bidimensional aleatorio
        int[][] matrizRandom = generaArrayBiInt(4, 3, 10, 99);
        System.out.println("\n== Lista de números aleatorios ==");
        for (int[] fila : matrizRandom) {
            System.out.println(Arrays.toString(fila));
        }

        //Ejercicio 8.6.30. Generar fila i-esima del array
        System.out.println("\n== Fila i-esima ==");
        System.out.println(Arrays.toString(filaDeArrayBiInt(matriz, 1)));

        //Ejercicio 8.6.31. Generar columna j-esima del array
        System.out.println("\n== Columna j-esima ==");
        System.out.println(Arrays.toString(columnaDeArrayBiInt(matriz, 2)));

        //Ejercicio 8.6.32. Generar columna j-esima del array
        System.out.println("\n== Fila y Columna ==");
        System.out.println(Arrays.toString(coordenadasEnArrayBiInt(matriz, 3)));
        System.out.println(Arrays.toString(coordenadasEnArrayBiInt(matriz, 5)));

        //Ejercicio 8.6.33. Generar columna j-esima del array
        System.out.println("\n== Es punto de silla? ==");
        System.out.println(esPuntoDeSilla(matriz, 1, 0));

        // Diagonal "nose" que pasa por [1,1] sería [1,6,11,16]
        System.out.println("\n== Diagonal \"nose\" ==");
        System.out.println(Arrays.toString(diagonal(matriz, 1, 1, "nose")));
        System.out.println("== Diagonal \"nese\" ==");
        System.out.println(Arrays.toString(diagonal(matriz, 1, 2, "neso")));
    }

    /**
     * Genera un array bidimensional (n x m) de enteros aleatorios en [min, max].
     * @param n   Número de filas.
     * @param m   Número de columnas.
     * @param min Valor mínimo (incluido).
     * @param max Valor máximo (incluido).
     * @return Array bidimensional generado.
     * @throws IllegalArgumentException si las dimensiones no son válidas o min > max.
     */
    private static int[][] generaArrayBiInt(int n, int m, int min, int max) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Las dimensiones deben de ser mayores que 0.");
        }
        if (min > max) {
            throw new IllegalArgumentException("El valor mínimo debe de ser menor o igual al valor máximo.");
        }

        int[][] array = new int[n][m];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return array;
    }

    /**
     * Devuelve una copia de la fila i-ésima del array bidimensional proporcionado.
     * @param array Array bidimensional de enteros.
     * @param i     Índice de la fila a devolver (comienza en 0).
     * @return Nuevo array unidimensional con la fila solicitada.
     * @throws IllegalArgumentException  si el array es nulo o vacío.
     * @throws IndexOutOfBoundsException si la fila no existe.
     */
    private static int[] filaDeArrayBiInt(int[][] array, int i) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("EL array no puede ser nulo ni vacio.");
        }
        if (i < 0 || i >= array.length) {
            throw new IllegalArgumentException("la fila solicitada no existe en el array.");
        }

        return array[i];
    }

    /**
     * Devuelve la columna j-ésima de un array bidimensional como un array independiente.
     * @param array Array bidimensional de enteros.
     * @param j     Índice de la columna a devolver (empieza en 0).
     * @return Nuevo array unidimensional con los elementos de la columna.
     * @throws IllegalArgumentException  si el array es nulo, vacío, o tiene filas insuficientes.
     * @throws IndexOutOfBoundsException si la columna no existe.
     */
    public static int[] columnaDeArrayBiInt(int[][] array, int j) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array no puede ser nulo ni vacío.");
        if (array[0].length == 0)
            throw new IllegalArgumentException("El array no tiene columnas.");
        if (j < 0 || j >= array[0].length)
            throw new IndexOutOfBoundsException("La columna solicitada no existe en el array.");

        int[] columna = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (j >= array[i].length)
                throw new IllegalArgumentException("No todas las filas tienen suficientes columnas.");
            columna[i] = array[i][j];
        }
        return columna;
    }

    /**
     * Devuelve la fila y columna de la primera ocurrencia de un número en una matriz.
     * @param array Matriz de enteros a buscar.
     * @param num   Número a buscar en la matriz.
     * @return Array de dos elementos: [fila, columna] de la primera ocurrencia,
     * o [-1, -1] si el número no está.
     * @throws IllegalArgumentException si la matriz es nula o vacía.
     */
    public static int[] coordenadasEnArrayBiInt(int[][] array, int num) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array no puede ser nulo ni vacío.");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == num) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Indica si el elemento en la posición dada es un punto de silla
     * (mínimo en su fila y máximo en su columna).
     *
     * @param array   Matriz de enteros (no nula ni vacía).
     * @param fila    Fila del elemento a comprobar.
     * @param columna Columna del elemento a comprobar.
     * @return        true si es punto de silla, false en caso contrario.
     * @throws IllegalArgumentException  si la matriz es nula o vacía.
     * @throws IndexOutOfBoundsException si la fila o columna está fuera de rango.
     */
    public static boolean esPuntoDeSilla(int[][] array, int fila, int columna) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array no puede ser nulo ni vacío.");
        if (fila < 0 || fila >= array.length)
            throw new IndexOutOfBoundsException("Índice de fila fuera de rango.");
        if (columna < 0 || columna >= array[0].length)
            throw new IndexOutOfBoundsException("Índice de columna fuera de rango.");

        int valor = array[fila][columna];
        // ¿Es mínimo en la fila?
        for (int j = 0; j < array[fila].length; j++) {
            if (array[fila][j] < valor) {
                return false;
            }
        }
        // ¿Es máximo en la columna?
        for (int[] ints : array) {
            if (ints[columna] > valor) {
                return false;
            }
        }
        return true;
    }

    public static int[] diagonal(int[][] array, int fila, int columna, String direccion) {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("El array no puede ser nulo ni vacío.");
        if (fila < 0 || fila >= array.length)
            throw new IndexOutOfBoundsException("Índice de fila fuera de rango.");
        if (columna < 0 || columna >= array[0].length)
            throw new IndexOutOfBoundsException("Índice de columna fuera de rango.");
        if (!(direccion.equals("nose") || direccion.equals("neso")))
            throw new IllegalArgumentException("Dirección debe ser 'nose' o 'neso'.");

        List<Integer> diag = new ArrayList<>();

        int i = fila;
        int j = columna;

        // Recorre hacia atrás hasta el borde
        if (direccion.equals("nose")) {
            // Noroeste a sureste: ir atrás hasta el inicio de la diagonal
            while (i > 0 && j > 0) {
                i--;
                j--;
            }
            // Recorre hacia adelante por la diagonal
            while (i < array.length && j < array[0].length) {
                diag.add(array[i][j]);
                i++;
                j++;
            }
        } else {
            // Noreste a suroeste: ir atrás hasta el inicio de la diagonal
            while (i > 0 && j < array[0].length - 1) {
                i--;
                j++;
            }
            // Recorre hacia adelante por la diagonal
            while (i < array.length && j >= 0) {
                diag.add(array[i][j]);
                i++;
                j--;
            }
        }

        // Convierte la lista a array
        return diag.stream().mapToInt(Integer::intValue).toArray();
    }

}
