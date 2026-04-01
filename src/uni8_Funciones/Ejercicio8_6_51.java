package uni8_Funciones;

import java.util.Random;

/**
 * Realiza un programa que rellene un array con 10 números aleatorios comprendidos entre 2 y 100 (ambos incluidos) y que
 * los muestre por pantalla. A continuación, el programa indicará para cada uno de ellos si es un número primo y/o un
 * capicúa de la forma que muestra el ejemplo.
 * <br>Ejemplo:
 * <br>Array generado:
 * <br>19 22 57 11 3 52 32 46 2 14
 * <br>El 19 es primo y no es capicúa.
 * <br>El 22 no es primo y es capicúa.
 * <br>El 57 no es primo y no es capicúa
 * @author Saulolo
 */
public class Ejercicio8_6_51 {

    public static void main(String[] args) {

        System.out.println("=== PRIMO Y/O CAPICUA ===");
        aleatorioPrimoCapicua();

    }

    /**
     * Genera un array con diez números aleatorios entre 2 y 100,
     * los muestra y para cada número indica si es primo y/o capicúa.
     */
    public static void aleatorioPrimoCapicua() {

        int min = 2;
        int max = 100;
        int cantidad = 10;
        int[] numeros = new int[cantidad];

        Random random = new Random();

        System.out.println("Array generado:");
        //Releno el array
        for (int i = 0; i < cantidad; i++) {
            System.out.println(numeros[i] = random.nextInt((max - min) + 1) + min);
        }

        System.out.println();
        // Analizar cada número
        for (int x : numeros) {
            System.out.print("El " + x + " ");
            if (esPrimo(x)) {
                System.out.print("es primo");
            } else {
                System.out.print("no es primo");
            }
            System.out.print(" y ");
            if (esCapicua(x)) {
                System.out.print("es capicúa.");
            } else {
                System.out.print("no es capicúa.");
            }
            System.out.println();
        }

    }

    // Función auxiliar para validar si un número es primo
    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Función auxiliar para validar si un número es capicua
    public static boolean esCapicua(int n) {
        int original = n, invertido = 0;
        while (n > 0) {
            invertido = invertido * 10 + n % 10;
            n /= 10;
        }
        return original == invertido;
    }

}
