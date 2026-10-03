package uni5_Bucles;

import java.util.Scanner;

/* @author: Saulolo */
public class Bucles {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        //BUCLE FOR
        for (int i = 0; i < 20; i = i + 2) {
            System.out.println(i);
            break; //Puedo utilizar esta palabra para romper el ciclo.
        }
        //BUCLE FOR ejemplo 2.
        for (int i = 0; i < 20; i = i + 2) {
            if (i % 2!=0) { 
                continue;//Ir a la sigiente iteración 
            }
            System.out.println("i = " + i);
        }
          
 
        }
        
        //BUCLE WHILE
//        int i = 1;
//        while (i < 20) {  
//            System.out.println(i);
//            i++;   
//        }
        
        /*EJEMPLO: Pedir números por teclado hasta que el usuario ingrese un 
        número negativo.*/
//        System.out.println("Por favor, vaya introduciendo númmeros y pulsando enter.");
//        System.out.println("Para terminar, introduzca un número negativo.");
//        
//        int numeroIntroducido = 0;
//        int cuentaNumeros = 0;
//        int suma = 0;
//
//        while (numeroIntroducido >= 0) {
//            numeroIntroducido = input.nextInt();
//            cuentaNumeros++;
//            suma += numeroIntroducido; //Equivale a suma = suma + numeroIntroducido
//        }
//        System.out.println("Has introducido " + (cuentaNumeros - 1) + " números positivos.");
//        System.out.println("La suma total de ellos es: " + (suma - numeroIntroducido));
        
        //BUCLE DO WHILE
//        int j = 1;
//        do {
//            System.out.println(i);
//            i++;
//        } while (j < 11);
        
        /*EJEMPLO 2: Introducir números por teclado, cuando se introduzca un
        número par, el programa parará*/
//        int m = 0;
//        int numeroIntroducido2 = 0;
//        String respuesta;
//        do {
//            System.out.println("Dime un número: ");
//            numeroIntroducido2 = input.nextInt();
//            if (numeroIntroducido2 %2 == 0) {
//                System.out.println("Que bonito es el número: " + numeroIntroducido2);
//                System.out.println("¿Quiere continuar?: ");
//                respuesta = input.next();
//                if (respuesta.equals("s")) {
//                } 
//            }
//            else {
//                System.out.println("No me gustan los números impares, adiós.");
//            }
//            m++;  
//        } while (numeroIntroducido2 %2 == 0);
//        System.out.println("La cantidad de numeros.txt pares introducidos fueron: " + (m-1));
    }

