package uni7_Arrays;

import javax.swing.*;
import java.util.Scanner;

/**
 * Modifica el programa anterior (Ejercicio7_5_2) de tal forma que los números que se introducen
 * en el array se generen de forma aleatoria (valores entre 100 y 999).
 * @author Saulolo
 */
public class Ejercicio7_5_3 {

    public static void main(String[] args) {

        String intro = "GENERANDO NÚMEROS ALEATORIOS PARA ARRAYS BIDIMENSIONALES";
        JOptionPane.showMessageDialog(null, intro);

        int[][] num = new int[4][5];
        int[] sumaFilas = new int[4];
        int[] sumaColumnas = new int[5];
        int sumaTotal = 0;

        // Llenar el array con números aleatorios y calcular las sumas
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = (int)(Math.random() * (999 - 100 + 1)) + 100; // Generar número aleatorio
                sumaFilas[i] += num[i][j];
                sumaColumnas[j] += num[i][j];
                sumaTotal += num[i][j];
            }
        }

        // Mostrar el array con las sumas parciales y totales
        System.out.println("Array bidimensional con sumas:");
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.printf("%5d", num[i][j]);
            }
            System.out.printf(" | Suma fila %d: %d\n", i + 1, sumaFilas[i]);
        }

        System.out.println("========================");

        for (int j = 0; j < sumaColumnas.length; j++) {
            System.out.printf("Suma columna %d: %d\n", j + 1, sumaColumnas[j]);
        }

        System.out.println("Suma total: " + sumaTotal);
    }
}


