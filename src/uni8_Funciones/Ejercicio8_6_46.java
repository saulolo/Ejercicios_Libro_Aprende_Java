package uni8_Funciones;

import java.util.Scanner;

/**
 * Realiza un programa que pinte un valle tal como se muestra en los ejemplos. El usuario debe introducir la altura de
 * la figura. Podemos suponer que el usuario introduce una altura mayor o igual a 3. (Imagen).
 * <br>Ejemplo 1:
 * <br>Introduzca la altura de la figura: 8
 * @author Saulolo
 */
public class Ejercicio8_6_46 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== VALLE BASE HUECA ===");
        System.out.print("Introduce la altura del valle: ");
        int altura = scanner.nextInt();

        imprimeValleHueco(altura);

    }


    /**
     * Imprime los lados del valle hueco y los espacios centrales.
     */
    public static void imprimeValleHueco(int altura) {
        for (int i = 1; i <= altura; i++) {
            // Lado izquierdo
            ladoHueco(i);

            // Espacios del valle
            for (int j = 0; j < 2 * (altura - i); j++) System.out.print(" ");

            // Lado derecho
            ladoHueco(i);

            System.out.println();
        }
    }

    /**
     * Imprime un lado de triángulo hueco de tamaño i.
     * @param i Fila actual
     */
    public static void ladoHueco(int i) {
        System.out.print("*");
        if (i > 1) {
            for (int j = 0; j < i - 2; j++) System.out.print(" ");
            System.out.print("*");
        }
    }

}








