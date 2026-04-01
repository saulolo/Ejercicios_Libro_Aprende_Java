package uni8_Funciones;

import java.util.Scanner;

/**
 * Realiza un programa que pinte un triángulo relleno tal como se muestra en los ejemplos. El usuario debe introducir la
 * altura de la figura. Utiliza funciones para pintar las líneas.
 * <br>Ejemplo 1:
 * <br>Introduzca la altura de la figura: 8
 * <br>********
 * <br>&nbsp*******
 * <br>&nbsp &nbsp******
 * <br>&nbsp &nbsp &nbsp****
 * <br>&nbsp &nbsp &nbsp &nbsp***
 * <br>&nbsp &nbsp &nbsp &nbsp &nbsp**
 * <br>&nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp*
 * @author Saulolo
 */
public class Ejercicio8_6_43 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TRINGULO RELLENO ===");
        System.out.print("Introduce la altura del tríangulo: ");
        int altura = scanner.nextInt();

        for (int i = 0; i < altura; i++) {
            linea(i, '*', altura - i);
        }

    }

    /**
     * Imprime una línea formada por espacios a la izquierda y luego el carácter especificado.
     * @param espacios Número de espacios iniciales.
     * @param caracter Carácter que se imprime.
     * @param repeticiones Rep. de ese carácter tras los espacios.
     */
    public static void linea(int espacios, char caracter, int repeticiones) {
        for (int i = 0; i < espacios; i++) {
            System.out.print(' ');
        }
        for (int i = 0; i < repeticiones; i++) {
            System.out.print(caracter);
        }
        System.out.println();
    }

}
