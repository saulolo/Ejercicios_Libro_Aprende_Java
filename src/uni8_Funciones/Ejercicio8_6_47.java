package uni8_Funciones;

/**
 * Define la función convierteArrayEnString con la siguiente cabecera:
 * <br>public static String convierteArrayEnString(int[] a)
 * <br>Esta función toma como parámetro un array que contiene números y devuelve una cadena de caracteres con esos números.
 * Por ejemplo, si a = { }, convierteArrayEnString(a) devuelve “”; si a = { 8 }, convierteArrayEnString(a)
 * devuelve “8”; si a = { 6, 2, 5, 0, 1 }, convierteArrayEnString(a) devuelve “62501”.
 * @author Saulolo
 */
public class Ejercicio8_6_47 {

    public static void main(String[] args) {

        System.out.println("=== CONVERTIDOR DE ARRAY A STRING ===");
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(convierteArrayEnString(numbers));

    }

    /**
     * Convierte un array de enteros en una cadena concatenando sus elementos sin separadores.
     *
     * @param a Array de enteros.
     * @return Cadena resultante de concatenar los números del array.
     */
    public static String convierteArrayEnString(int[] a) {
        StringBuilder result = new StringBuilder();
        for (int num : a) {
            result.append(num);

        }
        return result.toString();
    }

}
