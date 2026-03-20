package uni8_Funciones;

import java.util.ArrayList;
import java.util.List;

/**
 * Muestra los números capicúa que hay entre 1 y 99999.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_16 {

    public static void main(String[] args) {

        System.out.println("=== NUMEROS CAPICUAS ENTRE 1 y 99999 ===");
        System.out.println(capicuaNumbers());

    }

    /**
     * Devuelve una lista con todos los números palíndromos (capicuas) entre 1 y 999999.
     *
     * @return Lista de números palíndromos.
     */
    public static List<Integer> capicuaNumbers() {
        List<Integer> capicuas = new ArrayList<>();

        for (int i = 1; i <= 99999; i++) {
            if (isCapicua(i)) {
                capicuas.add(i);
            }
        }
        return capicuas;
    }

    /**
     * Comprueba si un número ingresado es palindromo.
     *
     * @param number Número a validar
     * @return {@code true} si el número es palindromo o {@code false} en caso contrario
     */
    public static boolean isCapicua(int number) {
        String numberText = String.valueOf(number);
        String invertNumber = new StringBuilder(numberText).reverse().toString();

        return numberText.equals(invertNumber);
    }

}
