package uni7_Arrays;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Modifica el programa anterior de tal forma que no se repita ningún número en el array.
 * @author Saulolo
 */
public class Ejercicio7_5_6 {

    public static void main(String[] args) {

        String intro = "MÁXIMO Y MÍNIMO DE UN ARRAY SIN REPETIR NÚMERO";
        JOptionPane.showMessageDialog(null, intro);

        int[][] array = new int[6][10];
        Set<Integer> numerosGenerados = new HashSet<>();
        int filas = array.length;
        int columnas = array[0].length;

        // Rellenar el array con números únicos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int numero;
                do {
                    numero = (int) (Math.random() * 1001);
                } while (numerosGenerados.contains(numero)); // Verificar si ya existe
                array[i][j] = numero;
                numerosGenerados.add(numero);
            }
        }

        // Encontrar el máximo y el mínimo
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        int posMaxFila = -1, posMaxColumna = -1;
        int posMinFila = -1, posMinColumna = -1;

        // Rellenar el array con números aleatorios y buscar máximo y mínimo
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (array[i][j] > maximo) {
                    maximo = array[i][j];
                    posMaxFila = i;
                    posMaxColumna = j;
                }
                if (array[i][j] < minimo) {
                    minimo = array[i][j];
                    posMinFila = i;
                    posMinColumna = j;
                }
            }
        }

        // Imprimir el array
        System.out.println("Contenido del array:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%4d ", array[i][j]);
            }
            System.out.println();
        }

        // Imprimir el máximo y mínimo con sus posiciones
        System.out.println("\nNúmero máximo: " + maximo + " en la posición [" + posMaxFila + "][" + posMaxColumna + "]");
        System.out.println("Número mínimo: " + minimo + " en la posición [" + posMinFila + "][" + posMinColumna + "]");
    }
}


