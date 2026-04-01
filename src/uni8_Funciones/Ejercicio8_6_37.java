package uni8_Funciones;

/**
 * Crea una función con la siguiente cabecera:
 * <br>public String convierteEnMorse(int n)
 * Esta función convierte el número n al sistema Morse y lo devuelve en una cadena de caracteres. Por ejemplo, el 213 es
 * el . . _ _ _ . _ _ _ _ . . . _ _ en Morse. Utiliza esta función en un programa para comprobar que funciona bien.
 * Desde la función no se debe mostrar nada por pantalla, solo se debe usar print desde el programa principal.
 * <br>1 . _ _ _ _ 6 _ . . . .
 * <br>2 . . _ _ _ 7 _ _ . . .
 * <br>3 . . . _ _ 8 _ _ _ . .
 * <br>4 . . . . _ 9 _ _ _ _ .
 * <br>5 . . . . . 0 _ _ _ _ _
 *
 * @author Saulolo
 */
public class Ejercicio8_6_37 {

    public static void main(String[] args) {

        System.out.println("=== NÚMERO EN MORSE ===");
        int number = 13;
        System.out.println("Número " + number + " ==> " + convierteEnMorse(number));
    }

    /**
     * Convierte el número n a su representación en código Morse según la tabla.
     *
     * @param n Número entero (positivo o negativo).
     * @return  Cadena Morse de los dígitos, separados por espacio.
     */
    public static String convierteEnMorse(int n) {
        String[] MORSE_DIGITOS = {
                "_ _ _ _ _", // 0
                ". _ _ _ _", // 1
                ". . _ _ _", // 2
                ". . . _ _", // 3
                ". . . . _", // 4
                ". . . . .", // 5
                "_ . . . .", // 6
                "_ _ . . .", // 7
                "_ _ _ . .", // 8
                "_ _ _ _ .", // 9
        };

        String numero = String.valueOf(Math.abs(n));
        StringBuilder morse = new StringBuilder();
        for (int i = 0; i < numero.length(); i++) {
            int d = numero.charAt(i) - '0';
            morse.append(MORSE_DIGITOS[d]);
            if (i < numero.length() - 1) morse.append(" ");
        }
        return morse.toString();
    }

}
