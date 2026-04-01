package uni8_Funciones;

import java.util.Scanner;

/**
 * Realiza un programa que pinte un triángulo relleno tal como se muestra en los ejemplos. El usuario debe introducir la
 * altura de la figura. Este ejercicio ya se realizó en el tema de bucles, ahora se trata de usar una función para que la
 * implementación sea más sencilla. Por ejemplo, se puede crear una función:
 * <br>linea(char caracter, int repeticiones)
 * <br>que pinte una línea con el carácter especificado.
 * Ejemplo 1:
 * <br>Introduzca la altura de la figura: 8
 * <br>********
 * <br>*******
 * <br>******
 * <br>*****
 * <br>****
 * <br>***
 * <br>**
 * <br>*
 * @author Saulolo
 */
public class Ejercicio8_6_41 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TRINGULO ===");
        System.out.print("Introduce la altura del tríangulo: ");
        int altura = scanner.nextInt();

        for (int i = altura; i >= 1; i--) {
            lineal('*', i);
        }

    }

    /**
     * Pinta una línea con el carácter especificado repetido.
     * @param caracter El carácter a imprimir.
     * @param repeticiones Número de repeticiones.
     */
    public static void lineal(char caracter, int repeticiones) {
        for (int i = 0; i < repeticiones; i++) {
            System.out.print(caracter);
        }
        System.out.println();
    }

}
