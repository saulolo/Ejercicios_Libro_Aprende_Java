package uni7_Arrays;

import javax.swing.*;
import java.util.Random;

/**
 * Realiza un programa que muestre por pantalla un array de 10 filas por 10 columnas relleno con números aleatorios
 * entre 200 y 300. A continuación, el programa debe mostrar los números de la diagonal que va desde la esquina superior
 * izquierda a la esquina inferior derecha, así como el máximo, el mínimo y la media de los números que hay en esa
 * diagonal.
 * @author Saulolo
 */
public class Ejercicio7_5_11 {

    public static void main(String[] args) {

        String intro = "NÚMEROS EN DIAGONAL";
        JOptionPane.showMessageDialog(null, intro);

        // Crear el array bidimensional de 10x10
        int[][] matriz = new int[10][10];
        Random random = new Random();

        // Variables para el cálculo
        int suma = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Llenar la matriz con números aleatorios entre 200 y 300
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = 200 + random.nextInt(101); // Aleatorio entre 200 y 300
            }
        }

        // Mostrar la matriz
        System.out.println("Matriz generada:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

        // Mostrar y calcular los valores de la diagonal principal
        System.out.println("\nNúmeros en la diagonal principal:");
        for (int i = 0; i < 10; i++) {
            int numeroDiagonal = matriz[i][i];
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
        double media = (double) suma / 10;

        // Mostrar los resultados
        System.out.println("\n\nResultados:");
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Media: " + media);
    }
    
}


