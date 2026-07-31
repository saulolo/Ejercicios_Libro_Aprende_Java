package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Realiza un programa equivalente al anterior pero en esta ocasión, el programa debe ordenar <b>palabras</b> en lugar
 * de números.
 * @author Saulolo
 */
public class OrdenarPalabrasMain {


    public static void main(String[] args) {

        System.out.println("=== ORDENAR PALABRAS INTRODUCIDOS ===");

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();


        //Introducir las palabras
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingresa la palabra [" + (i + 1) + "]: ");
            words.add(scanner.nextLine());

        }

        //Ordenar la lista
        Collections.sort(words);

        //Listar las palabras
        for (String word : words) {
            System.out.println(word);
        }

        scanner.close();

    }
}
