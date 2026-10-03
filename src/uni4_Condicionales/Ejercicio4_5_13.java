package uni4_Condicionales;

import java.util.Scanner;

public class Ejercicio4_5_13 {
    
    public static void main(String[] args) {
        
        /*Escribe un programa que ordene tres números enteros introducidos 
        por teclado.*/
        
        System.out.println("ORDENAR TRES NÚMEROS");
        System.out.println("--------------------");
        
        Scanner entrada = new Scanner(System.in);
        
        int auxi;
        int num1;
        int num2;
        int num3;
        
        System.out.println("Ingresa el pimer número: ");
        num1 = entrada.nextInt();
        
        System.out.println("Ingresa el segundo número: ");
        num2 = entrada.nextInt();
        
        System.out.println("Ingresa el tercer número: ");
        num3 = entrada.nextInt();
        
        if (num1 > num2) {
            auxi = num1;
            num1 = num2;
            num2 = auxi;
        }
        if (num2 > num3) {
            auxi = num2;
            num2 = num3;
            num3 = auxi;
        }
        if (num1 > num2) {
            auxi = num1;
            num1 = num2;
            num2 = auxi;
        }
        
        System.out.println("Los numeros.txt introducidos organizados de menor a mayor "
                + "son: " + num1 + " " + num2 + " " + num3 );
        
        
        System.out.println("================================================");
        System.out.println(" ");
        
        

        System.out.println("Este programa ordena tres números introducidos por teclado.");
        System.out.println("Por favor, vaya introduciendo los tres números y pulsando INTRO:");

        int aux;
        int a;
        int b;
        int c;

        System.out.println("Ingresa el pimer número: ");
        a = entrada.nextInt();

        System.out.println("Ingresa el segundo número: ");
        b = entrada.nextInt();

        System.out.println("Ingresa el tercer número: ");
        c = entrada.nextInt();

        // ordenación de los dos primeros números
        if (a > b) {
            aux = a;
            a = b;
            b = aux;
        }

        // ordenación de los dos últimos números
        if (b > c) {
            aux = b;
            b = c;
            c = aux;
        }

        // se vuelven a ordenar los dos primeros
        if (a > b) {
            aux = a;
            a = b;
            b = aux;
        }

        System.out.println("Los números introducidos ordenados de menor a mayor son " + a + ", " + b + " y " + c + ".");

    }
    
}
