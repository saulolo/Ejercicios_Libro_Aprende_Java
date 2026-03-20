package uni8_Funciones;

import java.util.ArrayList;
import java.util.List;

/**
 * Muestra los números primos que hay entre 1 y 1000.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_15 {

    public static void main(String[] args) {

        System.out.println("=== NUMEROS PRIMOS ENTRE 1 y 1000 ===");
        System.out.println(primeNumbers());

    }

    /**
     * Devuelve una lista con todos los números primos entre 1 y 1000.
     *
     * @return Lista de números primos.
     */
    public static List<Integer> primeNumbers() {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * Comprueba si el número ingresado es primo.
     *
     * @param number Número a validar
     * @return {@code true}si el número es primo o {@code false} en caso contrario
     */
    public static boolean isPrime(int number) {
        int acum = 0;

        if (number < 2) {
            return false;
        }
        for (int i = 1; i <= number; i++) {
            int aux = number % i;
            if (aux == 0) {
                acum = acum + 1;
            }
        }
        if (acum > 2) {
            return false;
        }
        return true;
    }

}
