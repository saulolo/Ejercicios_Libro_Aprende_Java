package uni8_Funciones.matematicas;

/**
 * Funciones Matemáticas varias
 *
 * @author Saulolo
 */
public class Various {


    /**
     * Valida si un número es primo o no.
     *
     * @param number número a evaluar
     * @return {@code true} si el número es primo o {@code false} en caso contrario
     */
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Devuelve el número de digitos que contiene un número entero
     *
     * @param number Número entero a evaluar
     * @return la cantidad de digitos que contiene el número
     */
    public static int digits(int number) {
        if (number == 0) return 1;
        else {
            int count = 0;
            while (number > 0) {
                number = number / 10;
                count++;
            }
            return count;
        }
    }

}
