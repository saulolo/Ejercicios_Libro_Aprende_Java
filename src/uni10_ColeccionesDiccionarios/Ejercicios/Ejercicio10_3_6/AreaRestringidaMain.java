package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_6;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Implementa el control de acceso al área restringida de un programa. Se debe pedir un <b>nombre de usuario</b> y una
 * <b>contraseña</b>. Si el usuario introduce los datos correctamente, el programa dirá “Ha accedido al área
 * restringida”. El usuario tendrá un máximo de 3 oportunidades. Si se agotan las oportunidades el programa dirá
 * “Lo siento, no tiene acceso al área restringida”. Los nombres de usuario con sus correspondientes contraseñas deben
 * estar almacenados en una estructura de la clase {@code HashMap}.
 * @author Saulolo
 */
public class AreaRestringidaMain {

    public static void main(String[] args) {

        System.out.println("=== CONTROL DE ACCESO ===");

        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        int option = 1;
        boolean accesoConcedido = false;

        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("saulolo", "1234");


        while (option <= 3 && !accesoConcedido) {
            System.out.print("Por favor, ingresa el usuario: ");
            username = scanner.nextLine();

            System.out.print("Por favor, ingresa la contraseña: ");
            password = scanner.nextLine();

            if (credentials.containsKey(username) && (credentials.get(username).equals(password))) {
                System.out.println("Ha accedido al área restringida.");
                accesoConcedido = true;
            } else {
                System.out.println("Lo siento, no tiene acceso al área restringida.");
                if (option == 3) {
                    System.out.println("Haz superado el número máximo de intentos, Hasta pronto!!!");
                }
            }
            System.out.println("Numero de intentos: " + option);
            option++;
        }
        scanner.close();
    }
}