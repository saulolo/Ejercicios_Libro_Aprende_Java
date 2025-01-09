package uni7_Arrays;

import javax.swing.*;
import java.util.Random;

/**
 * Realiza un programa que calcule la estatura media, mínima y máxima en centímetros de personas de diferentes países.
 * El array que contiene los nombres de los paises es el siguiente: pais = {“España”, “Rusia”, “Japón”, “Australia”}.
 * Los datos sobre las estaturas se deben simular mediante un array de 4 filas por 10 columnas con números aleatorios
 * generados al azar entre 140 y 210. Los decimales de la media se pueden despreciar. Los nombres de los países se deben
 * mostrar utilizando el array de países (no se pueden escribir directamente).
 * @author Saulolo
 */
public class Ejercicio7_5_13 {

    public static void main(String[] args) {

        String intro = "CÁLCULO DE ESTATURA EN PAISES";
        JOptionPane.showMessageDialog(null, intro);

        // Array de países
        String[] paises = {"España", "Rusia", "Japón", "Australia"};

        // Array bidimensional de estaturas (4 filas x 10 columnas)
        int[][] estaturas = new int[4][10];
        Random random = new Random();

        // Llenar el array con valores aleatorios entre 140 y 210
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                estaturas[i][j] = 140 + random.nextInt(71); // Aleatorio entre 140 y 210
            }
        }

        // Mostrar los resultados por país
        for (int i = 0; i < 4; i++) {
            System.out.println("País: " + paises[i]);

            int suma = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // Calcular suma, mínimo y máximo para cada país
            for (int j = 0; j < 10; j++) {
                int estatura = estaturas[i][j];
                suma += estatura;

                if (estatura < min) {
                    min = estatura;
                }

                if (estatura > max) {
                    max = estatura;
                }
            }

            // Calcular la media (despreciando decimales)
            int media = suma / 10;

            // Mostrar estaturas y resultados
            System.out.println("Estaturas: ");
            for (int j = 0; j < 10; j++) {
                System.out.print(estaturas[i][j] + " ");
            }

            System.out.println("\nEstatura media: " + media + " cm");
            System.out.println("Estatura mínima: " + min + " cm");
            System.out.println("Estatura máxima: " + max + " cm");
            System.out.println();
        }

    }
    
}


