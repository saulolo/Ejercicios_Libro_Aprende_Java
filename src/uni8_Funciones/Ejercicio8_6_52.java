package uni8_Funciones;

import java.util.Random;

/**
 * Implementa la función aleatorioDeArray con la cabecera que se muestra a continuación:
 * <br>public static int aleatorioDeArray(int[] a)
 * <br>Ejemplo:
 * <br>Esta función debe devolver un número del array escogido al azar entre todos los disponibles. Por ejemplo,
 * si a = {111, 222, 333, 444}, aleatorioDeArray(a) podría devolver el 111, el 222, el 333 o el 444. Si b = {52, 37},
 * aleatorio- DeArray(b) podría devolver el 52 o el 37. Utiliza la función en un programa de prueba.
 * @author Saulolo
 */
public class Ejercicio8_6_52 {

    public static void main(String[] args) {

        System.out.println("=== ÀRRAY ALEATORIO ===");
        int[] numbersA = {1, 2, 3, 4, 5};
        System.out.println(aleatorioDeArray(numbersA));
    }

    /**
     * Devuelve un elemento elegido al azar del array proporcionado.
     *
     * @param a Array de enteros.
     * @return Elemento aleatorio del array.
     */
    public static int aleatorioDeArray(int[] a) {
        Random random = new Random();
        int indice = random.nextInt(a.length);

        return a[indice];
    }

}
