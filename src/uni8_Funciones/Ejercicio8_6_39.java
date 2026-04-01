package uni8_Funciones;

/**
 * Crea una función con la siguiente cabecera:
 * <br>public String convierteEnPalabras(int n)
 * Esta función convierte los dígitos del número n en las correspondientes palabras y lo devuelve tod en una cadena de
 * caracteres. Por ejemplo, el 470213 convertido a palabras sería:
 * <br>cuatro, siete, cero, dos, uno, tres
 * <br>Utiliza esta función en un programa para comprobar que funciona bien. Desde la función no se debe mostrar nada por
 * pantalla, solo se debe usar print desde el programa principal. Fíjate que hay una coma detrás de cada palabra salvo
 * al final.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_39 {

    public static void main(String[] args) {

        System.out.println("=== CONVERSOS DE PALABRAS NUMÉRICAS ===");
        int numero = 13;
        System.out.println("Número: " + numero + " en texto ==> " + convierteEnPalabras(numero));


    }

    /**
     * Convierte los dígitos del número n en palabras separadas por coma.
     *
     * @param n Número entero (positivo o negativo).
     * @return  Cadena con las palabras correspondientes.
     */
    public static String convierteEnPalabras(int n) {
        String[] NUMEROS_TEXTO = {
                "cero",
                "uno",
                "dos",
                "tres",
                "cuatro",
                "cinco",
                "seis",
                "siete",
                "ocho",
                "nueve",
        };

        String numStr = String.valueOf(Math.abs(n));
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            int d = numStr.charAt(i) - '0';
            resultado.append(NUMEROS_TEXTO[d]);
            if (i < numStr.length() - 1) {
                resultado.append(", ");
            }
        }
        return resultado.toString();

    }

}
