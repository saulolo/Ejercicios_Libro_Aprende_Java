package uni8_Funciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Crea la función de manejo de arrays que tenga la siguiente cabecera y que haga lo que se especifica en los comentarios
 * (puedes incluirla en tu propia biblioteca de rutinas):
 * <br>public int[] filtraCon7(int x[])
 * <br>// Devuelve un array con todos los números  que contienen el 7 (por ej. 7, 27, 782) que se encuentren en otro array
 * <br>// que se pasa como parámetro. El tamaño del array que se devuelve será menor o igual al que se pasa como parámetro.
 * <br>Utiliza esta función en un programa para comprobar que funcionan bien. Para que el ejercicio resulte más fácil, las
 * repeticiones de números que contienen 7 se conservan; es decir, si en el array x el número 875 se repite 3 veces, en
 * el array devuelto también estará repetido 3 veces. Si no existe ningún número que contiene 7 en el array x, se
 * devuelve un array con el número -1 como único elemento.
 * @author Saulolo
 */
public class Ejercicio8_6_40 {

    public static void main(String[] args) {

        System.out.println("=== ARRAY FILTRADO POR 7 ===");
        int[] numeros = {1, 2, 3, 5, 7, 6, 17, 18, 71, 56, 89, 77};

        Arrays.stream(filtraCon7(numeros))
                .forEach(System.out::println);

    }

    /**
     * Devuelve un array con todos los números que contienen el dígito 7.
     * Si no hay ninguno, devuelve {-1}.
     * @param x Array de enteros a filtrar.
     * @return Array con los números que contienen 7 o {-1} si no hay ninguno.
     */
    public static int[] filtraCon7(int[] x) {
        if (x == null || x.length == 0) {
            throw new IllegalArgumentException("El array no puede ser nulo ni vacio.");
        }

        List<Integer> con7 = new ArrayList<>();
        for (int num : x) {
            if (contiene7(num)) {
                con7.add(num);
            }
        }
        if (con7.isEmpty()) {
            return new int[]{-1};
        }
        int[] resultado = new int[con7.size()];
        for (int i = 0; i < con7.size(); i++) {
            resultado[i] = con7.get(i);
        }
        return resultado;
    }

    //Validar si un número contiene un 7
    public static boolean contiene7(int n) {
        return String.valueOf(Math.abs(n)).contains("7");
    }

}
