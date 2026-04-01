package uni8_Funciones;

import java.util.Arrays;

/**
 * Implementa una función con nombre corteza que sea capaz de extraer la capa exterior de un array bidimensional.
 * Esta capa se extrae en forma de array de una dimensión. La extracción de números comienza en la esquina superior
 * izquierda y continúa en el sentido de las agujas del reloj. Se debe entregar tanto el código de la función como el
 * código de prueba que la usa. La cabecera de la función es la siguiente:
 * <br>public static int[] corteza(int[][] n)
 * <br>Por ejemplo, si el array bidimensional a es el que se muestra a continuación:
 * <br>45 92 14 20 25 78
 * <br>35 72 24 45 42 60
 * <br>32 42 64 23 41 39
 * <br>98 45 94 11 18 48
 * <br>El array unidimensional generado por corteza(a) sería el siguiente:
 * <br>45 92 14 20 25 78 60 39 48 18 11 94 45 98 32 35
 *
 * @author Saulolo
 */
public class Ejercicio8_6_56 {

    public static void main(String[] args) {


        System.out.println("=== ARRAY CORTEZA ===");
        int[][] a = {
                {45, 92, 14, 20, 25, 78},
                {35, 72, 24, 45, 42, 60},
                {32, 42, 64, 23, 41, 39},
                {98, 45, 94, 11, 18, 48}
        };
        Arrays.stream(corteza(a))
                .forEach(System.out::println);

    }

    /**
     * Extrae la capa exterior (corteza) de un array bidimensional y la devuelve como un array de una dimensión.
     * El recorrido empieza en la esquina superior izquierda y sigue en sentido horario.
     *
     * @param n Matriz de enteros.
     * @return Array con la capa exterior de la matriz.
     */
    public static int[] corteza(int[][] n) {
        if (n == null || n.length == 0) return new int[0];
        int filas = n.length;
        int columnas = n[0].length;
        int total = 2 * filas + 2 * columnas - 4;

        int[] resultado = new int[total];
        int k = 0;

        // 1. Fila superior (izquierda a derecha)
        for (int j = 0; j < columnas; j++)
            resultado[k++] = n[0][j];

        // 2. Columna derecha (de la 2ª fila a la última)
        for (int i = 1; i < filas; i++)
            resultado[k++] = n[i][columnas - 1];

        // 3. Fila inferior (derecha a izquierda, sin la esquina ya tomada)
        for (int j = columnas - 2; j >= 0; j--)
            resultado[k++] = n[filas - 1][j];

        // 4. Columna izquierda (de la penúltima fila hacia la 2ª, sin esquinas)
        for (int i = filas - 2; i > 0; i--)
            resultado[k++] = n[i][0];

        return resultado;
    }

}
