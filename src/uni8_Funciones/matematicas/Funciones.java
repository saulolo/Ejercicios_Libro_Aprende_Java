package uni8_Funciones.matematicas;

import java.util.Scanner;

/**
 * Introducción a las funciones
 *
 * @author Saul Echeverri
 */
public class Funciones {

    public static void main(String[] args) {

        /*- IMPLEMENTANDO FUNCIONES PARA REUTILIZAR CÓDIGO - */
        /*Una función es un trozo de código que realiza una tarea muy concreta y que se puede incluir en cualquier
        programa cuando hace falta resolver esa tarea. Opcionalmente, las funciones aceptan una entrada (parámetros de
        entrada) y devuelven una salida.*/

        System.out.println("EJEMPLO 1: DICE SI UN NUMERO ES PRIMO O NO ES PRIMO (sin función)");
        //System.out.println("Introduce un número entero positivo: ");

        Scanner input = new Scanner(System.in);
        int numero = input.nextInt();

        boolean esPrimo = true;
        for (int i = 2; i < numero; i++) {
            if ((numero % i) == 0) {
                esPrimo = false;
            }
        }

        if (esPrimo) {
            System.out.println("El número " + numero + " Es primo.");
        } else {
            System.out.println("El número " + numero + " No es primo.");
        }


        System.out.println("=============== llamado de Funciones ===============");
        System.out.println(isPrime(33));

    }

    //"EJEMPLO 2: DICE SI UN NUMERO ES PRIMO O NO ES PRIMO (con función)"
    /* Ámbito de las variables
    es el espacio donde “existe” esa variable o, dicho de otro modo, el contexto dentro del cual la variable es válida.
    */

    /**
     * Valida si un número es primo o no.
     * @param number Número a evaluar
     * @return {@code true} si el número es primo o {@code false} en caso contrario
     */
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
    /*Cada función tiene una cabecera y un cuerpo. En el ejemplo anterior la cabecera es
    public static boolean esPrimo(int x)
    De momento no vamos a explicar qué significa public static, lo dejaremos para cuando veamos el capítulo 9
    “Programación orientada a objetos”, por ahora lo escribiremos tal cual cada vez que definamos una función.
    A continuación se escribe el tipo de dato que devuelve la función, en este caso es boolean porque la función
    devolverá siempre true (verdadero) o false falso. Lo último que lleva la cabecera son los parámetros encerrados
    entre paréntesis. Esos parámetros son los valores que se le pasan a la función para que realice los cálculos.
    En este caso concreto, el parámetro que se pasa es x, o sea, el número que queremos saber si es primo o no.
    Es necesario indicar siempre el tipo de cada parámetro; en esta ocasión, el parámetro que se pasa es de tipo entero
    (int).
    * */


}
