package Uni9_POO.Ejer_2_POO_en_Java.Ejercicio9_9_7;

import java.util.Scanner;

/**
 * Queremos gestionar la venta de entradas (no numeradas) de Expocoches Campanillas que tiene 3 zonas, la sala principal
 * con 1000 entradas disponibles, la zona de compra-venta con 200 entradas disponibles y la zona vip con 25 entradas
 * disponibles. Hay que controlar que existen entradas antes de venderlas.
 * La clase Zona con sus atributos y métodos se muestra a continuación:
 * @author Saulolo
 */
public class ExpoCochesMain {

    public static void main(String[] args) {

        System.out.println("=== EXPOCOCHES ===");

        Scanner sc = new Scanner(System.in);

        Zona principal = new Zona(1000);
        Zona compraVenta = new Zona(200);
        Zona vip = new Zona(25);

        int option;

        do {
            System.out.println("\n=== EXPOCOCHES CAMPANILLAS ===");
            System.out.println("1. Mostrar número de entradas libres");
            System.out.println("2. Vender entradas");
            System.out.println("3. Salir");
            System.out.print("Elija una opción [1-3]: ");
            option = sc.nextInt();

            switch(option) {
                case 1:
                    System.out.println("Entradas disponibles:");
                    System.out.println("Sala principal: " + principal.getEntradasPorVender());
                    System.out.println("Zona de compra-venta: " + compraVenta.getEntradasPorVender());
                    System.out.println("Zona VIP: " + vip.getEntradasPorVender());
                    break;

                case 2:
                    System.out.println("¿Para qué zona desea las entradas?");
                    System.out.println("1. Sala principal");
                    System.out.println("2. Zona de compra-venta");
                    System.out.println("3. Zona VIP");
                    int zonaOpcion = sc.nextInt();
                    System.out.print("¿Cuántas entradas desea?: ");
                    int cantidad = sc.nextInt();

                    switch (zonaOpcion) {
                        case 1:
                            principal.vender(cantidad);
                            break;
                        case 2:
                            compraVenta.vender(cantidad);
                            break;
                        case 3:
                            vip.vender(cantidad);
                            break;
                        default:
                            System.out.println("Zona seleccionada no válida.");
                    }
                    break;

                case 3:
                    System.out.println("Hasta pronto.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 3);

        sc.close();
    }
}
