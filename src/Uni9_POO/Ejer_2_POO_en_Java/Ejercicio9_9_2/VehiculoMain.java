package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_2;

import java.util.Scanner;

/**
 * Crea la clase Vehiculo, así como las clases Bicicleta y Coche como subclases de la primera. Para la clase Vehiculo,
 * crea los atributos de clase vehiculosCreados y kilometrosTotales, así como el atributo de instancia kilometrosRecorridos.
 * Crea también algún método específico para cada una de las subclases. Prueba las clases creadas mediante un programa
 * con un menú como el que se muestra a continuación:
 * <br/>VEHÍCULOS
 * <br/>=========
 * <br/>1. Anda con la bicicleta
 * <br/>2. Haz el caballito con la bicicleta
 * <br/>3. Anda con el coche
 * <br/>4. Quema rueda con el coche
 * <br/>5. Ver kilometraje de la bicicleta
 * <br/>6. Ver kilometraje del coche
 * <br/>7. Ver kilometraje total
 * <br/>8. Salir
 * <br/>Elige una opción (1-8):
 * @author Saulolo
 */
public class VehiculoMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        int kmRecorrido;

        Bicicleta bicicleta = new Bicicleta();
        Coche coche = new Coche();

        while (option != 8) {

            System.out.println("\nVEHICULOS");
            System.out.println("=========");

            System.out.println("""
                1. Anda con la Bicicleta.
                2. Haz el caballito con la Bicicleta.
                3. Anda con el coche
                4. Quema rueda con el coche.
                5. Ver kilometraje de la bicicleta.
                6. Ver kilometraje del coche.
                7. Ver kilometraje total.
                8. Salir.
                """);
            System.out.print("Elije una opción [1-8]: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Ingresa la cantidad de Km recorridos en la Bicicleta: ");
                    kmRecorrido = scanner.nextInt();
                    bicicleta.andar(kmRecorrido);
                    System.out.println("Haz ingresado => " + kmRecorrido + " Km.");
                    break;
                case 2:
                    bicicleta.caballito();
                    break;
                case 3:
                    System.out.println("Ingresa la cantidad de Km recorridos en el Coche: ");
                    kmRecorrido = scanner.nextInt();
                    coche.andar(kmRecorrido);
                    System.out.println("Haz ingresado => " + kmRecorrido + " Km.");
                    break;
                case 4:
                    coche.quemarRueda();
                    break;
                case 5:
                    System.out.println("Mi bicicleta tiene: " + bicicleta.getKilometrosRecorridos() + " km.");
                    break;
                case 6:
                    System.out.println("Mi coche tiene: " + coche.getKilometrosRecorridos() + " km.");
                    break;
                case 7:
                    System.out.println("Total Km: " + Vehiculo.getKilometrosTotales());
                    break;
                case 8:
                    System.out.println("Vehicluos creados: " + Vehiculo.getVehiculosCreados());
                    System.out.println("Hasta pronto!!!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
