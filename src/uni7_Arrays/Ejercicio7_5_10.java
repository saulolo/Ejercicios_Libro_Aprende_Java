package uni7_Arrays;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Realiza un programa que sea capaz de rotar todos los elementos de una matriz cuadrada una posición en el sentido de
 * las agujas del reloj. La matriz debe tener 12 filas por 12 columnas y debe contener números generados al azar entre
 * 0 y 100. Se debe mostrar tanto la matriz original como la matriz resultado, ambas con los números convenientemente
 * alineados.
 * @author Saulolo
 */
public class Ejercicio7_5_9 {

    public static void main(String[] args) {

        String intro = "ROTANDO ELEMENTOS DE UNA MATRIZ' ";
        JOptionPane.showMessageDialog(null, intro);

        final int SIZE = 12;
        int[][] matriz = new int[SIZE][SIZE];
        Random random = new Random();

        // Generar matriz con números aleatorios entre 0 y 100
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matriz[i][j] = random.nextInt(101);
            }
        }

        // Mostrar matriz original
        System.out.println("Matriz original:");
        mostrarMatriz(matriz);

        // Rotar la matriz
        rotarMatriz(matriz);

        // Mostrar matriz rotada
        System.out.println("\nMatriz rotada:");
        mostrarMatriz(matriz);
    }

    // Método para mostrar la matriz
    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

    // Método para rotar la matriz
    public static void rotarMatriz(int[][] matriz) {
        int n = matriz.length;

        // Procesar cada capa de la matriz
        for (int capa = 0; capa < n / 2; capa++) {
            int inicio = capa;
            int fin = n - 1 - capa;

            // Guardar los elementos de la fila superior de la capa
            int[] temp = new int[fin - inicio];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = matriz[inicio][inicio + i];
            }

            // Mover los elementos de la columna izquierda hacia la fila superior
            for (int i = inicio; i < fin; i++) {
                matriz[inicio][i] = matriz[n - 1 - (i - inicio)][inicio];
            }

            // Mover los elementos de la fila inferior hacia la columna izquierda
            for (int i = inicio; i < fin; i++) {
                matriz[n - 1 - (i - inicio)][inicio] = matriz[fin][n - 1 - (i - inicio)];
            }

            // Mover los elementos de la columna derecha hacia la fila inferior
            for (int i = inicio; i < fin; i++) {
                matriz[fin][n - 1 - (i - inicio)] = matriz[i][fin];
            }

            // Colocar los elementos de la fila superior almacenados en la columna derecha
            for (int i = 0; i < temp.length; i++) {
                matriz[i + inicio][fin] = temp[i];
            }
        }

    }

}


