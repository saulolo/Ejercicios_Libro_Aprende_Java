package uni8_Funciones;

import java.util.Scanner;

/**
 * Realiza un programa que pinte un triángulo hueco tal como se muestra en los ejemplos. El usuario debe introducir la
 * altura de la figura. Utiliza funciones para pintar las líneas.
 * <br>Ejemplo 1:
 * <br>Introduzca la altura de la figura: 8
 * <br>********
 * <br>*&nbsp &nbsp &nbsp &nbsp &nbsp*
 * <br>*&nbsp &nbsp &nbsp &nbsp*
 * <br>*&nbsp &nbsp &nbsp*
 * <br>*&nbsp &nbsp*
 * <br>*&nbsp*
 * <br>**
 * <br>*
 * @author Saulolo
 */
public class Ejercicio8_6_42 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TRINGULO HUECO ===");
        System.out.print("Introduce la altura del tríangulo: ");
        int altura = scanner.nextInt();

        for (int i = altura; i >= 1; i--) {
            if (i == altura) {
                lineaLlena('*', i);
            } else if (i == 1) {
                lineaLlena('*', 1);
            } else {
                lineaHueca('*', ' ', i);
            }
        }

    }

    /**
     * Imprime una línea hueca con el carácter de borde y el relleno especificados.
     * Si el largo es 1, imprime solo el borde.
     * Si el largo es 2, imprime dos bordes juntos.
     * Si es mayor, imprime borde, relleno(s), borde.
     *
     * @param borde   Carácter que se usará como borde.
     * @param relleno Carácter que se usará como relleno (entre los bordes).
     * @param largo   Número total de caracteres a imprimir.
     */
    public static void lineaHueca(char borde, char relleno, int largo) {
        if (largo <= 0) return;
        if (largo == 1) {
            System.out.println(borde);
        } else if (largo == 2) {
            System.out.println("" + borde + borde);
        } else {
            System.out.print(borde);
            for (int i = 0; i < largo - 2; i++) {
                System.out.print(relleno);
            }
            System.out.println(borde);
        }
    }

    /**
     * Imprime una línea llena con el carácter y longitud especificados.
     *
     * @param caracter     Carácter a imprimir.
     * @param repeticiones Número de veces que el carácter se imprime en la línea.
     */
    public static void lineaLlena(char caracter, int repeticiones) {
        for (int i = 0; i < repeticiones; i++) {
            System.out.print(caracter);
        }
        System.out.println();
    }

}
