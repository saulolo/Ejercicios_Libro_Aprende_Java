package uni8_Funciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Crea la función de manejo de arrays que tenga la siguiente cabecera y que haga lo que se especifica en los comentarios
 * (puedes incluirla en tu propia biblioteca de rutinas):
 * <br>public int[] filtraCapicuas(int x[])
 * <br>// Devuelve un array con todos los números.
 * <br>// capicúa que se encuentren en otro array que se pasa como parámetro.
 * <br>// Obviamente el tamaño del array que se devuelve será menor o igual al que se pasa como parámetro.
 * Utiliza esta función en un programa para comprobar que funcionan bien. Para que el ejercicio resulte más fácil, las
 * repeticiones de números capicúa se conservan; es decir, si en el array x el número 505 se repite 3 veces, en el array
 * devuelto también estará repetido 3 veces. Si no existe ningún número capicúa en x, se devuelve un array con el
 * número -1 como único elemento.
 *
 * @author Saulolo
 */
public class Ejercicio8_6_38 {

    public static void main(String[] args) {

        System.out.println("=== FILTRO CAPUCÚA ===");
        int[] numbers = {21, 121, 33, 13};
        Arrays.stream(filtraCapicuas(numbers))
                .forEach(System.out::println);

    }

    /**
     * Devuelve un array con todos los números capicúa encontrados en el array dado.
     * Si no hay ninguno, devuelve {-1}.
     *
     * @param x Array de enteros a filtrar.
     * @return  Array con los números capicúa o {-1} si no hay ninguno.
     */
    public static int[] filtraCapicuas(int[] x) {
        if (x == null || x.length == 0)
            throw new IllegalArgumentException("El array no puede ser nulo ni vacío.");

        List<Integer> capicuas = new ArrayList<>();
        for (int num : x) {
            if (esCapicua(num)) {
                capicuas.add(num);
            }
        }
        if (capicuas.isEmpty()) {
            return new int[] { -1 };
        }
        int[] resultado = new int[capicuas.size()];
        for (int i = 0; i < capicuas.size(); i++) {
            resultado[i] = capicuas.get(i);
        }
        return resultado;
    }

    // Función auxiliar para comprobar si es capicua
    private static boolean esCapicua(int n) {
        String s = String.valueOf(Math.abs(n));
        String r = new StringBuilder(s).reverse().toString();
        return s.equals(r);
    }

}
