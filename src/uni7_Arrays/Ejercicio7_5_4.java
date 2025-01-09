package uni7_Arrays;

import javax.swing.*;

/**
 * Modifica el programa anterior (Ejercicio7_5_2) de tal forma que las sumas parciales y la suma
 * total aparezcan en la pantalla con un pequeño retardo, dando la impresión de que el ordenador se
 * queda “pensando” antes de mostrar los números.
 *
 * @author Saulolo
 */
public class Ejercicio7_5_4 {

    public static void main(String[] args) {


        String intro = "GENERANDO NÚMEROS ALEATORIOS Y MOSTRANDO SUMAS CON RETARDO";
        JOptionPane.showMessageDialog(null, intro);

        int[][] num = new int[4][5];
        int[] sumaFilas = new int[4];
        int[] sumaColumnas = new int[5];
        int sumaTotal = 0;

        // Llenar el array con números aleatorios y calcular las sumas
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = (int) (Math.random() * (999 - 100 + 1)) + 100; // Generar número aleatorio
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

        try {
            // Mostrar sumas de columnas con retardo
            System.out.println("Calculando las sumas de las columnas...");
            Thread.sleep(1000); // Retardo de 1 segundo
            for (int j = 0; j < sumaColumnas.length; j++) {
                System.out.printf("Suma columna %d: %d\n", j + 1, sumaColumnas[j]);
                Thread.sleep(500); // Retardo de 0.5 segundos entre columnas
            }

            // Mostrar suma total con retardo
            System.out.println("Calculando la suma total...");
            Thread.sleep(1500); // Retardo de 1.5 segundos
            System.out.println("Suma total: " + sumaTotal);

        } catch (InterruptedException e) {
            System.err.println("El cálculo fue interrumpido.");
        }
    }
}


