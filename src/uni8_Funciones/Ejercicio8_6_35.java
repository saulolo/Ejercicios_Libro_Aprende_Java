package uni8_Funciones;

/**
 * Crea una función con la siguiente cabecera:
 * <br>public static String convierteEnPalotes(int n)<br/>
 * Esta función convierte el número n al sistema de palotes y lo devuelve en una cadena de caracteres.
 * Por ejemplo, el 470213 en decimal es el | | | | - | | | | | | | - - | | - | - | | | en el sistema de palotes.
 * Utiliza esta función en un programa para comprobar que funciona bien. Desde la función no se debe mostrar nada por
 * pantalla, solo se debe usar print desde el programa principal.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_35 {

    public static void main(String[] args) {

        System.out.println("=== CONVERSION EN PALOTES ===");
        System.out.println(convierteEnPalotes(205465));
    }

    /**
     * Convierte un número al sistema de palotes y lo devuelve como cadena.
     * Cada cifra se representa con palotes '|' y las cifras se separan con '-'.
     * El cero se representa como '--'.
     *
     * @param n Número entero positivo o negativo a convertir.
     * @return  Cadena de palotes correspondiente.
     */
    public static String convierteEnPalotes(int n) {
        String numStr = String.valueOf(Math.abs(n));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);

            if (c == '0') {
                result.append("--");
            } else {
                int digit = c - '0';
                for (int j = 0; j < digit; j++) {
                    result.append('|');
                }
            }
            // Sólo añade separador si no es la última cifra
            if (i != numStr.length() - 1) {
                result.append('-');
            }
        }
        return result.toString();
    }

}
