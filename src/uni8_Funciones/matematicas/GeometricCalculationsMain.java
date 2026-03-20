package uni8_Funciones.matematicas;

import java.util.Scanner;

public class GeometricCalculationsMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number;
        System.out.print("\nIngrese un número entero positivo: ");
        number = scanner.nextInt();

        System.out.println("=== CALCULANDO NÚMEROS PRIMOS ===");
        boolean prime = Various.isPrime(number);
        if (prime) {
            System.out.printf("El %d es un número primo", number);
        } else {
            System.out.printf("El %d NO es un número primo", number);
        }


        System.out.println("\n=== CALCULANDO CANTIDAD DIGITOS ===");
        int digit = Various.digits(number);
        System.out.printf("El número: %d tiene %d digitos.", number, digit);


        System.out.println("\n=== CALCULANDO VOLUMEN DE UN CILINDRO ===");
        int radio;
        int height;
        System.out.print("\nIngrese el radio del cilindro: ");
        radio = scanner.nextInt();

        System.out.print("Ingrese la altura del cilindro: ");
        height = scanner.nextInt();

        System.out.println("El volumen del cilindro ingresado es: " + Geometry.cylinderVolume(radio, height) + " mts cuadrados.");

        System.out.println("\n=== CALCULANDO LA LONGITUD DE UNA CIRCUNFERENCIA ===");
        System.out.println("la longitud de la circinferencia es: " + Geometry.circumferenceLength(radio) + " mts.");


    }
}
