package uni8_Funciones;

/**
 * Escribe un programa que pase de decimal a binario.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_18 {

    public static void main(String[] args) {

        System.out.println("=== DECIMAL A BINARIO ===");
        System.out.println(decimalToBinary(5));

    }


    /**
     * Convierte un número decimal (entero) a binario (representado como String).
     *
     * @param decimal Número decimal entero.
     * @return La cadena binaria equivalente.
     */
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

}
