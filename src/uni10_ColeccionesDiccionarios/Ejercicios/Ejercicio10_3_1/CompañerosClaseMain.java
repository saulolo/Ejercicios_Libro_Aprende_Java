package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Crea un {@code ArrayList} con los nombres de 6 compañeros de clase. A continuación, muestra esos nombres por pantalla.
 * Utiliza para ello un bucle for que recorra el {@code ArrayList} sin usar ningún índice.
 * @author Saulolo
 */
public class CompañerosClaseMain {

    public static void main(String[] args) {

        System.out.println("=== COMPAÑEROS DE CLASE ===");

        System.out.println("== Forma 1 de inicializar ArraList ==");
        ArrayList<String> classmates = new ArrayList<>();
        classmates.add("Felipe");
        classmates.add("Alejandra");
        classmates.add("Saul");
        classmates.add("Leidy");
        classmates.add("Diego");
        classmates.add("Pablo");

        for (String classmate : classmates) {
            System.out.println("Nombre: " + classmate);
        }


        System.out.println("\n== Forma 2 de inicializar ArraList (Arrays.asList) ==");
        ArrayList<String> classmates2 = new ArrayList<>(Arrays.asList(
                ("Manuela"),
                ("Pilar"),
                ("Susana"),
                ("Ana"),
                ("Sandra"),
                ("Oswaldo")
        ));

        for (int i = 0; i < classmates2.size(); i++) {
            System.out.println(classmates2);
        }
    }

}
