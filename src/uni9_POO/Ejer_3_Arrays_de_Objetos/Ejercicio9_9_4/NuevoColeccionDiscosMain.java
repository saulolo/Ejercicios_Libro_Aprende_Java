package uni9_POO.Ejer_3_Arrays_de_Objetos.Ejercicio9_9_4;

import java.time.Year;
import java.util.Scanner;

/**
 * Modifica el programa “Colección de discos” como se indica a continuación:
 * <p>a) Mejora la opción “Nuevo disco” de tal forma que cuando se llenen todas las posiciones del array, el programa
 * muestre un mensaje de error. No se permitirá introducir los datos de ningún disco hasta que no se borre alguno de la
 * lista.</p>
 * <p>b) Mejora la opción “Borrar” de tal forma que se verifique que el código introducido por el usuario existe.</p>
 * <p>c) Modifica el programa de tal forma que el código del disco sea único, es decir
 * que no se pueda repetir.</p>
 * <p>d) Crea un submenú dentro dentro de “Listado” de tal forma que exista un listado completo, un listado por autor
 * (todos los discos que ha publicado un determinado autor), un listado por género (todos los discos de un género
 * determinado) y un listado de discos cuya duración esté en un rango determinado por el usuario.</p>
 * @author Saulolo
 */
public class NuevoColeccionDiscosMain {

    private static ColeccionDiscos coleccion;
    private static Scanner sc;

    public static void main(String[] args) {

        System.out.println("=== NUEVA COLECCIÓN DE DISCOS ===");

        coleccion = new ColeccionDiscos(5);
        sc = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    nuevoDiscoI();
                    break;
                case 2:
                    listarDiscos();
                    break;
                case 3:
                    borrarDisco();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }

    /**
     * Muestra el menú principal.
     */
    private static void mostrarMenu() {
        System.out.println("\n=== COLECCIÓN DE DISCOS ===");
        System.out.println("1. Nuevo disco");
        System.out.println("2. Listado");
        System.out.println("3. Borrar disco");
        System.out.println("4. Salir");
    }

    /**
     * Añade un nuevo disco con validaciones (PASO a).
     */
    private static void nuevoDiscoI() {
        if (coleccion.estaLlena()) {
            System.out.println("❌ ERROR: La colección está llena. Borra un disco para añadir uno nuevo.");
            return;
        }

        DiscoNuevo disco = new DiscoNuevo();

        System.out.print("Título: ");
        disco.setTitulo(sc.nextLine());

        System.out.print("Artista: ");
        disco.setArtista(sc.nextLine());

        System.out.print("Año de lanzamiento: ");
        int anio = sc.nextInt();
        sc.nextLine();
        disco.setAnioLanzamiento(Year.of(anio));

        System.out.print("Número de pistas: ");
        disco.setNumeroPistas(sc.nextInt());
        sc.nextLine();

        System.out.print("Género: ");
        disco.setGenero(sc.nextLine());

        System.out.print("Duración (minutos): ");
        disco.setDuracion(sc.nextInt());
        sc.nextLine();

        if (coleccion.anadirDisco(disco)) {
            System.out.println("✅ Disco añadido con ID: " + disco.getId());
        }
    }

    /**
     * Muestra el submenú de listado (PASO d).
     */
    private static void listarDiscos() {
        int opcion;
        do {
            System.out.println("\n=== SUBMENÚ LISTADO ===");
            System.out.println("1. Listado completo");
            System.out.println("2. Listado por artista");
            System.out.println("3. Listado por género");
            System.out.println("4. Listado por duración");
            System.out.println("5. Volver");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    mostrarListadoCompleto();
                    break;
                case 2:
                    mostrarListadoPorArtista();
                    break;
                case 3:
                    mostrarListadoPorGenero();
                    break;
                case 4:
                    mostrarListadoPorDuracion();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    /**
     * Muestra todos los discos.
     */
    private static void mostrarListadoCompleto() {
        if (coleccion.estaVacia()) {
            System.out.println("❌ No hay discos en la colección.");
            return;
        }
        DiscoNuevo[] discos = coleccion.obtenerTodos();
        for (DiscoNuevo disco : discos) {
            System.out.println(disco);
        }
    }

    /**
     * Muestra discos por artista.
     */
    private static void mostrarListadoPorArtista() {
        System.out.print("Introduce el nombre del artista: ");
        String artista = sc.nextLine();
        DiscoNuevo[] discos = coleccion.obtenerPorArtista(artista);
        if (discos.length == 0) {
            System.out.println("❌ No hay discos de ese artista.");
            return;
        }
        for (DiscoNuevo disco : discos) {
            System.out.println(disco);
        }
    }

    /**
     * Muestra discos por género.
     */
    private static void mostrarListadoPorGenero() {
        System.out.print("Introduce el género: ");
        String genero = sc.nextLine();
        DiscoNuevo[] discos = coleccion.obtenerPorGenero(genero);
        if (discos.length == 0) {
            System.out.println("❌ No hay discos de ese género.");
            return;
        }
        for (DiscoNuevo disco : discos) {
            System.out.println(disco);
        }
    }

    /**
     * Muestra discos en un rango de duración.
     */
    private static void mostrarListadoPorDuracion() {
        System.out.print("Duración mínima (minutos): ");
        int min = sc.nextInt();
        System.out.print("Duración máxima (minutos): ");
        int max = sc.nextInt();
        sc.nextLine();

        DiscoNuevo[] discos = coleccion.obtenerPorDuracion(min, max);
        if (discos.length == 0) {
            System.out.println("❌ No hay discos en ese rango de duración.");
            return;
        }
        for (DiscoNuevo disco : discos) {
            System.out.println(disco);
        }
    }

    /**
     * Borra un disco por ID con validaciones (PASO b y c).
     */
    private static void borrarDisco() {
        if (coleccion.estaVacia()) {
            System.out.println("❌ No hay discos para borrar.");
            return;
        }

        System.out.print("Introduce el ID del disco a borrar: ");
        int id = sc.nextInt();
        sc.nextLine();

        // PASO c: Verifica que el ID existe
        if (!coleccion.existeDisco(id)) {
            System.out.println("❌ ERROR: No existe un disco con ID " + id);
            return;
        }

        // PASO b: Borra el disco
        if (coleccion.eliminarDisco(id)) {
            System.out.println("✅ Disco eliminado correctamente.");
        }
    }

}
