package uni8_Funciones;

/**
 * Escribe un programa que pase de binario a decimal.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_17 {

    public static void main(String[] args) {

        System.out.println("=== BINARIO A DECIMAL ===");
        System.out.println(binaryToDecimal("1011"));

    }


    /**
     * Convierte un número binario (representado como String) a decimal.
     *
     * @param binary Cadena que representa el número binario (ej: "1011").
     * @return El valor decimal equivalente.
     * @throws NumberFormatException Si la cadena contiene caracteres no binarios.
     */
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

}
