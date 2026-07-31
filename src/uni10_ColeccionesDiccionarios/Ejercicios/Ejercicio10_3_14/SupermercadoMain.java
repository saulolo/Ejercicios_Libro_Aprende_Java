package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Un supermercado de productos ecológicos nos ha pedido hacer un programa para vender su mercancía.
 * En esta primera versión del programa se tendrán en cuenta los productos que se indican en la tabla junto con su
 * precio. Los productos se venden en bote, brick, etc. Cuando se realiza la compra, hay que indicar el producto y el
 * número de unidades que se compran, por ejemplo “guisantes” si se quiere comprar un bote de guisantes y la cantidad,
 * por ejemplo “3” si se quieren comprar 3 botes. La compra se termina con la palabra “fin. Suponemos que el usuario no
 * va a intentar comprar un producto que no existe. Utiliza un diccionario para almacenar los nombres y precios de los
 * productos y una o varias listas para almacenar la compra que realiza el usuario.
 * @author Saulolo
 */
public class SupermercadoMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SUPERMERCADO ===");

        HashMap<String, Double> productos = new HashMap<>(Map.of(
                "Avena", 2.21,
                "Garbanzos", 2.30,
                "Tomate", 1.59,
                "Jengibre", 3.13,
                "Quinoa", 4.50,
                "Guizantes", 1.60
        ));

        ArrayList<DetalleCompra> compras = new ArrayList<>();
        String nombre = "";
        int cantidad;
        double totalCompra = 0;


        while (true) {
            System.out.println("Ingresa el nombre del producto: ");
            nombre = scanner.next();
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.println("Ingresa la cantidad a llevar: ");
            cantidad = scanner.nextInt();
            scanner.nextLine();

            compras.add(new DetalleCompra(nombre, cantidad));
        }

        String encabezado = "| PRODUCTO | PRECIO | CANTIDAD | SUBTOTAL|";
        String lineaDivisoria = "+----------+--------+----------+---------+";

        System.out.println(encabezado);
        System.out.println(lineaDivisoria);

        for (DetalleCompra compra : compras) {
            double precioUnitario = productos.get(compra.getNombre());
            double subTotal = precioUnitario * compra.getCantidad();
            totalCompra = totalCompra + subTotal;

            System.out.println(compra.getNombre() + " | " + precioUnitario + " | " + compra.getCantidad() + " | " + subTotal);
        }

        scanner.close();
    }

}
