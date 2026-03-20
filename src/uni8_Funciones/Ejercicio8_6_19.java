package uni8_Funciones;

/**
 * Une y amplía los dos programas anteriores de tal forma que se permita convertir un número entre
 * cualquiera de las siguientes bases: decimal, binario, hexadecimal y octal.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_19 {

    public static void main(String[] args) {

        System.out.println("=== DECIMAL A BINARIO, HEXADECIMAL U OCTAL ===");
        decimalToBase(255);

    }


    /**
     * Imprime la conversión de un número decimal a binario, hexadecimal y octal.
     *
     * @param number Número en base decimal a convertir.
     */
    public static void decimalToBase(int number) {
        String decimal = Integer.toString(number);
        String binary = Integer.toBinaryString(number);
        String hexadecimal = Integer.toHexString(number).toUpperCase();
        String octal = Integer.toOctalString(number);

        System.out.printf("Resultado de la converción de número: %d convertido a otras bases: " +
                "\nDecimal => %s" +
                "\nBinario => %s" +
                "\nHexadecimal => %s" +
                "\nOctal => %s", number, decimal, binary, hexadecimal, octal);
    }

}
