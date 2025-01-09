package uni7_Arrays;

import javax.swing.*;
import java.util.Random;

/**
 * Realiza un programa que muestre por pantalla un array de 9 filas por 9 columnas relleno con números aleatorios entre
 * 500 y 900. A continuación, el programa debe mostrar los números de la diagonal que va desde la esquina inferior
 * izquierda a la esquina superior derecha, así como el máximo, el mínimo y la media de los números que hay en esa diagonal.
 * @author Saulolo
 */
public class Ejercicio7_5_12 {

    public static void main(String[] args) {

        String intro = "NÚMEROS EN DIAGONAL CON MÁXIMO, MÍNIMO Y MEDIA";
        JOptionPane.showMessageDialog(null, intro);
        // Crear el array bidimensional de 9x9
        int[][] matriz = new int[9][9];
        Random random = new Random();

        // Variables para el cálculo
        int suma = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Llenar la matriz con números aleatorios entre 500 y 900
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matriz[i][j] = 500 + random.nextInt(401); // Aleatorio entre 500 y 900
            }
        }

        // Mostrar la matriz
        System.out.println("Matriz generada:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

        // Mostrar y calcular los valores de la diagonal secundaria
        System.out.println("\nNúmeros en la diagonal secundaria:");
        for (int i = 0; i < 9; i++) {
            int numeroDiagonal = matriz[i][8 - i]; // Elemento de la diagonal secundaria
            System.out.print(numeroDiagonal + " ");
            suma += numeroDiagonal;

            if (numeroDiagonal > max) {
                max = numeroDiagonal;
            }
            if (numeroDiagonal < min) {
                min = numeroDiagonal;
            }
        }

        // Calcular la media
        double media = (double) suma / 9;

        // Mostrar los resultados
        System.out.println("\n\nResultados:");
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Media: " + media);
    }
    
}


