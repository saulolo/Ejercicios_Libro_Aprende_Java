package uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_1;

import java.util.Scanner;

/**
 * Utiliza la clase {@code Gato} para crear un array de cuatro gatos e introduce los datos de cada uno de ellos mediante
 * un bucle. Muestra a continuación los datos de todos los gatos utilizando también un bucle.
 * @author Saulolo
 */
public class GatosMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GATOS ===");

        Gato[] gatos = new Gato[4];

        //Ingresar Datos de cada gato mediante un bucle
        for (int i = 0; i < gatos.length; i++) {
            System.out.println("Introduce el nombre del gato Nro: " + (i + 1));
            String nombre = scanner.nextLine();

            System.out.println("Introduce la edad del gato Nro: " + (i + 1));
            int edad = scanner.nextInt();
            scanner.nextLine();

            gatos[i] = new Gato(nombre, edad);
        }


        //Mostrar todos los gatos mediante un bucle for each
        for (Gato gato : gatos) {
            System.out.println(gato);
        }

        scanner.close();
    }

}
