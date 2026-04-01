package uni8_Funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static uni8_Funciones.Ejercicio8_6_47.convierteArrayEnString;

/**
 * Escribe un programa que genere los n primeros términos de la sucesión look and say. El primer término es 1.
 * A continuación se va leyendo - un uno - por tanto tenemos 11, se sigue leyendo – dos unos – por tanto tenemos 21,
 * etc. Se recomienda usar arrays para almacenar los dígitos porque los tipos int y long son muy limitados en cuanto
 * al número de dígitos. También puede resultar de ayuda utilizar las funciones convierteArrayEnString y concatena
 * definidas en los ejercicios anteriores.
 * <br>Ejemplo:
 * <br>¿Cuántos términos de la sucesión look and say quiere calcular? 8
 * <br>1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211
 * @author Saulolo
 */
public class Ejercicio8_6_49 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SUCESIÓN LOOK AND SAY ===");
        System.out.println("¿Cuántos términos de la sucesión look and say quiere calcular?");
        int n = scanner.nextInt();

        int[] termino = {1}; // Primer término

        for (int i = 0; i < n; i++) {
            System.out.print(convierteArrayEnString(termino));
            if (i < n - 1) {
                System.out.print(", ");
            }
            termino = siguienteTermino(termino);
        }
        System.out.println();
    }

    /**
     * Genera el siguiente término de la sucesión look and say, dado el término actual.
     * @param termino Término actual como array de dígitos.
     * @return Array de dígitos del siguiente término.
     */
    public static int[] siguienteTermino(int[] termino) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0;
        while (i < termino.length) {
            int count = 1;
            while (i + count < termino.length && termino[i + count] == termino[i]) {
                count++;
            }
            resultado.add(count);
            resultado.add(termino[i]);
            i += count;
        }
        return resultado.stream().mapToInt(Integer::intValue).toArray();
    }

}
