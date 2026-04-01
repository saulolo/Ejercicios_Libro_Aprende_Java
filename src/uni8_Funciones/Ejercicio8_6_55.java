package uni8_Funciones;

import java.util.Arrays;

/**
 * Realiza una función que tome como parámetro un array de cadenas de caracteres y que devuelva otro array con los mismos
 * valores habiendo eliminado las posibles repeticiones. Se distinguen mayúsculas de minúsculas, por tanto “hola” es distinto
 * de “Hola”. Por ejemplo, si el array a contiene los valores {“casa”, “coche”, “sol”, “mesa”, “mesa”, “coche”, “ordenador”, “sol”, “CASA”},
 * la sentencia sinRepetir(a) devolvería el array {“casa”, “coche”, “sol”, “mesa”, “ordenador”, “CASA”}.
 * Se debe entregar tanto el código de la función como el código de prueba que la usa. La cabecera de la función es la siguiente:
 * <br>public static String[] sinRepetir(String[] s)
 *
 * @author Saulolo
 */
public class Ejercicio8_6_55 {

    public static void main(String[] args) {

        System.out.println("=== ARRAY SIN REPETIR ===");
        String[] cosas = {"casa", "coche", "sol", "mesa", "mesa", "coche","ordenador", "sol", "CASA"};

        Arrays.stream(sinRepetir(cosas))
                .forEach(System.out::println);
    }

    /**
     * Devuelve un nuevo array con los mismos valores que el original,
     * eliminando repeticiones (distinguiendo mayúsculas/minúsculas).
     *
     * @param s Array de cadenas de entrada.
     * @return Nuevo array sin repeticiones.
     */
    public static String[] sinRepetir(String[] s) {
        return Arrays.stream(s)
                .distinct()
                .toArray(String[]::new);
    }

}
