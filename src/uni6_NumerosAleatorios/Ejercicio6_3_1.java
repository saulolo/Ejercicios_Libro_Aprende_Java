package uni6_NumerosAleatorios;

/** Escribe un programa que muestre la tirada de tres dados. Se debe mostrar
también la suma total (los puntos que suman entre los tres dados).
author: Saulolo
*/

public class Ejercicio6_3_1 {

    public static void main(String[] args) {

        System.out.println("MOSTRANDO TIRADA DE DADOS");
        System.out.println("-------------------------");


                         /* SOLUCIÓN 1 */

        System.out.println("SOLUCIÓN 1");
        System.out.println("===========================");

        int dado1 = ((int)(Math.random() * 6) + 1);
        int dado2 = ((int)(Math.random() * 6) + 1);
        int dado3 = ((int)(Math.random() * 6) + 1);
        int sumaDados = dado1 + dado2 + dado3;

        System.out.println("La tirada de los 3 dados fue de: ");
        System.out.println("Dado 1: " + dado1);
        System.out.println("Dado 2: " + dado2);
        System.out.println("Dado 3: " + dado3);

        System.out.println("La sumatoria de los puntos arrojados es de: " + sumaDados + " puntos.");


                                        /* SOLUCIÓN 2 */
        System.out.println(" ");
        System.out.println("SOLUCIÓN 2");
        System.out.println("==============================");

        int tirada;
        int suma = 0;

        for (int i = 1; i <= 3; i++) {
            tirada = (int)(Math.random() * 6) + 1;
            System.out.println(tirada + " ");
            suma += tirada;
        }

        System.out.println("\nSuma: " + suma);






    }
}


























