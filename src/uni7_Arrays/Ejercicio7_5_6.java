package uni7_Arrays;

import javax.swing.*;

/**
 * Realiza un programa que rellene un array de 6 filas por 10 columnas con números enteros positivos comprendidos
 * entre 0 y 1000 (ambos incluidos). A continuación, el programa deberá dar la posición tanto del máximo como del
 * mínimo.
 * @author Saulolo
 */
public class Ejercicio7_5_5 {

    public static void main(String[] args) {

        String intro = "MÁXIMO Y MÍNIMO DE UN ARRAY";
        JOptionPane.showMessageDialog(null, intro);

        int[][] array = new int[6][10];
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        int filaMax = 0, colMax = 0;
        int filaMin = 0, colMin = 0;

        // Rellenar el array con números aleatorios y buscar máximo y mínimo
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 1001); // Generar números entre 0 y 1000

                // Comprobar si es el máximo
                if (array[i][j] > maximo) {
                    maximo = array[i][j];
                    filaMax = i;
                    colMax = j;
                }

                // Comprobar si es el mínimo
                if (array[i][j] < minimo) {
                    minimo = array[i][j];
                    filaMin = i;
                    colMin = j;
                }
            }
        }

        // Mostrar el array
        System.out.println("Array generado:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%5d ", array[i][j]); // Formato de salida
            }
            System.out.println();
        }

        // Mostrar resultados
        System.out.println("\nEl valor máximo es " + maximo + " en la posición [" + filaMax + "][" + colMax + "].");
        System.out.println("El valor mínimo es " + minimo + " en la posición [" + filaMin + "][" + colMin + "].");
    }
}


