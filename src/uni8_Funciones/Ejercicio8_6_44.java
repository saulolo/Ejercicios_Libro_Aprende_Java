package uni8_Funciones;

import java.util.Scanner;

/**
 * Realiza un programa que pinte un triángulo hueco tal como se muestra en los ejemplos. El usuario debe introducir la
 * altura de la figura. Utiliza funciones para pintar las líneas.
 * <br>Ejemplo 1:
 * <br>Introduzca la altura de la figura: 10
 * <br>**********
 * <br>*&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp*
 * <br>&nbsp*&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp *
 * <br>&nbsp &nbsp*&nbsp &nbsp &nbsp &nbsp &nbsp *
 * <br>&nbsp &nbsp &nbsp*&nbsp &nbsp &nbsp &nbsp *
 * <br>&nbsp &nbsp &nbsp &nbsp*&nbsp &nbsp &nbsp *
 * <br>&nbsp &nbsp &nbsp &nbsp &nbsp*&nbsp &nbsp *
 * <br>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp*&nbsp *
 * <br>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp**
 * <br>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp *
 * @author Saulolo
 */
public class Ejercicio8_6_44 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TRINGULO RELLENO ===");
        System.out.print("Introduce la altura del tríangulo: ");
        int altura = scanner.nextInt();


        // Primera línea: llena
        for (int i = 0; i < altura; i++) {
            System.out.print('*');
        }
        System.out.println();

        // Líneas intermedias (con hueco)
        for (int i = 1; i < altura - 1; i++) {
            int espaciosIzquierda = i;
            int espaciosMedios = altura - i - 2; // hueco entre los bordes
            if (espaciosMedios >= 0) {
                linea(espaciosIzquierda, '*', espaciosMedios, true);
            }
        }

        // Última línea: un solo asterisco muy a la derecha
        for (int i = 0; i < altura - 1; i++) System.out.print(' ');
        System.out.println('*');
    }

    /**
     * Imprime una línea de triángulo hueco invertido alineado a la derecha.
     * @param espaciosIzqda Espacios a la izquierda.
     * @param borde Carácter del borde, normalmente '*'.
     * @param espaciosMedios Espacios entre los dos bordes.
     * @param dobleBorde Si true, imprime dos bordes (inicio y final); si false, solo uno.
     */
    public static void linea(int espaciosIzqda, char borde, int espaciosMedios, boolean dobleBorde) {
        for (int i = 0; i < espaciosIzqda; i++) System.out.print(' ');
        System.out.print(borde);
        if (dobleBorde) {
            for (int i = 0; i < espaciosMedios; i++) System.out.print(' ');
            System.out.print(borde);
        }
        System.out.println();
    }

}
