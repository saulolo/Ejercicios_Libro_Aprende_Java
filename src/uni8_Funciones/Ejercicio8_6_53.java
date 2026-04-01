package uni8_Funciones;

/**
 * Implementa una función con nombre nEsimo que busque el número que hay dentro de un array bidimensional en la posición
 * n-ésima contando de izquierda a derecha y de arriba abajo, como si se estuviera leyendo. El primer elemento es el 0.
 * Si la posición donde se busca no existe en el array, la función debe devolver -1. Se debe entregar tanto el código de
 * la función como el código de prueba que la usa. La cabecera de la función es la siguiente:
 * <br>public static int nEsimo(int[][] n, int posicion)
 * <br>Si el array a es el que se muestra a continuación:
 * <br>35 72 24 45 42 60
 * <br>32 42 64 23 41 39
 * <br>98 45 94 11 18 48
 * <br>12 34 56 78 90 12
 * <br>nEsimo(a, 0) devuelve 35
 * <br>nEsimo(a, 2) devuelve 24
 * <br>nEsimo(a, 5) devuelve 60
 * <br>nEsimo(a, 6) devuelve 32
 *
 * @author Saulolo
 */
public class Ejercicio8_6_53 {

    public static void main(String[] args) {

        System.out.println("=== E-NESIMO ENCONTRADO ===");
        //Matriz
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(nEsimo(matriz, 3));
    }

    /**
     * Devuelve el elemento de la posición n-ésima de una matriz, contando de
     * izquierda a derecha y de arriba a abajo, o -1 si la posición no existe.
     *
     * @param n matriz
     * @param posicion posición lineal a consultar
     * @return el elemento, o -1 si la posición está fuera de rango
     */
    public static int nEsimo(int[][] n, int posicion) {
        if (n == null || n.length == 0) return -1;
        int filas = n.length;
        int columnas = n[0].length;
        int total = filas * columnas;
        if (posicion < 0 || posicion >= total) return -1;

        int fila = posicion / columnas;
        int columna = posicion % columnas;
        return n[fila][columna];
    }

}
