package uni8_Funciones;

import java.util.Scanner;

/**
 * Realiza un programa que pinte un valle tal como se muestra en los ejemplos. El usuario debe introducir la altura de
 * la figura. Podemos suponer que el usuario introduce una altura mayor o igual a 3 (Imagen).
 * <br>Ejemplo 1:
 * <br>Introduzca la altura de la figura: 10
 * @author Saulolo
 */
public class Ejercicio8_6_45 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== VALLE ===");
        System.out.print("Introduce la altura del valle: ");
        int altura = scanner.nextInt();

        for (int i = 1; i <= altura; i++) {
            imprime('*', i);
            imprime(' ', 2 * (altura - i));
            imprime('*', i);
            System.out.println();
        }
    }


    /**
     * Imprime un carácter dado una cantidad de veces en la misma línea.
     * @param c Carácter a imprimir.
     * @param repeticiones Número de veces.
     */
    public static void imprime(char c, int repeticiones) {
        for (int i = 0; i < repeticiones; i++) System.out.print(c);
    }
}




