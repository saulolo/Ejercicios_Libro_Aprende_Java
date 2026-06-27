package Uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_5;

import java.util.Scanner;

/**
 * Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el control de los artículos de un almacén.
 * De cada artículo se debe saber el código,la descripción, el precio de compra, el precio de venta y el stock
 * (número de unidades). El menú del programa debe tener, al menos, las siguientes opciones:
 * <p>1. Listado.</p>
 * <p>2. Alta</p>
 * <p>3. Baja</p>
 * <p>4. Modificación.</p>
 * <p>5. Entrada de mercancía</p>
 * <p>6. Salida de mercancía</p>
 * <p>7. Salir</p>
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
