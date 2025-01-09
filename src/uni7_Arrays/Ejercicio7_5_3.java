package uni7_Arrays;

import javax.swing.*;
import java.util.Scanner;

/**
 * Escribe un programa que pida 20 números enteros. Estos números se deben
 * introducir en un array de 4 filas por 5 columnas. El programa mostrará las
 * sumas parciales de filas y columnas igual que si de una hoja de cálculo se
 * tratara. La suma total debe aparecer en la esquina inferior derecha.
 * @author Saulolo
 */
public class Ejercicio7_5_2 {

    public static void main(String[] args) {

        String into = "INGRESANDO Y SUMANDO NÚMEROS DE ARRAYS BIDIMENSIONALES";
        JOptionPane.showMessageDialog(null, into);

        Scanner scanner = new Scanner(System.in);

        int[][] num = new int[4][5];
        int[] sumaFilas = new int[4];
        int[] sumaColumnas = new int[5];
        int sumaTotal = 0;


        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.print("Introduce un número para la posición [" + i + "][" + j + "]: ");
                num[i][j] = scanner.nextInt();
                sumaFilas[i] += num[i][j];
                sumaColumnas[j] += num[i][j];
                sumaTotal += num[i][j];
            }
        }


        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.println(num[i][j]);
            }
            System.out.println(sumaFilas[i]);
        }

        System.out.println("========================");


        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.println(sumaColumnas[j]);
            }
            System.out.println(sumaTotal);
        }

    }
}


