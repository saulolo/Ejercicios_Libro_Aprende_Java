package uni9_POO.Teoria.disco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class DiscoMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Disco> discos = new ArrayList<>();
        int cantidad;
        String codigo;
        String autor;
        String titulo;
        String genero;
        int duracion;
        int opcion;
        boolean salir = false;

        while (!salir) {

            System.out.println("\n=== CRUD de Discos ===");
            System.out.println("1. Alta (Añadir disco.)");
            System.out.println("2. Listado de discos.");
            System.out.println("3. Modificar disco.");
            System.out.println("4. Baja (Eliminar disco.)");
            System.out.println("5. Salir");

            System.out.println("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("\nCódigo: ");
                    codigo = scanner.nextLine();

                    System.out.print("\nAutor: ");
                    autor = scanner.nextLine();

                    System.out.print("\nTítulo: ");
                    titulo = scanner.nextLine();

                    System.out.print("\nGénero: ");
                    genero = scanner.nextLine();

                    System.out.print("\nDuración (en minutos): ");
                    duracion = scanner.nextInt();

                    discos.add(new Disco(codigo, autor, titulo, genero, duracion));
                    System.out.println("✅Disco añadido.");
                    break;


                case 2:
                    //Listado
                    if (discos.isEmpty()) {
                        System.out.println("⚠ No hay discos registrados.");
                    } else {
                        AtomicInteger idx = new AtomicInteger(1);
                        System.out.println("\n=== LISTA DE DISCOS ===");
                        discos.forEach(disco -> {
                            System.out.println("\n🎵Disco # " + idx.getAndIncrement());
                            System.out.println(disco);
                        });
                    }
                    break;

                case 3:
                    // Modificar
                    System.out.print("Ingrese el código del disco a modificar: ");
                    String codigoModificar = scanner.nextLine();
                    Disco discoModificar = buscarPorCodigo(discos, codigoModificar);
                    if (discoModificar == null) {
                        System.out.println("Disco no encontrado.");
                    } else {
                        System.out.print("Nuevo autor (dejar vacío para no cambiar): ");
                        String nuevoAutor = scanner.nextLine();
                        if (!nuevoAutor.isEmpty()) discoModificar.setAutor(nuevoAutor);

                        System.out.print("Nuevo título (dejar vacío para no cambiar): ");
                        String nuevoTitulo = scanner.nextLine();
                        if (!nuevoTitulo.isEmpty()) discoModificar.setTitulo(nuevoTitulo);

                        System.out.print("Nuevo género (dejar vacío para no cambiar): ");
                        String nuevoGenero = scanner.nextLine();
                        if (!nuevoGenero.isEmpty()) discoModificar.setGenero(nuevoGenero);

                        System.out.print("Nueva duración (0 para no cambiar): ");
                        String inputDur = scanner.nextLine();
                        if (!inputDur.isEmpty()) {
                            int nuevaDuracion = Integer.parseInt(inputDur);
                            if (nuevaDuracion > 0) discoModificar.setDuracion(nuevaDuracion);
                        }

                        System.out.println("✅ Disco modificado.");
                    }
                    break;

                case 4:
                    // Baja
                    System.out.print("Ingrese el código del disco a eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    Disco discoEliminar = buscarPorCodigo(discos, codigoEliminar);
                    if (discoEliminar == null) {
                        System.out.println("Disco no encontrado.");
                    } else {
                        discos.remove(discoEliminar);
                        System.out.println("✅ Disco eliminado.");
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Hasta luego :)");
                    break;

                default:
                    System.out.println("Opción no valida.");

            }

        }

    }

    /**
     * Busca un objeto Disco dentro de una lista utilizando el código del disco.
     *
     * @param lista  La lista de discos donde se realizará la búsqueda.
     * @param codigo El código del disco que se desea buscar (no sensible a mayúsculas/minúsculas).
     * @return       El objeto Disco si se encuentra uno con el código especificado;
     *               null si no se encuentra ningún disco con ese código.
     */
    public static Disco buscarPorCodigo(List<Disco> lista, String codigo) {
        for (Disco d : lista) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }

}
