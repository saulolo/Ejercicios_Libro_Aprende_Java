package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Escribe un programa que ordene 10 números enteros introducidos por teclado y almacenados en un objeto de la clase
 * {@code ArrayList}.
 * @author Saulolo
 */
public class OrdenarNumerosMain {


    public static void main(String[] args) {

        System.out.println("=== ORDENAR NÚMEROS INTRODUCIDOS ===");

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> integerNumbers = new ArrayList<>(10);

        //Introducir los números
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingresa el número [" + (i + 1) + "]: ");
            integerNumbers.add(scanner.nextInt());
        }

        //Ordenar la lista
        Collections.sort(integerNumbers);

        //Listar los números
        for (Integer num : integerNumbers) {
            System.out.println(num);
        }

        scanner.close();

    }
}
