package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_2;

import java.util.ArrayList;

/**
 * Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un {@code ArrayList} y que luego calcule la
 * <b>suma</b>, la <b>media</b>, el <b>máximo</b> y el <b>mínimo</b> de esos números. El tamaño de la lista también será
 * aleatorio y podrá oscilar entre 10 y 20 elementos ambos inclusive.
 * @author Saulolo
 */
public class CalculoAleatorioMain{


    public static void main(String[] args) {

        System.out.println("=== OPERACIONES CON NÚMEROS ALEATORIOS ===");
        int listSize = (int) (Math.random() * 11) + 10;
        int acum = 0;

        ArrayList<Integer> numbers = new ArrayList<>(listSize);

        //Genero el número aleatorio dentro de la lista.
        for (int i = 0; i < listSize; i++) {
            int randomNumber = (int) (Math.random() * 101);
            numbers.add(randomNumber);
        }

        System.out.println("\n== Lista de números aleatorios: ==");
        for (Integer number : numbers) {
            System.out.println(number);
        }

        //Calcula la suma de los números listados
        for (Integer number : numbers) {
            acum = acum + number;
        }

        //Calcula el número máximo de los números listados
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (number > max)
                max = number;
        }

        //Calcula el número mínimo de los números listados
        int min = numbers.get(0);
        for (Integer number : numbers) {
            if (number < min)
                min = number;
        }


        System.out.print("\nSuma: " + acum);
        System.out.print("\nPromedio: " + (double) acum / numbers.size());
        System.out.print("\nNúmero Mayor: " + max);
        System.out.print("\nNúmero Menor: " + min);
    }

}
