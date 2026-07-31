package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_13;

import uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_5.Almacen;
import uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_5.Articulo;

import java.util.Scanner;

/**
 * Modifica el programa Gestisimal realizado anteriormente añadiendo las siguientes mejoras:
 * <p>- Utiliza una lista en lugar de un array para el almacenamiento de los datos.</p>
 * <p>- Comprueba la existencia del código en el alta, la baja y la modificación de artículos para evitar errores.</p>
 *  <p>- Cambia la opción “Salida de stock” por “Venta”. Esta nueva opción permitirá hacer una venta de varios artículos y
 *  emitir la factura correspondiente. Se debe preguntar por los códigos y las cantidades de cada artículo que se quiere
 *  comprar. Aplica un 21% de IVA.</p>
 *
 * @author Saulolo
 */
public class GestisimalMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GESTISIMAL ===");

        Almacen almacen = new Almacen();
        Articulo articulo;
        int opcion;
        int codigo;
        String descripcion;
        int precioCompra;
        int precioVenta;
        int cantidad;

        do {
            System.out.print("""
                \nBienvenido a 💼GESTISIMAL💼
                MENU DE OPCIONES
                1. Listado.
                2. Alta.
                3. Baja.
                4. Modificación
                5. Entrada de Mercancia.
                6. Salida de Mercancia.
                7. Salir.
                """);
            System.out.print("Elige la operación a realizar: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    almacen.listar();
                    break;

                case 2:
                    System.out.print("\nIngresa el código: ");
                    codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingresa la descripción del articulo: ");
                    descripcion = scanner.nextLine();

                    System.out.print("Ingresa el precio de compra: ");
                    precioCompra = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingresa el precio de venta: ");
                    precioVenta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingresa el stock: ");
                    cantidad = scanner.nextInt();
                    scanner.nextLine();

                    articulo = new Articulo(codigo, descripcion, precioCompra, precioVenta, cantidad);
                    almacen.alta(articulo);
                    break;

                case 3:
                    System.out.print("Ingresa el código: ");
                    codigo = scanner.nextInt();
                    scanner.nextLine();

                    almacen.baja(codigo);
                    break;

                case 4:
                    System.out.print("\nIngresa el código del articulo a modificar: ");
                    codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingresa la nueva descripción: ");
                    descripcion = scanner.nextLine();

                    System.out.print("Ingresa el nuevo precio de compra: ");
                    precioCompra = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingresa el nuevo precio de venta: ");
                    precioVenta = scanner.nextInt();
                    scanner.nextLine();

                    almacen.modificacion(codigo, descripcion, precioCompra, precioVenta);
                    break;

                case 5:
                    System.out.print("Ingresa el código del articulo a agregar su stock: ");
                    codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingresa el nuevo stock: ");
                    cantidad = scanner.nextInt();
                    scanner.nextLine();

                    almacen.entradaMercancia(codigo, cantidad);
                    break;

                case 6:
                    System.out.print("Ingresa el código del articulo a eliminar su stock: ");
                    codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingresa la cantidad de mercancia a eliminar: ");
                    cantidad = scanner.nextInt();
                    scanner.nextLine();

                    almacen.salidaMercancia(codigo, cantidad);
                    break;

                case 7:
                    System.out.println("Hasta Pronto!!!");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 7);

        scanner.close();
    }

}
