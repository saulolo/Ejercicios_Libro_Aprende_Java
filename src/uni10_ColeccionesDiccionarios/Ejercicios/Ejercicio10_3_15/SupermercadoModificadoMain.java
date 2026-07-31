package uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_15;

import uni10_ColeccionesDiccionarios.Ejercicios.Ejercicio10_3_14.DetalleCompra;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Realiza una nueva versión del ejercicio anterior con las siguientes mejoras: Si algún producto se repite en diferentes
 * líneas, se deben agrupar en una sola. Por ejemplo, si se pide primero 1 bote de tomate y luego 3 botes de tomate, en
 * el extracto se debe mostrar que se han pedido 4 botes de tomate. Después de teclear “fin”, el programa pide un código
 * de descuento. Si el usuario introduce el código “ECODTO”, se aplica un 10% de descuento en la compra.
 * @author Saulolo
 */
public class SupermercadoModificadoMain {

    public static void main(String[] args) {


        System.out.println("=== SUPERMERCADO MODIFICADO ===");

        Scanner scanner = new Scanner(System.in);

        HashMap<String, Double> productos = new HashMap<>(Map.of(
                "Avena", 2.21,
                "Garbanzos", 2.30,
                "Tomate", 1.59,
                "Jengibre", 3.13,
                "Quinoa", 4.50,
                "Guizantes", 1.60
        ));

        HashMap<String, DetalleCompra> compras = new HashMap<>();
        String nombre;
        int cantidad;
        double totalCompra = 0;

        while (true) {
            System.out.println("Ingresa el nombre del producto (o 'fin' para terminar): ");
            nombre = scanner.next();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.println("Ingresa la cantidad: ");
            cantidad = scanner.nextInt();
            scanner.nextLine();

            // Si ya existe, sumamos la cantidad
            if (compras.containsKey(nombre)) {
                DetalleCompra existente = compras.get(nombre);
                existente.setCantidad(existente.getCantidad() + cantidad);
            } else {
                // Si no existe, lo agregamos nuevo
                compras.put(nombre, new DetalleCompra(nombre, cantidad));
            }
        }

        // Código de descuento
        System.out.println("Ingresa el código de descuento (o Enter para omitir): ");
        String codigoDescuento = scanner.nextLine();
        scanner.nextLine();

        // Imprimir tabla
        String encabezado  = "| PRODUCTO   | PRECIO | CANTIDAD | SUBTOTAL |";
        String lineaDivisoria = "+------------+--------+----------+----------+";

        System.out.println(lineaDivisoria);
        System.out.println(encabezado);
        System.out.println(lineaDivisoria);

        // Iterar sobre los values del HashMap
        for (DetalleCompra compra : compras.values()) {
            double precioUnitario = productos.get(compra.getNombre());
            double subTotal = precioUnitario * compra.getCantidad();
            totalCompra += subTotal;

            System.out.printf("| %-10s | %6.2f | %8d | %8.2f |%n",
                    compra.getNombre(), precioUnitario, compra.getCantidad(), subTotal);
        }

        System.out.println(lineaDivisoria);

        // Aplicar descuento si el código es correcto
        if (codigoDescuento.equalsIgnoreCase("ECODTO")) {
            double descuento = totalCompra * 0.10;
            totalCompra = totalCompra - descuento;
            System.out.printf("Descuento aplicado (10%%): -%.2f%n", descuento);
        }
        System.out.println();

        System.out.printf("TOTAL: %.2f%n", totalCompra);

        scanner.close();
    }
}
